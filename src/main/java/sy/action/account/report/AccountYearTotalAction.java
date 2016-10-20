package sy.action.account.report;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;
import sy.action.BaseAction;
import sy.model.account.Account;
import sy.service.account.report.AccountYearTotalServiceI;
import sy.util.base.HqlFilter;

/**
 * 年统计报表
 * <p/>
 * action访问地址是/account/accountYearTotal.sy
 *
 * @author lyq
 */
@Namespace("/account")
@Action
public class AccountYearTotalAction extends BaseAction<Account> {

    /**
     * 注入业务逻辑，使当前action调用service.xxx的时候，直接是调用基础业务逻辑
     * <p/>
     * 如果想调用自己特有的服务方法时，请使用((TServiceI) service).methodName()这种形式强转类型调用
     *
     * @param service
     */
    @Autowired
    public void setService(AccountYearTotalServiceI service) {
        this.service = service;
    }

    /**
     * 账户收支统计表
     */
    public void doNotNeedSecurity_accountYearTotal() {
        HqlFilter hqlFilter = new HqlFilter(getRequest());
        writeJson(((AccountYearTotalServiceI) service).accountYearTotal(hqlFilter));
    }

}
