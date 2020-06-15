<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>CS472 WAP Project - Course registration system</title>
<%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css"/>--%>
      <link href="resources/css/login.css"  rel="stylesheet" type="text/css">

</head>
<body>
<form action="login" method="post">
    <div class="login-box">
        <h1>Login</h1>
        <div class="textbox">
            <input type="text" value="${cookie.user.value}" name="username" placeholder="Username">
        </div>
        <div class="textbox">
            <input type="password" name="password" placeholder="Password"/>
        </div>
            <label>Remember me: <input type="checkbox" <c:if test="${cookie.containsKey('user')}">checked</c:if> name="remember" value="yes"></label><br/>
        <input type="submit" class="btn" value="login">
        <span >${err_msg}</span>

    </div>

</form>
</body>
</html>



























<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>CS472 WAP Project - Course registration system</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form action="login" method="post">--%>
<%--    <label>Username: <input type="text" value="${cookie.user.value}" name="username"/> </label><br/>--%>
<%--    <label>Password: <input type="password" name="password" /> </label><br/>--%>
<%--    <label>Remember me: <input type="checkbox" <c:if test="${cookie.containsKey('user')}">checked</c:if> name="remember" value="yes"></label><br/>--%>
<%--    <input type="submit" value="login">--%>
<%--</form>--%>

<%--<span style="">${err_msg}</span>--%>

<%--</body>--%>
<%--</html>--%>
