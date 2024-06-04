<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Forbidden</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-5">
    <h2>Create User</h2>
    <form:form action="/sign-up" modelAttribute="user" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <form:input path="username" id="username" cssClass="form-control" required="true"/>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <form:input path="password" id="password" cssClass="form-control" type="password" required="true"/>
        </div>

        <button type="submit" class="btn btn-primary mt-3">Create User</button>
    </form:form>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger mt-3">
            <strong>Error:</strong> ${errorMessage}
        </div>
    </c:if>
</div>
</body>
</html>
