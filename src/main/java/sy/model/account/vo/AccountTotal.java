package sy.model.account.vo;

import sy.util.base.StringUtil;

public class AccountTotal {

	private String accountid = StringUtil.FS_EMPTY;// 账户id
	private String accountName = StringUtil.FS_EMPTY;// 账户名
	private double incomeTotal = 0;// 收入合计
	private double payoutTotal = 0;// 支出合计
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

	public double getIncomeTotal() {
		return incomeTotal;
	}

	public void setIncomeTotal(double incomeTotal) {
		this.incomeTotal = incomeTotal;
		this.total = this.incomeTotal - this.payoutTotal;
	}

	public double getPayoutTotal() {
		return payoutTotal;
	}

	public void setPayoutTotal(double payoutTotal) {
		this.payoutTotal = payoutTotal;
		this.total = this.incomeTotal - this.payoutTotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
