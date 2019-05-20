<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/pages/taglibs.jsp"%>

<h2>Dodaj zadanie</h2>
	<form:form modelAttribute="task" enctype="multipart/form-data">
		<table id="table-1">
			<tbody>
				<tr>
					<td>Subject:</td>
					<td><form:input path="subject" id="subject" /></td>
					<td><form:errors path="subject" class="msgError" /></td>
				</tr>
				<tr>
					<td>Date start</td>
					<td><form:input path="dateTimeStart" placeholder="${dateTimePrompt}" /></td>
					<td><form:errors path="dateTimeStart" class="msgError" /></td>
				</tr>
				<tr>
					<td>Date end</td>
					<td><form:input path="dateTimeEnd" placeholder="${dateTimePrompt}" /></td>
					<td><form:errors path="dateTimeEnd" class="msgError" /></td>
				</tr>
				<tr>
					<td>Task No</td>
					<td><form:input path="taskNo" id="taskNo" /></td>
					<td><form:errors path="taskNo" class="msgError" /></td>
				</tr>
				<tr>
					<td>Image</td>
					<td><form:input type="file" name="image" accept="image/*" path="image" /></td>
					<td><form:errors path="image" class="msgError" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"
						autofocus="autofocus" id="button-1" formmethod="post" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<br>
	<br>
	<c:if test="${alert == 'YES' }">
		<script>
			taskAdded();
		</script>
	</c:if>
	<c:if test="${alert == 'NO' }">
		<script>alert("Did not added new task!");</script>
	</c:if>
