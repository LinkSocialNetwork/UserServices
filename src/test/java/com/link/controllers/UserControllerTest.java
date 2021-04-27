package com.link.controllers;

import com.link.model.User;
import com.link.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    UserController userController;
    @Mock
    UserService userService;

    @BeforeEach
    void setUp() {
        userController = new UserController(userService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUserById() {
        User newUser=new User();
        newUser.setUserID(1);
        newUser.setUserName("TophTheGreatest");
        newUser.setPassword("melonlord");
        newUser.setBio("Greatest Earthbender to ever live.");
        newUser.setFirstName("Toph");
        newUser.setLastName("Bei-Fong");
        newUser.setAuthToken("BlahBaBlah");
        newUser.setBusinessName("Toph Greatest EarthBender");
        Date myDate;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 8);
        cal.set(Calendar.DATE, 24);
        cal.set(Calendar.YEAR, 2000);
        myDate=cal.getTime();
        newUser.setDob(myDate);
        newUser.setEmail("toph@yahoo.com");
        newUser.setProfileImg("d");
        newUser.setDateCreated(new Date());

        Mockito.when(userService.getUserByID(1)).thenReturn(newUser);

        User rUser = userController.getUserById(1);
        Mockito.verify(userService).getUserByID(1);
        assertEquals(newUser,rUser);
    }
}