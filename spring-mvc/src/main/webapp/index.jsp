<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>详情</title>
</head>
<body>
<h1 style="color:red">step-two to step-five 不要忘记开启数据库服务奥，还有新建表。哈哈</h1>
<h2>step-one: annotation</h2>
<form action="index"  method="post">
<input type="submit" value="index"/>
</form>
<h2>step-two/step-three: IOC + Spring JDBC + Mysql</h2>

<form action="getUserCount"  method="post">
<input type="submit" value="用户数量"/>
</form>
<h2>step-four: Local Transaction</h2>

<form action="addUser" method="post">
<input type="text" name="name"/>
<input type="text" name="age"/>
<input type="submit" value="添加用户"/>
</form>

<h2>step-five:Mongo - MongoTemplate</h2>

<form action="createCollection" method="post">
<input type="text" name="name"/>
<input type="submit" value="createCollection"/>
</form>

</body>
</html>