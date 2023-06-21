<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.File"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link href="css/admin_kkg.css" rel="stylesheet">
<!-- CSS 파일 추가 -->
<link href="css/modal.css" rel="stylesheet">
  <style>
    /* Add your custom CSS styles here */
    /* For example: */
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }

    .container-fluid {
      margin-top: 20px;
    }

    .col-md-2, .col-md-10 {
      padding: 0;
    }

    .sidebar {
      background-color: #f8f9fa;
      padding: 10px;
      min-height: 100vh;
    }

    .main-content {
      margin-left: 15%;
    }

    h3 {
      margin-bottom: 20px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-bottom: 20px;
    }

    th, td {
      padding: 8px;
      border: 1px solid #ddd;
      text-align: left;
    }

    th {
      background-color: #f2f2f2;
      font-weight: bold;
    }

    input[type="checkbox"] {
      margin-right: 5px;
    }

    input[type="button"] {
      margin-right: 10px;
    }

    .modal {
      display: none;
      position: fixed;
      z-index: 1;
      padding-top: 100px;
      left: 0;
      top: 0;
      width: 100%;
      height: 100%;
      overflow: auto;
      background-color: rgba(0, 0, 0, 0.4);
    }
	.modal-content img {
    max-width: 20%; /* 이미지의 최대 너비를 100%로 설정 */
    height: auto; /* 높이를 자동 조정하여 비율 유지 */
  }
	
    .modal-content {
      margin: auto;
  	padding: 20px;
  	border: 1px solid #888;
  	background-color: #fefefe;
  	width: 60%;
  	position: relative; /* 추가 */
    }

    .close {
      color: #aaa;
      float: right;
      font-size: 28px;
      font-weight: bold;
      cursor: pointer;
    }

    .close:hover,
    .close:focus {
      color: black;
      text-decoration: none;
      cursor: pointer;
      
  .confirm-button {
  font-size: 14px;
  padding: 5px 10px;
  position: absolute;
  right: 20px;
  bottom: 20px;
  transform: translate(-50%, -50%);
}
      
      
    }
  </style>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
<title>리뷰 목록</title>
<script src="js/modal.js"></script>
<script>
var fidList = '${fidList}'.split(',');
var pidList = '${pidList}'.split(',');

function selectAll() {
    var checkboxes = document.getElementsByName('selectedItems');
    var selectAllCheckbox = document.getElementById('selectAllCheckbox');

    for (var i = 0; i < checkboxes.length; i++) {
        checkboxes[i].checked = selectAllCheckbox.checked;
    }
}

function openModal(fid) {
    var productInfo = document.getElementById('productInfo-' + fid).innerHTML;
    var modalContent = document.getElementById('modalContent');
    modalContent.innerHTML = productInfo;

    var modal = document.getElementById('myModal');
    modal.style.display = 'block';
}

function openModal2(fid) {
    // 모달 열기 코드 작성
    // fid를 사용하여 필요한 데이터를 가져와서 모달에 표시
    var reviewInfo = document.getElementById("reviewInfo-" + fid).innerHTML;
    var modalContent = document.getElementById('modalContent');
    modalContent.innerHTML = reviewInfo;
    
    var modal = document.getElementById('myModal');
    modal.style.display = "block";
}

function deleteSelectedItems() {
    var checkboxes = document.getElementsByName('selectedItems');
    var selectedItems = [];

    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            selectedItems.push(checkboxes[i].value);
        }
    }

    if (selectedItems.length === 0) {
        alert('삭제할 상품을 선택해주세요.');
        return;
    }

    // 알림창 표시
    var result = confirm('정말로 삭제 하시겠습니까?');

    // 확인 버튼을 눌렀을 때만 삭제 요청 전송
    if (result) {
        var form = document.createElement('form');
        form.method = 'POST';
        form.action = 'deleteReview.do';

        for (var i = 0; i < selectedItems.length; i++) {
            var input = document.createElement('input');
            input.type = 'hidden';
            input.name = 'fid';
            input.value = selectedItems[i];
            form.appendChild(input);
        }

        document.body.appendChild(form);
        form.submit();
    }
}

function openCommentModal() {
    var checkboxes = document.getElementsByName('selectedItems');
    var selectedItems = [];
    var selectedPids = [];

    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            selectedItems.push(checkboxes[i].value);
            selectedPids.push(checkboxes[i].dataset.pid);
        }
    }

    if (selectedItems.length === 0) {
        alert('댓글을 작성할 상품을 선택해주세요.');
        return;
    }

    var modalContent = document.getElementById('commentModalContent');
    var modal = document.getElementById('commentModal');

    // 선택된 fid들을 모달창 내부의 숨은 필드에 설정
    var fidInput = modalContent.querySelector('input[name="fidList"]');
    fidInput.value = selectedItems.join(',');

    // 선택된 f_pid들을 모달창 내부의 숨은 필드에 설정
    var pidInput = modalContent.querySelector('input[name="pidList"]');
    pidInput.value = selectedPids.join(',');

    // 모달창을 보여줌
    modal.style.display = 'block';
}

function closeCommentModal() {
    var modalContent = document.getElementById('commentModalContent');
    var modal = document.getElementById('commentModal');

    // 모달창 내부의 숨은 필드를 제거
    modalContent.innerHTML = '';

    // 모달창을 닫음
    modal.style.display = 'none';
}

function closeModal() {
    var modal = document.getElementById('myModal');
    modal.style.display = 'none';
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

			<div class="col-md-10 main-content">
				<main class="ms-sm-auto px-md-4">
					<div id="commentModal" class="modal">
						<div class="modal-content">
							<span class="close" onclick="closeCommentModal()">&times;</span>
							<div id="commentModalContent"
								style="display: flex; justify-content: center; align-items: center;">
								<form action="Acheckcommentwrite.do" method="post">
									<input type="hidden" name="fidList" value="${fidList}">
									<input type="hidden" name="pidList" value="${pidList}">
									<textarea name="content" rows="30" cols="50"></textarea><br>
									<input type="submit" value="저장" style="background-color: #f2f2f2; color: #333; border: 1px solid #ccc; padding: 8px 16px; border-radius: 4px; font-weight: bold;">
								</form>
							</div>
						</div>
					</div>

					<h3>리뷰 목록</h3>
					<input type="checkbox" id="selectAllCheckbox"
						onchange="selectAll()"> <input type="button" value="삭제"
						onclick="deleteSelectedItems()"> <input type="button"
						value="댓글" onclick="openCommentModal()">
					<table border="1">
						<tr>
							<th></th>
							<th>ID</th>
							<th>작성일</th>
							<th>고객정보</th>
							<th>상품</th>
							<th>리뷰 보기</th>
							<th>리뷰 상세하게 보기</th>
						</tr>
						<c:forEach items="${reviewlist}" var="dto">
							<tr>
								<td><input type="checkbox" name="selectedItems"
									value="${dto.fid}" data-pid="${dto.f_pid}"></td>
								<td>${dto.fid}</td>
								<td>${dto.finsertdate}</td>
								<td>${dto.cname}</td>
								<td><a href="#" onclick="openModal('${dto.fid}')"> <img
										src="${dto.pfilename}" alt="Product Image" width="100" />
								</a></td>
								<td><a href="#" onclick="openModal2('${dto.fid}')">${dto.ftitle}</a>
								</td>
								<td>
									<form action="AForumView.do?fid=${dto.fid}&ftype=1"
										method="post">
										<input type="hidden" name="fid" value="${dto.fid}"> <input
											type="submit" name="action" value="페이지로 이동">
									</form>
								</td>
							</tr>
							<tr>
								<td colspan="7">
									<div id="productInfo-${dto.fid}" style="display: none;">
										<h3>제품 정보</h3>
										<p>주요정보</p>
										<p>상품사진</p>
										<a href="productInformation.do?query=${dto.pname}"> <img
											src="${dto.pfilename}" alt="Product Image" width="100" />
										</a>
										<table border="1">
											<tr>
												<td>상품번호</td>
												<td>${dto.f_pid}</td>
												<td>상품가격</td>
												<td>${dto.pprice}</td>
											</tr>
											<tr>
												<td>종류</td>
												<td>${dto.categoryName}</td>
												<td>모델명</td>
												<td>${dto.pname}</td>
											</tr>
										</table>
										<p>상세 설명</p>
										<p>${dto.pcontent}</p>
									</div>
									<div id="reviewInfo-${dto.fid}" style="display: none;">
										<h3>리뷰</h3>
										<table border="1">
											<tr>
												<td>작성자</td>
												<td>${dto.cname}</td>
											</tr>
											<tr>
												<td>제목</td>
												<td>${dto.ftitle}</td>
											</tr>
											<tr>
												<td>작성일</td>
												<td>${dto.finsertdate}</td>
											</tr>
											<tr>
												<td>내용</td>
												<td>${dto.fcontent}</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				</main>
			</div>
		</div>
  </div>

  <div id="myModal" class="modal">
    <div class="modal-content">
      <span class="close" onclick="closeModal()">&times;</span>
      <div id="modalContent"></div>
       <button class="confirm-button" onclick="closeModal()">확인</button>
    </div>
  </div>
</body>
</html>