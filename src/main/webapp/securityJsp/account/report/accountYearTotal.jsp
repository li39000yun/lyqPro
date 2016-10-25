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
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var grid;
	$(function() {
		initSearch();// 初始查询
		grid = $('#grid').datagrid({
			title : '',
//			url : sy.contextPath + '/securityJsp/account/report/yearTotal.json',
			url : sy.contextPath + '/account/accountYearTotal!doNotNeedSecurity_accountYearTotal.sy',
			striped : true,
			singleSelect : true,
			rownumbers : true,
			idField : 'id',
			sortName : 't.account.name',
			sortOrder : 'desc',
			columns : [ [ {
				width : '80',
				title : '账户名',
				field : 'accountName'
			}, {
				width : '80',
				title : '一月',
				field : 'monthMoney1'
			}, {
				width : '80',
				title : '二月',
				field : 'monthMoney2'
			}, {
				width : '80',
				title : '三月',
				field : 'monthMoney3'
			}, {
				width : '80',
				title : '四月',
				field : 'monthMoney4'
			}, {
				width : '80',
				title : '五月',
				field : 'monthMoney5'
			}, {
				width : '80',
				title : '六月',
				field : 'monthMoney6'
			}, {
				width : '80',
				title : '七月',
				field : 'monthMoney7'
			}, {
				width : '80',
				title : '八月',
				field : 'monthMoney8'
			}, {
				width : '80',
				title : '九月',
				field : 'monthMoney9'
			}, {
				width : '80',
				title : '十月',
				field : 'monthMoney10'
			}, {
				width : '80',
				title : '十一月',
				field : 'monthMoney11'
			}, {
				width : '80',
				title : '十二月',
				field : 'monthMoney12'
			}, {
				width : '100',
				title : '小计',
				field : 'total'
			}] ],
			showFooter : true,
			toolbar : '#toolbar',
			onBeforeLoad : function(param) {
				parent.$.messager.progress({
					text : '数据加载中....'
				});
			},
			onLoadSuccess : function(data) {
				$('.iconImg').attr('src', sy.pixel_0);
				parent.$.messager.progress('close');
			},
			queryParams: sy.serializeObject($('#searchForm'))
		});
	});
	
	// 初始查询条件
	function initSearch() {
		$('#searchForm input').val('');
		// 设置查询时间段为当月
		$('#beginTime').val(lyq.Time.getFirstDayForNow());
		$('#endTime').val(lyq.Time.getLastDayForNow());
	}

	function exportExcel() {
//		$.post(sy.contextPath + '/account/account!doNotNeedSecurity_excel_accountTotal.sy', $("#searchForm").serialize());
//		parent.$.messager.alert('提示','导出excel成功');
		$("#searchForm").attr("action", sy.contextPath + '/account/account!doNotNeedSecurity_excel_accountTotal.sy');
		$("#searchForm").submit();
		$("#searchForm").attr("action", sy.contextPath + '/account/account!doNotNeedSecurity_accountTotal.sy');
	}
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
								<td>创建时间:</td>
								<td><input id="beginTime" name="QUERY_t#createdatetime_D_GE" class="Wdate" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" style="width: 120px;" />-<input id="endTime" name="QUERY_t#createdatetime_D_LE" class="Wdate" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" style="width: 120px;" /></td>
								<td>账户名:</td>
								<td><input id="QUERY_accountname" name="QUERY_account#name_S_LK" class="easyui-combobox" data-options="valueField:'name',textField:'name',url:'<%=contextPath%>/account/account!doNotNeedSessionAndSecurity_nameComboBox.sy',mode:'remote',delay : 500,hasDownArrow:false" style="width: 80px;" /></td>
								<td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-zoom',plain:true" onclick="grid.datagrid('load',sy.serializeObject($('#searchForm')));">过滤</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-zoom_out',plain:true" onclick="initSearch();grid.datagrid('load',sy.serializeObject($('#searchForm')));">重置过滤</a></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-table_go',plain:true" onclick="exportExcel()">导出</a></td>
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