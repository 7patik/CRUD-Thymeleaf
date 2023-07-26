package com.webcrudapi.service;

import com.webcrudapi.model.dto.UserDto;
import com.webcrudapi.model.entity.UserEntity;
import com.webcrudapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
    private final UserRepository repository;
    @Override
    public UserEntity creat(UserEntity entity) {
        return repository.save(entity);
    }

    @Override
    public UserEntity findById(Integer id)  {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) repository.findAll();
    }

    @Override
    public UserEntity update(Integer id) throws UserNotFoundExcemtion {
        Optional<UserEntity> oldentity = repository.findById(id);
        if (oldentity.isPresent()){
            return oldentity.get();
        }
        throw new UserNotFoundExcemtion("Could not find any users with id");
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Boolean exist(Integer id) {
        return repository.existsById(id);
    }
}
