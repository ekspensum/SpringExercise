<%@ include file="/WEB-INF/views/pages/taglibs.jsp"%>

<h2>Contact Us Page</h2>
<form:form modelAttribute="emailContactService" id="contactForm" enctype="multipart/form-data" >
	<p>
	<form:input id="subject" path="subject" placeholder="${subjectPrompt}" style="width:250px" />
	<form:errors path="subject" class="msgError"></form:errors>
	</p>
	<p>
	<form:textarea id="message" path="message" cols="40" rows="8" placeholder="${messagePrompt}" />
	<form:errors path="message" class="msgError"></form:errors>
	</p>
	<p>
	<form:input id="replyMail" path="replyMail" placeholder="${replyMailPrompt }" style="width:250px" />
	<form:errors path="replyMail" class="msgError"></form:errors>
	</p>
	<p>
	<form:input path="attachment" type="file" name="attachment" placeholder="${attachmentPrompt }" />
	<form:errors path="attachment" class="msgError"></form:errors>
	</p>
	<p><input type="submit" value="Submit" id="button-1"/></p>
</form:form>
	<c:if test="${alert == 'YES' }">
		<script>
			sentEmailConfirm();
		</script>
	</c:if>
	<c:if test="${alert == 'NO' }">
		<script>alert("Mail has not been sent!");</script>
	</c:if>
