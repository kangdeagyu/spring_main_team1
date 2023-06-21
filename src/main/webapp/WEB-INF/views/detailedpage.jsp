<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="header.jsp" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
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
<style>

.nav-linktwo {
  display: inline-block;
  padding: 15px 200px;
  background-color: black;
  margin-right: 20px;
  color: #fff;
  text-decoration: none;
  border-radius: 10px;
  margin-bottom: 20px;
  
}
.nav-linkthere{
 display: inline-block;
  padding: 15px 200px;
  background-color: black;
  margin-right: 20px;
  color: #fff;
  text-decoration: none;
  border-radius: 10px;
  margin-bottom: 20px;
  }

</style>

</head>
<script>
function updateTotalAmount() { // 수량을 늘렸을 때 db에 남아있는 갯수만큼만 가능
	  var quantity = parseInt(document.getElementById('quantity').value);
	  var price = parseInt(document.getElementById('price').innerText);
	  var maxQuantity = 30; // 최대 수량 설정
	  if (quantity > maxQuantity) {
	    quantity = maxQuantity; // 최대 수량을 초과하는 경우 최대 수량으로 설정
	    document.getElementById('quantity').value = maxQuantity; // 수량 입력 필드에 최대 수량 설정
	    alert('최대 수량을 초과할 수 없습니다.');
	  }
	  var totalAmount = quantity * price;
	  document.getElementById('total-amount').innerText = totalAmount;
	  var quantity = document.getElementById("quantity").value;
	}
function updateQty() {
	  var quantityField = document.getElementById('quantity');
	  var cartLink = document.getElementById('cartLink');
	  var purchaseLink = document.getElementById('purchaseLink');
	  
	  var quantity = parseInt(quantityField.value);
	  
	  var originalCartHref = cartLink.getAttribute('href');
	  var updatedCartHref = originalCartHref.replace(/qty=\d+/, 'qty=' + quantity);
	  cartLink.setAttribute('href', updatedCartHref);
	  
	  var originalPurchaseHref = purchaseLink.getAttribute('href');
	  var updatedPurchaseHref = originalPurchaseHref.replace(/qty=\d+/, 'qty=' + quantity);
	  purchaseLink.setAttribute('href', updatedPurchaseHref);
	}

productImage.innerHTML = '<img src="' + randomProduct.image + '" alt="' + randomProduct.name + '">';
productName.textContent = randomProduct.name;
productDescription.textContent = randomProduct.description;

</script>

<body>

<div class="container">
  <table class="product-table">
    <thead>
      <tr>
        <c:forEach items="${listdetailPage}" var="dto">
          <td class="product-image">
            <img alt="상품 이미지" style="width: 500px; height: 500px;" src="image/${dto.pfilename}">
          </td>
          
         
       
          <td class="product-info">
          <table class="product-info-table" style="margin-left: 150px; margin-right: 0;">
              <tr>
              	<th>상품 이름</th>
              	<td>${dto.pname}</td>
              	</tr>
              	<tr>
                <th>상품 설명</th>
                <td>${dto.pcontent}</td>
              </tr>
              <tr>
                <th>상품 가격</th> 
                <td id="price">${dto.pprice}</td>
              </tr>
              <tr>
                <th>수량</th> 
            	<td>
            	<form action="userCart.jsp" method="get">
 						 <input type="hidden" name="pid" value="${dto.pid}">
 						 <input type="number" id="quantity" value="1" min="1" max="${dto.pstock}" onchange="updateTotalAmount()">
				</form>
       
   	
   <tr>
     <td colspan="2" class="purchase-details">
       <div class="money">
         <span>총 구매 금액: </span>
         <span id="total-amount">${dto.pprice}</span><br><br><br>
         	<c:if test="${cid != null }">
       	          <a id="purchaseLink" class="nav-linkthere" href="KJJOrderView?pid=${dto.pid}&qty=1" onclick="updateQty()">구매하기</a>
           			<a id="cartLink" class="nav-linktwo" href="KUserCartViewKJJ?pid=${dto.pid}&qty=1" onclick="updateQty()">장바구니</a>
           </c:if>
           <c:if test="${cid == null }">
       	          	<a id="purchaseLink" class="nav-linkthere" href="#" onclick="return userCheck()">구매하기</a>
           			<a id="cartLink" class="nav-linktwo" href="#" onclick="return userCheck()">장바구니</a>           
           </c:if>
       </div>
     </td>
   </tr>
            </table>
          </td>
        </c:forEach>
      </tr>
    </thead>
  </table>
</div>
<script type="text/javascript">

function userCheck() {
	if(${cid == null }){
	    alert("로그인을 해주세요.")
	    return false
	}else{
		return true
	}
	
}





</script>

<div id="detailReview" class="table-responsive">
		 <table class="table table-striped table-sm">
		  <thead class="thead-light">
		    <tr>
		      <th style="width: 100px; text-align: center">
		       ReviewNo.
		      </th>
		      <th style="width: 200px; text-align: center">작성자</th>
		      <th style="width: 200px; text-align: center">제품</th>
		      <th style="width: 350px; text-align: center">제목</th>
		      <th style="width: 300px; text-align: center">작성일</th>
		    </tr>
		    </thead>
        	<c:choose>
    <c:when test="${empty Rdto}">
        <tr>
            <td colspan="6">아직 게시물이 없습니다.</td>
        </tr>
    </c:when>
    <c:otherwise>
    		<c:set var="a" value="0" />
        	<c:forEach items="${Rdto}" var="dto">
        	<c:set var="a" value="${a+1}" />
            	<tr>
                <td style="text-align: center"><a href="ForumView?fid=${dto.fid}">${a}</a></td>
                <td style="text-align: center">${dto.cname}</td>
                <td style="text-align: center">${dto.pname}</td>
                <td style="text-align: center">${dto.ftitle}</td>
                <td style="text-align: center">${dto.finsertdate}</td>
            	</tr>
        	</c:forEach>
        	 </c:otherwise>
</c:choose>
		</table>
	</div>

<div id="detailQna" class="table-responsive">
			<table class="table table-striped table-sm">
			  <thead class="thead-light">
			    <tr>
			      <th style="width: 100px; text-align: center">
			       QnANo.
			      </th>
			      <th style="width: 200px; text-align: center">작성자</th>
			      <th style="width: 200px; text-align: center">제품</th>
			      <th style="width: 350px; text-align: center">제목</th>
			      <th style="width: 300px; text-align: center">작성일</th>
			    </tr>
			    </thead>
        	<c:choose>
    <c:when test="${empty Qdto}">
        <tr>
            <td colspan="6">아직 게시물이 없습니다.</td>
        </tr>
    </c:when>
    <c:otherwise>
   			<c:set var="b" value="0" />
        	<c:forEach items="${Qdto}" var="dto">
        	<c:set var="b" value="${b+1}" />
            	<tr>
                <td style="text-align: center"><a href="ForumView?fid=${dto.fid}">${b}</a></td>
                <td style="text-align: center">${dto.cname}</td>
                <td style="text-align: center">${dto.pname}</td>
                <td style="text-align: center">${dto.ftitle}</td>
                <td style="text-align: center">${dto.finsertdate}</td>
            	</tr>
        </c:forEach>
         </c:otherwise>
</c:choose>


</table></div>
<form action="QnAWrite" method="get" onsubmit="return userCheck()">
<input type="submit" value="질문작성하기">
<input type="hidden" name="cid" value="${cid }">
<input type="hidden" name="pid" value="${param.pid}">
</form>

<%@ include file="bottom.jsp" %>
</body>

</html>