package com.library.bootLibrary.service;

import com.library.bootLibrary.database.LibraryDao;
import com.library.bootLibrary.hibernateEntities.Book;
import com.library.bootLibrary.dto.AdminDto;
import com.library.bootLibrary.formEntities.BookPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;

@ComponentScan(basePackages = "com.library.bootLibrary")
@Component
public class AdminServices {
    @Autowired
    LibraryDao dao;
    @Autowired
    AdminDto adminDto;

    public String adminService(ModelMap modelMap){
        modelMap.addAttribute("adminDto",adminDto);
        modelMap.addAttribute("bookPojo",new BookPojo());
        return "admin";
    }

    public String acceptService(HttpServletRequest request, ModelMap modelMap){
        String username= request.getParameter("username");
        dao.acceptRegister(username);
        adminDto.setRegisterList(dao.getRegisterList());
        modelMap.addAttribute("adminDto",adminDto);
        return "admin";
    }

    public String adminLogoutService(){
        adminDtoDestructor();
        return "redirect:/loginPage";
    }

    public void adminDtoDestructor(){
        adminDto.setUsername(null);
        adminDto.setPassword(null);
        adminDto.setRole(null);
        adminDto.setRegisterList(null);
        adminDto.setRubViewList(null);
        adminDto.setBookList(null);
    }

    public String addBookService(BookPojo bookPojo){
        Book book=new Book(bookPojo);
        dao.addBook(book);
        adminDto.setBookList(dao.getAllBooks());
        return "redirect:/admin";
    }

    public String denyService(HttpServletRequest request) {
        String username = request.getParameter("username");
        dao.denyRegister(username);
        adminDto.setRegisterList(dao.getRegisterList());
        return "redirect:/admin";
    }


    public String givePermissionService(HttpServletRequest request){
        dao.givePermissionForBook(request.getParameter("recordId"));
        adminDto.setRubViewList(dao.bookRequestList());
        return "redirect:/admin";
    }

    public String rejectPermissionService(HttpServletRequest request){
        dao.rejectPermissionForBook(request.getParameter("recordId"));
        adminDto.setRubViewList(dao.bookRequestList());
        return "redirect:/admin";
    }
}
