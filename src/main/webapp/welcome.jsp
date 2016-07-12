<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <title>欢迎页面</title>
    <jsp:include page="inc.jsp"></jsp:include>
    <script type="text/javascript">
        $(function () {
            $('#p2').panel({
                width: 500,
                height: 150,
                title: '系统公告',
                fit: true,
                closable: true,
                collapsible: true,
                iconCls:'ext-icon-heart'
            });
        })
    </script>
</head>
<body style="background:#fafafa;">
<div>
    <div id="p" class="easyui-panel" title="当前任务"
         style="width:100%;height:150px;padding:10px;background:#fafafa;"
         data-options="closable:true,collapsible:true,fit:true,iconCls:'ext-icon-heart'">
        <ul>
            <li>密码管家</li>
            <li>密码生成规则</li>
        </ul>
    </div>
</div>
<div>
    <div style="width:50%;height:200px;float:left;">
        <div id="p2" style="padding:10px;background:#fafafa;">
            <p>今年国庆不放假</p>
        </div>
    </div>
    <div style="width:50%;height:200px;float: left;">
        <div id="p3" class="easyui-panel" title="备忘录"
             style="width:500px;height:150px;padding:10px;background:#fafafa;"
             data-options="closable:true,collapsible:true,fit:true,iconCls:'ext-icon-sport_shuttlecock'">
            <p>备忘录1</p>
            <p>备忘录2.</p>
        </div>
    </div>
</div>
</body>
</html>