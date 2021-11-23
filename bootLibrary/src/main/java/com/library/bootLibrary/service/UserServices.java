package com.library.bootLibrary.service;

import com.library.bootLibrary.database.LibraryDao;
import com.library.bootLibrary.hibernateEntities.RubView1;
import com.library.bootLibrary.dto.UserDto;
import com.library.bootLibrary.hibernateEntities.Record;
import com.library.bootLibrary.formEntities.BookRequestPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ComponentScan(basePackages = "com.library.bootLibrary")
@Component
public class UserServices {
    @Autowired
    LibraryDao dao;
    @Autowired
    UserDto userDto;

    private String outOfBooks="";
    private String userRedirect="redirect:/user";

    public String userService(ModelMap modelMap){
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

    public String bookRequestService(HttpServletRequest request) throws ParseException {
        BookRequestPojo bookRequestPojo=new BookRequestPojo();
        bookRequestPojo.setFromDate(request.getParameter("fromDate"));
        bookRequestPojo.setToDate(request.getParameter("toDate"));
        bookRequestPojo.setBookId(request.getParameter("bookId"));
        dao.addRecord(new Record(bookRequestPojo,userDto.getUsername()));
        return userRedirect;
    }

    public String userLogoutService(){
        userDtoDestructor();
        return "redirect:/loginPage";
    }

    public void userDtoDestructor(){
        userDto.setUsername(null);
        userDto.setPassword(null);
        userDto.setRole(null);
        userDto.setBookList(null);
        userDto.setHavingBook(null);
        userDto.setHistory(null);
    }

    public String returnService(HttpServletRequest request){
        dao.returnBook(request.getParameter("recordId"));
        return userRedirect;
    }

    public String barrowService(HttpServletRequest request){
        outOfBooks="";
        try{
            dao.barrowBook(request.getParameter("recordId"));
        }
        catch (Exception e){
            outOfBooks=e.getMessage();
        }
        return userRedirect;
    }
}
