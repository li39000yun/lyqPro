package sy.service.account;

import java.util.List;

import sy.model.account.Account;
import sy.model.account.vo.AccountTotal;
import sy.service.BaseServiceI;
import sy.util.base.HqlFilter;

/**
 * 账户业务
 * 
 * @author lyq
 * 
 */
public interface AccountServiceI extends BaseServiceI<Account> {

	/**
	 * 账户收支统计表
	 * 
	 * @param hqlFilter
	 *            hql过滤类
	 * @return
	 */
	public List<AccountTotal> accountTotal(HqlFilter hqlFilter);

	/**
	 * 导出excle
	 * 
	 * @param hqlFilter
	 *            hql过滤类
	 * @param excleName
	 *            导出excel文件名
	 */
	public void exportExcelAccountTotal(HqlFilter hqlFilter, String excleName);

}
