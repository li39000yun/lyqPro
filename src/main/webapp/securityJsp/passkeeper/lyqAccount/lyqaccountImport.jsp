<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page="/inc.jsp"></jsp:include>
<script type="text/javascript">
	var submitNow = function($dialog, $grid, $pjq) {
		var url = sy.contextPath + '/passkeeper/lyqaccount!importExcel.sy';
		console.info(sy.serializeObject($('form')));
		$.post(url, sy.serializeObject($('form')), function(result) {
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
</script>
</head>
<body>
	<form method="post" enctype="multipart/form-data" class="form">
		<fieldset>
			<legend>Excel导入</legend>
			<table class="table" style="width: 100%;">
				<tr>
					<td><input type="file" name="importFile" maxlength="100" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>