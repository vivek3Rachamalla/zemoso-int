package com.library.bootlibrary.service;

import com.library.bootlibrary.database.LibraryDao;
import com.library.bootlibrary.hibernateentities.Book;
import com.library.bootlibrary.dto.AdminDto;
import com.library.bootlibrary.formentities.BookPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;


@ComponentScan(basePackages = "com.library.bootLibrary")
@Service
public class AdminServices {
    @Autowired
    LibraryDao dao;
    @Autowired
    AdminDto adminDto;

    private String adminRedirect="redirect:/admin";
    private String loginPageRedirect="redirect:/loginPage";

    public String adminService(ModelMap modelMap){

        if(adminDto.getUsername()==null && adminDto.getPassword()==null)
            return loginPageRedirect;

                modelMap.addAttribute("adminDto",adminDto);
        modelMap.addAttribute("bookPojo",new BookPojo());
        return "admin";
    }

    public String acceptService(String username){
        dao.acceptRegister(username);
        adminDto.setRegisterList(dao.getRegisterList());
        return adminRedirect;
    }

    public String adminLogoutService(){
        adminDtoDestructor();
        return loginPageRedirect;
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
        return adminRedirect;
    }

    public String denyService(String username) {
        dao.denyRegister(username);
        adminDto.setRegisterList(dao.getRegisterList());
        return adminRedirect;
    }

    public String givePermissionService(String recordId){
        dao.givePermissionForBook(recordId);
        adminDto.setRubViewList(dao.bookRequestList());
        return adminRedirect;
    }

    public String rejectPermissionService(String recordId){
        dao.rejectPermissionForBook(recordId);
        adminDto.setRubViewList(dao.bookRequestList());
        return adminRedirect;
    }
}
