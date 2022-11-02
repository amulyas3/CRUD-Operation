package com.example.task1.repository;

import com.example.task1.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
@Repository
public interface GroupRepo extends JpaRepository<GroupEntity,Integer> {
    GroupEntity findById(int groupId);

}
