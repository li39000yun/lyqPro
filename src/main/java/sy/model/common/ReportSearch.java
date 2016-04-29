package sy.model.common;

/**
 * Created by lyq on 2016/4/26.
 */
public class ReportSearch extends LevelSearch {
    private static final long serialVersionUID = 1L;
    // 固定查询
    protected int customerId = 0;// 客户编号
    protected String customerName = "";// 客户名称
    protected String bookingNo = "";// 订舱号
    protected String containerNo = "";// 柜号
    protected int state = -1;// 当前状态
    protected int sequence = 0;// 柜序号
    protected int defaultState = 50;// 默认查询状态
    protected String dateType = "container";// 时间类型
    protected String searchType = "containerNo";// 查询类型(柜号，业务编号)

    // 自定义查询
    protected String fieldsOfTime = "";// 自定义时间查询
    protected String beginDate = "";// 开始日期
    protected String endDate = "";// 结束日期
    protected String fieldsOfChar = "";// 自定义字符查询
    protected String fieldsValue = "";// 字符查询内容
    protected String[] fieldsId = new String[0];// 字段编号
    protected String[] commonBoxValue = new String[0];// 自动补全下拉框字段数据集
    protected String[] commonBoxId = new String[0];// 自动补全下拉框编号数据集
    protected String[] commonBoxName = new String[0];// 自动补全下拉框内容数据集
    protected String[] selectCommonBoxValue = new String[0];// 下拉框字段数据集
    protected String[] selectCommonBoxName = new String[0];// 下拉框内容数据集

    // 自定义列表数据
    protected int tabWidth = 0;// 表格宽度
    protected int headId = 0;// 公司id
    protected int styleId = 1;// 样式编号
    protected int colspan = 0;// 合并列数
    protected int reportType = 0;// 设置报表类型(0:数据报表;1:业务列表)
    protected String filePath = "";// excel存放路径
    protected ReportSetup[] reports = new ReportSetup[0];// 自定义信息
    protected String orderBySql = "";// 组合排序语句


    public int getTabWidth() {
        return tabWidth;
    }

    public void setTabWidth(int tabWidth) {
        this.tabWidth = tabWidth;
    }

    public int getHeadId() {
        return headId;
    }

    public void setHeadId(int headId) {
        this.headId = headId;
    }

    public String getOrderBySql() {
        return orderBySql;
    }

    public void setOrderBySql(String orderBySql) {
        this.orderBySql = orderBySql;
    }

    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    public int getColspan() {
        return colspan;
    }

    public void setColspan(int colspan) {
        this.colspan = colspan;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ReportSetup[] getReports() {
        return reports;
    }

    public void setReports(ReportSetup[] reports) {
        this.reports = reports;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getDefaultState() {
        return defaultState;
    }

    public void setDefaultState(int defaultState) {
        this.defaultState = defaultState;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public int getReportType() {
        return reportType;
    }

    public void setReportType(int reportType) {
        this.reportType = reportType;
    }

    public String getFieldsOfTime() {
        return fieldsOfTime;
    }

    public void setFieldsOfTime(String fieldsOfTime) {
        this.fieldsOfTime = fieldsOfTime;
    }

    public String getFieldsOfChar() {
        return fieldsOfChar;
    }

    public void setFieldsOfChar(String fieldsOfChar) {
        this.fieldsOfChar = fieldsOfChar;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFieldsValue() {
        return fieldsValue;
    }

    public void setFieldsValue(String fieldsValue) {
        this.fieldsValue = fieldsValue;
    }

    public String[] getFieldsId() {
        return fieldsId;
    }

    public void setFieldsId(String[] fieldsId) {
        this.fieldsId = fieldsId;
    }

    public String[] getCommonBoxValue() {
        return commonBoxValue;
    }

    public void setCommonBoxValue(String[] commonBoxValue) {
        this.commonBoxValue = commonBoxValue;
    }

    public String[] getCommonBoxId() {
        return commonBoxId;
    }

    public void setCommonBoxId(String[] commonBoxId) {
        this.commonBoxId = commonBoxId;
    }

    public String[] getCommonBoxName() {
        return commonBoxName;
    }

    public void setCommonBoxName(String[] commonBoxName) {
        this.commonBoxName = commonBoxName;
    }

    public String[] getSelectCommonBoxValue() {
        return selectCommonBoxValue;
    }

    public void setSelectCommonBoxValue(String[] selectCommonBoxValue) {
        this.selectCommonBoxValue = selectCommonBoxValue;
    }

    public String[] getSelectCommonBoxName() {
        return selectCommonBoxName;
    }

    public void setSelectCommonBoxName(String[] selectCommonBoxName) {
        this.selectCommonBoxName = selectCommonBoxName;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchValue(String paramString) {
        if (commonBoxValue.length > 0) {
            for (int i = 0; i < commonBoxValue.length; i++) {
                if (commonBoxValue[i].lastIndexOf(paramString) != -1) {
                    return commonBoxName[i];
                }
            }
        }
        return "";
    }

    public void clone(ReportSearch obj) {
        super.clone(obj);
        if (obj != null) {
            // 固定查询
            obj.customerId = customerId;
            obj.customerName = customerName;
            obj.bookingNo = bookingNo;
            obj.containerNo = containerNo;
            obj.state = state;
            obj.sequence = sequence;
            obj.defaultState = defaultState;
            obj.dateType = dateType;
            // 自定义查询
            obj.fieldsOfTime = fieldsOfTime;
            obj.beginDate = beginDate;
            obj.endDate = endDate;
            obj.fieldsOfChar = fieldsOfChar;
            obj.fieldsValue = fieldsValue;
            obj.fieldsId = fieldsId;
            obj.commonBoxValue = commonBoxValue;
            obj.commonBoxId = commonBoxId;
            obj.commonBoxName = commonBoxName;
            obj.selectCommonBoxValue = selectCommonBoxValue;
            obj.selectCommonBoxName = selectCommonBoxName;

            // 自定义列表数据
            obj.tabWidth = tabWidth;
            obj.headId = headId;
            obj.styleId = styleId;
            obj.colspan = colspan;
            obj.reportType = reportType;
            obj.filePath = filePath;
            obj.reports = reports;
            obj.orderBySql = orderBySql;

        }
    }

}
