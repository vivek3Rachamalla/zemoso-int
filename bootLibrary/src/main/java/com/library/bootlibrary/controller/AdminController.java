package com.library.bootlibrary.controller;

import com.library.bootlibrary.formentities.BookPojo;
import com.library.bootlibrary.service.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdminController {
    @Autowired
    AdminServices adminServices;

    @GetMapping("/admin")
    public String admin(ModelMap modelMap){
        return adminServices.adminService(modelMap);
    }

    @RequestMapping(value = "/acceptRegister",method = {RequestMethod.GET,RequestMethod.POST})
    public String accept(@RequestParam String username){
        return adminServices.acceptService(username);
    }

    @RequestMapping(value = "/denyRegister",method = {RequestMethod.GET,RequestMethod.DELETE})
    public String deny(@RequestParam String username){
       return adminServices.denyService(username);
    }

    @GetMapping("/adminLogout")
    public String adminLogout(){
        return adminServices.adminLogoutService();
    }

    @RequestMapping(value = "/addBook",method = {RequestMethod.GET,RequestMethod.POST})
    public String addBook(@ModelAttribute("loginPojo") BookPojo bookPojo){
        return adminServices.addBookService(bookPojo);
    }

    @RequestMapping(value = "/givePermission",method = {RequestMethod.GET,RequestMethod.POST})
    public String givePermission(@RequestParam String recordId){
        return adminServices.givePermissionService(recordId);
    }

    @RequestMapping(value = "/rejectPermission",method = {RequestMethod.GET,RequestMethod.DELETE})
    public String rejectPermission(@RequestParam String recordId){
        return adminServices.rejectPermissionService(recordId);
    }



}
