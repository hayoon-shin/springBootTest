<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyBatis 게시판</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(document).ready(function() {
        var formObj = $("#board");
        $("#btnModify").on("click", function() {
            formObj.attr("action", "/board/modify");
            formObj.attr("method", "post");
            formObj.submit();
        });
        $("#btnList").on("click", function() {
            self.location = "/board/list";
        });
    });
</script>
</head>
<body>
     <h1>게시글 수정</h1>
    <form method="post" action="/board/modify">
        <input type="hidden" name="boardNo" value="${board.boardNo}">
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" value="${board.title}">
        <br>
        <label for="content">내용:</label>
        <textarea id="content" name="content">${board.content}</textarea>
        <br>
        <button type="submit">수정하기</button>
    </form>
    <div>
        <button type="submit" id="btnModify">Modify</button>
        <button type="submit" id="btnList">List</button>
    </div>
</body>
</html>