<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<link href='<c:url value="/resources/css/sheet.css" />' style="text/css" rel="stylesheet" media="all" />
<!-- 	<meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- 	<link rel="stylesheet" href="http://code.ionicframework.com/1.0.0/css/ionic.css" /> -->
<!-- 	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" /> -->
<!-- 	<script src="http://code.ionicframework.com/1.0.0/js/ionic.bundle.js"></script> -->
<!-- 	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script> -->
<!-- 	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script> -->
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="task">
	<table id="table-1">
		<tbody>
			<tr>
				<td>Subject:</td><td><form:input path="subject" /></td>
				<td><form:errors path="subject" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Date start</td><td><form:input path="dateTimeStart" /></td>
				<td><form:errors path="dateTimeStart" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Date end</td><td><form:input path="dateTimeEnd"/></td>
				<td><form:errors path="dateTimeEnd" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Task No</td><td><form:input path="taskNo"/></td>
				<td><form:errors path="taskNo" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Image</td><td><form:input type="file" name="image" accept="image/*" path="image" /></td>
				<td><form:errors path="image" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"
					autofocus="autofocus" id="button-1" formmethod="post" /></td>
			</tr>
		</tbody>
	</table>
	
	</form:form>
	<br><br>
<%-- 	<form id="form-1" method="POST"> --%>
<!-- 	<label for="input-1">Input:</label> -->
<!-- 	<input id="input-1" name="dateTimeStart" placeholder="Text" type="text"/> -->
<!-- 	<input type="submit" value="Submit" id="button-2"/> -->
<%-- 	</form> --%>

</body>
</html>