<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-5">

    <h1>Welcome!</h1>
    <p>This is the home page of your Spring Boot application.</p>

    <sec:authorize access="isAuthenticated()">
        <p>Logged as: <sec:authentication property="principal.username"/></p>
        <p>Has roles: <sec:authentication property="authorities"/></p>

        <form action="<c:url value="/logout"/>" method="post">
            <input type="submit" class="btn btn-primary mt-3" value="Wyloguj">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
        <p>It seems you are not logged. Maybe you want to log in?</p>
        <a href="${pageContext.request.contextPath}/login" class="btn btn-primary mt-3">Login</a>
    </sec:authorize>
</div>
</body>
</html>
