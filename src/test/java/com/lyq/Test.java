package com.lyq;

import com.alibaba.fastjson.JSONArray;
import sy.model.account.vo.AccountYearTotal;
import sy.model.account.vo.Month;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyq on 2016/10/20.
 */
public class Test {

    public static void main(String[] args) {
        List<AccountYearTotal> totals = new ArrayList<AccountYearTotal>();
        AccountYearTotal total = new AccountYearTotal();
        total.setAccountid("1");
        total.setAccountName("招行");
        total.setTotal(1000);
        total.setMonthMoney1(50);
        total.setMonthMoney2(50);
        total.setMonthMoney3(80);
        total.setMonthMoney4(40);
        total.setMonthMoney5(50);
        total.setMonthMoney6(20);
        total.setMonthMoney8(50);
        total.setMonthMoney10(150);
        total.setMonthMoney12(50);
        totals.add(total);
        total = new AccountYearTotal();
        total.setAccountid("1");
        total.setAccountName("招行");
        total.setMonthMoney1(150);
        total.setMonthMoney2(60);
        total.setMonthMoney3(280);
        total.setMonthMoney4(40);
        total.setMonthMoney5(70);
        total.setMonthMoney6(20);
        total.setMonthMoney8(50);
        total.setMonthMoney10(140);
        total.setMonthMoney12(50);
        total.setTotal(2000);
        totals.add(total);
        System.out.println(JSONArray.toJSON(totals).toString());
    }

}
