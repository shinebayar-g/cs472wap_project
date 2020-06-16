<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CS472 WAP Project - Course registration system</title>
    <link href="resources/css/student.css" rel="stylesheet" type="text/css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="resources/js/script.js"></script>
</head>

<body>
<div id="hh1"><h2>Available courses</h2></div>
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
            <td><button class="addBtn" type="submit">Select Course</button></td>
        </tr>
         </c:forEach>
       </tbody>
     </table>



<div id="hh2"><h2>My courses</h2></div>
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
            <td><button class="deleteBtn" type="submit">Delete Course</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


    <div id="log"> <a href="logout" <button>Log Out</button> </a> </div>


</body>
</html>
