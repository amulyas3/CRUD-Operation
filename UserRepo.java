package com.example.task1.repository;

import com.example.task1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUserName(String userName);

    UserEntity findByUserNameAndEmailId(String userName, String emailId);

    UserEntity findByEmailId(String emailId);

    void deleteByEmailId(String emailId);
}
