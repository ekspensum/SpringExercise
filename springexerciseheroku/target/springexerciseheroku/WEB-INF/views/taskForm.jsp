<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src='<c:url value="/resources/js/main.js" />'></script>
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
<form:form modelAttribute="task" enctype="multipart/form-data" >
	<table id="table-1">
		<tbody>
			<tr>
				<td>Subject:</td><td><form:input path="subject" id="subject" /></td>
				<td><form:errors path="subject" class="msgError" /></td>
			</tr>
			<tr>
				<td>Date start</td><td><form:input path="dateTimeStart" /></td><td>Np. 219-01-01 00:30</td>
				<td><form:errors path="dateTimeStart" class="msgError" /></td>
			</tr>
			<tr>
				<td>Date end</td><td><form:input path="dateTimeEnd"/></td>
				<td><form:errors path="dateTimeEnd" class="msgError" /></td>
			</tr>
			<tr>
				<td>Task No</td><td><form:input path="taskNo" id="taskNo"/></td>
				<td><form:errors path="taskNo" class="msgError" /></td>
			</tr>
			<tr>
				<td>Image</td><td><form:input type="file" name="image" accept="image/*" path="image" /></td>
				<td><form:errors path="image" class="msgError" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" 
					autofocus="autofocus" id="button-1" formmethod="post" /></td>
			</tr>
		</tbody>
	</table>	
	</form:form>
	<br><br>
<a href="${pageContext.request.contextPath}/">Home</a>
<c:if test="${alert == 'YES' }">
<script>
alert("New task was added!");
document.getElementById("subject").value = "";
document.getElementById("taskNo").value = "";
</script>
</c:if>
<c:if test="${alert == 'NO' }">
<script>alert("Did not added new task!");</script>
</c:if>
</body>
</html>