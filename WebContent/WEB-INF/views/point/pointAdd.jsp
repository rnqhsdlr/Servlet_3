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
  <h1>Point Add Form</h1>
  <form action="./pointAdd" method="post">
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>
    
    <div class="form-group">
      <label for="num">Num:</label>
      <input type="text" class="form-control" id="num" placeholder="Enter Num" name="num">
    </div>
    
    <div class="form-group">
      <label for="kor">Kor:</label>
      <input type="text" class="form-control" id="kor" placeholder="Enter Point" name="kor">
    </div>
    
    <div class="form-group">
      <label for="eng">Eng:</label>
      <input type="text" class="form-control" id="eng" placeholder="Enter Point" name="eng">
    </div>
    
    <div class="form-group">
      <label for="math">Math:</label>
      <input type="text" class="form-control" id="math" placeholder="Enter Point" name="math">
    </div>
   
    <button type="submit" class="btn btn-success">Submit</button>
  </form>
</div>
	
</body>
</html>