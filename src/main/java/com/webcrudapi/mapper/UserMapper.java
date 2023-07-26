package com.webcrudapi.mapper;

import com.webcrudapi.model.dto.UserDto;
import com.webcrudapi.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
//    UserMapper Mapper= Mappers.getMapper(UserMapper.class);

    UserDto entityToDto(UserEntity entity);
    List<UserDto> allEntitytoDtos(List<UserEntity> entitys);

}
