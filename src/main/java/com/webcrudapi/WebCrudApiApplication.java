package com.webcrudapi;

import com.webcrudapi.mapper.UserMapper;
import com.webcrudapi.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebCrudApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebCrudApiApplication.class, args);
    }


}
