package sy.service.account.report.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sy.dao.base.BaseDaoI;
import sy.model.account.Account;
import sy.model.account.Daily;
import sy.model.account.vo.AccountYearTotal;
import sy.service.account.report.AccountYearTotalServiceI;
import sy.service.impl.BaseServiceImpl;
import sy.util.base.DateUtil;
import sy.util.base.HqlFilter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 年统计报表业务
 *
 * @Author 李云强
 * @Date 2016/10/20 22:34
 */
@Service
public class AccountYearTotalServiceImpl extends BaseServiceImpl<AccountYearTotal> implements AccountYearTotalServiceI {

    @Autowired
    private BaseDaoI<Daily> dailyDao;

    @Override
    public List<AccountYearTotal> accountYearTotal(HqlFilter hqlFilter) {
        String hql = "select distinct t from Daily t join t.account account";
        List<Daily> dailys = dailyDao.find(hql + hqlFilter.getWhereAndOrderHql(), hqlFilter.getParams());
        AccountYearTotal accountYearTotal;
        List<AccountYearTotal> datas = new ArrayList<AccountYearTotal>();// 年统计报表，按账户
        HashMap<String, AccountYearTotal> totalHashMap = new HashMap<String, AccountYearTotal>();// key=账户id，value=年统计表对象
        String key;
        for (Daily daily : dailys) {
            key = daily.getAccount().getId();
            if (totalHashMap.containsKey(key)) {
                accountYearTotal = totalHashMap.get(key);
            } else {
                accountYearTotal = new AccountYearTotal();
                accountYearTotal.setAccountid(key);
                accountYearTotal.setAccountName(daily.getAccount().getName());
                datas.add(accountYearTotal);
            }
            totalMoney(accountYearTotal, daily);
            totalHashMap.put(key, accountYearTotal);
        }
        return datas;
    }

    /**
     * 把日记账的金额按月份累加到年统计报表上
     *
     * @param accountYearTotal 年统计报表对象
     * @param daily            收支录入记录
     */
    private void totalMoney(AccountYearTotal accountYearTotal, Daily daily) {
        String month = DateUtil.dateToString(daily.getCreatedatetime()).substring(5, 7);
        double money = daily.getType() == 0 ? daily.getMoney() : -daily.getMoney();
        String getMethod = "getMonthMoney" + Integer.parseInt(month);
        String setMethod = "setMonthMoney" + Integer.parseInt(month);
        // 通过反射调用set方法设置金额
        try {
            Method method = accountYearTotal.getClass().getMethod(getMethod);
            Object object = method.invoke(accountYearTotal);
            method = accountYearTotal.getClass().getMethod(setMethod, double.class);
            method.invoke(accountYearTotal, ((Double) object + money));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
