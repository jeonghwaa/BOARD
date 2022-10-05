<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<span style="font-size:11pt;">
	<a href="#" onClick="fn_btnSignupClick()">Sign up</a>
	</span>
    
	<script>
		function fn_btnSignupClick(){
			location.href ="${pageContext.request.contextPath}/user/signupForm";
        	}    
	</script>
</body>
</html>