package com.example.task1.controller;

import com.example.task1.entity.GroupEntity;
import com.example.task1.entity.SubGroupEntity;
import com.example.task1.entity.UserEntity;
import com.example.task1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/get")
    public List<UserEntity> getAll(){
         return userService.getAll();
    }

    @GetMapping("/user/get/{userName}")
    public UserEntity getByUserName(@PathVariable String userName){
        return userService.getByUserName(userName);
    }
    @GetMapping("/user/get/{userName}/{emailId}")
    public UserEntity getByUserNameAndEmailId(@PathVariable String userName,@PathVariable String emailId){
        return userService.getByUserNameAndEmailId(userName,emailId);
    }
    @PostMapping("/user/add")
    @Transactional
    public String add(@RequestBody UserEntity userEntity){
        return userService.add(userEntity);
    }
    @PutMapping("/user/update/{emailId}")
    @Transactional
    public UserEntity updateUser(@RequestBody UserEntity userEntity,@PathVariable String emailId){
        return userService.updateUser(userEntity,emailId);
    }
    @PutMapping("user/update/{groupId}")
    @Transactional
    public GroupEntity updateGroup(@RequestBody GroupEntity userEntity, @PathVariable int groupId){
        return userService.updateGroup(userEntity,groupId);
    }
    @PutMapping("/user/update/{subGroupId}")
    @Transactional
    public SubGroupEntity updateSubGroup(@RequestBody SubGroupEntity subGroupEntity, @PathVariable int subGroupId){
        return userService.updateSubGroup(subGroupEntity,subGroupId);
    }
    @DeleteMapping("/user/delete/{emailId}")
    @Transactional
    public String delete(@PathVariable String emailId){
        userService.delete(emailId);
        return "User is Deleted ";
    }
}