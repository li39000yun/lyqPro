package sy.model.common;

import java.io.Serializable;

/**
 * 装/卸工厂
 */
public class MoreFactory implements Serializable {

    private static final long serialVersionUID = 1L;

    protected int count = 0;// 分页列表中的序号
    protected int id = Integer.MIN_VALUE;// 流水号
    protected String accreditId = "";// 授权代码,引用(corp_accredit.accredit_id)
    protected String busiId = "";// 承运单号,引用(busi_base.busi_id)
    protected int sequence = 0;// 柜序号
    protected int factoryId = 0;// 工厂编号
    protected String factoryShortName = "";// 工厂简称
    protected String contact = "";// 联系人
    protected String telephone = "";// 联系电话
    protected String loadPlace = "";// 装/卸货地点
    protected String address = "";// 装/卸货地址
    protected int typeId = 0;// 工厂类型(0:装货;1:卸货)

    public MoreFactory() {

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccreditId() {
        return accreditId;
    }

    public void setAccreditId(String accreditId) {
        if (accreditId != null) {
            this.accreditId = accreditId;
        }
    }

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        if (busiId != null) {
            this.busiId = busiId;
        }
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactoryShortName() {
        return factoryShortName;
    }

    public void setFactoryShortName(String factoryShortName) {
        if (factoryShortName != null) {
            this.factoryShortName = factoryShortName;
        }
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        if (contact != null) {
            this.contact = contact;
        }
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        if (telephone != null) {
            this.telephone = telephone;
        }
    }

    public String getLoadPlace() {
        return loadPlace;
    }

    public void setLoadPlace(String loadPlace) {
        if (loadPlace != null && !loadPlace.equals("装")
                && !loadPlace.equals("卸")) {
            this.loadPlace = loadPlace;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && !address.equals("装") && !address.equals("卸")) {
            this.address = address;
        }
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

}