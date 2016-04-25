package sy.model.account;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.StringUtils;

/**
 * Daily entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "daily", catalog = "ss")
public class Daily implements java.io.Serializable {

	// Fields

	private String id;
	private Double money;
	private Timestamp createdatetime;
	private String remark;
	private Short type;
	private Short actflag;
	
	private Account account;// 关联日记账账户对象

	// Constructors

	/** default constructor */
	public Daily() {
	}

	/** full constructor */
	public Daily(String id, String accountid, Double money, Timestamp createdatetime, String remark, Short type, Short actflag) {
		this.id = id;
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
		if (!StringUtils.isBlank(this.id)) {
			return this.id;
		}
		return UUID.randomUUID().toString();
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "money", precision = 10)
	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdatetime", length = 7)
	public Date getCreatedatetime() {
		if (this.createdatetime != null)
			return this.createdatetime;
		return new Date();
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
		if (this.actflag != null)
			return this.actflag;
		return 1;
	}

	public void setActflag(Short actflag) {
		this.actflag = actflag;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountid")
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}