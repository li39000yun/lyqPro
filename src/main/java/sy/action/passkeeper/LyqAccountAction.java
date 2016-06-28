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
 * 账户信息
 * action访问地址是/passkeeper/lyqaccount.sy
 * Created by liyunqaing on 2016/6/28.
 */
@Namespace("/passkeeper")
@Action
public class LyqAccountAction extends BaseAction<LyqAccount> {

    @Autowired
    public void setService(LyqAccountServiceI service) {
        super.setService(service);
    }

    /**
     * 新建一个账户
     */
    synchronized public void save() {
        Json json = new Json();
        if (data != null) {
            HqlFilter hqlFilter = new HqlFilter();
            hqlFilter.addFilter("QUERY_t#name_S_EQ", data.getName());
            LyqAccount account = service.getByFilter(hqlFilter);
            if (account != null) {
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
            LyqAccount account = service.getByFilter(hqlFilter);
            if (account != null) {
                json.setMsg("更新账户失败，账户名已存在！");
            } else {
                LyqAccount t = service.getById(data.getId());
                BeanUtils.copyNotNullProperties(data, t, new String[]{"createdatetime"});
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
        writeJsonByIncludesProperties(service.findByFilter(hqlFilter, 1, 10), new String[]{"name"});
    }

}
