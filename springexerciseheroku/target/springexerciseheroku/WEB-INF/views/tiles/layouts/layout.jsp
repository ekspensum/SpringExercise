<%@ include file="/WEB-INF/views/pages/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src='<c:url value="/static/js/main.js" />'></script>
	<link href='<c:url value="/static/css/sheet.css" />' style="text/css" rel="stylesheet" media="all" />
	<title><tiles:getAsString name="title" /></title>
</head>
<body onload="dateTime()">
        <header id="header">
            <tiles:insertAttribute name="header" />
        </header>
     
        <section id="menu">
            <tiles:insertAttribute name="menu" />
        </section>
             
        <section id="content">
            <tiles:insertAttribute name="body" />
        </section>
         
        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
</body>
</html>