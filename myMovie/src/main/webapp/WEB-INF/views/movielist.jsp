<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2016/6/18
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>电影网页</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">

    <div class="page-header">
        <h3>分页演示</h3>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            电影列表
        </div>
        <div class="panel-body">

            <table class="table">
                <thead>
                <tr>
                    <th>影片名称</th>
                    <th>评分</th>
                    <th>导演</th>
                    <th>发行时间</th>
                    <th>上映时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.items}" var="m">
                    <tr>
                        <td>${m.title}</td>
                        <td>${m.rate}</td>
                        <td>${m.daoyan}</td>
                        <td>${m.sendtime}</td>
                        <td>${m.releaseyear}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
        <div class="panel-footer text-right">

            <ul class="pagination" id="page"></ul>

        </div>
    </div>


</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery.twbsPagination.min.js"></script>
<script>
    $(function () {

        $("#page").twbsPagination({
            totalPages:${page.totalPages},
            visiblePages: 10,
            first: '首页',
            prev: '上一页',
            next: '下一页',
            last: '末页',
            href: '?p={{number}}'
        });

    });
</script>
</body>
</html>
