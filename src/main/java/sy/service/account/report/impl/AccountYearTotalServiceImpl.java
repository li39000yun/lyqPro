package sy.service.account.report.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sy.dao.base.BaseDaoI;
import sy.model.account.Account;
import sy.model.account.Daily;
import sy.model.account.vo.AccountTotal;
import sy.service.account.AccountServiceI;
import sy.service.account.report.AccountYearTotalServiceI;
import sy.service.impl.BaseServiceImpl;
import sy.util.base.HqlFilter;
import sy.util.base.excel.ExcelUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
/**
 *年统计报表业务
 *@Author 李云强
 *@Date 2016/10/20 22:34
 */
@Service
public class AccountYearTotalServiceImpl extends BaseServiceImpl<Account> implements AccountYearTotalServiceI {

    @Autowired
    private BaseDaoI<Daily> dailyDao;

    @Override
    public List<AccountTotal> accountYearTotal(HqlFilter hqlFilter) {
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

}
