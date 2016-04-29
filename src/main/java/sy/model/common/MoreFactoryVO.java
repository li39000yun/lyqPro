package sy.model.common;

/**
 * Created by lyq on 2016/4/29.
 */
public class MoreFactoryVO extends MoreFactory {
    private static final long serialVersionUID = 1L;
    protected String factoryAllName = "";// 工厂全称
    protected int factoryId$ = 0;// 卸工厂编号
    protected String factoryShortName$ = "";// 卸工厂简称
    protected String contact$ = "";// 装/卸联系人
    protected String telephone$ = "";// 装/卸联系电话
    protected String loadPlace$ = "";// 装/卸货地点
    protected String address$ = "";// 装/卸货地址
    protected String factoryAllName$ = "";// 装/卸货工厂全称

    protected String factoryShortName1$ = "";// 装货工厂简称
    protected String contact1$ = "";// 装货联系人
    protected String telephone1$ = "";// 装货联系电话
    protected String loadPlace1$ = "";// 装货地点
    protected String address1$ = "";// 装货地址
    protected String factoryAllName1$ = "";// 装货工厂全称

    protected String factoryShortName2$ = "";// 卸货工厂简称
    protected String contact2$ = "";// 卸货联系人
    protected String telephone2$ = "";// 卸货联系电话
    protected String loadPlace2$ = "";// 卸货地点
    protected String address2$ = "";// 卸货地址
    protected String factoryAllName2$ = "";// 卸货工厂全称

    public void toFactory(String factoryName) {
        if (!StringManage.isEmpty(factoryName)) {
            this.factoryShortName = this.factoryShortName + "<br>"
                    + factoryName;
        }
    }

    public void toFactoryAllName(String factoryName) {
        if (!StringManage.isEmpty(factoryName)) {
            this.factoryAllName = this.factoryAllName + "<br>"
                    + factoryName;
        }
    }

    public void toLoadPlace(String loadPlace) {
        if (!StringManage.isEmpty(loadPlace)) {
            this.loadPlace = this.loadPlace + "<br>" + loadPlace;
        }
    }

    public void toContact(String contact) {
        if (!StringManage.isEmpty(contact)) {
            this.contact = this.contact + "<br>" + contact;
        }
    }

    public void toAddress(String address) {
        if (!StringManage.isEmpty(address)) {
            this.address = this.address + "<br>" + address;
        }
    }

    public void toTelephone(String telephone) {
        if (telephone != null) {
            this.telephone = this.telephone + "<br>" + telephone;
        }
    }

    public void toFactory$(String factoryName) {
        if (!StringManage.isEmpty(factoryName)) {
            this.factoryShortName$ = this.factoryShortName$ + "<br>"
                    + factoryName;
        }
    }

    public void toFactory1(String factoryName) {
        if (!StringManage.isEmpty(factoryName)) {
            this.factoryShortName1$ = this.factoryShortName1$ + "<br>"
                    + factoryName;
        }
    }

    public void toFactory2(String factoryName) {
        if (!StringManage.isEmpty(factoryName)) {
            this.factoryShortName2$ = this.factoryShortName2$ + "<br>"
                    + factoryName;
        }
    }

    public void toLoadPlace$(String loadPlace) {
        if (!StringManage.isEmpty(loadPlace)) {
            this.loadPlace$ = this.loadPlace$ + "<br>" + loadPlace;
        }
    }

    public void toLoadPlace1(String loadPlace) {
        if (!StringManage.isEmpty(loadPlace)) {
            this.loadPlace1$ = this.loadPlace1$ + "<br>" + loadPlace;
        }
    }

    public void toLoadPlace2(String loadPlace) {
        if (!StringManage.isEmpty(loadPlace)) {
            this.loadPlace2$ = this.loadPlace2$ + "<br>" + loadPlace;
        }
    }

    public void toContact$(String contact) {
        if (!StringManage.isEmpty(contact)) {
            this.contact$ = this.contact$ + "<br>" + contact;
        }
    }

    public void toContact1(String contact) {
        if (!StringManage.isEmpty(contact)) {
            this.contact1$ = this.contact1$ + "<br>" + contact;
        }
    }

    public void toContact2(String contact) {
        if (!StringManage.isEmpty(contact)) {
            this.contact2$ = this.contact2$ + "<br>" + contact;
        }
    }

    public void toAddress$(String address) {
        if (!StringManage.isEmpty(address)) {
            this.address$ = this.address$ + "<br>" + address;
        }
    }

    public void toAddress1(String address) {
        if (!StringManage.isEmpty(address)) {
            this.address1$ = this.address1$ + "<br>" + address;
        }
    }

    public void toAddress2(String address) {
        if (!StringManage.isEmpty(address)) {
            this.address2$ = this.address2$ + "<br>" + address;
        }
    }

    public void toTelephone$(String telephone) {
        if (telephone != null) {
            this.telephone$ = this.telephone$ + "<br>" + telephone;
        }
    }

    public void toTelephone1(String telephone) {
        if (telephone != null) {
            this.telephone1$ = this.telephone1$ + "<br>" + telephone;
        }
    }

    public void toTelephone2(String telephone) {
        if (telephone != null) {
            this.telephone2$ = this.telephone2$ + "<br>" + telephone;
        }
    }

    public void toFactoryName$(String factoryName) {
        if (factoryName != null) {
            this.factoryAllName$ = this.factoryAllName$ + "<br>" + factoryName;
        }
    }

    public void toFactoryName1(String factoryName) {
        if (factoryName != null) {
            this.factoryAllName1$ = this.factoryAllName1$ + "<br>" + factoryName;
        }
    }

    public void toFactoryName2(String factoryName) {
        if (factoryName != null) {
            this.factoryAllName2$ = this.factoryAllName2$ + "<br>" + factoryName;
        }
    }

    public int getFactoryId$() {
        return factoryId$;
    }

    public void setFactoryId$(int factoryId$) {
        this.factoryId$ = factoryId$;
    }

    public String getFactoryShortName$() {
        return factoryShortName$;
    }

    public void setFactoryShortName$(String factoryShortName$) {
        if (factoryShortName$ != null) {
            this.factoryShortName$ = factoryShortName$;
        }
    }

    public String getContact$() {
        return contact$;
    }

    public void setContact$(String contact$) {
        if (contact$ != null) {
            this.contact$ = contact$;
        }
    }

    public String getTelephone$() {
        return telephone$;
    }

    public void setTelephone$(String telephone$) {
        if (telephone$ != null) {
            this.telephone$ = telephone$;
        }
    }

    public String getLoadPlace$() {
        return loadPlace$;
    }

    public void setLoadPlace$(String loadPlace$) {
        if (loadPlace$ != null) {
            this.loadPlace$ = loadPlace$;
        }
    }

    public String getAddress$() {
        return address$;
    }

    public void setAddress$(String address$) {
        if (address$ != null) {
            this.address$ = address$;
        }
    }

    public String getAddress2$() {
        return address2$;
    }

    public void setAddress2$(String address2$) {
        this.address2$ = address2$;
    }

    public String getAddress1$() {
        return address1$;
    }

    public void setAddress1$(String address1$) {
        this.address1$ = address1$;
    }

    public String getContact1$() {
        return contact1$;
    }

    public void setContact1$(String contact1$) {
        this.contact1$ = contact1$;
    }

    public String getContact2$() {
        return contact2$;
    }

    public void setContact2$(String contact2$) {
        this.contact2$ = contact2$;
    }

    public String getTelephone1$() {
        return telephone1$;
    }

    public void setTelephone1$(String telephone1$) {
        this.telephone1$ = telephone1$;
    }

    public String getTelephone2$() {
        return telephone2$;
    }

    public void setTelephone2$(String telephone2$) {
        this.telephone2$ = telephone2$;
    }

    public String getLoadPlace1$() {
        return loadPlace1$;
    }

    public void setLoadPlace1$(String loadPlace1$) {
        this.loadPlace1$ = loadPlace1$;
    }

    public String getLoadPlace2$() {
        return loadPlace2$;
    }

    public void setLoadPlace2$(String loadPlace2$) {
        this.loadPlace2$ = loadPlace2$;
    }

    public String getFactoryShortName1$() {
        return factoryShortName1$;
    }

    public void setFactoryShortName1$(String factoryShortName1$) {
        this.factoryShortName1$ = factoryShortName1$;
    }

    public String getFactoryShortName2$() {
        return factoryShortName2$;
    }

    public void setFactoryShortName2$(String factoryShortName2$) {
        this.factoryShortName2$ = factoryShortName2$;
    }

    public String getFactoryAllName() {
        return factoryAllName;
    }

    public void setFactoryAllName(String factoryAllName) {
        this.factoryAllName = factoryAllName;
    }

    public String getFactoryAllName$() {
        return factoryAllName$;
    }

    public void setFactoryAllName$(String factoryAllName$) {
        this.factoryAllName$ = factoryAllName$;
    }

    public String getFactoryAllName1$() {
        return factoryAllName1$;
    }

    public void setFactoryAllName1$(String factoryAllName1$) {
        this.factoryAllName1$ = factoryAllName1$;
    }

    public String getFactoryAllName2$() {
        return factoryAllName2$;
    }

    public void setFactoryAllName2$(String factoryAllName2$) {
        this.factoryAllName2$ = factoryAllName2$;
    }

    public void copyTo1$() {
        this.factoryAllName1$ = this.factoryAllName;
        this.factoryShortName1$ = this.factoryShortName;
        this.contact1$ = this.contact;
        this.telephone1$ = this.telephone;
        this.loadPlace1$ = this.loadPlace;
        this.address1$ = this.address;
    }

}

