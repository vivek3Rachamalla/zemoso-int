package com.library.bootLibrary;

import com.library.bootLibrary.controller.AdminController;
import com.library.bootLibrary.dto.AdminDto;
import com.library.bootLibrary.formEntities.BookPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminControllerTest {
    @Autowired
    AdminController adminController;
    @Autowired
    AdminDto adminDto;

    private String redirectAdmin="redirect:/admin";
    private String acceptUserUsername="example1";
    private String denyUserUsername="example2";
    private String acceptRecordId="32";
    private String denyRecordId="33";
    private BookPojo bookPojo=new BookPojo("The OverStory","Richard Powers","4");

    @Test
    public void adminTestWithOutLogin(){
        adminDto.setUsername(null);
        adminDto.setPassword(null);
        assertEquals("redirect:/loginPage",adminController.admin(new ModelMap()));
    }

    @Test
    public void adminTest(){
        adminDto.setUsername("admin");
        adminDto.setPassword("admin1123");
        assertEquals("admin",adminController.admin(new ModelMap()));
    }

    @Test
    public void adminLogoutTest(){
        assertEquals("redirect:/loginPage",adminController.adminLogout());
    }

    @Test
    public void acceptUserTest(){
        assertEquals(redirectAdmin,adminController.accept(acceptUserUsername));
    }

    @Test
    public void denyUserTest(){
        assertEquals(redirectAdmin,adminController.deny(denyUserUsername));
    }

    @Test
    public void givePermissionTest(){
        assertEquals(redirectAdmin,adminController.givePermission(acceptRecordId));
    }

    @Test
    public void denyPermissionTest(){
        assertEquals(redirectAdmin,adminController.rejectPermission(denyRecordId));
    }

    @Test
    public void addBookTest(){
        assertEquals(redirectAdmin,adminController.addBook(bookPojo));
    }

}
