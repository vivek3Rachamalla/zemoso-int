package com.library.bootLibrary.controller;

import com.library.bootLibrary.formEntities.LoginPojo;
import com.library.bootLibrary.formEntities.RegisterPojo;
import com.library.bootLibrary.service.LoginServices;
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

    @RequestMapping("/loginPage")
    public String loginPage(ModelMap modelMap){
        return loginService.loginPageService(modelMap);
    }

    @RequestMapping(path = "/login")
    public String login(@Valid @ModelAttribute("loginPojo") LoginPojo loginPojo, BindingResult bindingResult,
                        @ModelAttribute("registerPojo") RegisterPojo registerPojo ){
        return loginService.loginService(loginPojo,bindingResult);
    }

    @RequestMapping("/register")
    public String register(@Valid @ModelAttribute("registerPojo") RegisterPojo registerPojo, BindingResult bindingResult, @ModelAttribute("loginPojo") LoginPojo loginPojo){
        return loginService.registerService(registerPojo);
    }

}