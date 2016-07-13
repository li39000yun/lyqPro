package sy.action.passkeeper;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;
import sy.action.BaseAction;
import sy.model.easyui.Json;
import sy.model.passkeeper.LyqAccount;
import sy.service.passkeeper.LyqAccountServiceI;
import sy.util.base.BeanUtils;
import sy.util.base.HqlFilter;

/**
 * 账号信息
 * action访问地址是/passkeeper/lyqaccount.sy
 * Created by liyunqaing on 2016/6/28.
 */
@Namespace("/passkeeper")
@Action
public class LyqaccountAction extends BaseAction<LyqAccount> {

    @Autowired
    public void setService(LyqAccountServiceI service) {
        super.setService(service);
    }

    /**
     * 获得账号下拉树
     */
    public void doNotNeedSecurity_comboTree() {
        HqlFilter hqlFilter = new HqlFilter();
        writeJson(service.findByFilter(hqlFilter));
    }

    /**
     * 账号信息的自动补全
     */
    public void doNotNeedSessionAndSecurity_nameComboBox() {
        HqlFilter hqlFilter = new HqlFilter();
        hqlFilter.addFilter("QUERY_t#name_S_LK", "%%" + StringUtils.defaultString(q) + "%%");
        hqlFilter.addSort("t.name");
        hqlFilter.addOrder("asc");
        writeJsonByIncludesProperties(service.findByFilter(hqlFilter, 1, 10), new String[]{"name"});
    }

}
