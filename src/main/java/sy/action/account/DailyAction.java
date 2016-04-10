package sy.action.account;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import sy.action.BaseAction;
import sy.model.account.Daily;

/**
 * 账户
 * 
 * action访问地址是/account/daily/daily.sy
 * 
 * @author lyq
 * 
 */
@Namespace("/account/daily")
@Action
public class DailyAction extends BaseAction<Daily> {

}
