<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }


      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
    </style>

<!--e94ea7cf7a4161d305da7590513621dc  -->

<link href="css/KLogin.css" rel="stylesheet">
</head>


<body>
<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
function kakaoLogin() {
	Kakao.init('e94ea7cf7a4161d305da7590513621dc'); // 발급받은 키 중 javascript키를 사용해준다.
	
		Kakao.Auth.login({
			success: function(authObj) {
				Kakao.API.request({
					url: '/v2/user/me',
					success: function(response) {
						console.log(response); // 응답 객체 출력하여 구조 확인
						
						var nickname = response.properties.nickname; // 닉네임 가져오기
						var kakaoAccount = response.kakao_account;
						var email = kakaoAccount.email; // 카카오 계정 이메일 가져오기
						var accessToken = authObj.access_token; // 카카오 토큰 가져오기
						
						
						// 이메일을 서버로 전송하여 데이터베이스에 있는지 확인
						
						axios.post('kakaoLogin', null, {
							params: {
								cid: email,
								cname: nickname,
								accessToken: accessToken,
							}
						})
						.then(response => {
							// 로그인 성공 시 처리
							console.log(response.data);
							if (response.data == "join") {
								alert("등록되어 있는 회원정보가 없습니다. 회원가입을 해주세요");
								window.location.href = 'joinView?kakao=1'; 
							} else if (response.data == "mdraw") {
								alert("탈퇴한 회원입니다.");
							} else {
								alert("로그인 성공");
								window.location.href = '/'; 
							}
						})
						.catch(error => {
							// 로그인 실패 시 처리
							this.errorMessage = error.response.data.message;
							alert("아이디와 비밀번호를 확인해주세요!");
						});
					},
					fail: function(error) {
						console.log(error);
					}
				});
			},
			fail: function(error) {
				console.log(error);
			}
		});
	
}

</script>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
 
 
<script type="text/javascript">
	//페이지가 로드될 때 호출되며, 저장된 쿠키가 있는 경우 해당 쿠키 값을 가져와 입력란에 표시하고 체크박스를 선택  
     $(function() {
           fnInit();   
     });
     
     function frm_check(){
         saveid();
     }
 
    function fnInit(){
        var cookieid = getCookie("saveid");
        console.log(cookieid);
        if(cookieid !=""){
            $("input:checkbox[id='saveId']").prop("checked", true);
            $('#floatingInput').val(cookieid);
        }
        
    }    
 	//setCookie(name, value, expiredays) 함수: 쿠키를 설정하는 함수입니다. 쿠키의 이름, 값을, 그리고 만료일을 매개변수로 받습니다. document.cookie를 사용하여 쿠키를 설정하고, 만료일을 설정합니다.
    function setCookie(name, value, expiredays) {
        var todayDate = new Date();
        todayDate.setTime(todayDate.getTime() + 0);
        if(todayDate > expiredays){
            document.cookie = name + "=" + escape(value) + "; path=/; expires=" + expiredays + ";";
        }else if(todayDate < expiredays){
            todayDate.setDate(todayDate.getDate() + expiredays);
            document.cookie = name + "=" + escape(value) + "; path=/; expires=" + todayDate.toGMTString() + ";";
        }
        
        
        console.log(document.cookie);
    }
 	//getCookie(Name) 함수: 주어진 이름에 해당하는 쿠키 값을 검색하는 함수입니다. document.cookie를 사용하여 쿠키 값을 가져옵니다.
    function getCookie(Name) {
        var search = Name + "=";
        console.log("search : " + search);
        
        if (document.cookie.length > 0) { // 쿠키가 설정되어 있다면 
            offset = document.cookie.indexOf(search);
            console.log("offset : " + offset);
            if (offset != -1) { // 쿠키가 존재하면 
                offset += search.length;
                // set index of beginning of value
                end = document.cookie.indexOf(";", offset);
                console.log("end : " + end);
                // 쿠키 값의 마지막 위치 인덱스 번호 설정 
                if (end == -1)
                    end = document.cookie.length;
                console.log("end위치  : " + end);
                
                return unescape(document.cookie.substring(offset, end));
            }
        }
        return "";
    }
 	//saveid() 함수: 입력란의 값을 저장하고 체크박스 상태에 따라 쿠키의 만료일을 설정합니다. 체크박스가 선택된 경우 입력값을 쿠키에 저장하고, 선택되지 않은 경우 쿠키를 삭제합니다.
    function saveid() {
        var expdate = new Date();
        if ($("#saveId").is(":checked")){
            expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 30);
            setCookie("saveid", $("#floatingInput").val(), expdate);
            }else{
            expdate.setTime(expdate.getTime() - 1000 * 3600 * 24 * 30);
            setCookie("saveid", $("#floatingInput").val(), expdate);
             
        }
    }
 
</script>


<div class="container">
	<main class="form-signin w-100 m-auto">
	<div class="container">
		<figure class="text-center">
			<h3 class="text-dark">Little and Precious</h3>
		</figure>
		<hr/>
		</div>
	<div id="app">	
	  <form id="login-form" @submit.prevent="login" method="post" onsubmit="return frm_check();">
	    <h6 class="h6 mb-3 fw-normal">*가입하신 이메일 주소로 로그인 해주세요</h6>
	
	    <div class="form-floating">
	      <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" v-model="username" required>
	      <label for="floatingInput">이메일 (아이디)</label>
	    </div>
	    
	    <div class="form-floating">
	      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" v-model="password" required>
	      <label for="floatingPassword">비밀번호</label>
	    </div>
	
	    <button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
	  </form>
	  <div class="logSave">
   		 <input type="checkbox" class="save_id" name="checkId" id="saveId">
    	<label for="saveId">remember me</label>
</div>
</div>
<hr/>
	<div class="d-flex justify-content-between">
	  <div>
	 	 <a href="joinView" class="text-dark">회원가입</a>
	  </div>
	  <div>
	  	<a href="findId" class="text-dark">아이디</a> / <a href="findPw" class="text-dark">비밀번호 찾기</a>
	  </div>
	</div>
<hr/>
	<a href="javascript:void(0)" onclick="kakaoLogin();">
	   <img src="image/so8.png" alt="" class="w-100 btn btn-lg">
	</a>


</main>



  <script>
    new Vue({
      el: '#app',
      data: {
        username: '',
        password: '',
        errorMessage: ''
      },
      methods: {
    	  login() {
    		  const username = this.username;
    		  const password = this.password;

    		  axios.post('loginCheck', null, {
    		    params: {
    		      cid: username,
    		      cpassword: password
    		    }
    		  })
    		  .then(response => {
    		    // 로그인 성공 시 처리
    		    console.log(response.data);
				if(response.data == "mdraw"){
    		    	 alert("탈퇴한 회원입니다.")
    		    }else if(response.data == "admin"){
    		    	alert("관리자 입니다.")
    		    	window.location.href = 'adminHome.do';
    		    }else if(response.data == "error"){
    		    	alert("아이디와 비밀번호를 확인해주세요!")
    		    }else{
	    		    alert("로그인 성공")
	    		    window.location.href = '/';    	 	
    		    }  
    	      
    		  })
    		  .catch(error => {
    		    // 로그인 실패 시 처리
    		    alert("아이디와 비밀번호를 확인해주세요!")
    		  });
    		}
        
      }
    });
  </script>



	<%@ include file="bottom.jsp" %>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>