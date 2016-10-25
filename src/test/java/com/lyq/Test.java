package com.lyq;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.DoubleArraySerializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import sy.model.account.vo.AccountYearTotal;
import sy.model.account.vo.Month;
import sy.util.base.DateUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lyq on 2016/10/20.
 */
public class Test {

    /**
     * 测试合计方法的反射
     */
    @org.junit.Test
    public void testTotal() {
        AccountYearTotal total = new AccountYearTotal();
        String date = "01";
//        setMonthMoney1
// getMonthMoney2
        total.setMonthMoney1(11);
        String getMethod = "getMonthMoney" + Integer.parseInt(date);
        String setMethod = "setMonthMoney" + Integer.parseInt(date);
        try {
            Method method = total.getClass().getMethod(getMethod);
            Object object = method.invoke(total);
            System.out.println(object);
            System.out.println(String.valueOf((Double)object+3));
            method = total.getClass().getMethod(setMethod,double.class);
            method.invoke(total, ((Double) object + 400));
            System.out.println(total.getMonthMoney1());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试时间
     */
    public void testTime() {
        Date date = new Date();
        String dateStr = DateUtil.dateToString(date);
        System.out.println(dateStr);
        System.out.println(date);
        System.out.println(dateStr.substring(5, 7));
    }

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
