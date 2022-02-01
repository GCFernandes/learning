package com.amdocs.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

import lombok.Data;

@Data
@Entity
@Table(name = UserEntity.TABLE_NAME)
public class UserEntity {

    public static final String ENTITY_NAME = "UserEntity";
    public static final String TABLE_NAME = "USER1";

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "PHONE_NO")
    private int phone;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "ADDRESS", length = 100)
    private String address;

    @Column(name = "REG_DATE")
    private Date date;

    @Column(name = "PASSWORD", length = 100)
    private String password;

    @Column(name = "UPLOAD_PHOTO", length = 100)
    private String photo;

}