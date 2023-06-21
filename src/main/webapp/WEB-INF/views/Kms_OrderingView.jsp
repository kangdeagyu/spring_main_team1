<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<script type="text/javascript">
    function confirmRefund() {
        var confirmed = confirm("정말 환불 하시겠습니까?");
        if (confirmed) {
            alert("제품이 성공적으로 환불되었습니다.");
            return true;
        } else {
            return false;
        }
    }
</script>

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



<title>주문 상세정보</title>
</head>
<body>
	
		<div class="container">
			<figure class="text">
				<h3 class="text-dark">주문 상세정보</h3>
			</figure>
		</div>

<main>
    <table border="1">
        <tr>
            <td style="text-align: center">주문 번호 :</td><td style="text-align: center">${param.oid }</td>
        </tr>
        <tr>
            <td style="text-align: center">주문날짜 :</td><td>${param.odate }</td>
        </tr>
        <tr>
            <td style="text-align: center">상품 :</td><td>${param.pname }</td>
        </tr>
        <tr>
            <td style="text-align: center">수량 :</td><td>${param.oqty }</td>
        </tr>
        <tr>
		    <td style="text-align: center">금액 :</td>
		    <td><fmt:formatNumber value="${param.oprice}" pattern="#,##0원" /></td>
		</tr>

        <tr>
            <td style="text-align: center">배송상태 :</td><td><c:choose>
          			<c:when test="${param.odelivery == 0}">배송 전</c:when>
          			<c:when test="${param.odelivery == 1}">배송 중</c:when>
		          	<c:when test="${param.odelivery == 2}">배송 완료</c:when>
		          	<c:when test="${param.odelivery == 3}">배송 완료</c:when>
		          	<c:when test="${param.odelivery == 4}">환불 완료</c:when>
		        </c:choose></td>
        </tr>
        <tr>
            <td style="text-align: center">우편 번호 :</td><td>${param.opostnum }</td>
        </tr>
        <tr>
            <td style="text-align: center">상세주소 :</td><td>${param.oaddress1 }<br/>${param.oaddress2 }</td>
        </tr>
        <tr>
            <td style="text-align: center">요청사항 :</td><td>${param.omemo }</td>
        </tr>
        <tr>
            <td style="text-align: center">결제방법 :</td><td>${param.opaytype }</td>
        </tr>
        <tr>
            <td style="text-align: center">주문자 :</td><td>${param.cname }</td>
        </tr>
		
		<c:set var="listSize" value="${fn:length(list)}" />
</table>
				<c:choose>
          			<c:when test="${param.odelivery == 2}">환불 불가</c:when>
		          	<c:when test="${param.odelivery == 3}">환불 불가</c:when>
		          	<c:when test="${param.odelivery == 4}">환불 완료</c:when>
		          	<c:otherwise>
						<form id="refundForm" action="orderRefund">
							<input type="hidden" name="oid" value="${param.oid}">
							<input type="submit" value="환불요청">
						</form>
					</c:otherwise>
		        </c:choose>
		        

    
      
</main>




	
	<!-- footer -->
	<%@ include file="bottom.jsp" %>
	

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>