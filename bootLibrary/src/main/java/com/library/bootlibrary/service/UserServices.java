package com.library.bootlibrary.service;

import com.library.bootlibrary.database.LibraryDao;
import com.library.bootlibrary.hibernateentities.RubView1;
import com.library.bootlibrary.dto.UserDto;
import com.library.bootlibrary.hibernateentities.Record;
import com.library.bootlibrary.formentities.BookRequestPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ComponentScan(basePackages = "com.library.bootLibrary")
@Service
public class UserServices {
    @Autowired
    LibraryDao dao;
    @Autowired
    UserDto userDto;

    private String outOfBooks="";
    private String userRedirect="redirect:/user";
    private String loginPageRedirect="redirect:/loginPage";

    public String userService(ModelMap modelMap){

        if(userDto.getUsername()==null && userDto.getPassword()==null) return loginPageRedirect;

        userDto.setHavingBook(getHavingBookList(userDto.getUsername()));
        userDto.setHistory(permissionAndDate());
        modelMap.addAttribute("userDto",userDto);
        modelMap.addAttribute("outOfBooks",outOfBooks);
        modelMap.addAttribute("bookRequestPojo",new BookRequestPojo());
        return "user";
    }

    public List<RubView1> permissionAndDate(){
       List<RubView1> rubView1List= dao.getRubViewList(userDto.getUsername());
        LocalDate today=LocalDate.now();
        LocalDate fromDate;
        LocalDate toDate;
        List<RubView1> newRubview1=new ArrayList<>();
        for(RubView1 rubView:rubView1List) {
            fromDate = rubView.getFromDate().toLocalDate();
            toDate = rubView.getToDate().toLocalDate();
            if ((today.isAfter(fromDate) || today.isEqual(fromDate))
                    && (today.isBefore(toDate) || today.isEqual(toDate))) newRubview1.add(rubView);
        }
        return newRubview1;
    }

    public Map<RubView1, String> getHavingBookList(String username){
        List<RubView1> rubViewList=dao.getUserBook(username);
        LocalDate today=LocalDate.now();
        LocalDate fromDate;
        LocalDate toDate;
        Map<RubView1,String> havingBooks =new HashMap<>();
        for(RubView1 rubView:rubViewList) {
             fromDate = rubView.getFromDate().toLocalDate();
             toDate = rubView.getToDate().toLocalDate();
                if ((today.isAfter(fromDate) || today.isEqual(fromDate))
                        && (today.isBefore(toDate) || today.isEqual(toDate))) havingBooks.put(rubView,"");
                else havingBooks.put(rubView,"return book");
        }
        return havingBooks;
    }

    public String bookRequestService(String fromDate,String toDate,String bookId) throws ParseException {
        BookRequestPojo bookRequestPojo=new BookRequestPojo();
        bookRequestPojo.setFromDate(fromDate);
        bookRequestPojo.setToDate(toDate);
        bookRequestPojo.setBookId(bookId);
        dao.addRecord(new Record(bookRequestPojo,userDto.getUsername()));
        return userRedirect;
    }

    public String userLogoutService(){
        userDtoDestructor();
        return loginPageRedirect;
    }

    public void userDtoDestructor(){
        userDto.setUsername(null);
        userDto.setPassword(null);
        userDto.setRole(null);
        userDto.setBookList(null);
        userDto.setHavingBook(null);
        userDto.setHistory(null);
    }

    public String returnService(String recordId){
        dao.returnBook(recordId);
        return userRedirect;
    }

    public String barrowService(String recordId){
        outOfBooks="";
        try{
            dao.barrowBook(recordId);
        }
        catch (Exception e){
            outOfBooks=e.getMessage();
        }
        return userRedirect;
    }
}
