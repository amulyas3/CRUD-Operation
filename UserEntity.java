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
@Table(name="user",schema = "public")
public class UserEntity {
    @Id
    private String emailId;

    @Column(unique = true)
    private String userName;

    private long phoneNumber;

    @OneToMany(targetEntity = GroupEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name="fk_user_group",referencedColumnName = "emailId")
   private List<GroupEntity> groups;

}
