package com.library.bootLibrary.controller;

import com.library.bootLibrary.formEntities.loginPojo;
import com.library.bootLibrary.formEntities.registerPojo;
import com.library.bootLibrary.service.loginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class loginController {
    @Autowired
    loginServices loginService;

    @RequestMapping("/loginPage")
    public String loginPage(ModelMap modelMap){
        return loginService.loginPageService(modelMap);
    }

    @RequestMapping(path = "/login")
    public String login(@Valid @ModelAttribute("loginPojo") loginPojo loginPojo,BindingResult bindingResult,
                        @ModelAttribute("registerPojo") registerPojo registerPojo ){
        return loginService.loginService(loginPojo,bindingResult);
    }

    @RequestMapping("/register")
    public String register(@Valid @ModelAttribute("registerPojo") registerPojo registerPojo,BindingResult bindingResult,@ModelAttribute("loginPojo") loginPojo loginPojo){
        return loginService.registerService(registerPojo);
    }

}