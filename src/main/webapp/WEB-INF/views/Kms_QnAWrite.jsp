<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA작성하기</title>
</head>
<script type="text/javascript">
    function validateForumWriteForm() {
        var title = document.getElementsByName("ftitle")[0].value;
        var content = document.getElementsByName("fcontent")[0].value;

        if (title.trim() === "") {
            alert("제목을 입력하세요.");
            return false;
        }

        if (content.trim() === "") {
            alert("내용을 입력하세요.");
            return false;
        }

        return true;
    }
</script>
<body>
<h1>QnA 작성</h1>
<form action="QnAwrite" method="post" onsubmit="return validateForumWriteForm()">
		<input type="hidden" name="f_pid" value="${param.pid }">
    <table>
        <tr>
            <td>제목</td>
            <td><input type="text" name="ftitle" ></td>
        </tr>
        <tr>
            <td>작성자</td>
            <td><input type="text" name="f_cid" value="${cid }" readonly="readonly"></td>
        </tr>
        <tr>
            <td>상품명</td>
            <td><input type="text" name="pname" value="${Pname.pname}" readonly="readonly"></td>
        </tr>
        <tr>
            <td colspan="2">내용</td>
        </tr>
    </table>
    <textarea name="fcontent" cols="35" rows="10"></textarea>
    <br/>
    <input type="submit" value="리뷰작성하기">
</form>
<%@ include file="bottom.jsp" %>
</body>
</html>