package com.library.bootLibrary.controller;

import com.library.bootLibrary.formEntities.BookPojo;
import com.library.bootLibrary.service.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class AdminController {
    @Autowired
    AdminServices adminServices;

    @RequestMapping("/admin")
    public String admin(ModelMap modelMap){
        return adminServices.adminService(modelMap);
    }

    @RequestMapping("/acceptRegister")
    public String accept(HttpServletRequest request, ModelMap modelMap){
        return adminServices.acceptService(request,modelMap);
    }

    @RequestMapping("/denyRegister")
    public String deny(HttpServletRequest request,ModelMap modelMap){
       return adminServices.denyService(request);
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
    public String givePermission(HttpServletRequest request){
        return adminServices.givePermissionService(request);
    }

    @RequestMapping("/rejectPermission")
    public String rejectPermission(HttpServletRequest request){
        return adminServices.rejectPermissionService(request);
    }



}
