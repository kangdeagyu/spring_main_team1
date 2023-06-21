<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="css/admin_kkg.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/aQnA_style.css">
    <style>
        table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    th, td {
        border: 1px solid #ccc;
        padding: 8px;
        text-align: center;
    }

    th {
        background-color: #f2f2f2;
    }

    /* 댓글 입력 폼 스타일 */
    .comment-form {
        margin-bottom: 20px;
    }

    .comment-form input[type="text"] {
        width: 300px;
        padding: 8px;
    }

    .comment-form input[type="submit"] {
        padding: 8px 20px;
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }

    /* 등록된 댓글이 없을 때의 스타일 */
    .no-comments {
        text-align: center;
        margin-bottom: 20px;
    }
    </style>
    <title>리뷰 상세 보기</title>
    <script type="text/javascript">
        function confirmDelete(cid, form) {
            var confirmed = confirm("정말로 댓글을 삭제하시겠습니까?");
            if (confirmed) {
                alert("댓글이 성공적으로 삭제되었습니다.");
                return true;
            } else {
                return false;
            }
        }
    </script>
    <!-- 여기서부터 복사하시면 됩니다~~~~~~~~~!!!! -->
    <jsp:include page="admin_01_header.jsp" />
</head>

<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
                <jsp:include page="admin_01_sidebar.jsp" />
            </div>
            <div class="col-md-10" style="margin-left: 15%;">
                <main class="ms-sm-auto px-md-4">
                    <!-- 요기서부터 본문 내용 입력하면 됩니다아~~!!!!!  하단에  </div> 및 </main> 자리 맞춰서 넣는거만 기억하면 됩니다.-->
                    <h2>리뷰 상세 보기</h2>
                    <table>
                        <tr>
                            <td style="width: 100px;"><strong>제목:</strong></td>
                            <td>${forumView.ftitle}</td>
                        </tr>
                        <tr>
                            <td><strong>작성자:</strong></td>
                            <td>${forumView.f_cid}</td>
                        </tr>
                        <tr>
                            <td><strong>상품:</strong></td>
                            <td>${forumView.pname}</td>
                        </tr>
                        <tr>
                            <td><strong>내용:</strong></td>
                            <td>${forumView.fcontent}</td>
                        </tr>
                    </table>
                    <br/>
                   <h3>댓글 목록</h3>
<table>
    <tr style="text-align: center;">
        <th style="width: 100px;">작성자</th>
        <th>제목</th>
        <th>작성일</th>
        <th>댓글</th>
        <th>삭제</th>
    </tr>
    <tbody>
        <c:if test="${empty Clist}">
            <tr>
                <td colspan="5" class="no-comments">아직 등록된 댓글이 없습니다.</td>
            </tr>
        </c:if>
        <c:forEach items="${Clist}" var="cdto">
            <tr>
                <td>${cdto.cname}</td>
                <td class="text-left">
                    <c:choose>
                        <c:when test="${cdto.fstep eq 0}">
                            ${cdto.ftitle}
                        </c:when>
                        <c:otherwise>
                            <span style="font-weight: bold; margin-left: ${cdto.fstep * 30}px">ㄴ${cdto.ftitle}</span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${cdto.finsertdate}</td>
                <td>
                    <c:if test="${cdto.fdeletedate eq null}">
                        <form action="ABigCommentWrite.do" method="post" class="comment-form">
                            <input type="text" name="ftitle" placeholder="댓글을 입력하세요.">
                            <input type="hidden" name="ftype" value="${ftype}">
                            <input type="hidden" name="page" value="${forumView.fid}">
                            <input type="hidden" name="f_cid" value="${cid}">
                            <input type="hidden" name="fid" value="${cdto.fid}">
                            <input type="hidden" name="f_pid" value="${cdto.f_pid}">
                            <input type="hidden" name="fref" value="${cdto.fref}">
                            <input type="hidden" name="fstep" value="${cdto.fstep}">
                            <input type="hidden" name="fsteporder" value="${cdto.fsteporder}">
                            <input type="hidden" name="freforder" value="${cdto.freforder}">
                            <input type="hidden" name="fmotherid" value="${cdto.fmotherid}">
                            <input type="hidden" name="fanswernum" value="${cdto.fanswernum}">
                            <input type="hidden" name="fanswernum" value="${cdto.fsteporder}">
                            <input type="submit" id="replyButton_${cdto.f_cid}" value="입력">
                        </form>
                    </c:if>
                </td>
                <td>
                    <c:if test="${cdto.fdeletedate eq null}">
                        <form action="Acommentdelete.do" method="post" onsubmit="return confirmDelete('${cdto.f_cid}', this)">
                            <input type="hidden" name="ftype" value="${ftype}">
                            <input type="hidden" name="page" value="${forumView.fid}">
                            <input type="hidden" name="f_cid" value="${cdto.f_cid}">
                            <input type="hidden" name="fid" value="${cdto.fid}">
                            <input type="submit" id="deleteButton_${cdto.f_cid}" value="삭제">
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<!-- 새로운 댓글 입력 폼 -->
<div class="center-align" style="display: flex; justify-content: center;">
    <form action="Acommentwrite.do" method="post" class="comment-form">
        <input type="text" name="ftitle" style="width: 300px;" placeholder="댓글을 입력하세요.">
        <input type="hidden" name="ftype" value="${ftype}">
        <input type="hidden" name="fsteporder" value="${forumView.fsteporder}">
        <input type="hidden" name="fid" value="${forumView.fid}">
        <input type="hidden" name="f_cid" value="${cid}">
        <input type="hidden" name="f_pid" value="${forumView.f_pid}">
        <input type="submit" value="입력">
    </form>
</div>
            </main>
        </div>
    </div>
</body>
</html>