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
public class AdminService {

    @Autowired
    private AdminRepository repository;

    public List<AdminVO> getAll(){
        log.debug("message=Get all admins");
        List<AdminEntity> entityList = repository.findAll();
        List<AdminVO> list = entityList.stream().map(AdminConverter::toVO).collect(Collectors.toList());
        return list;
    }

    public AdminVO getById(int id){
        log.debug("id={}, message=Get admin", id);
        Optional<AdminEntity> byId = repository.findById(id);
        return byId.isPresent() ? AdminConverter.toVO(byId.get()) : null;
    }

    public int save(AdminVO adminVo){
        log.debug("admins={}, message=Saving admin", adminVo.toString());
        AdminEntity entity = AdminConverter.toEntity(adminVo);
        return repository.save(entity).getId();
    }

    public boolean update(AdminVO adminVO){
        log.debug("admins={}, message=Updating admin", adminVO.toString());
        Optional<AdminEntity> byId = repository.findById(adminVO.getId());
        if(byId.isPresent()){
            AdminEntity entity = byId.get();
            entity.setName(adminVO.getName());
            entity.setEmail(adminVO.getEmail());
            entity.setPassword(adminVO.getPassword());
            repository.save(entity);
            return true;
        }
        return false;
    }

    public boolean delete(int id){
        log.debug("id={}, message=Delete admin", id);
        Optional<AdminEntity> byId = repository.findById(id);
        if(byId.isPresent()){
            repository.delete(byId.get());
            return true;
        }
        return false;
    }

}
