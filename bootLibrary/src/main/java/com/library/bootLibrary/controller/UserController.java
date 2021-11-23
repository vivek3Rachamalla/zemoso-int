package com.library.bootLibrary.controller;


import com.library.bootLibrary.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String bookRequest(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String bookId ) throws ParseException {
       return userService.bookRequestService(fromDate,toDate,bookId);
   }

   @RequestMapping("/userLogout")
    public String userLogout(){
        return userService.userLogoutService();
   }

   @RequestMapping("/return")
    public String returnBook(@RequestParam String recordId){
        return userService.returnService(recordId);
   }

   @RequestMapping("/barrow")
    public String barrowBook(@RequestParam String recordId){
        return userService.barrowService(recordId);
   }

}
