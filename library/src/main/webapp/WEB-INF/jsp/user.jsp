<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<%@ page isELIgnored="false" %>
</head>
<body>

<div class="jumbotron" style="background-color: #5cd6d6;">
<div class="row">
<div class="col-8">
<div class="row justify-content-center">
<div class="col-10">
<h1>Welcome user</h1>
</div>
</div>
</div>
</div>
</div>
<div class="container">
<table class="table table-striped">
<thead>
      <tr>
        <th>Book name</th>
        <th>author name</th>
        <th>from date</th>
        <th>to date</th>
        <th>Request</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${books}" var="book">
        <form action="">
        <tr>
        <td>${book.getName()}</td>
        <td>${book.getAuthor()}</td>
        <td>${book.getAvailable()}</td>
        <td><input type="date" id="start" name="trip-start"
                   value="2021-11-09"
                   max="2021-11-09" min="2021-11-09"</td>
        <td><input type="date" id="start" name="trip-start"
                           value="2021-11-09"
                           min="2021-11-09" max="2024-12-31"></td>
         <td><button type="submit" class="btn btn-success" >Request</button></td>
        </form>
        </tr>

        </c:forEach>
    </tbody>
</table>
</div>
<div class="container">
<table class="table table-striped">
   <thead>
         <tr>
         <th>Book ID</th>
         <th>Permission</th>
         <th>From date</th>
         <th>To date</th>
         </tr>
   </thead>
   <tbody>
     <c:forEach items="${user.getRecordList()}" var="record">
     <tr>
     <td name="bookID" value=${record.getBookId()} >${record.getBookId()}</td>
     <td>${record.getPermission()}</td>
     <td>${record.getFromDate()}</td>
     <td>${record.getToDate()}</td>
     </tr>
     </c:forEach>
   </tbody>
</table>
</div>

</body>
</html>
