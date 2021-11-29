package com.library.bootlibrary.service;

import com.library.bootlibrary.database.LibraryDao;
import com.library.bootlibrary.dto.AdminDto;
import com.library.bootlibrary.dto.UserDto;
import com.library.bootlibrary.hibernateentities.Register;
import com.library.bootlibrary.formentities.LoginPojo;
import com.library.bootlibrary.formentities.RegisterPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@ComponentScan(basePackages = "com.library.bootLibrary")
@Service
public class LoginServices {
    @Autowired
    LibraryDao dao;
    @Autowired
    UserDto userDto;
    @Autowired
    AdminDto adminDto;

    private String authenticationMsg="";
    private String login="login";

    public String loginPageService(ModelMap modelMap){
        if(userDto.getUsername()!=null && userDto.getPassword()!=null &&
            userDto.getRole().equals("user")) return "redirect:/user";

        if(adminDto.getUsername()!=null && adminDto.getPassword()!=null &&
             adminDto.getRole().equals("admin")) return "redirect:/admin";

        modelMap.addAttribute("titleId","idLogin");
        modelMap.addAttribute("registerPojo",new RegisterPojo());
        modelMap.addAttribute("authenticationMsg",authenticationMsg);
        modelMap.addAttribute("loginPojo",new LoginPojo());
        return login;
    }

    public String loginService(LoginPojo loginPojo, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            authenticationMsg="";
            return login;
        }
        else {
            String role = dao.getRole(loginPojo.getUsernameLogin(), loginPojo.getPasswordLogin());
            if (role.equals("user")) {
                userDto.setUsername(loginPojo.getUsernameLogin());
                userDto.setPassword(loginPojo.getPasswordLogin());
                userDto.setRole(role);
                userDto.setBookList(dao.getAllBooks());
                authenticationMsg="";
                return "redirect:/user";
            } else if (role.equals("admin")) {
                adminDto.setUsername(loginPojo.getUsernameLogin());
                adminDto.setPassword(loginPojo.getPasswordLogin());
                adminDto.setRole(role);
                adminDto.setBookList(dao.getAllBooks());
                adminDto.setRegisterList(dao.getRegisterList());
                adminDto.setRubViewList(dao.bookRequestList());
                authenticationMsg="";
                return "redirect:/admin";
            }
        }
        authenticationMsg="Invalid username or password";
        return "redirect:/loginPage";
    }

    public String registerService(RegisterPojo registerPojo){
        Register register=new Register(registerPojo);
        dao.addRegister(register);
        return login;
    }


}