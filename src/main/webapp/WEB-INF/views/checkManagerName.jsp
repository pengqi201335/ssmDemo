<%--
  Created by IntelliJ IDEA.
  User: pengqi
  Date: 19-1-4
  Time: 上午11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>checkManagerName</title>
</head>
<body>
<c:if test="${checkResult=='正确的账号名'}">
    <span style="color: green">${checkResult}</span>
</c:if>
<c:if test="${checkResult=='账号名不存在'}">
    <span style="color: red">${checkResult}</span>
</c:if>
</body>
</html>
