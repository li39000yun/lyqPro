package sy.model.account;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Daily entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "daily", catalog = "ss")
public class Daily implements java.io.Serializable {

	// Fields

	private String id;
	private String accountid;
	private Double money;
	private Timestamp createdatetime;
	private String remark;
	private Short type;
	private Short actflag;

	// Constructors

	/** default constructor */
	public Daily() {
	}

	/** minimal constructor */
	public Daily(String id, String accountid) {
		this.id = id;
		this.accountid = accountid;
	}

	/** full constructor */
	public Daily(String id, String accountid, Double money, Timestamp createdatetime, String remark, Short type, Short actflag) {
		this.id = id;
		this.accountid = accountid;
		this.money = money;
		this.createdatetime = createdatetime;
		this.remark = remark;
		this.type = type;
		this.actflag = actflag;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "accountid", nullable = false, length = 36)
	public String getAccountid() {
		return this.accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	@Column(name = "money", precision = 10)
	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Column(name = "createdatetime", length = 0)
	public Timestamp getCreatedatetime() {
		return this.createdatetime;
	}

	public void setCreatedatetime(Timestamp createdatetime) {
		this.createdatetime = createdatetime;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "type")
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@Column(name = "actflag")
	public Short getActflag() {
		return this.actflag;
	}

	public void setActflag(Short actflag) {
		this.actflag = actflag;
	}

}