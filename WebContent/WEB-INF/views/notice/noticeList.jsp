<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>
	
	
	<div class="container">
  <h2 id="notice" style="text-align: center">Notice</h2>
              
  <table class="table">
    <thead>
      <tr>
        <th>NO</th>
        <th>SUBJECT</th>
        <th>NAME</th>
        <th>DATE</th>
        <th>HIT</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="noticeDTO">
      <tr>
        <td>${noticeDTO.num }</td>
        <td style="width: 60%" id="select"> <a style="color: black" href="./noticeSelect?num=${noticeDTO.num}">${noticeDTO.title }</a></td>
        <td>${noticeDTO.id }</td>
        <td>${noticeDTO.day }</td>
        <td>${noticeDTO.hit }</td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
  <button type="button" class="btn btn-info" id="goo">글쓰기</button>
  
</div>


<script type="text/javascript">


	$("#goo").on("click", function() {
		if(${member.memberId eq "admin"}){
		location.href="./noticeAdd";
		} else {
			alert("관리자만 이용 가능합니다.")
		}
		
	})
</script>

	
	
</body>
</html>