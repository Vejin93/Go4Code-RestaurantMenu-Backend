package com.go4code.data;

import com.go4code.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String userName);
    public User findByPassword(String password);
}
