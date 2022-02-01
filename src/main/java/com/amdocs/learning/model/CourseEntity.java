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
@Table(name = CourseEntity.TABLE_NAME)
public class CourseEntity {

    public static final String ENTITY_NAME = "CourseEntity";
    public static final String TABLE_NAME = "COURSE";

    @Id
    @Column(name = "COURSE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "C_NAME", length = 100)
    private String name;

    @Column(name = "C_DESP", length = 100)
    private String desp;

    @Column(name = "C_FEES", length = 100)
    private String fees;

    @Column(name = "C_RESOURCE", length = 100)
    private String resource;
}
