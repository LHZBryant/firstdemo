<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 16-12-7
  Time: 下午5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div align="center">
        <form action="/sensor/data/input" method="post">
            id:<input type="text" name="id">
            <br />
            value:<input type="text" name="value">
            <br />
            time:<input type="text" name="time">
            <br />
            exception:<input type="text" name="exception">
            <br />
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
