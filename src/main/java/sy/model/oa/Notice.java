package sy.model.oa;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 公告
 */
@Entity
@Table(name = "notice")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Notice implements java.io.Serializable {

    private int id;
    private String title;// 标题
    private String concent;// 内容
    private String createtime;// 创建时间
    private String createman;// 创建人
    private int actflag;// 状态

    // Constructors

    /**
     * default constructor
     */
    public Notice() {
    }

    /**
     * minimal constructor
     */
    public Notice(int id) {
        this.id = id;
    }

    // Property accessors
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title", length = 30)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "concent")
    public String getConcent() {
        return concent;
    }

    public void setConcent(String concent) {
        this.concent = concent;
    }

    @Column(name = "createtime", length = 20)
    public String getCreatetime() {
        if (this.createtime!=null && this.createtime != "") {
            return createtime;
        }
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Column(name = "createman", length = 30)
    public String getCreateman() {
        return createman;
    }

    public void setCreateman(String createman) {
        this.createman = createman;
    }

    @Column(name = "actflag", length = 4)
    public int getActflag() {
        return actflag;
    }

    public void setActflag(int actflag) {
        this.actflag = actflag;
    }
}