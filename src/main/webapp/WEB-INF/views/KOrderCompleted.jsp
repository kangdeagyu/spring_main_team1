<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 성공</title>
</head>
<body>

		<div class="container">
			<figure class="text-center">
				<h3 class="text-dark">Little and Precious</h3>
				<h3 class="text-dark">주문이 완료 되었습니다</h3>	
				<h3 class="text-dark">감사합니다.</h3>	
				<h3 class="text-dark"><a href="orderinglist">주문내역</a></h3>	
			</figure>
		</div>
		
		<figure class="text-center">
			<button class="w-100 btn btn-lg btn-primary" onclick="home()">홈으로 가기</button>
		</figure>
	
		<script type="text/javascript">
			function home(){
				 window.location.href = "/";
			}
		</script>
	
	
	<%@ include file="bottom.jsp" %>
</body>
</html>