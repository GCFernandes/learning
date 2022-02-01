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
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserVO> getAll(){
        log.debug("message=Get all users");
        List<UserEntity> entityList = repository.findAll();
        List<UserVO> list = entityList.stream().map(UserConverter::toVO).collect(Collectors.toList());
        return list;
    }

    public UserVO getById(int id){
        log.debug("id={}, message=Get user", id);
        Optional<UserEntity> byId = repository.findById(id);
        return byId.isPresent() ? UserConverter.toVO(byId.get()) : null;
    }

    public int save(UserVO userVo){
        log.debug("participant={}, message=Saving user", userVo.toString());
        UserEntity entity = UserConverter.toEntity(userVo);
        return repository.save(entity).getId();
    }

    public boolean update(UserVO userVo){
        log.debug("participant={}, message=Updating user", userVo.toString());
        Optional<UserEntity> byId = repository.findById(userVo.getId());
        if(byId.isPresent()){
            UserEntity entity = byId.get();
            entity.setName(userVo.getName());
            entity.setPhone(userVo.getPhone());
            entity.setEmail(userVo.getEmail());
            entity.setAddress(userVo.getAddress());
            entity.setDate(userVo.getDate());
            entity.setPassword(userVo.getPassword());
            entity.setPhoto(userVo.getPhoto());
            repository.save(entity);
            return true;
        }
        return false;
    }

    public boolean delete(int id){
        log.debug("id={}, message=Delete user", id);
        Optional<UserEntity> byId = repository.findById(id);
        if(byId.isPresent()){
            repository.delete(byId.get());
            return true;
        }
        return false;
    }

}
