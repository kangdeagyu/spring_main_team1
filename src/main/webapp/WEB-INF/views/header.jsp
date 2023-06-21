<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Little</title>
	<style>

	  	html,
		body {
		  height: 100%;
		}
		
		body {
		  display: flex;
		  padding-top: 40px;
		  padding-bottom: 40px;
		}
		.header {
		  position: fixed;
		  top: 0;
		  left: 0;
		  width: 100%;
		}


	</style>



</head>
<body>
<div class="container">

 <div class="row">
 	<div class="col-3">
		<ul class="nav">
		  <li class="nav-item">
		    <a class="nav-link active" href="/">
		      <!-- <img src="image/so7.png" alt="" width="80" height="40"> -->
		      <h3 class="text-dark">Little and Precious</h3>
		    </a>
		  </li>
		 </ul>
	 </div>
	 <div class="col-6">
		<ul class="nav justify-content-center">
			  <li class="nav-item">
			    <a class="nav-link active" aria-current="page" href="/"><p class="text-dark">HOME</p></a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="CategoryView?num=0"><p class="text-dark">LAMP</p></a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="CategoryView?num=1"><p class="text-dark">MINIATURE</p></a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="CategoryView?num=2"><p class="text-dark">CHAIR</p></a>
			  </li>
			  <li class="nav-item">
			 	 <c:set var="ftype" value="${param.ftype}" />
			    <a class="nav-link" href="writelist?ftype=2"><p class="text-dark">Q&A</p></a>
		
		</ul>
		
	</div>
	<div class="col-3">
		<ul class="nav justify-content-end">
			<c:if test="${cid != null }">
				<li class="nav-item">
				   	<a class="nav-link" href="KMypageView"><p class="text-dark" >${name }님</p></a>
				<li class="nav-item">
				   	 <a class="nav-link" href="#" onclick="logoutAndKakaoLogout();"><p class="text-dark">로그아웃</p></a>
			    </li>
			</c:if>
			<c:if test="${cid == null }">
				<li class="nav-item">
				   	 <a class="nav-link" href="loginView"><p class="text-dark">로그인</p></a>
			    </li>
			</c:if>
			<li class="nav-item">	<!-- 마이 페이지 이동 -->
			    <a class="nav-link" href="KMypageView" onclick="return userCheck()">
			   	 <img src="image/so04.png" alt="" width="30" height="24">
			    </a>
		    </li>
			<li class="nav-item">	<!-- 장바구니 이동 -->
			    <a class="nav-link" href="KUserCartView" onclick="return userCheck()">
			   	 <img src="image/so9.png" alt="" width="30" height="24">
			    </a>
		    </li>
		</ul>
	</div>
</div>

<hr/>

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


<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>

function logoutAndKakaoLogout() {
	  Kakao.init('e94ea7cf7a4161d305da7590513621dc');
	  Kakao.isInitialized();

	  if (!Kakao.Auth.getAccessToken()) {
	    location.href='logout';
	    alert("로그아웃되었습니다. 편안한 하루 되세요!");
	    console.log('Not logged in.'); // 이미 로그아웃되어 있음
	    return;
	  }
	  
	  Kakao.Auth.logout(function(response) {
	    if (response) {
	      Kakao.Auth.setAccessToken(undefined); // 토큰 제거
	      location.href='logout';
	      alert("로그아웃되었습니다. 편안한 하루 되세요!");
	    } else {
	      alert("잘못된 정보입니다. 관리자에 문의해 주시기 바랍니다.");
	    }
	  });
}
  

  

</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>