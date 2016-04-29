package sy.model.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 财务报表公共查询条件
 */
public class ReportFeeSearch extends ReportSearch {
    private static final long serialVersionUID = 1L;
    protected double total = 0;// 金额总计
    protected double writeOffTotal = 0;// 核销金额总计
    protected double balanceTotal = 0.0;// 未核销金额总计
    protected double feeTotal = 0;// 运输费用合计
    protected double feeTotal$ = 0;// 特殊费用合计
    protected List<IncomeFee> incomeFee = new ArrayList<IncomeFee>();// 应收费用
    protected List<PayoutFee> payoutFee = new ArrayList<PayoutFee>();// 应付费用
    protected int reportType = 0;// 应收账单样式(0:默认明细账单;1:简易账单(费用只显示运费和杂费))
    protected int reportFeeType = -1;//费用类型(-1:所有费用;0:运费;1:杂费)
    protected int payoutReportType = 0;// 应付账单样式(0:默认明细账单;1:简易账单(费用只显示运费和杂费))
    protected double truckProfitTotal = 0;// 车辆利润总计
    protected double operationManProfitTotal = 0;// 业务员提成总计
    protected int feeProperty = -1;//费用性质(-1:请选择;0:'正常费用',1:'预收类型,2:'预付类型',3:'扣除类型')
    protected int isExcelFormula = 0;// 导出excel的合计是否需要设置计算公式(0:不需要;1:要)
    protected int excelBeginRows = 0;// 导出excel合计的开始行

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getWriteOffTotal() {
        return writeOffTotal;
    }

    public void setWriteOffTotal(double writeOffTotal) {
        this.writeOffTotal = writeOffTotal;
    }

    public void setWriteOffTotal$(double writeOffTotal) {
        this.writeOffTotal = writeOffTotal;
    }

    public double getBalanceTotal() {
        return balanceTotal;
    }

    public void setBalanceTotal(double balanceTotal) {
        this.balanceTotal = balanceTotal;
    }

    public List<IncomeFee> getIncomeFee() {
        return incomeFee;
    }

    public void setIncomeFee(List<IncomeFee> incomeFee) {
        this.incomeFee = incomeFee;
    }

    public List<PayoutFee> getPayoutFee() {
        return payoutFee;
    }

    public void setPayoutFee(List<PayoutFee> payoutFee) {
        this.payoutFee = payoutFee;
    }

    public double getFeeTotal() {
        return feeTotal;
    }

    public void setFeeTotal(double feeTotal) {
        this.feeTotal = feeTotal;
    }

    public double getFeeTotal$() {
        return feeTotal$;
    }

    public void setFeeTotal$(double feeTotal$) {
        this.feeTotal$ = feeTotal$;
    }

    public int getReportType() {
        return reportType;
    }

    public void setReportType(int reportType) {
        this.reportType = reportType;
    }


    public int getReportFeeType() {
        return reportFeeType;
    }

    public void setReportFeeType(int reportFeeType) {
        this.reportFeeType = reportFeeType;
    }

    public int getPayoutReportType() {
        return payoutReportType;
    }

    public void setPayoutReportType(int payoutReportType) {
        this.payoutReportType = payoutReportType;
    }

    public double getTruckProfitTotal() {
        return truckProfitTotal;
    }

    public void setTruckProfitTotal(double truckProfitTotal) {
        this.truckProfitTotal = truckProfitTotal;
    }

    public double getOperationManProfitTotal() {
        return operationManProfitTotal;
    }

    public void setOperationManProfitTotal(double operationManProfitTotal) {
        this.operationManProfitTotal = operationManProfitTotal;
    }

    public int getFeeProperty() {
        return feeProperty;
    }

    public void setFeeProperty(int feeProperty) {
        this.feeProperty = feeProperty;
    }

    public int getIsExcelFormula() {
        return isExcelFormula;
    }

    public void setIsExcelFormula(int isExcelFormula) {
        this.isExcelFormula = isExcelFormula;
    }

    public int getExcelBeginRows() {
        return excelBeginRows;
    }

    public void setExcelBeginRows(int excelBeginRows) {
        this.excelBeginRows = excelBeginRows;
    }

}
