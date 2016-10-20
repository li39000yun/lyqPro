package sy.model.account.vo;

import sy.util.base.StringUtil;

public class AccountYearTotal {

    private String accountid = StringUtil.FS_EMPTY;// 账户id
    private String accountName = StringUtil.FS_EMPTY;// 账户名
    private double monthMoney1 = 0;//一月份金额
    private double monthMoney2 = 0;//二月份金额
    private double monthMoney3 = 0;//三月份金额
    private double monthMoney4 = 0;//四月份金额
    private double monthMoney5 = 0;//五月份金额
    private double monthMoney6 = 0;//六月份金额
    private double monthMoney7 = 0;//七月份金额
    private double monthMoney8 = 0;//八月份金额
    private double monthMoney9 = 0;//九月份金额
    private double monthMoney10 = 0;//十月份金额
    private double monthMoney11 = 0;//十一月份金额
    private double monthMoney12 = 0;//十二月份金额
    private double total = 0;// 小计

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getMonthMoney1() {
        return monthMoney1;
    }

    public void setMonthMoney1(double monthMoney1) {
        this.monthMoney1 = monthMoney1;
    }

    public double getMonthMoney2() {
        return monthMoney2;
    }

    public void setMonthMoney2(double monthMoney2) {
        this.monthMoney2 = monthMoney2;
    }

    public double getMonthMoney3() {
        return monthMoney3;
    }

    public void setMonthMoney3(double monthMoney3) {
        this.monthMoney3 = monthMoney3;
    }

    public double getMonthMoney4() {
        return monthMoney4;
    }

    public void setMonthMoney4(double monthMoney4) {
        this.monthMoney4 = monthMoney4;
    }

    public double getMonthMoney5() {
        return monthMoney5;
    }

    public void setMonthMoney5(double monthMoney5) {
        this.monthMoney5 = monthMoney5;
    }

    public double getMonthMoney6() {
        return monthMoney6;
    }

    public void setMonthMoney6(double monthMoney6) {
        this.monthMoney6 = monthMoney6;
    }

    public double getMonthMoney7() {
        return monthMoney7;
    }

    public void setMonthMoney7(double monthMoney7) {
        this.monthMoney7 = monthMoney7;
    }

    public double getMonthMoney8() {
        return monthMoney8;
    }

    public void setMonthMoney8(double monthMoney8) {
        this.monthMoney8 = monthMoney8;
    }

    public double getMonthMoney9() {
        return monthMoney9;
    }

    public void setMonthMoney9(double monthMoney9) {
        this.monthMoney9 = monthMoney9;
    }

    public double getMonthMoney10() {
        return monthMoney10;
    }

    public void setMonthMoney10(double monthMoney10) {
        this.monthMoney10 = monthMoney10;
    }

    public double getMonthMoney11() {
        return monthMoney11;
    }

    public void setMonthMoney11(double monthMoney11) {
        this.monthMoney11 = monthMoney11;
    }

    public double getMonthMoney12() {
        return monthMoney12;
    }

    public void setMonthMoney12(double monthMoney12) {
        this.monthMoney12 = monthMoney12;
    }
}
