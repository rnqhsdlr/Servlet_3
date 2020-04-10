<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../template/boot.jsp"></c:import>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>

<div class="container">
  <h1>Member Join</h1>
  <form action="./memberJoin" method="post">
    <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="memberId">
    </div>
    
    <div class="form-group">
      <label for="pw">PW:</label>
      <input type="password" class="form-control" id="pw" placeholder="Enter Password" name="memberPw">
    </div>
    
    <div class="form-group">
      <label for="name">NAME:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>
    
    <div class="form-group">
      <label for="phone">PHONE:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter PhoneNum" name="memberPhone">
    </div>
    
    <div class="form-group">
      <label for="email">EMAIL:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter Email" name="memberEmail">
    </div>
    
    <div class="form-group">
      <label for="age">AGE:</label>
      <input type="text" class="form-control" id="age" placeholder="Enter Age" name="memberAge">
    </div>
   
    <button type="submit" class="btn btn-success">Submit</button>
  </form>
</div>


</body>
</html>