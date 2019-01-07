<%--
  Created by IntelliJ IDEA.
  User: pengqi
  Date: 18-12-27
  Time: 下午10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>论文管理系统</title>
    <link rel="icon" href="${pageContext.request.contextPath}/image/icon_1.0.png" type="image/x-icon">
    <style type="text/css">
        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }

        h3 {
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 4px;
        }
        form {
            text-align: center;
            line-height: 40px;
            border-radius: 5px;
        }
    </style>
    <script type="text/javascript">
        var xmlHttp;
        function check() {
            var managerName = document.getElementById("managerName").value;
            var url = "http://localhost:8080/ssmDemo/manager/checkManagerExist/"+managerName;

            xmlHttp = new XMLHttpRequest();
            xmlHttp.onreadystatechange = checkResult;
            xmlHttp.open("GET",url,true);
            xmlHttp.send();
        }
        function checkResult() {
            if(xmlHttp.readyState===4 && xmlHttp.status===200){
                document.getElementById('checkResult').innerHTML = xmlHttp.responseText;
            }
        }
    </script>
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
</div>
<br><br>
<%--<h3>--%>
    <%--<a href="${path }/paper/queryAllPapers">点击进入管理页面</a>--%>
<%--</h3>--%>
<form id="login" action="${pageContext.request.contextPath}/manager/managerLogin" method="post">
    <label>
        <span>管理员账号：</span>
        <input id="managerName" type="text" name="managerName" onkeyup="check()">
        <span id="checkResult"></span>
    </label>
    <br>
    <label>
        <span>登录密码：</span>
        <input type="password" id="password" name="password">
    </label>
    <br>
    <input id="clickToSubmit" type="submit" value="登录">
</form>

</body>
</html>
