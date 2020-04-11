<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>

<style type="text/css">
	#text {
		width: 100%;
		height: 600px;
		font-size: 1.5em;
	
	}
	#mod {
		float : right;
		margin-right: 20px;
	}
	#del {
		float: right;
	}
	


</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
    
      <tr>
        <td>${noticeDTO.num }</td>
        <td style="width: 60%">${noticeDTO.title }</td>
        <td>${noticeDTO.id }</td>
        <td>${noticeDTO.day }</td>
        <td>${noticeDTO.hit }</td>
      </tr>
     
    </tbody>
  </table>
   <table class="table" style="border: 1px solid gray;">
  	 <tr>
      	<td id="text">${noticeDTO.text }</td>
      </tr>
   </table><br>
  <button type="button" class="btn btn-danger" id="del">삭제하기</button>
  <button type="button" class="btn btn-primary" id="mod">수정하기</button>
  
</div>

	<div class="container">
               
  <ul class="pager">
    <li class="previous"><a href="./noticeSelect?num=${noticeDTO.num-1 }">Previous</a></li>
    <li class="next"><a href="./noticeSelect?num=${noticeDTO.num+1 }">Next</a></li>
  </ul>
</div>

<script type="text/javascript">

	$(".previous > a").on("click", function() {
		if(${noticeDTO.num-1 eq 0}) {
			alert("마지막 페이지입니다.");
		}
	})
	
	$("#mod").on("click", function() {
		if(${member.memberId eq "admin"}){
			location.href="./noticeUpdate?num="+${noticeDTO.num};	
		} else {
			alert("관리자만 가능합니다.")
		}
		
	})
	
	
	
	$("#del").on("click", function() {
		if(${member.memberId eq "admin"}){
			if(confirm("정말 삭제하시겠습니까?")){
			location.href="./noticeDelete?num="+${noticeDTO.num};	
			};
		} else {
			alert("관리자만 가능합니다.")
		}
		
	})


</script>

</body>
</html>