package com.amdocs.learning.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserConverter {

    public static UserVO toVO(UserEntity entity){
        log.debug("entity={}, message=Converting to VO", entity.toString());
        return new UserVO(entity.getId(), entity.getName(), entity.getPhone(), entity.getEmail(), entity.getAddress(), entity.getDate(), entity.getPassword(), entity.getPhoto());
    }

    public static UserEntity toEntity(UserVO vo){
        log.debug("vo={}, message=Converting to Entity", vo.toString());
        UserEntity entity = new UserEntity();
        entity.setId(vo.getId());
        entity.setName(vo.getName());
        entity.setPhone(vo.getPhone());
        entity.setEmail(vo.getEmail());
        entity.setAddress(vo.getAddress());
        entity.setDate(vo.getDate());
        entity.setPassword(vo.getPassword());
        entity.setPhoto(vo.getPhoto());
        return entity;
    }
}
