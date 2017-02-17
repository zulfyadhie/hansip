package com.dpbg.hansip.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by zulfyadhie on 2/14/17.
 */
@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "role_seq_gen")
    @SequenceGenerator(name = "role_seq_gen", sequenceName = "role_seq")
    private Long id;
    @Column(name = "code", nullable = false, unique = true)
    private String code;
    @Column(name = "name")
    private String name;
}