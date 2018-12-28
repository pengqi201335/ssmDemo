<%--
  Created by IntelliJ IDEA.
  User: pengqi
  Date: 18-12-27
  Time: 下午8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<% pageContext.setAttribute("path", request.getContextPath()); %>
<html>
<head>
    <title>论文查询</title>
    <link rel="icon" href="${pageContext.request.contextPath}/image/icon_1.0.png" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    基于SSM框架的管理系统：简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>论文列表 —— 显示所有论文</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${path}/paper/toAddPaper">+新增</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>论文编号</th>
                    <th>论文标题</th>
                    <th>论文被引次数</th>
                    <th>论文描述</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="paper" items="${requestScope.get('paperList')}" varStatus="status">
                    <tr>
                        <td>${paper.paperId}</td>
                        <td>${paper.paperTitle}</td>
                        <td>${paper.paperRef}</td>
                        <td>${paper.paperDetail}</td>
                        <td>
                            <a href="${path}/paper/toUpdatePaper?paperId=${paper.paperId}">修改</a> |
                            <a href="<%=appPath%>/paper/deletePaper/${paper.paperId}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

