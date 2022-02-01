package com.amdocs.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = ContactEntity.TABLE_NAME)
public class ContactEntity {

    public static final String ENTITY_NAME = "ContactEntity";
    public static final String TABLE_NAME = "CONTACT";

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "PHONE_NO")
    private int phone;

    @Column(name = "MESSAGE", length = 100)
    private String message;

    @Id
    @Column(name = "CONTACT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}