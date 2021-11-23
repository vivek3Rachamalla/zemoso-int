<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admim</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<%@ page isELIgnored="false" %>
</head>
<body>

<div class="jumbotron" style="background-color: #5cd6d6;">
<div class="row">
<div class="col-8">
<div class="row justify-content-center">
<div class="col-10">
<h1>Welcome admin</h1>
</div>
</div>
</div>
<div class="col-4">
<form action="adminLogout"><button type="submit" class="btn btn-primary" style="float: right;">Logout</button></form>
</div>
</div>
</div>
<div class="col-4">
<div class="container">
<div class="row justify-content-end	">
<div class="col-6" style="padding-top: 50px;">
</div>
</div>
</div>
</div>
</div>
</div>
<div class="container">
<h1>new users for the application seeking for access</h1>
<table class="table table-striped">
    <thead>
      <tr>
        <th>Username</th>
        <th>Role</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Phone Number</th>
        <th>Accept request</th>
        <th>Deny request</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${adminDto.getRegisterList()}" var="register">
      <tr>
        <td>${register.getUsername()}</td>
        <td>${register.getRole()}</td>
        <td>${register.getFirstName()}</td>
        <td>${register.getLastName()}</td>
        <td>${register.getPhoneNo()}</td>

        <td><form action="acceptRegister"><button type="submit" class="btn btn-success" name="username" value=${ register.getUsername() } >Accept</button></form></td>
        <td><form action="denyRegister"><button type="submit" class="btn btn-danger" name="username" value=${ register.getUsername() }>Deny</button></form></td>
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
        <th>user name</th>
        <th>give permission</th>
        <th>reject permission</th>
      </tr>
      </thead>
          <tbody>
          <c:forEach items="${adminDto.getRubViewList()}" var="bookRequest">
          <tr>
          <td>${bookRequest.getName()}</td>
          <td>${bookRequest.getUsername()}</td>
          <td><form action="givePermission"><button type="submit" class="btn btn-success" name="recordId" value=${ bookRequest.getRecordId() } >Give</button></form></td>
          <td><form action="rejectPermission"><button type="submit" class="btn btn-danger" name="recordId" value=${ bookRequest.getRecordId() }>Reject</button></form></td>
          </tr>
          </c:forEach>
          </tbody>
</div>
<div class="container">
<table class="table table-striped">
<thead>
      <tr>
        <th>Book name</th>
        <th>Author name</th>
        <th>In library</th>
        <th>Out library</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${adminDto.getBookList()}" var="book">
        <tr>
        <td>${book.getName()}</td>
        <td>${book.getAuthor()}</td>
        <td>${book.getQuantity().getInLibrary()}</td>
        <td>${book.getQuantity().getOutLibrary()}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</div>
<div class="container">
<div class="row">
<div class="col-6" style="padding-top: 100px;">
<div class="card">
  <div class="card-header" style="background-color:#0d6efd"><h5 style="color: white">Add book</h5></div>
  <div class="card-body">
   <form:form modelAttribute="bookPojo" action="addBook">
       <div class="form-group" style="padding-top: 10px;">
         <form:label for="username" path="bookName">Book name:</form:label>
         <form:input type="text" path="bookName" class="form-control"  placeholder="Enter name" />
       </div>
       <div class="form-group" style="padding-top: 10px;">
         <form:label for="pwd" path="authorName">Author name:</form:label>
         <form:input type="text" path="authorName" class="form-control" placeholder="Enter author name"  />
       </div >
       <div class="form-group" style="padding-top: 10px;">
                <form:label  path="quantity">Quantity:</form:label>
                <form:input type="number" path="quantity" class="form-control" placeholder="Enter Quantity"  />
              </div >
       <div style="padding-top: 10px;">
       <button type="submit" class="btn btn-primary" style="float: right;" >Submit</button>
       </div>
     </form:form>
  </div>
</div>
</div>
</div>
</div>
</body>
</html>
