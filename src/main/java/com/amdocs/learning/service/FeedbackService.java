package com.amdocs.learning.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.amdocs.learning.model.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    public List<FeedbackVO> getAll(){
        log.debug("message=Get all feedbacks");
        List<FeedbackEntity> entityList = repository.findAll();
        List<FeedbackVO> list = entityList.stream().map(FeedbackConverter::toVO).collect(Collectors.toList());
        return list;
    }

    public FeedbackVO getById(int id){
        log.debug("id={}, message=Get feedback", id);
        Optional<FeedbackEntity> byId = repository.findById(id);
        return byId.isPresent() ? FeedbackConverter.toVO(byId.get()) : null;
    }

    public int save(FeedbackVO FeedbackVO){
        log.debug("admins={}, message=Saving feedback", FeedbackVO.toString());
        FeedbackEntity entity = FeedbackConverter.toEntity(FeedbackVO);
        return repository.save(entity).getId();
    }

    public boolean update(FeedbackVO FeedbackVO){
        log.debug("admins={}, message=Updating feedback", FeedbackVO.toString());
        Optional<FeedbackEntity> byId = repository.findById(FeedbackVO.getId());
        if(byId.isPresent()){
            FeedbackEntity entity = byId.get();
            entity.setName(FeedbackVO.getName());
            entity.setEmail(FeedbackVO.getEmail());
            entity.setUser(FeedbackVO.getUser());
            entity.setId(FeedbackVO.getId());
            entity.setFeedback(FeedbackVO.getFeedback());
            repository.save(entity);
            return true;
        }
        return false;
    }

    public boolean delete(int id){
        log.debug("id={}, message=Delete admin", id);
        Optional<FeedbackEntity> byId = repository.findById(id);
        if(byId.isPresent()){
            repository.delete(byId.get());
            return true;
        }
        return false;
    }

}
