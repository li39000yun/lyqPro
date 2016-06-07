package sy.action.account;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import sy.action.BaseAction;
import sy.model.account.Account;
import sy.model.easyui.Json;
import sy.service.account.AccountServiceI;
import sy.util.base.BeanUtils;
import sy.util.base.HqlFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 账户
 * 
 * action访问地址是/account/account.sy
 * 
 * @author lyq
 * 
 */
@Namespace("/account")
@Action
public class AccountAction extends BaseAction<Account> {

	/**
	 * 注入业务逻辑，使当前action调用service.xxx的时候，直接是调用基础业务逻辑
	 * 
	 * 如果想调用自己特有的服务方法时，请使用((TServiceI) service).methodName()这种形式强转类型调用
	 * 
	 * @param service
	 */
	@Autowired
	public void setService(AccountServiceI service) {
		this.service = service;
	}

	/**
	 * 新建一个账户
	 */
	synchronized public void save() {
		Json json = new Json();
		if (data != null) {
			HqlFilter hqlFilter = new HqlFilter();
			hqlFilter.addFilter("QUERY_t#name_S_EQ", data.getName());
			Account Account = service.getByFilter(hqlFilter);
			if (Account != null) {
				json.setMsg("新建账户失败，账户名已存在！");
			} else {
				service.save(data);
				json.setMsg("新建账户成功！");
				json.setSuccess(true);
			}
		}
		writeJson(json);
	}

	/**
	 * 更新一个账户
	 */
	synchronized public void update() {
		Json json = new Json();
		json.setMsg("更新失败！");
		if (data != null && !StringUtils.isBlank(data.getId())) {
			HqlFilter hqlFilter = new HqlFilter();
			hqlFilter.addFilter("QUERY_t#id_S_NE", data.getId());
			hqlFilter.addFilter("QUERY_t#name_S_EQ", data.getName());
			Account account = service.getByFilter(hqlFilter);
			if (account != null) {
				json.setMsg("更新账户失败，账户名已存在！");
			} else {
				Account t = service.getById(data.getId());
				BeanUtils.copyNotNullProperties(data, t, new String[] { "createdatetime" });
				service.update(t);
				json.setSuccess(true);
				json.setMsg("更新成功！");
			}
		}
		writeJson(json);
	}

	/**
	 * 获得账户下拉树
	 */
	public void doNotNeedSecurity_comboTree() {
		HqlFilter hqlFilter = new HqlFilter();
		writeJson(service.findByFilter(hqlFilter));
	}

	/**
	 * 账户信息的自动补全
	 */
	public void doNotNeedSessionAndSecurity_nameComboBox() {
		HqlFilter hqlFilter = new HqlFilter();
		hqlFilter.addFilter("QUERY_t#name_S_LK", "%%" + StringUtils.defaultString(q) + "%%");
		hqlFilter.addSort("t.name");
		hqlFilter.addOrder("asc");
		writeJsonByIncludesProperties(service.findByFilter(hqlFilter, 1, 10), new String[] { "name" });
	}

	/**
	 * 账户收支统计表
	 */
	public void doNotNeedSecurity_accountTotal() {
		HqlFilter hqlFilter = new HqlFilter(getRequest());
		writeJson(((AccountServiceI) service).accountTotal(hqlFilter));
	}

	/**
	 * 导出账户收支统计表
	 */
	public String doNotNeedSecurity_excel_accountTotal() throws IOException, IllegalAccessException {
		HqlFilter hqlFilter = new HqlFilter(getRequest());
		String path = getSession().getServletContext().getRealPath("/");
		((AccountServiceI) service).exportExcelAccountTotal(hqlFilter, path+"fileCache/accountTotal.xls");
		return null;
	}
}
