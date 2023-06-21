<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.File"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="css/admin_kkg.css" rel="stylesheet">
    <link href="css/modifymodal.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <title>상품 리스트</title>
      <style>
        /* Add your custom CSS styles here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        
        .container-fluid {
            margin-top: 20px;
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
            text-align: center;
            border: 1px solid #ddd;
        }
        
        th {
            background-color: #f9f9f9;
            font-weight: bold;
        }
        
        .form-select {
            padding: 5px;
            margin-right: 10px;
        }
        
        input[type="text"], input[type="file"], textarea {
            width: 100%;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        
        input[type="checkbox"] {
            margin-right: 5px;
        }
        
        .btn {
            padding: 8px 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        
        .btn:hover {
            background-color: #45a049;
        }
        
        /* Modal */
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
        
        .modal-content {
            margin: auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #888;
            width: 50%;
            max-width: 800px;
        }
        
        .close {
            color: #888;
            float: right;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }
        
        .close:hover, .close:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
        }
        
        #editImageContainer {
            margin-bottom: 20px;
            text-align: center;
        }
        
        #editImageContainer img {
            max-width: 100%;
            height: auto;
        }
    </style>
    <script>
        function selectAll() {
            var checkboxes = document.getElementsByName('selectedItems');
            var selectAllCheckbox = document.getElementById('selectAllCheckbox');

            for (var i = 0; i < checkboxes.length; i++) {
                checkboxes[i].checked = selectAllCheckbox.checked;
            }
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

            // 선택된 상품들의 값을 'pid'라는 이름으로 서버로 전송
            var form = document.createElement('form');
            form.method = 'POST';
            form.action = 'deleteProduct.do';

            for (var i = 0; i < selectedItems.length; i++) {
                var input = document.createElement('input');
                input.type = 'hidden';
                input.name = 'pid';
                input.value = selectedItems[i];
                form.appendChild(input);
            }

            document.body.appendChild(form);
            form.submit();

            return false; // 폼 제출 중지
        }

        var product = {}; // 전역 범위에 product 객체 정의

        function openEditModal(pid, pprice, pstock, cname, pname, pcontent, pfilename) {
            product = {
                pid: pid,
                pprice: pprice,
                pstock: pstock,
                cname: cname,
                pname: pname,
                pcontent: pcontent,
                pfilename: pfilename
            };

            populateEditModal(product);

            var modal = document.getElementById('myModal');
            modal.style.display = 'block';
        }

        function populateEditModal(product) {
            document.getElementById('editPid').value = product.pid;
            document.getElementById('editPidDisplay').innerText = product.pid;
            document.getElementById('editPprice').value = product.pprice;
            document.getElementById('editPstock').value = product.pstock;
            document.getElementById('editCname').innerText = product.cname;
            document.getElementById('editPname').value = product.pname;
            document.getElementById('editPcontent').value = product.pcontent;

            var imageContainer = document.getElementById('editImageContainer');
            imageContainer.innerHTML = ""; // 이미지 컨테이너 초기화

            if (product.pfilename) {
            	  var image = document.createElement('img');
                  image.src = product.pfilename;
                  image.alt = "Product Image";
                  image.style.maxWidth = "0%"; // 이미지의 최대 너비를 100%로 설정하여 축소
                  image.style.maxHeight = "0px"; // 이미지의 최대 높이를 200px로 설정하여 조정
                  imageContainer.appendChild(image);
            }
        }

        function saveChanges() {
            var form = document.getElementById('editForm');
            var fileInput = document.getElementById('pfilename');
            var fileInput1 = document.getElementById('pcontentfilename1');
            var fileInput2 = document.getElementById('pcontentfilename2');

            // FormData 객체 생성
            var formData = new FormData(form);

            // 선택된 파일들을 FormData에 추가
            if (fileInput.files.length > 0) {
                var file = fileInput.files[0];
                var newFileName = generateNewFileName(product.pid, file.name);
                formData.append('pfilename', file, newFileName);
            }
            if (fileInput1.files.length > 0) {
                var file1 = fileInput1.files[0];
                var newFileName1 = generateNewFileName(product.pid, file1.name);
                formData.append('pcontentfilename1', file1, newFileName1);
            }
            if (fileInput2.files.length > 0) {
                var file2 = fileInput2.files[0];
                var newFileName2 = generateNewFileName(product.pid, file2.name);
                formData.append('pcontentfilename2', file2, newFileName2);
            }

            // AJAX를 사용하여 파일 업로드 및 폼 데이터 전송
            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'editProduct.do', true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    // 업로드 및 저장 완료 후 처리할 로직 작성
                    closeModal(); // 업로드 및 저장 완료 후 모달 닫기
                }
            };
            xhr.send(formData);
        }

        function generateNewFileName(pid, originalFileName) {
            var timestamp = new Date().getTime();
            var extension = originalFileName.split('.').pop();
            var newFileName = pid + '_' + timestamp + '.' + extension;
            return newFileName;
        }

        function closeModal() {
            var modal = document.getElementById('myModal');
            modal.style.display = 'none';
        }
        
        function validateForm() {
            var priceInput = document.getElementById('editPprice');
            var stockInput = document.getElementById('editPstock');
            var price = priceInput.value.trim();
            var stock = stockInput.value.trim();
            var numericRegex = /^[0-9]+$/;

            if (!numericRegex.test(price)) {
                alert('숫자를 입력해주세요.');
                priceInput.focus();
                return false; // Prevent form submission
            }

            if (!numericRegex.test(stock)) {
                alert('숫자를 입력해주세요.');
                stockInput.focus();
                return false; // Prevent form submission
            }

            return true; // Allow form submission
        }
        
        
        
        
    </script>
<!-- 여기서부터 복사하시면 됩니다~~~~~~~~~!!!! -->

<jsp:include page="admin_01_header.jsp" />


</head>

<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
                <%@include file="admin_01_sidebar.jsp" %>
            </div>
            <div class="col-md-10" style="margin-left: 15%;">
                <main class="ms-sm-auto px-md-4">
                    <h3>상품 리스트</h3>
                    <form action="productQuery.do" method="post">
                        <select name="list" class="form-select">
                            <option value="pname" selected="selected">상품명</option>
                            <option value="pcategory">카테고리</option>
                        </select>
                        <input type="text" name="query">
                        <input type="submit" name="action" value="검색">
                    </form>
                    <form action="APinsert.do" method="post" enctype="multipart/form-data">
                        <input type="submit" name="action" value="상품 추가하기">
                    </form>
                    <form>
                        <input type="checkbox" id="selectAllCheckbox" onchange="selectAll()"> 전체 선택
                        <input type="button" value="삭제" onclick="deleteSelectedItems()">
                    </form>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>상품선택</th>
                                <th>사진</th>
                                <th>카테고리</th>
                                <th>제품명</th>
                                <th>가격</th>
                                <th>편집</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="dto">
                                <tr>
                                    <td><input type="checkbox" name="selectedItems" value="${dto.pid}"></td>
                                    <td><img src="${dto.pfilename}" alt="Product Image" width="100" /></td>
                                    <td>${dto.c_name }</td>
                                    <td>${dto.pname }</td>
                                    <td>${dto.pprice }</td>
                                    <td>
                                        <button class="btn btn-primary" onclick="openEditModal('${dto.pid}', '${dto.pprice}', '${dto.pstock}','${dto.cname}', '${dto.pname}', '${dto.pcontent}', '${dto.pfilename}')">수정</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </main>
            </div>
        </div>
    </div>

    <!-- Edit Modal -->
    <div id="myModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <h3>상품 수정</h3>
            <form id="editForm" method="post" enctype="multipart/form-data">
                <input type="hidden" id="editPid" name="pid" value="">
                <p>상품번호: <span id="editPidDisplay"></span></p>
                <p>
                    가격:
                    <input type="text" id="editPprice" name="pprice" value="">
                </p>
                <p>
                    재고:
                    <input type="text" id="editPstock" name="pstock" value="">
                </p>
                <p>카테고리: <span id="editCname"></span></p>
                <p>
                    제품명:
                    <input type="text" id="editPname" name="pname" value="">
                </p>
                <p>
                    제품설명:
                    <textarea id="editPcontent" name="pcontent"></textarea>
                </p>
                <p>
                    사진:
                    <input type="file" id="pfilename" name="pfilename">
                </p>
                <div id="editImageContainer"></div>
                <p>
                    제품설명 사진 1:
                    <input type="file" id="pcontentfilename1" name="pcontentfilename1">
                </p>
                <p>
                    제품설명 사진 2:
                    <input type="file" id="pcontentfilename2" name="pcontentfilename2">
                </p>
                <input type="button" value="저장" onclick="saveChanges()">
            </form>
        </div>
    </div>
</body>
</html>