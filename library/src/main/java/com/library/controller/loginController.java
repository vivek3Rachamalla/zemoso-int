package com.library.controller;

import com.library.database.LibraryDao;
import com.library.hibernateEntities.Register;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class loginController {
    LibraryDao dao=new LibraryDao();

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, ModelMap modelMap){
        String username= request.getParameter("username");
        String password= request.getParameter("pswd");
        String role=dao.getRole(username,password);
        if(role.equals("user")) {
            modelMap.addAttribute("books",dao.getAllBooks());
            modelMap.addAttribute("user",dao.getUser(username));
            modelMap.addAttribute("rubView",dao.getRubViewList());
            return "user";
        }
        else if(role.equals("admin")){
            modelMap.addAttribute("registers",dao.getRegisterList());
            modelMap.addAttribute("books",dao.getAllBooks());
            modelMap.addAttribute("bookRequest",dao.waitingRecordsList());
            return "admin";
        }
        return "error";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request){
        Register register=new Register(
        request.getParameter("username"),
        request.getParameter("password"),
        request.getParameter("role"),
        request.getParameter("firstName"),
        request.getParameter("lastName"),
        request.getParameter("phoneNumber"));
        dao.addRegister(register);
        return "login";
    }
    @RequestMapping("/accept")
    public String accept(HttpServletRequest request,ModelMap modelMap){
       String username= request.getParameter("username");
       dao.acceptRegister(username);
        modelMap.addAttribute("registers",dao.getRegisterList());
        modelMap.addAttribute("books",dao.getAllBooks());
        return "admin";
    }
    @RequestMapping("/deny")
    public String deny(HttpServletRequest request,ModelMap modelMap){
        String username= request.getParameter("username");
        dao.denyRegister(username);
        modelMap.addAttribute("registers",dao.getRegisterList());
        modelMap.addAttribute("books",dao.getAllBooks());
        return "admin";
    }
    @RequestMapping("/requestBook")
    public String requestBook(HttpServletRequest request,ModelMap modelMap){
        return "error";
    }

}