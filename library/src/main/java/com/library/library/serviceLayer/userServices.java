package com.library.serviceLayer;

import com.library.database.LibraryDao;
import com.library.hibernateEntities.rubView1;
import com.library.dtos.userDto;
import com.library.hibernateEntities.Record;
import com.library.pojo.bookRequestPojo;
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

@ComponentScan(basePackages = "com.library")
@Component
public class userServices {
    @Autowired
    LibraryDao dao;
    @Autowired
    userDto userDto;

    public String userService(ModelMap modelMap){
        userDto.setHavingBook(getHavingBookList(userDto.getUsername()));
        userDto.setHistory(permissionAndDate());
        modelMap.addAttribute("userDto",userDto);
        modelMap.addAttribute("bookRequestPojo",new bookRequestPojo());
        return "user";
    }

    public List<rubView1> permissionAndDate(){
       List<rubView1> rubView1List= dao.getRubViewList(userDto.getUsername());
        LocalDate today=LocalDate.now();
        LocalDate fromDate;
        LocalDate toDate;
        List<rubView1> newRubview1=new ArrayList<>(rubView1List);
        for(rubView1 rubView:rubView1List) {
            fromDate = rubView.getFromDate().toLocalDate();
            toDate = rubView.getToDate().toLocalDate();
            if ((today.isAfter(fromDate) || today.isEqual(fromDate))
                    && (today.isBefore(toDate) || today.isEqual(toDate))) newRubview1.add(rubView);
        }
        return newRubview1;
    }

    public Map<rubView1, String> getHavingBookList(String username){
        List<rubView1> rubViewList=dao.getUserBook(username);
        LocalDate today=LocalDate.now();
        LocalDate fromDate;
        LocalDate toDate;
        Map<rubView1,String> havingBooks =new HashMap<rubView1,String>();
        for(rubView1 rubView:rubViewList) {
             fromDate = rubView.getFromDate().toLocalDate();
             toDate = rubView.getToDate().toLocalDate();
                if ((today.isAfter(fromDate) || today.isEqual(fromDate))
                        && (today.isBefore(toDate) || today.isEqual(toDate))) havingBooks.put(rubView,"");
                else havingBooks.put(rubView,"return book");
        }
        return havingBooks;
    }

    public String bookRequestService(HttpServletRequest request) throws ParseException {
        bookRequestPojo bookRequestPojo=new bookRequestPojo();
        bookRequestPojo.setFromDate(request.getParameter("fromDate"));
        bookRequestPojo.setToDate(request.getParameter("toDate"));
        bookRequestPojo.setBookId(request.getParameter("bookId"));
        dao.addRecord(new Record(bookRequestPojo,userDto.getUsername()));
        return "redirect:/user";
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
        return "redirect:/user";
    }

    public String barrowService(HttpServletRequest request){

        dao.barrowBook (request.getParameter("recordId"));
        return "redirect:/user";
    }
}
