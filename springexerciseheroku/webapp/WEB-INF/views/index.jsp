<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%-- <%@ page session="false"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<link href='<c:url value="/resources/css/sheet.css" />' style="text/css" rel="stylesheet" media="all" />
<!-- 	<meta name="viewport" content="width=device-width, initial-scale=1" /> -->
<%-- 	<link rel="stylesheet" href='<c:url value="http://code.ionicframework.com/1.0.0/css/ionic.css" />' /> --%>
<%-- 	<link rel="stylesheet" href='<c:url value="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />' /> --%>
<%-- 	<script src='<c:url value="http://code.ionicframework.com/1.0.0/js/ionic.bundle.js" />'></script> --%>
<%-- 	<script src='<c:url value="http://code.jquery.com/jquery-2.0.1.min.js" />'></script> --%>
<%-- 	<script src='<c:url value="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js" />'></script> --%>
<meta charset="UTF-8">
<title>Tasks</title>
</head>
<body>
	<h1>Home Web Site</h1>
	<h2><b>Date time: </b>${dateTime}</h2>
	<a href="${pageContext.request.contextPath}/taskForm" id="button-1" class="ui-btn ui-icon-plus ui-btn-icon-left ui-btn-inline ui-corner-all ui-btn-a">Dodaj zadanie</a>
	<p>All task:</p>
	<table class="tableHomePage" >
		<thead>
			<tr class="ui-bar-a">
				<th>Id</th>
				<th data-priority="1">Subject</th>
				<th data-priority="2">Date start</th>
				<th data-priority="3">Date end</th>
				<th data-priority="3">Task No</th>
				<th data-priority="3">Image</th>
			</tr>
		</thead>
		<c:forEach items="${taskList }" var="t">
		<tbody>
			<tr>
				<td>${t.id }</td>
				<td>${t.subject }</td>
				<td>${t.dateTimeStart }</td>
				<td>${t.dateTimeEnd }</td>
				<td>${t.taskNo }</td>
				<td><img src="data:image;base64,${t.base64Image }" height="50%" width="150" /></td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
</body>
</html>