<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
 	
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/headerNav.css">
    <script src="/js/main.js"></script>
    <script type="text/javascript" src="/js/test.js"></script>
    <script src="https://kit.fontawesome.com/70bcde4f7a.js" crossorigin="anonymous"></script>
</head>
<body onload="carousel();" >
<%@ include file="/WEB-INF/views/headerNav.jsp"%>
     <div class="slideshow">
        <div class="slideshow_slides">
            <a href="#"><img src="/image/slide-1.jpg" alt=""></a>
            <a href="#"><img src="/image/slide-2.jpg" alt=""></a>
            <a href="#"><img src="/image/slide-3.jpg" alt=""></a>
            <a href="#"><img src="/image/slide-4.jpg" alt=""></a>
        </div>
        <div class="slideshow_nav">
            <a href="#" class="prev"><i class="fa-solid fa-circle-chevron-left"></i></a>
            <a href="#" class="next"><i class="fa-solid fa-circle-chevron-right"></i></a>
        </div>
        <div class="slideshow_indicator">
            <a href="#" class="active"><i class="fa-solid fa-circle-dot"></i></a>
            <a href="#"><i class="fa-solid fa-circle-dot"></i></a>
            <a href="#"><i class="fa-solid fa-circle-dot"></i></a>
            <a href="#"><i class="fa-solid fa-circle-dot"></i></a>
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>