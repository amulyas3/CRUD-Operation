package com.example.task1.service;

import com.example.task1.entity.GroupEntity;
import com.example.task1.entity.SubGroupEntity;
import com.example.task1.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {


    List<UserEntity> getAll();

    UserEntity getByUserName(String userName);

    UserEntity getByUserNameAndEmailId(String userName, String emailId);

    String add(UserEntity userEntity);

    UserEntity updateUser(UserEntity userEntity, String emailId);

    GroupEntity updateGroup(GroupEntity groupEntity, int groupId);

    SubGroupEntity updateSubGroup(SubGroupEntity subGroupEntity, int subGroupId);

    void delete(String emailId);
}
