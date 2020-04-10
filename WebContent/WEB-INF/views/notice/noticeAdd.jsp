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
  
  <form action="./noticeAdd" method="post">
  	<div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title">
    </div>
    <div class="form-group">
      <label for="text">Comment:</label>
      <textarea class="form-control" rows="20" id="text" name="text"></textarea>
    </div>
    <input type="file"><br><br>
    <button type="submit" class="btn btn-primary">확인</button>
  </form>
</div>


</body>
</html>