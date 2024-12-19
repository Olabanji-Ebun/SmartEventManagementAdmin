package com.ebunoluwa.smarteventmanagementadmin.configurations;

import com.ebunoluwa.smarteventmanagementadmin.service.CustomSuccessHandler;
import com.ebunoluwa.smarteventmanagementadmin.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable())

                .authorizeHttpRequests(request -> request
                        .requestMatchers("/", "/login", "/registration", "/css/**", "/fonts/**").permitAll() // Public URLs
                        .requestMatchers("/admin-page").hasAuthority("ADMIN")  // Protected admin page
                        .requestMatchers("/user-page").hasAuthority("USER")   // Protected user page
                        .anyRequest().authenticated() // Secure all other URLs
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .successHandler(customSuccessHandler)
                        .permitAll()
                )

                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )

                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login") // Custom login page for OAuth2
                        .defaultSuccessUrl("/user-page", true) // Redirect to user page after OAuth2 login
                );

        return http.build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
}
