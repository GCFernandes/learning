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
@Table(name = FeedbackEntity.TABLE_NAME)
public class FeedbackEntity {

    public static final String ENTITY_NAME = "FeedbackEntity";
    public static final String TABLE_NAME = "FEEDBACK";

    @Column(name = "USER_ID")
    private int user;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Id
    @Column(name = "F_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FEEDBACK", length = 100)
    private String feedback;
}