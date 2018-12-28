<%--
  Created by IntelliJ IDEA.
  User: pengqi
  Date: 18-12-27
  Time: 下午8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>修改论文</title>
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
                    <small>修改论文</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="" name="userForm">
        <input type="hidden" name="paperId" value="${updatePaper.paperId}"/>
        <label>
        论文标题：<input type="text" name="paperTitle" value="${updatePaper.paperTitle}"/>
        </label>
        <label>
        论文被引次数：<input type="text" name="paperRef" value="${updatePaper.paperRef}"/>
        </label>
        <label>
        论文描述：<input type="text" name="paperDetail" value="${updatePaper.paperDetail }"/>
        </label>
        <input type="button" value="提交" onclick="updatePaper()"/>
    </form>
    <script type="text/javascript">
        function updatePaper() {
            var form = document.forms[0];
            form.action = "<%=basePath %>paper/updatePaper";
            form.method = "post";
            form.submit();
        }
    </script>
</div>
</body>
</html>
