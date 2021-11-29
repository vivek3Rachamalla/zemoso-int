package com.library.bootlibrary.controller;

import com.library.bootlibrary.formentities.LoginPojo;
import com.library.bootlibrary.formentities.RegisterPojo;
import com.library.bootlibrary.service.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class LoginController {
    @Autowired
    LoginServices loginService;

    @GetMapping(path = "/loginPage" )
    public String loginPage(ModelMap modelMap){
        return loginService.loginPageService(modelMap);
    }

    @RequestMapping(path = "/login" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String login(@Valid @ModelAttribute("loginPojo") LoginPojo loginPojo, BindingResult bindingResult,
                        @ModelAttribute("registerPojo") RegisterPojo registerPojo ){
        return loginService.loginService(loginPojo,bindingResult);
    }

    @RequestMapping(value = "/register",method = {RequestMethod.GET,RequestMethod.POST})
    public String register(@Valid @ModelAttribute("registerPojo") RegisterPojo registerPojo,
                           BindingResult bindingResult, @ModelAttribute("loginPojo") LoginPojo loginPojo){
        return loginService.registerService(registerPojo);
    }

}