package com.library.bootlibrary;


import com.library.bootlibrary.controller.UserController;
import com.library.bootlibrary.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ModelMap;


import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    UserController userController;
    @Autowired
    UserDto userDto;

    @Test
    public void userTestWithOutLogin(){
        userDto.setUsername(null);
        userDto.setPassword(null);
        assertEquals("redirect:/loginPage",userController.user(new ModelMap()));
    }

    @Test
    public void userTest(){
        userDto.setUsername("user");
        userDto.setPassword("user1123");
        assertEquals("user",userController.user(new ModelMap()));
    }

    @Test
    public void userLogoutTest(){
        assertEquals("redirect:/loginPage",userController.userLogout());
    }

    @Test
    public void bookRequestTest() throws ParseException {
        userDto.setUsername("user");
        assertEquals("redirect:/user",userController.bookRequest("2021-11-24","2021-11-24","2"));
    }

    @Test
    public void returnBookTest(){
        assertEquals("redirect:/user",userController.returnBook("7"));
    }

    @Test
    public void barrowBookTest(){
        assertEquals("redirect:/user",userController.barrowBook("28"));
    }


}
