# Servlet_3

####
- 공지사항(Notice) 게시판
- 글쓰기, 수정, 삭제 id가 admin인 사람만 가능
- 글리스트 페이지, 최신순으로 출력
- 리스트페이지에서 글쓰기 버튼을 누르면 글쓰기 이동
- 리스트페이지에서 글제목을 누르면 글상세보기 이동
- 글상세보기에서 글수정, 글삭제 버튼 존재
- 글삭제 버튼을 누르면 확인, 취소 창을 띄우고 확인을 누르면 삭제,
- 글수정 누르면 글수정 이동
- [option] 조회수, 글상세보기 하면 조회수를 1 증가

##Notice
- 리스트(select) 최신순으로
- 글쓰기(insert)
- 수정(update)
- 삭제(delete)
- 글 제목 누르면 글상세보기(select one) 이동


 
 
# 기능

##Member
- 회원 가입(insert)
- 로그인 (select one)
- 회원 수정 (update)
- 회원 탈퇴(delete)
- myPage

## JSP
- /WEB-INF/views/member/...

URL
/member/memberJoin		memberJoin.JSP		GET
/member/memberJoin							POST
/member/memberLogin		memberLogin.jsp		GET
/member/memberLogin							POST
/member/memberPage		memberPage.jsp		GET
/member/memberUpdate	memberUpdate.jsp	GET
/member/memberUpdate						POST
/member/memberDelete						GET

### point
- point list 출력
- point 등록
- point 상세정보
- point 수정
- point 삭제

## JSP
- pointList.jsp		: List 출력
- pointAdd.jsp		: 입력폼
- pointSelect.jsp	: point 상세정보 출력
- pointMod.jsp		: point 수정 폼

## URL 주소			/	JSP				/	Method 
### /WEB-INF/views/point/**
- /point/pointList	/	pointList.jsp	/	GET
- /point/pointAdd	/	pointAdd.jsp	/	GET
- /point/pointAdd	/					/	POST
- /point/pointSelect/	pointSelect.jsp	/	GET
- /point/pointMod	/	pointMod.jsp	/	GET
- /point/pointMod	/					/	POST
- /point/pointDelete/					/	GET


