<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/pages/taglibs.jsp"%>

	<h3>Wszystkie zadania:</h3>
	<table class="tableHomePage" >
		<thead>
			<tr>
				<th>Id</th>
				<th>Subject</th>
				<th>Date start</th>
				<th>Date end</th>
				<th>Task No</th>
				<th>Image</th>
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
				<td><img src="data:image;base64,${t.base64Image }" height="100px" width="150px" /></td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
