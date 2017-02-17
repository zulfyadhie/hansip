package com.dpbg.hansip.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zulfyadhie on 2/14/17.
 */
@Entity
@Table(name = "app_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq")
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roleList;

}