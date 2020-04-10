<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<div class="row">
	<h1>My Page</h1>
		<table class="table table-hover">
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>전화번호</td>
				<td>이메일</td>
				<td>나이</td>
			</tr>
			
			<tr>
				<td>${member.memberId }</td>
				<td>${member.memberPw }</td>
				<td>${member.name }</td>
				<td>${member.memberPhone }</td>
				<td>${member.memberEmail }</td>
				<td>${member.memberAge }</td>
			</tr>
		</table>
		<button class="btn btn-primary" id="update">UPDATE</button>
		<button class="btn btn-danger" id="del">DELETE</button>
	</div>
</div>

<script type="text/javascript">
	
	$("#update").on("click", function() {
		location.href="./memberUpdate";
	})


	$("#del").on("click", function() {
		var result=confirm("탈퇴 하실?");
		console.log(result);
		if (result) {
			location.href="./memberDelete";
			
		}
		
	})
</script>
</body>
</html>