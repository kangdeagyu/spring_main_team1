<%@ page language="java" contentType="application/vnd.ms-excel;charset=UTF-8" %> <%@ page language="java" import="java.util.*" %> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%  java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy_MMdd_HHmm_ss");
  String today = formatter.format(new java.util.Date());
  String file_name = "Orderlist_"+today;
  String ExcelName 	= new String(file_name.getBytes(),"UTF-8")+".xls";
  response.setContentType("application/vnd.ms-excel");
  response.setHeader("Content-Disposition", "attachment; filename="+ExcelName);
  response.setHeader("Pragma", "no-cache");  %>No.	주문번호	제품	수량	결재금액	고객아이디	고객이름	주소	연락처	주문일자<c:set var="a" value="0" />
<c:forEach items="${orderList}" var="order" varStatus="status"><c:set var="a" value="${a+1}" />${a}	${order.oid}	${order.pname}	${order.oqty}	${order.oprice}	${order.cid}	${order.cname}	${order.caddress}	${order.cphone}	${order.odate}
</c:forEach>