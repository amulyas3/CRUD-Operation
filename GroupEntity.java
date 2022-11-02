package com.example.task1.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Table(name="group",schema = "public")
public class GroupEntity {
    @Id
    private int groupId;

    private String groupName;

    @OneToMany(targetEntity = SubGroupEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name="fk_group_subgroup" ,referencedColumnName = "groupId")
    private List<SubGroupEntity> subGroups;
}
