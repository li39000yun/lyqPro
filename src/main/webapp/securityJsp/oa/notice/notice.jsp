<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="sy.util.base.SecurityUtil"%>
<%
    String contextPath = request.getContextPath();
    SecurityUtil securityUtil = new SecurityUtil(session);
%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <jsp:include page="/inc.jsp"></jsp:include>
    <script type="text/javascript">
        var grid;
        var addFun = function() {
            var dialog = parent.sy.modalDialog({
                title : '添加公告信息',
                url : sy.contextPath + '/securityJsp/oa/notice/noticeForm.jsp',
                buttons : [ {
                    text : '添加',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        };
        var showFun = function(id) {
            var dialog = parent.sy.modalDialog({
                title : '查看公告信息',
                url : sy.contextPath + '/securityJsp/oa/notice/noticeForm.jsp?id=' + id
            });
        };
        var editFun = function(id) {
            var dialog = parent.sy.modalDialog({
                title : '编辑公告信息',
                url : sy.contextPath + '/securityJsp/oa/notice/noticeForm.jsp?id=' + id,
                buttons : [ {
                    text : '编辑',
                    handler : function() {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
                    }
                } ]
            });
        };
        var removeFun = function(id) {
            parent.$.messager.confirm('询问', '您确定要删除此记录？', function(r) {
                if (r) {
                    $.post(sy.contextPath + '/oa/notice/notice!delete.sy', {
                        id : id
                    }, function() {
                        grid.datagrid('reload');
                    }, 'json');
                }
            });
        };
        $(function() {
            grid = $('#grid').datagrid({
                title : '',
                url : sy.contextPath + '/oa/notice/notice!grid.sy',
                striped : true,
                rownumbers : true,
                pagination : true,
                singleSelect : true,
                idField : 'id',
                sortName : 'createtime',
                sortOrder : 'desc',
                pageSize : 50,
                pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
                frozenColumns : [ [ {
                    width : '120',
                    title : '标题',
                    field : 'title',
                    sortable : true
                } ] ],
                columns : [ [ {
                    width : '150',
                    title : '创建时间',
                    field : 'createtime',
                    sortable : true
                }, {
                    width : '250',
                    title : '内容',
                    field : 'concent'
                } ] ],
                toolbar : '#toolbar',
                onBeforeLoad : function(param) {
                    parent.$.messager.progress({
                        text : '数据加载中....'
                    });
                },
                onLoadSuccess : function(data) {
                    $('.iconImg').attr('src', sy.pixel_0);
                    parent.$.messager.progress('close');
                }
            });
        });
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div id="toolbar" style="display: none;">
    <table>
        <tr>
            <td>
                <form id="searchForm">
                    <table>
                        <tr>
                            <td>标题</td>
                            <td><input name="QUERY_t#title_S_LK" style="width: 80px;" /></td>
                            <td>创建时间</td>
                            <td><input name="QUERY_t#createtime_D_GE" class="Wdate" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" style="width: 120px;" />-<input name="QUERY_t#createtime_D_LE" class="Wdate" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" style="width: 120px;" /></td>
                            <td>内容</td>
                            <td><input name="QUERY_t#concent_S_LK" style="width: 80px;" /></td>
                            <td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-zoom',plain:true" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-zoom_out',plain:true" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a></td>
                        </tr>
                    </table>
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <table>
                    <tr>
                        <%if (securityUtil.havePermission("/oa/notice/notice!save")) {%>
                        <td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-note_add',plain:true" onclick="addFun();">添加</a></td>
                        <%}%>
                        <td><div class="datagrid-btn-separator"></div></td>
                        <td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-table_add',plain:true" onclick="">导入</a></td>
                        <td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-table_go',plain:true" onclick="">导出</a></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>
<div data-options="region:'center',fit:true,border:false">
    <table id="grid" data-options="fit:true,border:false"></table>
</div>
</body>
</html>