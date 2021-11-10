<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<script>function Login(){
	document.getElementById("#register").style.display="none";
	document.getElementById("#login").style.display="block";
}

function Register(){
	document.getElementById("#login").style.display="none";
	document.getElementById("#register").style.display="block";
}</script>
</head>
<body>

<div class="jumbotron" style="background-color: #5cd6d6;">
<div class="row">
<div class="col-8">
<div class="row justify-content-center">
<div class="col-10">
<h1>Library</h1>
</div>
</div>
</div>
<div class="col-4">
<div class="container">
<div class="row justify-content-end	">
<div class="col-6" style="padding-top: 50px;">
<button type="button" class="btn btn-success" onclick="Login()" name="test">Login</button> 	
<button type="button" class="btn btn-success" onclick="Register()">Register</button>
</div>
</div>
</div>
</div>
</div>
</div>

<div class="container" id="#login" >
<div class="row justify-content-center">
<div class="col-6" style="padding-top: 100px;">
<div class="card">
  <div class="card-header" style="background-color:#0d6efd"><h5 style="color: white">Login</h5></div>
  <div class="card-body">
   <form action="login">
       <div class="form-group" style="padding-top: 10px;">
         <label for="username">Username:</label>
         <input type="text" class="form-control" id="Username" placeholder="Enter Username" name="username">
       </div>
       <div class="form-group" style="padding-top: 10px;">
         <label for="pwd">Password:</label>
         <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
       </div >
       <div style="padding-top: 10px;">
       <button type="submit" class="btn btn-primary" >Submit</button>
       </div>
     </form>
  </div>
</div>
</div>
</div>
</div>


<div class="container" id="#register" style="display: none;">
<div class="row justify-content-center">
<div class="col-6" style="padding-top: 100px;">
<div class="card">
  <div class="card-header" style="background-color:#0d6efd"><h5 style="color: white">Register</h5></div>
  <div class="card-body">
  <form action="register">
  <div class="form-group" style="padding-top: 10px;">
        <label for="username">Username:</label>
        <input type="text" class="form-control" id="Username" placeholder="Enter Username" name="username">
      </div>
      <div class="form-group" style="padding-top: 10px;">
        <label for="pwd">Password:</label>
        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
      </div>
      <div class="form-group" style="padding-top: 10px;">
              <label for="Role">Role:</label>
              <input type="text" class="form-control" id="role" placeholder="Enter role" name="role">
      </div>
    <div class="form-group" style="padding-top: 10px;">
      <label for="firstname">First name:</label>
      <input type="text" class="form-control" id="Firstname" placeholder="Enter First Name" name="firstName">
    </div>
    <div class="form-group" style="padding-top: 10px;">
      <label for="lastname">Last name:</label>
      <input type="text" class="form-control" id="Lastname" placeholder="Enter Last Name" name="lastName">
    </div>
    <div class="form-group" style="padding-top: 10px;">
      <label for="phoneNumber">Phone Number:</label>
      <input type="text" class="form-control" id="phoneNumber" placeholder="Enter Phone Number" name="phoneNumber">
    </div>

    <div style="padding-top: 10px;">
    <button type="submit" name="register" value="register" class="btn btn-primary" style="float: right;">Submit</button>
    </div>
  </form>
</div>
</div>
</div>
</div>
</div>


</body>
</html>