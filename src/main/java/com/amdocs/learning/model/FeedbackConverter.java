package com.amdocs.learning.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeedbackConverter {

    public static FeedbackVO toVO(FeedbackEntity entity){
        log.debug("entity={}, message=Converting to VO", entity.toString());
        return new FeedbackVO(entity.getUser(), entity.getName(), entity.getEmail(), entity.getId(), entity.getFeedback());
    }

    public static FeedbackEntity toEntity(FeedbackVO vo){
        log.debug("vo={}, message=Converting to Entity", vo.toString());
        FeedbackEntity entity = new FeedbackEntity();
        entity.setId(vo.getId());
        entity.setName(vo.getName());
        entity.setEmail(vo.getEmail());
        entity.setUser(vo.getUser());
        entity.setFeedback(vo.getFeedback());
        return entity;
    }
}
