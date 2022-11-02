package com.example.task1.serviceImpl;

import com.example.task1.entity.GroupEntity;
import com.example.task1.entity.SubGroupEntity;
import com.example.task1.entity.UserEntity;
import com.example.task1.repository.GroupRepo;
import com.example.task1.repository.SubGroupRepo;
import com.example.task1.repository.UserRepo;
import com.example.task1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private SubGroupRepo subGroupRepo;
    @Override
    public List<UserEntity> getAll() {
        return userRepo.findAll() ;
    }

    @Override
    public UserEntity getByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }

    @Override
    public UserEntity getByUserNameAndEmailId(String userName, String emailId) {
        return userRepo.findByUserNameAndEmailId(userName,emailId);
    }

    @Override
    public String add(UserEntity userEntity) {
        System.out.println(userEntity);
        try{
            if(!userRepo.findByEmailId(userEntity.getEmailId()).getEmailId().equals(userEntity.getEmailId())){
                userRepo.save(userEntity);
                return "User is Added successfully";
            }
        }catch (Exception e) {
            userRepo.save(userEntity);
            return "User is Added successfully";
        }
        return "User is already present";
    }

    @Override
    public UserEntity updateUser(UserEntity user, String emailId) {
        UserEntity user1=userRepo.findByEmailId(emailId);
        System.out.println(user1);
        if (user1!=null){
            user1.setUserName(user.getUserName());
            user1.setPhoneNumber(user.getPhoneNumber());
            return userRepo.save(user1);
        }
        return null;
    }

    @Override
    public GroupEntity updateGroup(GroupEntity groups, int groupId) {
        GroupEntity groups1=groupRepo.findById(groupId);
        if(groups1!=null){
            groups1.setGroupName(groups.getGroupName());
            return  groupRepo.save(groups1);
        }
        return null;
    }

    @Override
    public SubGroupEntity updateSubGroup(SubGroupEntity subGroupEntity, int subGroupId) {
        SubGroupEntity subGroupEntity1=subGroupRepo.findById(subGroupId);
        if(subGroupEntity1!=null){
            subGroupEntity1.setGroupId(subGroupEntity.getGroupId());
            subGroupEntity1.setGroupName(subGroupEntity.getGroupName());
            return subGroupRepo.save(subGroupEntity1);
        }
        return null;
    }

    @Override
    public void delete(String emailId) {
        userRepo.deleteByEmailId(emailId);
    }
}
