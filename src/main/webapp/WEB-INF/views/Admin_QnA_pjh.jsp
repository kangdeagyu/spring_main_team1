<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>공지사항 작성</title>
    <link href="css/admin_kkg.css" rel="stylesheet">
    <style>
        .container-fluid {
            margin-top: 20px;
        }

        .row {
            display: flex;
        }

        .col-md-2, .col-md-10 {
            padding: 10px;
        }

        .col-md-2 {
            background-color: #f8f9fa;
        }

        .col-md-10 {
            margin-left: 15%;
        }

        main {
            padding: 20px;
        }

        h3 {
            margin-bottom: 20px;
        }

        form {
            margin-bottom: 20px;
        }

        table {
            margin-bottom: 20px;
            width: 50%;
            border-collapse: collapse;
        }

        td {
            padding: 10px;
        }

        input[type="text"],
        textarea {
            width: 50%;
            padding: 5px;
        }

        input[type="submit"],
        input[type="button"] {
            padding: 5px 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover,
        input[type="button"]:hover {
            background-color: #0069d9;
        }
        
        
    </style>
    <!-- 여기서부터 복사하시면 됩니다~~~~~~~~~!!!! -->
    <jsp:include page="admin_01_header.jsp" />
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
                <jsp:include page="admin_01_sidebar.jsp" />
            </div>
            <div class="col-md-10">
                <main>
                    <!-- 요기서부터 본문 내용 입력하면 됩니다아~~!!!!!  하단에 </div> 및 </main> 자리 맞춰서 넣는거만 기억하면 됩니다. -->
                    <h3>공지사항</h3>
                    <form action="ANoticeUpload.do?ftype=${ftype}" method="post" id="myForm">
                        <table>
                            <tr>
                                <td>이름:</td>
                                <td>관리자</td>
                            </tr>
                            <tr>
                                <td>제목 :</td>
                                <td><input type="text" name="title"></td>
                            </tr>
                            <tr>
                                <td>내용 :</td>
                                <td><textarea name="content" rows="10"></textarea></td>
                            </tr>
                            <tr>
                            <td></td>
                            <td>
                        <input type="submit" name="action" value="업로드">
                        <input type="button" value="재작성" onclick="resetForm()">
                        <input type="submit" value="목록" formaction="Awritelist.do?ftype=${ftype}">
                        </table>
                        </div>
                    </form>
                </main>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        function resetForm() {
            document.getElementById("myForm").reset();
        }
    </script>
</body>
</html>