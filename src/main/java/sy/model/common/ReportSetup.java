package sy.model.common;

import java.io.Serializable;

/**
 * Created by lyq on 2016/4/26.
 */
public class ReportSetup implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String $MAPPING_TABLE_NAME = "base_report_setup";// 数据库表名称

    protected int count = 0;// 分页列表中的序号
    protected String accreditId = "";// 授权码,引用(accredit_corporate.accredit_id)
    protected String serviceId = "";// 所属业务服务编号
    protected int fieldsId = Integer.MIN_VALUE;// 字段编号
    protected int styleId = 1;// 样式编号
    protected String styleName = "初始样式";// 样式名称
    protected String fieldsName = "";// 字段名称
    protected String orderByColumn = "";// 排序字段
    protected String align = "";// 对齐方式
    protected int width = 0;// 宽度
    protected int excelWidth = 0;// excel中宽度
    protected String orderByMode = "";// 排序方式
    protected int orderby = 1;// 排序
    protected int isOrderBy = 0;// 是否排序
    protected String color = "";// 颜色

    public ReportSetup() {

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAccreditId() {
        return accreditId;
    }

    public void setAccreditId(String accreditId) {
        if (accreditId != null) {
            this.accreditId = accreditId;
        }
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        if (serviceId != null) {
            this.serviceId = serviceId;
        }
    }

    public int getFieldsId() {
        return fieldsId;
    }

    public void setFieldsId(int fieldsId) {
        this.fieldsId = fieldsId;
    }

    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        if (styleName != null) {
            this.styleName = styleName;
        }
    }

    public String getFieldsName() {
        return fieldsName;
    }

    public void setFieldsName(String fieldsName) {
        if (fieldsName != null) {
            this.fieldsName = fieldsName;
        }
    }

    public String getOrderByColumn() {
        return orderByColumn;
    }

    public void setOrderByColumn(String orderByColumn) {
        if (orderByColumn != null) {
            this.orderByColumn = orderByColumn;
        }
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        if (align != null) {
            this.align = align;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getExcelWidth() {
        return excelWidth;
    }

    public void setExcelWidth(int excelWidth) {
        this.excelWidth = excelWidth;
    }

    public String getOrderByMode() {
        return orderByMode;
    }

    public void setOrderByMode(String orderByMode) {
        if (orderByMode != null) {
            this.orderByMode = orderByMode;
        }
    }

    public int getOrderby() {
        return orderby;
    }

    public void setOrderby(int orderby) {
        this.orderby = orderby;
    }

    public int getIsOrderBy() {
        return isOrderBy;
    }

    public void setIsOrderBy(int isOrderBy) {
        this.isOrderBy = isOrderBy;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}