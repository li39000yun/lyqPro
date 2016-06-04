package sy.service.account.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.base.BaseDaoI;
import sy.model.account.Account;
import sy.model.account.Daily;
import sy.model.account.vo.AccountTotal;
import sy.service.account.AccountServiceI;
import sy.service.impl.BaseServiceImpl;
import sy.util.base.HqlFilter;

/**
 * @Description: 账户业务
 * 
 * @author lyq
 * @version V1.0
 * @Date 2015-3-25 下午10:13:05
 */
@Service
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountServiceI {

	@Autowired
	private BaseDaoI<Daily> dailyDao;

	@Override
	public List<AccountTotal> accountTotal(HqlFilter hqlFilter) {
		String hql = "select distinct t from Daily t join t.account account";
		List<Daily> dailys = dailyDao.find(hql + hqlFilter.getWhereAndOrderHql(), hqlFilter.getParams());
		Map<String, AccountTotal> totalMap = new HashMap<String, AccountTotal>();
		AccountTotal accountTotal;
		String key;
		List<AccountTotal> datas = new ArrayList<AccountTotal>();
		for (Daily daily : dailys) {
			key = daily.getAccount().getId();
			if (totalMap.containsKey(key)) {
				accountTotal = totalMap.get(key);
			} else {
				accountTotal = new AccountTotal();
				accountTotal.setAccountid(key);
				accountTotal.setAccountName(daily.getAccount().getName());
				datas.add(accountTotal);
			}
			if (daily.getType() == 0) {// 收入
				accountTotal.setIncomeTotal(accountTotal.getIncomeTotal() + daily.getMoney());
			} else {// 支出
				accountTotal.setPayoutTotal(accountTotal.getPayoutTotal() + daily.getMoney());
			}
			totalMap.put(key, accountTotal);
		}
		return datas;
	}

	@Override
	public void exportExcelAccountTotal(HqlFilter hqlFilter, String excleName) {
		// TODO Auto-generated method stub
		List<AccountTotal> accountTotals = accountTotal(hqlFilter);
		List<List<Object>> datas = new ArrayList<List<Object>>();
		List<Object> data = new ArrayList<Object>();
		data.add("序号");
		data.add("账户名");
		data.add("收入");
		data.add("支出");
		data.add("小计");
		datas.add(data);
		int i = 1;
		for (AccountTotal accountTotal : accountTotals) {
			data = new ArrayList<Object>();
			data.add(i++);
			data.add(accountTotal.getAccountName());
			data.add(accountTotal.getIncomeTotal());
			data.add(accountTotal.getPayoutTotal());
			data.add(accountTotal.getTotal());
			datas.add(data);
		}

	}

}
