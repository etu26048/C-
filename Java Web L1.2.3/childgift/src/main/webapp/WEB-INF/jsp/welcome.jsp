<%@ page language="java" contentType="text/html charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
	<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
	<title>Welcome</title>
</head>
	<body>
		Welcome in our magic world
		<form:form  id="formulaire" 
					method="POST" 
					action = "/childgift/welcome/send" 
					modelAttribute="magicKeyForm">
					
			<form:label path="magicKey">Magic Key</form:label>
			<form:input path="magicKey"/>
			<form:button>Send</form:button>		
		</form:form>
	</body>
</html>