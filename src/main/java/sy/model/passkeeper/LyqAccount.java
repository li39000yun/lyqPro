package sy.model.passkeeper;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

/**
 * 账户信息
 * Created by liyunqaing on 2016/6/27.
 */
@Entity
@Table(name = "account")
@DynamicInsert(true)
@DynamicUpdate(true)
public class LyqAccount {
    // Fields

    private String id;
    private String name;// 账户名
    private Double money;// 余额
    private String password;// 密码
    private Date createdatetime;// 创建时间
    private String remark;// 备注
    private int actflag;// 状态(0:禁用;1:启用;)

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

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "password", length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "money", precision = 10)
    public Double getMoney() {
        return this.money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Column(name = "createdatetime", length = 0)
    public Date getCreatedatetime() {
        if (this.createdatetime != null)
            return this.createdatetime;
        return new Date();
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    @Column(name = "remark", length = 200)
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "actflag")
    public int getActflag() {
        return actflag;
    }

    public void setActflag(int actflag) {
        this.actflag = actflag;
    }

}
