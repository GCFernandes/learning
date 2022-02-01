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
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public List<CourseVO> getAll(){
        log.debug("message=Get all courses");
        List<CourseEntity> entityList = repository.findAll();
        List<CourseVO> list = entityList.stream().map(CourseConverter::toVO).collect(Collectors.toList());
        return list;
    }

    public CourseVO getById(int id){
        log.debug("id={}, message=Get course", id);
        Optional<CourseEntity> byId = repository.findById(id);
        return byId.isPresent() ? CourseConverter.toVO(byId.get()) : null;
    }

    public int save(CourseVO courseVO){
        log.debug("participant={}, message=Saving course", courseVO.toString());
        CourseEntity entity = CourseConverter.toEntity(courseVO);
        return repository.save(entity).getId();
    }

    public boolean update(CourseVO courseVO){
        log.debug("participant={}, message=Updating user", courseVO.toString());
        Optional<CourseEntity> byId = repository.findById(courseVO.getId());
        if(byId.isPresent()){
            CourseEntity entity = byId.get();
            entity.setName(courseVO.getName());
            entity.setDesp(courseVO.getDesp());
            entity.setFees(courseVO.getFees());
            entity.setResource(courseVO.getResource());
            repository.save(entity);
            return true;
        }
        return false;
    }

    public boolean delete(int id){
        log.debug("id={}, message=Delete course", id);
        Optional<CourseEntity> byId = repository.findById(id);
        if(byId.isPresent()){
            repository.delete(byId.get());
            return true;
        }
        return false;
    }

}
