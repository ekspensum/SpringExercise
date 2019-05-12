<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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