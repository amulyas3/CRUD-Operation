package com.example.task1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Table(name="subgroup",schema = "public")
public class SubGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subgroupId;

    private String groupName;

    private int groupId;


}
