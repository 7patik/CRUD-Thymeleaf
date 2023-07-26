package com.webcrudapi.service;

import com.webcrudapi.model.dto.UserDto;
import com.webcrudapi.model.entity.UserEntity;

import java.util.List;

public interface AdminService {
    UserEntity creat(UserEntity entity);
    UserEntity findById(Integer id);
    List<UserEntity> findAll();
    UserEntity update(Integer id) throws UserNotFoundExcemtion;
    void delete(Integer id);
    Boolean exist(Integer id);
}
