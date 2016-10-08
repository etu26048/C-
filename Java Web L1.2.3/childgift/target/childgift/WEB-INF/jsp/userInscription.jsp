<%@ page language="java" contentType="text/html charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
	<head>
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>User Inscription</title>
	</head>
	<body>
		<form:form id="userInscriptionForm"
					method="POST"
					action="/childgift/userInscription/send"
					modelAttribute="userInscription">
			<form:label path="Name">Name</form:label>
			<form:input path="Name"/>
			<form:label path="Age">Age</form:label>
			<form:input path="Age"/>
			<form:radiobutton path="male" value="true" label="Boy"></form:radiobutton>
			<form:radiobutton path="male" value="false" label="Girl"></form:radiobutton>
			<form:select path="hobby">
				<form:option value="Sport" label="Sport"></form:option>
				<form:option value="Nature" label="Nature"></form:option>
				<form:option value="Reading" label="Reading"></form:option>
				<form:option value="Music" label="Music"></form:option>
			</form:select>
			<form:button>Send</form:button>
		</form:form>
	</body>
</html>