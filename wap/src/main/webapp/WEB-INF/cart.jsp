<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Your cart</title>
    <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>Your cart</h1>

<table id="cart_items">
    <thead>
    <tr>
        <th>Product ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${cart.getItems()}" var="item">
        <tr>
            <td><c:out value="${item.product.id}"/></td>
            <td><c:out value="${item.product.name}"/></td>
            <td><c:out value="$${item.product.price}"/></td>
            <td><c:out value="${item.quantity}"/></td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <c:set var="total" value="${0}"/>
        <c:forEach var="item" items="${cart.getItems()}">
            <c:set var="total" value="${total + item.product.price}" />
        </c:forEach>
        <th id="total" colspan="3">Total :</th>
        <td><c:out value="${total}"></c:out></td>
    </tr>
    </tfoot>
</table>
</body>
</html>
