package sy.model.account.vo;

/**
 * 月份金额
 * Created by lyq on 2016/10/20.
 */
public class Month {
    private double money = 0;// 金额
    private String month = "";// 月份

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
