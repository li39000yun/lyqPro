<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<%
	String id = request.getParameter("id");
	if (id == null) {
		id = "";
	}
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var submitNow = function($dialog, $grid, $pjq) {
		var url;
		if ($(':input[name="data.id"]').val().length > 0) {
			url = sy.contextPath + '/account/account!update.sy';
		} else {
			url = sy.contextPath + '/account/account!save.sy';
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
			$.post(sy.contextPath + '/account/account!getById.sy', {
				id : $(':input[name="data.id"]').val()
			}, function(result) {
				if (result.id != undefined) {
					$('form').form('load', {
						'data.id' : result.id,
						'data.name' : result.name,
						'data.type' : result.type,
						'data.money' : result.money,
						'data.remark' : result.remark
					});
				}
				parent.$.messager.progress('close');
			}, 'json');
			// 金额不可改
			$('#money').css({background: "#A1A1A1" }).attr("readonly","readonly");
			// 账户名不可改
			$('#name').css({background: "#A1A1A1" }).attr("readonly","readonly");
		}
	});
</script>
</head>
<body>
	<form method="post" class="form">
		<fieldset>
			<legend>账户基本信息</legend>
			<table class="table" style="width: 100%;">
				<tr>
					<th>编号</th>
					<td><input name="data.id" style="background-color:#A1A1A1" value="<%=id%>" readonly="readonly" /></td>
				</tr>
				<tr>
					<th>账户名</th>
					<td><input id="name" name="data.name" class="easyui-validatebox" data-options="required:true"/></td>
				</tr>
				<tr>
					<th>类型</th>
					<td>
						<select id="type" class="easyui-combobox" name="data.type" data-options="panelHeight:'auto',editable:false" style="width: 155px;">
							<option value="0">现金</option>
							<option value="1">银行卡</option>
							<option value="2">虚拟账户</option>
							<option value="3">信用卡</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>余额</th>
					<td><input id="money" name="data.money" class="easyui-validatebox" data-options="required:true,validType:'number'"/></td>
				</tr>
				<tr>
					<th>备注</th>
					<td><input name="data.remark" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>