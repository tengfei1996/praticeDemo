package com.example.demo;

import com.example.demo.model.SystemUser;
import com.example.demo.service.SystemUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VuedemoApplicationTests {

    @Autowired
    SystemUserService systemUserService;
    @Test
    void contextLoads() {
//        SystemUser systemUser = new SystemUser();
//        systemUser.setUserAccount("@ningtengfei");
//        systemUser.setPassword("123456");
//        systemUserService.save(systemUser);
    }

}
