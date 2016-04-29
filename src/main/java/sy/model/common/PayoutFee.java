package sy.model.common;

import java.io.Serializable;

/**
 * 报表中的应付费用对象
 */
public class PayoutFee implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String busiId = StringManage.FS_EMPTY;// 承运单号
    protected int sequence = 1;// 柜序号
    protected int id = 0;// 费用编号
    protected String name = StringManage.FS_EMPTY;// 费用名称
    protected double money = 0.0;// 金额
    protected double writeOffMoney = 0.0;// 核销金额
    protected int feeType = 0;// 费用类型
    protected String currency = StringManage.FS_EMPTY;// 币种
    protected int feeProperty = 0;// 费用性质
    protected String payoutToUnit = StringManage.FS_EMPTY;// 支付单位
    protected String payoutToObject = StringManage.FS_EMPTY;// 支付对象
    protected int isTax = 0;// 是否交税
    protected int isAdvance = 0;// 是否代垫
    protected String writeOffTime = StringManage.FS_EMPTY;// 核销时间

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getWriteOffMoney() {
        return writeOffMoney;
    }

    public void setWriteOffMoney(double writeOffMoney) {
        this.writeOffMoney = writeOffMoney;
    }

    public int getFeeType() {
        return feeType;
    }

    public void setFeeType(int feeType) {
        this.feeType = feeType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        if (currency != null) {
            this.currency = currency;
        }
    }

    public String getPayoutToUnit() {
        return payoutToUnit;
    }

    public void setPayoutToUnit(String payoutToUnit) {
        if (payoutToUnit != null) {
            this.payoutToUnit = payoutToUnit;
        }
    }

    public String getPayoutToObject() {
        return payoutToObject;
    }

    public void setPayoutToObject(String payoutToObject) {
        if (payoutToObject != null) {
            this.payoutToObject = payoutToObject;
        }
    }

    public int getFeeProperty() {
        return feeProperty;
    }

    public void setFeeProperty(int feeProperty) {
        this.feeProperty = feeProperty;
    }

    public int getIsTax() {
        return isTax;
    }

    public void setIsTax(int isTax) {
        this.isTax = isTax;
    }

    public int getIsAdvance() {
        return isAdvance;
    }

    public void setIsAdvance(int isAdvance) {
        this.isAdvance = isAdvance;
    }

    public String getWriteOffTime() {
        return writeOffTime;
    }

    public void setWriteOffTime(String writeOffTime) {
        this.writeOffTime = writeOffTime;
    }

    public String getColor() {
        String color = StringManage.FS_EMPTY;
        switch (feeType) {// 按费用类型
            case 1:
                color = "red";
                break;
            case 2:
                color = "blue";
                break;
            case 3:
                color = "purple";
                break;
            case 4:
                color = "green";
                break;
        }
        switch (feeProperty) {// 按费用性质
            case 2:
                color = "fuchsia";
                break;
            case 3:
                color = "red";
                break;
            case 4:
                color = "deeppink";
                break;
        }
        if (isAdvance > 0) {// 是否代垫
            color = "sandybrown";
        }
        return color;
    }
}
