<%--
  Created by IntelliJ IDEA.
  User: shinee
  Date: 2020.06.14
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <link href="resources/css/admin.css" rel="stylesheet" type="text/css"/>
    <script src="resources/js/admin_page.js" type="text/javascript" defer="defer"></script>
</head>


<div id="forma">
    <form>
        <legend class="header">Course Registration System</legend>

        <label for="course_code">Course Code</label>
        <input type="text" id="course_code" name="course_code" placeholder="Enter code..">

        <label for="course_name">Course Name</label>
        <input type="text" id="course_name" name="course_name" placeholder="Enter course name..">

        <label for="course_credits">Course Credits</label>
        <input type="text" id="course_credits" name="course_credits" placeholder="Enter credits..">

        <label for="course_instructor">Instructor Name</label>
        <input type="text" id="course_instructor" name="course_instructor" placeholder="Enter course instructor..">

        <input type="button" value="Save Data" id="btnAdd" class="adminbtn">
        <input type="button" value="Clear" id="btnClear" name="btnClear" class="adminbtn">
        <br>
    </form>
  </div>

<div id="table">
    <table id="tbl">
        <legend>Courses on MUM Portal</legend>

        <tr>
            <th>#</th>
            <th>Code</th>
            <th>Course Name</th>
            <th>Course Credits</th>
            <th>Course Instructor</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

    </table>
</div>

<a href="logout">
    <button id="log">Log Out</button>
</a>
</body>
</html>
