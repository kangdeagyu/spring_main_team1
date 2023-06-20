<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
 <table>
        <tr>
            <td style="width: 100px;"><strong>제목:</strong></td>
            <td>${AforumView.ntitle}</td>
        </tr>
        <tr>
            <td><strong>작성자:</strong></td>
            <td>${AforumView.n_aid}</td>
        </tr>
        <tr>
            <td colspan="2"><strong>내용:</strong></td>
        </tr>
        <tr>
            <td colspan="2">${AforumView.ncontent}</td>
        </tr>
    </table>
 <%@ include file="bottom.jsp" %>
</body>
</html>