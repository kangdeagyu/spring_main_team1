<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/admin_kkg.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.rtl.css" rel="stylesheet">
<link href="css/bootstrap.rtl.min.css" rel="stylesheet">

<link href="css/bootstrap-grid.css" rel="stylesheet">
<link href="css/bootstrap-grid.min.css" rel="stylesheet">
<link href="css/bootstrap-grid.rtl.css" rel="stylesheet">
<link href="css/bootstrap-grid.min.rtl.css" rel="stylesheet">


<link href="css/bootstrap-reboot.css" rel="stylesheet">
<link href="css/bootstrap-reboot.min.css" rel="stylesheet">
<link href="css/bootstrap-reboot.rtl.css" rel="stylesheet">
<link href="css/bootstrap-reboot.rtl.min.css" rel="stylesheet">

<link href="css/bootstrap-utilities.css" rel="stylesheet">
<link href="css/bootstrap-utilities.min.css" rel="stylesheet">
<link href="css/bootstrap-utilities.rtl.css" rel="stylesheet">
<link href="css/bootstrap-utilities.rtl.min.css" rel="stylesheet">
<title>제품 리뷰 목록</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="css/aQnA_style.css">
  <script>
        // 전체 데이터 개수
        var totalData = ${ListSize};

        // 데이터를 테이블에 렌더링하는 함수
        function renderData(data) {
            var tableBody = $("#tableBody");
            tableBody.empty();
            tableBody.append(data);
        }

        // 특정 페이지 번호에 해당하는 데이터를 가져오는 함수
        function GetTarget(pageNumber) {
            var dataPerPage = 10;
            var startIndex = (pageNumber - 1) * dataPerPage;
            var endIndex = startIndex + dataPerPage;

            var rows = $("#tableBody tr.data-row");
            rows.addClass("hidden-row"); // 모든 행 숨기기
            rows.slice(startIndex, endIndex).removeClass("hidden-row"); // 현재 페이지에 해당하는 행 보이기

            paging(totalData, pageNumber);
        }

        // 페이지네이션 링크 생성 함수
        function paging(totalData, currentPage) {
            var dataPerPage = 10;
            var pageCount = 10;

            var totalPage = Math.ceil(totalData / dataPerPage);
            var pageGroup = Math.ceil(currentPage / pageCount);

            var last = pageGroup * pageCount;
            var first = last - (pageCount - 1);
            var next = last + 1;
            var prev = first - 1;

            var pages = $("#pages");
            pages.empty();

            // 이전 링크 추가 (이전 페이지가 있는 경우)
            if (first > 10) {
                pages.append("<li class=\"pagination-item\">" +
                    "<a onclick=\"GetTarget(" + prev + ");\" style='margin-left: 2px'>이전</a></li>");
            }

            // 페이지 번호 링크 생성
            for (var i = first; i <= last; i++) {
                if (i > totalPage) {
                    break;
                }
                if (i == currentPage) {
                    pages.append("<li class=\"pagination-item\">" +
                        "<a class=\"active\">" + i + "</a></li>"); // 현재 페이지를 강조 표시
                } else {
                    pages.append("<li class=\"pagination-item\">" +
                        "<a onclick=\"GetTarget(" + i + ");\">" + i + "</a></li>"); // 다른 페이지에 대한 링크 추가
                }
            }

            // 다음 링크 추가 (더 많은 페이지가 있는 경우)
            if (last < totalPage) {
                pages.append("<li class=\"pagination-item\">" +
                    "<a onclick=\"GetTarget(" + next + ");\" style='margin-left: 2px'>다음</a></li>");
            }
        }

        $(document).ready(function() {
            GetTarget(1); // 초기 페이지를 1로 설정
        });
    </script>
<style>
	a.no-underline {
	    text-decoration: none;
	  }
    table {
        border-collapse: collapse;
        width: 100%;
    }

    th {
        text-align: center;
        padding: 10px;
    }

    th:first-child {
        text-align: left;
        width: 50%;
    }

    td {
        text-align: center;
        padding: 10px;
    }

    td:first-child {
        text-align: left;
    }
	.subscript {
    	vertical-align: super;
    	font-size: smaller;
	}
  .center-align {
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>

</head>
<body>

  
        <h1>QnA 게시판</h1>


    <div style="text-align: right;">
        <form action="forumSearch" method="post">
            <input type="hidden" name="ftype" value="2">
            <input type="text" name="content" placeholder="원하시는 상품을 검색하세요!">
            <input type="submit" value="검색">
        </form>
    </div>
	<div class="table-responsive">
    <table class="table table-striped table-sm">
  <thead class="thead-light">
    <tr>
      <th style="width: 100px; text-align: center">
        No.
      </th>
      <th style="width: 200px; text-align: center">작성자</th>
      <th style="width: 200px; text-align: center">제품</th>
      <th style="width: 350px; text-align: center">제목</th>
      <th style="width: 300px; text-align: center">작성일</th>
    </tr>
  </thead>
  <tbody id="tableBody">
    <c:forEach items="${noticelist}" var="noticedto" varStatus="status">
      <tr>
        <td style="text-align: center">${noticedto.nid}</td>
        <td style="text-align: center">관리자</td>
        <td style="text-align: center">공지사항</td>
        <td style="text-align: center"><a href="noticeView?nid=${noticedto.nid}" style="color: black;">${noticedto.ntitle}</a></td>
        <td style="text-align: center">${noticedto.ninsertdate}</td>
      </tr>
    </c:forEach>
    <c:set var="a" value="0" />
    <c:forEach items="${RList}" var="dto" varStatus="status">
    <c:set var="a" value="${a+1}" />
      <tr class="data-row hidden-row" id="dataRow${status.index}">
        <td style="text-align: center">${a}</td>
        <td style="text-align: center">${dto.cname}</td>
        <td style="text-align: center">${dto.pname}</td>
        <td style="text-align: center"><a href="ForumView?fid=${dto.fid}" class="no-underline" style="color: black;">${dto.ftitle}</a></td>
        <td style="text-align: center">${dto.finsertdate}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</div>

  <div class="pagination-wrapper clearfix">
        <ul class="pagination float--right" id="pages">
        </ul>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
</body>
</html>