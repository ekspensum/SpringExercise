<%@ include file="/WEB-INF/views/pages/taglibs.jsp"%>

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
				<td><img src="data:image;base64,${t.base64Image }" height="100px" width="150px" /></td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
