package com.example.task1.repository;

import com.example.task1.entity.SubGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
@Repository
public interface SubGroupRepo extends JpaRepository<SubGroupEntity,Integer> {
    SubGroupEntity findById(int subGroupId);
}
