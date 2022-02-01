package com.amdocs.learning.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CourseConverter {

    public static CourseVO toVO(CourseEntity entity){
        log.debug("entity={}, message=Converting to VO", entity.toString());
        return new CourseVO(entity.getId(), entity.getName(), entity.getDesp(), entity.getFees(), entity.getResource());
    }

    public static CourseEntity toEntity(CourseVO vo){
        log.debug("vo={}, message=Converting to Entity", vo.toString());
        CourseEntity entity = new CourseEntity();
        entity.setId(vo.getId());
        entity.setName(vo.getName());
        entity.setDesp(vo.getDesp());
        entity.setFees(vo.getFees());
        entity.setResource(vo.getResource());
        return entity;
    }
}
