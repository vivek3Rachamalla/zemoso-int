package com.library.bootLibrary.controller;


import com.library.bootLibrary.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;


@Controller
public class UserController {
    @Autowired
    UserServices userService;

    @RequestMapping("/user")
    public String user(ModelMap modelMap){
        return userService.userService(modelMap);
    }

    @RequestMapping("/bookRequest")
    public String bookRequest(HttpServletRequest request) throws ParseException {
       return userService.bookRequestService(request);
   }

   @RequestMapping("/userLogout")
    public String userLogout(){
        return userService.userLogoutService();
   }

   @RequestMapping("/return")
    public String request(HttpServletRequest request){
        return userService.returnService(request);
   }

   @RequestMapping("/barrow")
    public String barrow(HttpServletRequest request){
        return userService.barrowService(request);
   }

}
