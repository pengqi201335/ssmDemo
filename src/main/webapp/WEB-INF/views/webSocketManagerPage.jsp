<%--
  Created by IntelliJ IDEA.
  User: pengqi
  Date: 19-1-14
  Time: 下午4:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebSocket连接管理界面</title>
</head>
<body>
    Welcome<br/>
    <label>
    <input id="text" type="text"/>
    </label>
    <button onclick="send()">发送消息</button><hr/>
    <button onclick="closeWebSocket()">关闭WebSocket连接</button><hr/>
    <div id="message"></div>
</body>
<script>
    var webSocket = null;
    if('WebSocket' in window){
        webSocket = new WebSocket("ws://localhost:8080/ssmDemo/webSocket");
    }
    else {
        alert("当前浏览器不支持WebSocket！");
    }
    
    //连接成功时的回调方法
    webSocket.onopen = function () {
        setMessageInnerHTML("WebSocket连接成功！");
    };
    
    //连接关闭时的回调函数
    webSocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭！");
    };

    //连接发生错误时的回调函数
    webSocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误！");
    };

    //接收到消息时的回调函数
    webSocket.onmessage = function (event) {
        setMessageInnerHTML(event.data);
    };

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }
    
    //关闭连接
    function closeWebSocket() {
        webSocket.close();
    }

    //客户端向服务端发送消息
    function send() {
        var message = document.getElementById('text').value;
        webSocket.send(message);
    }
    
</script>
</html>
