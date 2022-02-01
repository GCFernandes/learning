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
@Table(name = ParticipantEntity.TABLE_NAME)
public class ParticipantEntity {

    public static final String ENTITY_NAME = "ParticipantEntity";
    public static final String TABLE_NAME = "CABALAT_PARTICIPANT";

    @Id
    @Column(name = "ID_CABALAT_PARTICIPANT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "ROLE", length = 100)
    private String role;

    @Column(name = "ACCOUNT", length = 100)
    private String account;
}