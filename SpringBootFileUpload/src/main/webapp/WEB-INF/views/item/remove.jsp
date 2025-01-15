<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mybatis 회원</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            const formObj = $("#memberForm");
            
            // 수정 요청
            $("#btnModify").on("click", function() {
                formObj.attr("action", "/user/modify");
                formObj.attr("method", "get");
                formObj.submit();
            });
            
            // 삭제 요청
            $("#btnRemove").on("click", function() {
                formObj.attr("action", "/user/remove");
                formObj.attr("method", "post");
                formObj.submit();
            });
            
            // 리스트 요청
            $("#btnList").on("click", function() {
                window.location.href = "/user/list";
            });
        });
    </script>
</head>
<body>
    <h3>회원 상세 정보</h3>
    <form:form id="memberForm" modelAttribute="member" action="#" method="post">
        <form:hidden path="userNo" />
        <table>
            <tr>
                <td>userid</td>
                <td><form:input path="userId" readonly="true" /></td>
            </tr>
            <tr>
                <td>username</td>
                <td><form:input path="userName" readonly="true" /></td>
            </tr>
            <c:forEach var="authIndex" begin="0" end="2">
                <tr>
                    <td>auth - ${authIndex + 1}</td>
                    <td>
                        <form:select path="authList[${authIndex}].auth" disabled="true">
                            <form:option value="" label="=== 선택해 주세요 ===" />
                            <form:option value="ROLE_USER" label="사용자" />
                            <form:option value="ROLE_MEMBER" label="회원" />
                            <form:option value="ROLE_ADMIN" label="관리자" />
                        </form:select>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form:form>
    <div>
        <button type="button" id="btnModify">수정하러가기</button>
        <button type="button" id="btnRemove">삭제처리</button>
        <button type="button" id="btnList">리스트보기</button>
    </div>
</body>
</html>
