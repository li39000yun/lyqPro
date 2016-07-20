<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<%
	String idstr = request.getParameter("id");
	int id=0;
	if (idstr!=null && idstr !=""){
		id = Integer.parseInt(idstr);
	}
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page="/inc.jsp"></jsp:include>
<script type="text/javascript">
	var submitNow = function($dialog, $grid, $pjq) {
		var url;
		if ($(':input[name="data.id"]').val()!= 0) {
			url = sy.contextPath + '/oa/notice/notice!update.sy';
		} else {
			url = sy.contextPath + '/oa/notice/notice!save.sy';
		}
		$.post(url, sy.serializeObject($('form')), function(result) {
			parent.sy.progressBar('close');//关闭上传进度条

			if (result.success) {
				$pjq.messager.alert('提示', result.msg, 'info');
				$grid.datagrid('load');
				$dialog.dialog('destroy');
			} else {
				$pjq.messager.alert('提示', result.msg, 'error');
			}
		}, 'json');
	};
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			submitNow($dialog, $grid, $pjq);
		}
	};
	$(function() {
		if ($(':input[name="data.id"]').val().length > 0) {
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(sy.contextPath + '/oa/notice/notice!getById.sy', {
				id : $(':input[name="data.id"]').val()
			}, function(result) {
				if (result.id != undefined) {
					$('form').form('load', {
						'data.id' : result.id,
						'data.title' : result.title,
						'data.content' : result.content
					});
				}
				parent.$.messager.progress('close');
			}, 'json');
		}
	});
</script>
</head>
<body>
	<form method="post" class="form">
		<fieldset>
			<legend>公告信息</legend>
			<table class="table" style="width: 100%;">
				<tr>
					<th>编号</th>
					<td><input name="data.id" style="background-color:#A1A1A1" value="<%=id%>" readonly="readonly" /></td>
				</tr>
				<tr>
					<th>标题</th>
					<td><input name="data.title" class="easyui-validatebox" data-options="required:true"/></td>
				</tr>
				<tr>
					<th>内容</th>
					<td><input name="data.concent" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>