package com.amdocs.learning.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParticipantConverter {

    public static ParticipantVO toVO(ParticipantEntity entity){
        log.debug("entity={}, message=Converting to VO", entity.toString());
        return new ParticipantVO(entity.getId(), entity.getName(), entity.getRole(), entity.getAccount());
    }

    public static ParticipantEntity toEntity(ParticipantVO vo){
        log.debug("vo={}, message=Converting to Entity", vo.toString());
        ParticipantEntity entity = new ParticipantEntity();
        entity.setId(vo.getId());
        entity.setName(vo.getName());
        entity.setRole(vo.getRole());
        entity.setAccount(vo.getAccount());
        return entity;
    }

}
