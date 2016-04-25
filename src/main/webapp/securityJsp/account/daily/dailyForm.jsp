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
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
.form input[class='textXL'],.form textarea[class='textXL'] {
	width: 300px;
}
</style>
<script type="text/javascript">
	var submitNow = function($dialog, $grid, $pjq) {
		var url;
		if ($(':input[name="data.id"]').val().length > 0) {
			url = sy.contextPath + '/account/daily/daily!update.sy';
		} else {
			url = sy.contextPath + '/account/daily/daily!save.sy';
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
			$.post(sy.contextPath + '/account/daily/daily!getById.sy', {
				id : $(':input[name="data.id"]').val()
			}, function(result) {
				if (result.id != undefined) {
					$('form').form('load', {
						'data.id' : result.id,
						'data.account.id' : result.account.id,
						'data.type' : result.type,
						'data.money' : result.money,
						'data.remark' : result.remark
					});
				}
				parent.$.messager.progress('close');
			}, 'json');
			// 金额不可改
			$("#money").css({background: "#A1A1A1" }).attr("readonly","readonly");
			// 收支类型不可改
			$("#type").combobox("disable");
			// 银行账户不可改
			$("#accountid").combobox({
				required: false
			});
			$("#accountid").combobox("disable");
			$("img").attr("style","display:none");
		}
	});
</script>
</head>
<body>
	<form method="post" class="form">
		<fieldset>
			<legend>收支录入</legend>
			<table class="table" style="width: 100%;">
				<tr>
					<th>编号</th>
					<td><input name="data.id" style="background-color:#A1A1A1" value="<%=id%>" readonly="readonly" /></td>
					<th>收支类型</th>
					<td>
						<select id="type" class="easyui-combobox" name="data.type" data-options="panelHeight:'auto',editable:false" style="width: 155px;">
							<option value="0">收入</option>
							<option value="1">支出</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>金额</th>
					<td><input id="money" name="data.money" class="easyui-validatebox" data-options="required:true,validType:'number',min:-99999999.99,max:99999999.99"/></td>
					<th>账户名称</th>
					<td><input id="accountid" name="data.account.id" class="easyui-combobox" data-options="required:true,editable:false,valueField:'id',textField:'name',url:'<%=contextPath%>/account/account!doNotNeedSecurity_comboTree.sy'" style="width: 155px;"/><img id="clearImg" class="iconImg ext-icon-cross" onclick="$('#accountid').combobox('clear');" title="清空" /></td>
				</tr>
				<tr>
					<th>备注</th>
					<td colspan="3"><textarea class="textXL" id="remark" name="data.remark"></textarea></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>