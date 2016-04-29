package sy.model.common;

import java.io.Serializable;

/**
 * Created by lyq on 2016/4/26.
 */
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    protected int count = 0;// 分页列表中的排序
    protected int id = Integer.MIN_VALUE;// 公司代码
    protected String accreditId = "";// 授权码,引用(accredit_corporate.accredit_id)
    protected String shortName = "";// 公司简称
    protected String name = "";// 公司名称
    protected String spell = "";// 拼音缩写
    protected String enName = "";// 英文名称
    protected String address = "";// 地址
    protected String contact = "";// 联系人
    protected String telephone = "";// 联系电话
    protected String fax = "";// 传真号码
    protected String www = "";// 网址
    protected String email = "";// 邮箱地址
    protected String remark = "";// 备注
    protected int actflag = 1;// 当前状态(0:停止使用;1:正常使用)
    protected String loadboxRemark = "";// 装箱单备注
    protected String logoName = "";// 文件名称

    public Company() {

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        if (shortName != null) {
            this.shortName = shortName;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        if (spell != null) {
            this.spell = spell;
        }
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        if (enName != null) {
            this.enName = enName;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null) {
            this.address = address;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        if (fax != null) {
            this.fax = fax;
        }
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        if (www != null) {
            this.www = www;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email;
        }
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        if (remark != null) {
            this.remark = remark;
        }
    }

    public int getActflag() {
        return actflag;
    }

    public void setActflag(int actflag) {
        this.actflag = actflag;
    }

    public String getLoadboxRemark() {
        return loadboxRemark;
    }

    public void setLoadboxRemark(String loadboxRemark) {
        if (loadboxRemark != null) {
            this.loadboxRemark = loadboxRemark;
        }
    }

    public String getLogoName() {
        return logoName;
    }

    public void setLogoName(String logoName) {
        if (logoName != null) {
            this.logoName = logoName;
        }
    }

    public void clone(Company model) {
        if (!(model instanceof Company)) {
            return;
        }
        Company obj = (Company) model;
        if (obj != null) {
            obj.count = count;
            obj.id = id;
            obj.accreditId = accreditId;
            obj.shortName = shortName;
            obj.name = name;
            obj.spell = spell;
            obj.enName = enName;
            obj.address = address;
            obj.contact = contact;
            obj.telephone = telephone;
            obj.fax = fax;
            obj.www = www;
            obj.email = email;
            obj.remark = remark;
            obj.actflag = actflag;
            obj.loadboxRemark = loadboxRemark;
            obj.logoName = logoName;
        }
    }

}