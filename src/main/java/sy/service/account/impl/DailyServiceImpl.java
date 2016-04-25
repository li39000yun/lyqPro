package sy.service.account.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.base.BaseDaoI;
import sy.model.account.Account;
import sy.model.account.Daily;
import sy.service.account.DailyServiceI;
import sy.service.impl.BaseServiceImpl;
import sy.util.base.HqlFilter;

/**
 * @Description: 收支录入业务实现类
 * 
 * @author lyq
 * @version V1.0
 * @Date 2015-12-5 上午10:21:53
 */
@Service
public class DailyServiceImpl extends BaseServiceImpl<Daily> implements DailyServiceI {

	@Autowired
	private BaseDaoI<Daily> dailyDao;

	@Autowired
	private BaseDaoI<Account> accountDao;

	@Override
	public Long countByFilter(HqlFilter hqlFilter) {
		String hql = "select count(*) from Daily t join t.account account";
		return count(hql + hqlFilter.getWhereHql(), hqlFilter.getParams());
	}

	@Override
	public List<Daily> findByFilter(HqlFilter hqlFilter, int page, int rows) {
		String hql = "select distinct t from Daily t join t.account account";
		return find(hql + hqlFilter.getWhereAndOrderHql(), hqlFilter.getParams(), page, rows);
	}

	@Override
	public Serializable save(Daily daily) {
		if (daily.getMoney() != 0) {
			// 修改账户余额
			Account account = accountDao.getById(Account.class, daily.getAccount().getId());
			if (daily.getType() == 0) {
				// 收入
				account.setMoney(account.getMoney() + daily.getMoney());
			} else {
				// 支出
				account.setMoney(account.getMoney() - daily.getMoney());
			}
			accountDao.update(account);
		}
		return dailyDao.save(daily);
	}

	@Override
	public void delete(Daily daily) {
		if (daily.getMoney() != 0) {
			// 修改账户余额
			Account account = accountDao.getById(Account.class, daily.getAccount().getId());
			if (daily.getType() == 0) {
				// 收入
				account.setMoney(account.getMoney() - daily.getMoney());
			} else {
				// 支出
				account.setMoney(account.getMoney() + daily.getMoney());
			}
			accountDao.update(account);
		}
		dailyDao.delete(daily);
	}
}
