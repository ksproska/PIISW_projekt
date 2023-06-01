package com.example.backendapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserServiceTest
{
    @Autowired
    private UserService userService;
}
