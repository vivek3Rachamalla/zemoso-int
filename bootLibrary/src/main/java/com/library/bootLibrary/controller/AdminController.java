package com.library.bootLibrary.controller;

import com.library.bootLibrary.formEntities.BookPojo;
import com.library.bootLibrary.service.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class AdminController {
    @Autowired
    AdminServices adminServices;

    @RequestMapping("/admin")
    public String admin(ModelMap modelMap){
        return adminServices.adminService(modelMap);
    }

    @RequestMapping("/acceptRegister")
    public String accept(@RequestParam String username){
        return adminServices.acceptService(username);
    }

    @RequestMapping("/denyRegister")
    public String deny(@RequestParam String username){
       return adminServices.denyService(username);
    }

    @RequestMapping("/adminLogout")
    public String adminLogout(){
        return adminServices.adminLogoutService();
    }

    @RequestMapping("/addBook")
    public String addBook(@ModelAttribute("loginPojo") BookPojo bookPojo){
        return adminServices.addBookService(bookPojo);
    }

    @RequestMapping("/givePermission")
    public String givePermission(@RequestParam String recordId){
        return adminServices.givePermissionService(recordId);
    }

    @RequestMapping("/rejectPermission")
    public String rejectPermission(@RequestParam String recordId){
        return adminServices.rejectPermissionService(recordId);
    }



}
