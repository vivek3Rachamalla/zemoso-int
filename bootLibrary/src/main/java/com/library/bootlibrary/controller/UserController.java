package com.library.bootlibrary.controller;


import com.library.bootlibrary.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;


@Controller
public class UserController {
    @Autowired
    UserServices userService;

    @GetMapping("/user")
    public String user(ModelMap modelMap){
        return userService.userService(modelMap);
    }

    @RequestMapping(value = "/bookRequest",method = {RequestMethod.GET,RequestMethod.POST})
    public String bookRequest(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String bookId ) throws ParseException {
       return userService.bookRequestService(fromDate,toDate,bookId);
   }

   @GetMapping(value = "/userLogout")
    public String userLogout(){
        return userService.userLogoutService();
   }

   @RequestMapping(value = "/return",method = {RequestMethod.GET,RequestMethod.POST})
    public String returnBook(@RequestParam String recordId){
        return userService.returnService(recordId);
   }

   @RequestMapping(value = "/barrow",method = {RequestMethod.GET,RequestMethod.POST})
    public String barrowBook(@RequestParam String recordId){
        return userService.barrowService(recordId);
   }

}
