<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shoppping3-1.css">
</head>
<body>
<div align="center" class="body">
<h2>��ü ��ǰ ���</h2>
<table border="1">
	<tr class="header">
	<th align="center" width="80">��ǰ ID</th>
	<th align="center" width="320">��ǰ��</th>
	<th align="center" width="100">����</th>
	<c:forEach items="${list}" var="item">
	<tr class="record">
	<td align="center">${item.itemNumber}</td>
	<td align="center"><a href="detail.do?itemnumber=${item.itemNumber}">${item.name}</a></td>
	<td align="center">${item.price} ��</td>
	</c:forEach>
	</table>
</div>
</body>
</html>