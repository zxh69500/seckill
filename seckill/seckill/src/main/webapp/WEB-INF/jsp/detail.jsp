<%--
  Created by IntelliJ IDEA.
  User: amall
  Date: 2018/6/21
  Time: 下午1:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>

<html>
<head>
    <title>秒杀详情页</title>

    <%@include file="common/head.jsp"%>
<body>
    <div class="container">
        <div class="panel panel-default text-center">
            <div class="panel-heading">
                ${seckill.name}
            </div>
            <div class="panel-body">

            </div>
        </div>
    </div>
</body>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
