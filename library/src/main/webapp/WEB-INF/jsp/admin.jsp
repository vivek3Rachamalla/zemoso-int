<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <th>Password</th>
        <th>Role</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Phone Number</th>
        <th>Accept request</th>
        <th>Deny request</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${registers}" var="register">
      <tr>
        <td>${register.getUsername() }</td>
        <td>${register.getPassword()}</td>
        <td>${register.getRole()}</td>
        <td>${register.getFirstName()}</td>
        <td>${register.getLastName()}</td>
        <td>${register.getPhoneNo()}</td>

        <td><form action="accept"><button type="submit" class="btn btn-success" name="username" value=${ register.getUsername() } >Accept</button></form></td>
        <td><form action="deny"><button type="submit" class="btn btn-danger" name="username" value=${ register.getUsername() }>Deny</button></form></td>
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
        <th>author name</th>
        <th>available</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${books}" var="book">
        <tr>
        <td><form action="accept"><button type="submit" class="btn btn-info" name="bookId" value=${ book.getId() } >${book.getName()}</button></form></td>
        <td>${book.getAuthor()}</td>
        <td>${book.getAvailable()}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
