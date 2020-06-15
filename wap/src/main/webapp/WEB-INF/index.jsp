<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CS472 WAP Project - Course registration system</title>
    <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="resources/js/script.js"></script>
</head>
<body>
<h1>Available courses</h1>
<table id="available_courses">
    <thead>
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Credits</th>
        <th>Instructor</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${courses}" var="course">
        <tr>
            <td><c:out value="${course.code}"/></td>
            <td><c:out value="${course.name}"/></td>
            <td><c:out value="${course.credits}"/></td>
            <td><c:out value="${course.instructor}"/></td>
            <td><button class="addBtn" type="submit">Select this course</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>My courses</h2>
<table id="myCourses">
    <thead>
    <tr>
        <th>#</th>
        <th>Code</th>
        <th>Name</th>
        <th>Credits</th>
        <th>Instructor</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${myCourses}" var="myCourse" varStatus="loop">
        <tr>
            <td><c:out value="${loop.index+1}"/></td>
            <td><c:out value="${myCourse.code}"/></td>
            <td><c:out value="${myCourse.name}"/></td>
            <td><c:out value="${myCourse.credits}"/></td>
            <td><c:out value="${myCourse.instructor}"/></td>
            <td><button class="deleteBtn" type="submit">Delete this course</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<a href="logout">
    <button>Log Out</button>
</a>

</body>
</html>
