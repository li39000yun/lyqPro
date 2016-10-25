package sy.service.account.report;

import sy.model.account.Account;
import sy.model.account.vo.AccountTotal;
import sy.model.account.vo.AccountYearTotal;
import sy.service.BaseServiceI;
import sy.util.base.HqlFilter;

import java.util.List;

/**
 * 年统计报表业务
 * 
 * @author lyq
 * 
 */
public interface AccountYearTotalServiceI extends BaseServiceI<AccountYearTotal> {

	/**
	 * 账户收支统计表
	 * 
	 * @param hqlFilter
	 *            hql过滤类
	 * @return
	 */
	public List<AccountYearTotal> accountYearTotal(HqlFilter hqlFilter);

}
