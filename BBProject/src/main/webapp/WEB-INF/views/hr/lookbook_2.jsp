<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CoderBy</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</style>
</head>
<body>


<h1>예약 확인</h1>
<table border="1">
<tr>
	<th>주문번호</th>
	<th>전화번호</th>
	<th>빵이름</th>
	<th>갯수</th>
	<th>예약금액</th>
</tr>
<c:forEach var="book" items="${bookVO}">
<tr>
	<td>${book.BOOK_ID }</td>
	<td>${book.PHONENUMBER}</td>
	<td>${book.BREAD_NAME}</td>
	<td>${book.BOOK_AMOUNT}</td>
	<td>${book.BOOK_PRICE}</td>
</tr>
</c:forEach>
</table>
<c:url var="bookAction" value='/hr/lookbook2' />
	<form method="POST" action="${bookAction}" name="bookForm" id="cStyle">
	<h1>예약취소하기</h1>
		취소할 주문번호<input class="form-control" type="text" name="cancelBook" id="cancelBook" style="width: 150px;"><br>
			<br>
			<input style="width: 150px;" class="form-control" type="submit"  value="예 약 취 소">
	</form>
</body>
</html>