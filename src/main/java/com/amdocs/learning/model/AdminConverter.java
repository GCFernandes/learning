package com.amdocs.learning.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminConverter {

    public static AdminVO toVO(AdminEntity entity){
        log.debug("entity={}, message=Converting to VO", entity.toString());
        return new AdminVO(entity.getId(), entity.getName(), entity.getEmail(), entity.getPassword());
    }

    public static AdminEntity toEntity(AdminVO vo){
        log.debug("vo={}, message=Converting to Entity", vo.toString());
        AdminEntity entity = new AdminEntity();
        entity.setId(vo.getId());
        entity.setName(vo.getName());
        entity.setEmail(vo.getEmail());
        entity.setPassword(vo.getPassword());
        return entity;
    }
}
