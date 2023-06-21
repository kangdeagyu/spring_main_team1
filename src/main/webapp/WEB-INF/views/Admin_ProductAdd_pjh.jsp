<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<link href="css/admin_kkg.css" rel="stylesheet">
  <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <title>상품 추가하기</title>
<style>
    body {
      padding-top: 20px;
    }
    
    .container-fluid {
      padding-right: 15px;
      padding-left: 15px;
      margin-right: auto;
      margin-left: auto;
    }
    
    .col-md-2,
    .col-md-10 {
      position: relative;
      width: 100%;
      min-height: 1px;
      padding-right: 15px;
      padding-left: 15px;
    }
    
    .col-md-2 {
      -webkit-box-flex: 0;
      -webkit-flex: 0 0 16.666667%;
      -ms-flex: 0 0 16.666667%;
      flex: 0 0 16.666667%;
      max-width: 16.666667%;
    }
    
    .col-md-10 {
      -webkit-box-flex: 0;
      -webkit-flex: 0 0 83.333333%;
      -ms-flex: 0 0 83.333333%;
      flex: 0 0 83.333333%;
      max-width: 83.333333%;
    }
    
    .main {
      margin-left: 15%;
    }
    
    h3 {
      margin-top: 0;
    }
    
    table {
      width: 100%;
      max-width: 400px;
      margin-bottom: 20px;
    }
    
    th {
      text-align: left;
    }
    
    td {
      padding: 5px;
    }
    
    .form-control {
      width: 100%;
    }
    
    .form-select {
      width: 100%;
    }
    
    input[type="submit"] {
      display: block;
      width: 100px;
      margin-top: 10px;
      padding: 5px;
      background-color: #4caf50;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
    
    input[type="submit"]:hover {
      background-color: #45a049;
    }
      .error-message {
      color: red;
      font-size: 14px;
      margin-top: 5px;
    }
    
    
  </style>
  <!-- 여기서부터 복사하시면 됩니다~~~~~~~~~!!!! -->
  <jsp:include page="admin_01_header.jsp" />
  <script>
  function showUploadAlert() {
      var pname = document.getElementById('pname');
      var pprice = document.getElementById('pprice');
      var pstock = document.getElementById('pstock');
      var pnameError = document.getElementById('pname-error');
      var ppriceError = document.getElementById('pprice-error');
      var pstockError = document.getElementById('pstock-error');

      if (pname.value.trim() === '') {
        pnameError.innerText = '상품 이름칸이 비어있습니다.';
        pname.focus();
        return false;
      } else {
        pnameError.innerText = '';
      }

      if (pprice.value.trim() === '') {
          ppriceError.innerText = '상품 가격을 입력하지 않았습니다.';
          pprice.focus();
          return false;
        } else if (!isNumeric(pprice.value.trim())) {
          ppriceError.innerText = '잘못 입력하셨습니다. 숫자를 입력해주세요.';
          pprice.focus();
          return false;
        } else {
          ppriceError.innerText = '';
        }

      if (pstock.value.trim() === '') {
          pstockError.innerText = '상품 수량을 입력하지 않았습니다.';
          pstock.focus();
          return false;
        } else if (!isNumeric(pstock.value.trim())) {
          pstockError.innerText = '잘못 입력하셨습니다. 숫자를 입력해주세요.';
          pstock.focus();
          return false;
        } else {
          pstockError.innerText = '';
        }

      if (pstock.value.trim() === '') {
        pcontentError.innerText = '상품 설명을 입력하지 않았습니다.';
        pcontent.focus();
        return false;
      } else {
        pcontentError.innerText = '';
      }
      
      alert('업로드 완료 되었습니다.');
      return true;
    }
  
  function isNumeric(value) {
      return /^\d+$/.test(value);
    }
  </script>
</head>

<body>
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-2">
        <jsp:include page="admin_01_sidebar.jsp" />
      </div>
      <div class="col-md-10 main">
        <h3>상품 추가하기</h3>
        <form action="AProductInsert.do" method="post" enctype="multipart/form-data" onsubmit="return showUploadAlert()">
          <table>
            <tr>
              <th>상품 설정</th>
            </tr>
            <tr>
              <td>이름</td>
            </tr>
            <tr>
             <td>
                <input type="text" class="form-control" name="pname" id="pname">
                <div id="pname-error" class="error-message"></div>
              </td>
            </tr>
            <tr>
              <td>카테고리</td>
            </tr>
            <tr>
              <td>
                <select name="pcategory" class="form-select">
                  <option value="0" selected="selected">조명</option>
                  <option value="1">미니어쳐</option>
                  <option value="2">의자</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>가격</td>
            </tr>
            <tr>
               <td>
                <input type="text" name="pprice" class="form-control" id="pprice">
                <div id="pprice-error" class="error-message"></div>
              </td>
            </tr>
            <tr>
              <td>대표 이미지</td>
            </tr>
            <tr>
              <td><input type="file" name="file" class="form-control"></td>
            </tr>
           <tr>
              <td>수량</td>
            </tr>
            <tr>
              <td>
                <input type="text" name="pstock" class="form-control" id="pstock">
                <div id="pstock-error" class="error-message"></div>
              </td>
            </tr>
            <tr>
              <td>상세 설명</td>
            </tr>
            <tr>
              <td><textarea id="content" name="pcontent" id="pcontent" class="form-control"></textarea>
              <div id="pcontent-error" class="error-message"></div></td>
            </tr>
            <tr>
              <td>상세 이미지 1</td>
            </tr>
            <tr>
              <td><input type="file" name="file1" class="form-control"></td>
            </tr>
            <tr>
              <td>상세 이미지 2</td>
            </tr>
            <tr>
              <td><input type="file" name="file2" class="form-control"></td>
            </tr>
          </table>
          <input type="submit" value="업로드">
        </form>
      </div>
    </div>
  </div>
</body>
</html>