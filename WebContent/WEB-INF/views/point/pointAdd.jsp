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
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

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
   
    <a href="./pointDelete?num=${dto.num}" class="btn btn-danger">Submit</a>
  </form>
</div>
	
</body>
</html>