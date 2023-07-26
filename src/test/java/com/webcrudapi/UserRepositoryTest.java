package com.webcrudapi;

import com.webcrudapi.mapper.UserMapper;
import com.webcrudapi.model.dto.UserDto;
import com.webcrudapi.model.entity.UserEntity;
import com.webcrudapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;




@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)


public class UserRepositoryTest {
    @Autowired
    private  UserRepository repository;
    @Autowired

    private  UserMapper mapper;

    @Test
    public void testAddNew(){
        UserEntity entity =new UserEntity();
        entity.setEmail("n003@gmail.com2");
        entity.setPassword("290.787.078");
        entity.setFirstName("Ismayil");
        entity.setLastName("Zada");

        UserEntity userEntity=repository.save(entity);

        Assertions.assertThat(userEntity).isNotNull();
        Assertions.assertThat(userEntity.getId()).isGreaterThan(0);

    }
    @Test
    public void testListAll(){
        Iterable<UserEntity> users = repository.findAll();
        Assertions.assertThat(users).hasSize(0);

        for (UserEntity entity : users){
        System.out.println(entity);
        }
    }

    @Test
    public void testUpdate(){
        Integer userid=1;
        UserEntity entity = repository.findById(userid).orElse(null);
        entity.setFirstName("Togrul");
        UserEntity save = repository.save(entity);
        System.out.println(save);
    }

    @Test
    public void testGet(){
        Integer userid=1;
        UserEntity entity = repository.findById(userid).orElse(null);
        Assertions.assertThat(entity).isNotNull();
        UserDto userDto = mapper.entityToDto(entity);
        System.out.println(userDto);
    }

    @Test
    public void entitytodto(){
        UserEntity userEntity =new UserEntity(7,"togrul.ismayilzada@gmail.com","13.5.45.8.62","Ismayil","Zada");
        UserDto userDto = mapper.entityToDto(userEntity);
        System.out.println(userDto);
    }

    @Test
    public void testdelete(){
        Integer userid=5;
        repository.deleteById(userid);
    }

}

