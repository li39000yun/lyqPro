package sy.service.account.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.base.BaseDaoI;
import sy.model.account.Account;
import sy.model.account.Daily;
import sy.model.account.vo.AccountTotal;
import sy.service.account.AccountServiceI;
import sy.service.impl.BaseServiceImpl;
import sy.util.base.HqlFilter;
import sy.util.base.excel.ExcelUtil;

/**
 * @author lyq
 * @version V1.0
 * @Description: 账户业务
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
    public void exportExcelAccountTotal(HqlFilter hqlFilter, String excleName) throws IOException, IllegalAccessException {
        // TODO Auto-generated method stub
        List<AccountTotal> accountTotals = accountTotal(hqlFilter);
        ExcelUtil.ExportSetInfo exportSetInfo = new ExcelUtil.ExportSetInfo();
        exportSetInfo.setTitles(new String[]{"收支明细表"});
        List<String[]> headNames = new ArrayList<String[]>();
        headNames.add(new String[]{"账户名", "收入", "支出", "小计"});
        List<String[]> fieldNames = new ArrayList<String[]>();
        fieldNames.add(new String[]{"accountName", "incomeTotal", "payoutTotal", "total"});
        LinkedHashMap<String, List> objsMap = new LinkedHashMap<String, List>();
        objsMap.put("收支明细表", accountTotals);
        exportSetInfo.setHeadNames(headNames);
        exportSetInfo.setFieldNames(fieldNames);
        exportSetInfo.setObjsMap(objsMap);
        exportSetInfo.setOut(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\" + excleName));
        ExcelUtil.export2Excel(exportSetInfo);
    }

}
