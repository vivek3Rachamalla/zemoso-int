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
<div class="row justify-content-center">
<div class="col-8">
<div class="row justify-content-center">
<div class="col-10">
<h1>Welcome ${userDto.getUsername()}</h1>
</div>
</div>
</div>
<div class="col-4">
<form action="userLogout"><button type="submit" class="btn btn-primary" style="float: right;">Logout</button></form>
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
        <c:forEach items="${userDto.getBookList()}" var="book">
        <form action="bookRequest" >
        <tr>
        <td>${book.getName()}</td>
        <td>${book.getAuthor()}</td>
        <td><input type="date" id="start" name="fromDate"
                   value=${ userDto.getDate() }
                    min=${ userDto.getDate() } max="2024-12-31"></td>
        <td><input type="date" id="start" name="toDate"
                           value=${ userDto.getDate() }
                           min=${ userDto.getDate() } max="2024-12-31"></td>
         <td><button type="submit" class="btn btn-success" name="bookId" value=${ book.getId() } >Request</button></td>
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
         <th>Book name</th>
         <th>Permission</th>
         <th>From date</th>
         <th>To date</th>
         <th>Barrow</th>
         </tr>
   </thead>
   <tbody>
     <c:forEach items="${userDto.getHistory()}" var="rubView">
     <tr>
     <td>${rubView.getName()}</td>
     <td>${rubView.getPermission()}</td>
     <td>${rubView.getFromDate()}</td>
     <td>${rubView.getToDate()}</td>
     <td><form action="barrow"><button type="submit" class="btn btn-success" name="recordId" value=${ rubView.getRecordId() }>Barrow</button></form></td>
     </tr>
     </c:forEach>
   </tbody>
</table>
</div>

<div class="container">
<div class="row">
<div class="col-4">
<table class="table table-striped">
   <thead>
         <tr>
         <th>Book name</th>
         <th>Return</th>
         <th>warning</th>
         </tr>
   </thead>
   <tbody>
     <c:forEach items="${userDto.getHavingBook()}" var="rubViewMap">
     <tr>
     <td>${rubViewMap.key.getName()}</td>
     <td><form action="return"><button type="submit" class="btn btn-danger" name="recordId"  value=${ rubViewMap.key.getRecordId() }>return</button></form></td>
     <td Style="color: #ff0000;" >${rubViewMap.value}</td>
     </tr>
     </c:forEach>
   </tbody>
</table>
</div>
</div>
</div>
</body>
</html>
