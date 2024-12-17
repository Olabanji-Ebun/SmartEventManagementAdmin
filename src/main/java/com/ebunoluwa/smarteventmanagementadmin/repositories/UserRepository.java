package com.ebunoluwa.smarteventmanagementadmin.repositories;

import com.ebunoluwa.smarteventmanagementadmin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
