package com.webcrudapi.service;

import com.webcrudapi.mapper.UserMapper;
import com.webcrudapi.model.dto.UserDto;
import com.webcrudapi.model.entity.UserEntity;
import com.webcrudapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService{
    @Autowired private  UserMapper mapper;
    @Autowired private  UserRepository repository;


    @Override
    public UserDto creat(UserEntity entity) {
        return mapper.entityToDto(repository.save(entity));
    }

    @Override
    public UserDto findById(Integer id) {
        return mapper.entityToDto(repository.findById(id).orElse(null));
    }

    @Override
    public List<UserDto> findAll() {
        return mapper.allEntitytoDtos((List<UserEntity>)repository.findAll());
    }

    @Override
    public UserDto update(Integer id, UserDto userDto) {
        UserEntity oldentity = repository.findById(id).orElse(null);
        oldentity.setEmail(userDto.getEmail());
        oldentity.setFirstName(userDto.getFirstName());
        oldentity.setLastName(userDto.getLastName());
        return mapper.entityToDto(repository.save(oldentity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
