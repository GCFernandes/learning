package com.amdocs.learning.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContactConverter {

    public static ContactVO toVO(ContactEntity entity){
        log.debug("entity={}, message=Converting to VO", entity.toString());
        return new ContactVO(entity.getUser(), entity.getName(), entity.getEmail(), entity.getPhone(), entity.getMessage(), entity.getId());
    }

    public static ContactEntity toEntity(ContactVO vo){
        log.debug("vo={}, message=Converting to Entity", vo.toString());
        ContactEntity entity = new ContactEntity();
        entity.setId(vo.getId());
        entity.setName(vo.getName());
        entity.setPhone(vo.getPhone());
        entity.setEmail(vo.getEmail());
        entity.setMessage(vo.getMessage());
        entity.setUser(vo.getUser());
        return entity;
    }
}