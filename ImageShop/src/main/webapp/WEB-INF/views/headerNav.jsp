<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
        <div class="logo_set">
            <a href="../../main.jsp"><i class="fa-brands fa-stack-overflow"></i><span style="line-height: 90px; padding-left: 20px;">stack overflow</span></a>
        </div>
        <ul class="dropdown_list">
            <li><a href="/WEB-INF/views/user/register.jsp" class="dropbtn">회원가입</a>
                <div class="dropdown-content">
                    <a href="/join/join/view/login/login.jsp">로그인</a>
                    <a href="/join/join/view/login/mypage.jsp">마이페이지</a>
                </div></li>
            <li><a href="/codegroup/register.jsp" class="dropbtn">상품등록</a>
                <div class="dropdown-content">
                    <a href="/join/join/view/notice/list.jsp">공지사항</a>
                    <a href="/join/join/view/fileupload/fileuploadList.jsp">자료실</a>
                </div></li>
            <li><a href="/join/join/view/cart/productList.jsp" class="dropbtn">서비스 안내</a>
                <div class="dropdown-content">
                    <a href="#">menu1</a>
                    <a href="#">menu2</a>
                    <a href="#">menu3</a>
                </div></li>
            <li><a href="#" class="dropbtn">menu</a>
                <div class="dropdown-content">
                    <a href="#">menu1</a>
                    <a href="#">menu2</a>
                    <a href="#">menu3</a>
                </div></li>
        </ul>
        <div class="icon_set">
            <a href="#"><i class="fa-brands fa-facebook"></i></a>
            <a href="#"><i class="fa-brands fa-instagram"></i></a>
        </div>
    </header>
</body>
</html>