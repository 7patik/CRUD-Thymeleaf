package com.webcrudapi.service;

import com.webcrudapi.model.dto.UserDto;
import com.webcrudapi.model.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserDto creat(UserEntity entity);
    UserDto findById(Integer id);
    List<UserDto> findAll();
    UserDto update(Integer id,UserDto userDto);
    void delete(Integer id);
}
