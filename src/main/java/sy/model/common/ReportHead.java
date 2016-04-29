package sy.model.common;

import java.io.Serializable;


/**
 * Created by lyq on 2016/4/26.
 */
public class ReportHead implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String $MAPPING_TABLE_NAME = "organ_report_head";// 数据库表名称

	protected int count = 0;// 分页列表中的序号
	protected int id = Integer.MIN_VALUE;// 流水号
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
	protected int companyId = 0;// 所属公司,引用(organ_company.id)
	protected String remark = "";// 应收备注
	protected int actflag = 1;// 状态,0:休眠;1:激活
	protected String payoutRemark = "";// 应付备注
	protected String sendRemark = "";// 报柜备注

	public ReportHead() {

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

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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

	public String getPayoutRemark() {
		return payoutRemark;
	}

	public void setPayoutRemark(String payoutRemark) {
		if (payoutRemark != null) {
			this.payoutRemark = payoutRemark;
		}
	}

	public String getSendRemark() {
		return sendRemark;
	}

	public void setSendRemark(String sendRemark) {
		if (sendRemark != null) {
			this.sendRemark = sendRemark;
		}
	}

}