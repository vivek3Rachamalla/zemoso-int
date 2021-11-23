package com.library.controller;

import com.library.database.LibraryDao;
import com.library.hibernateEntities.Register;
import com.library.pojo.loginPojo;
import com.library.serviceLayer.loginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;

@Controller
public class loginController {
    LibraryDao dao=new LibraryDao();
    @Autowired
    loginServices loginService;

    @RequestMapping(value="/loginPage")
    public String loginPage(ModelMap modelMap){
        return loginService.loginPageService(modelMap);
    }

    @RequestMapping(path = "/login")
    public String login( @ModelAttribute("loginPojo") loginPojo loginPojo ){
        return loginService.loginService(loginPojo);
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request){
        Register register=new Register(
        request.getParameter("username"),
        request.getParameter("password"),
        request.getParameter("firstName"),
        request.getParameter("lastName"),
        request.getParameter("phoneNumber"));
        dao.addRegister(register);
        return "login";
    }

}