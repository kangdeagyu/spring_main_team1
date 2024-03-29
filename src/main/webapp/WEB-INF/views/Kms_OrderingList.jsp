<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style>
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



<title>장바구니</title>
</head>
<body>
	
		<div class="container">
			<figure class="text">
				<h3 class="text-dark">주문목록</h3>
			</figure>
		</div>

<main>
    <table border="1">
        <tr>
            <th style="width: 150px; text-align: center">주문 정보</th>
            <th style="width: 100px; text-align: center">상품 이미지</th>
            <th style="width: 200px; text-align: center">주문 내역 </th>
            <th style="width: 150px; text-align: center">주문 금액</th>
            <th style="text-align: center">주문 날짜</th>
            <th style="text-align: center">배송 상태</th>
            <th style="text-align: center">리뷰 쓰기</th>
        </tr>
		
		


		<c:forEach items="${Olist}" var="dto" varStatus="status">
				
			  <tr>
			   	<td style="width: 150px; text-align: center"><form action="OrderingView">
				   		<input type="hidden" name="oid" value="${dto.oid}">
	                    <input type="hidden" name="pname" value="${dto.pname}">
	                    <input type="hidden" name="cname" value="${dto.cname}">
	                    <input type="hidden" name="oqty" value="${dto.oqty}">
	                    <input type="hidden" name="oprice" value="${dto.oprice}">
				   		<input type="hidden" name="opostnum" value="${dto.opostnum}">
	                    <input type="hidden" name="oaddress1" value="${dto.oaddress1}">
	                    <input type="hidden" name="oaddress2" value="${dto.oaddress2}">
	                    <input type="hidden" name="omemo" value="${dto.omemo}">
	                    <input type="hidden" name="opaytype" value="${dto.opaytype}">
	                    <input type="hidden" name="odelivery" value="${dto.odelivery}">
	                    <input type="hidden" name="odate" value="${dto.odate}">
	                    <input type="submit" value="주문정보">
			   	</form></td>
			    <td style="width: 100px; text-align: center"><img src="image/${dto.pfilename }" style="width: 100px; height: 100px; margin-bottom: 10px;"  alt="..."></td>
			    <td style="width: 200px; text-align: center">${dto.pname} X ${dto.oqty}</td>
			    <td style="width: 150px; text-align: center"><fmt:formatNumber value="${dto.oprice}" pattern="#,##0원" /></td>
			    <td style="text-align: center">${dto.odate}</td>
			    <td style="text-align: center">
			     <c:choose>
          			<c:when test="${dto.odelivery == 0}">배송 전</c:when>
          			<c:when test="${dto.odelivery == 1}">배송 중</c:when>
		          	<c:when test="${dto.odelivery == 2}">배송 완료</c:when>
		          	<c:when test="${dto.odelivery == 3}">배송 완료</c:when>
		          	<c:otherwise>환불</c:otherwise>
		        </c:choose></td>
		        <td style="text-align: center">
		        	<c:choose>
			        <c:when test="${dto.odelivery == 3}">
			            작성완료
			        </c:when>
			        <c:otherwise>
            <c:if test="${dto.odelivery == 2}">
                <form action="ReviewWriteForum">
                    <input type="hidden" name="oid" value="${dto.oid}">
                    <input type="hidden" name="f_pid" value="${dto.product_pid}">
                    <input type="hidden" name="pname" value="${dto.pname}">
                    <input type="hidden" name="cname" value="${dto.cname}">
                    <input type="submit" value="리뷰쓰기">
                </form>
            </c:if>
        			</c:otherwise>
    				</c:choose>
				</td>
			  </tr>
		</c:forEach>
</table>
   	
    
      
</main>




	
	<!-- footer -->
	<%@ include file="bottom.jsp" %>
	

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>