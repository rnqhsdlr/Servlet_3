<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- BootStrap -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="${pageContext.request.contextPath}/point/pointList">Point</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     
      <li><a href="${pageContext.request.contextPath }/member/memberPage"><span class="glyphicon glyphicon-user"></span> My Page</a></li>
      <li><a href="${pageContext.request.contextPath }/member/memberLogout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      
    </ul>
  </div>
</nav>

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
		<a href="./memberUpdate?num=${member.memberId}" class="btn btn-primary">Update</a>
	
	</div>
</div>

</body>
</html>