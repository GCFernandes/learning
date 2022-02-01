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
public class ContactService {

    @Autowired
    private ContactRepository repository;

    public List<ContactVO> getAll(){
        log.debug("message=Get all contacts");
        List<ContactEntity> entityList = repository.findAll();
        List<ContactVO> list = entityList.stream().map(ContactConverter::toVO).collect(Collectors.toList());
        return list;
    }

    public ContactVO getById(int id){
        log.debug("id={}, message=Get contact", id);
        Optional<ContactEntity> byId = repository.findById(id);
        return byId.isPresent() ? ContactConverter.toVO(byId.get()) : null;
    }

    public int save(ContactVO ContactVO){
        log.debug("contact={}, message=Saving contact", ContactVO.toString());
        ContactEntity entity = ContactConverter.toEntity(ContactVO);
        return repository.save(entity).getId();
    }

    public boolean update(ContactVO ContactVO){
        log.debug("contact={}, message=Updating contact", ContactVO.toString());
        Optional<ContactEntity> byId = repository.findById(ContactVO.getId());
        if(byId.isPresent()){
            ContactEntity entity = byId.get();
            entity.setName(ContactVO.getName());
            entity.setPhone(ContactVO.getPhone());
            entity.setEmail(ContactVO.getEmail());
            entity.setMessage(ContactVO.getMessage());
            entity.setUser(ContactVO.getUser());
            repository.save(entity);
            return true;
        }
        return false;
    }

    public boolean delete(int id){
        log.debug("id={}, message=Delete contact", id);
        Optional<ContactEntity> byId = repository.findById(id);
        if(byId.isPresent()){
            repository.delete(byId.get());
            return true;
        }
        return false;
    }

}
