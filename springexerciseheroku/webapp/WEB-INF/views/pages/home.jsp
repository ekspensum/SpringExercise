<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Tasks</title>
</head>
<body>
	<h3>All task:</h3>
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