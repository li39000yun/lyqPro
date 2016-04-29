package sy.service.common;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.*;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import jxl.write.Number;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import sy.model.common.*;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Pattern;


/**
 * Created by lyq on 2016/4/26.
 */
public class ExportController {
    protected WritableSheet sheet;// Excel工作表
    protected String reportName = "";// 报表名称
    protected ReportSetup[] reports = new ReportSetup[0];// 报表自定义数据集
    public Map<String, CellFormat> FS_Cell_Maps = new HashMap<String, CellFormat>();// 存储表格对齐方式

    // 初始化报表参数
    public void initialized(WritableSheet sheet, ReportSetup[] reports,
                            String reportName) throws Exception {
        this.sheet = sheet;
        this.reports = reports;
        this.reportName = reportName;
        this.setPageSetup();// 设置纸张

        // 添加表格内容对齐方式
        FS_Cell_Maps.put("left", data(Alignment.LEFT, 10, false));
        FS_Cell_Maps.put("center", data(Alignment.CENTRE, 10, false));
        FS_Cell_Maps.put("right", data(Alignment.RIGHT, 10, false));
        FS_Cell_Maps.put("right_col", data(Alignment.RIGHT, 10, false, 1));//后面参数为object... 第一个参数为费用加颜色(1为是)
    }

    // 添加报表抬头
    public void addHead(ReportHead head, ReportSearch search, String toString) throws Exception {
        // 抬头名称
        int width = reports.length;// 报表宽度
        CellFormat headCell = head(18, Alignment.CENTRE, true);
        sheet.addCell(new Label(0, 0, head.getName(), headCell));
        sheet.mergeCells(0, 0, width, 0);
        sheet.setRowView(0, 450);

        // 设置地址
        headCell = head(12, Alignment.CENTRE, false);
        sheet.addCell(new Label(0, 1, head.getAddress(), headCell));
        sheet.mergeCells(0, 1, width, 1);
        sheet.setRowView(1, 350);

        // 设置电话、传真
        if ("".equals(head.getEmail())) {
            sheet.addCell(new Label(0, 2, "Tel：" + head.getTelephone() + " Fax：" + head.getFax() + " Email：" + head.getEmail(), headCell));
        } else {
            sheet.addCell(new Label(0, 2, "Tel：" + head.getTelephone() + " Fax：" + head.getFax(), headCell));
        }
        sheet.mergeCells(0, 2, width, 2);
        sheet.setRowView(2, 350);

        // 设置报表名称
        sheet.addCell(new Label(0, 3, reportName, headCell));
        sheet.mergeCells(0, 3, width, 3);
        sheet.setRowView(3, 350);

        // 设置收、付款对象信息
        if ("".equals(toString)) {
            sheet.addCell(new Label(0, 4, toString, head(10, Alignment.LEFT, true)));
            sheet.mergeCells(0, 4, width - 4, 4);
        }

        // 设置打印时间
        sheet.addCell(new Label(width - 3, 4, "结算日期：" + search.getBeginTime() + "-" + search.getEndTime(), head(10, Alignment.RIGHT, false)));
        sheet.mergeCells(width - 3, 4, width, 4);
        sheet.setRowView(4, 350);
    }

    // 添加报表抬头
    public void addHead(ReportHead head, ReportSearch search) throws Exception {
        // 抬头名称
        int width = reports.length;// 报表宽度
        CellFormat headCell = head(18, Alignment.CENTRE, true);
        sheet.addCell(new Label(0, 0, head.getName(), headCell));
        sheet.mergeCells(0, 0, width, 0);
        sheet.setRowView(0, 450);

        // 抬头英文名称
        sheet.addCell(new Label(0, 1, head.getEnName(), headCell));
        sheet.mergeCells(0, 1, width, 1);
        sheet.setRowView(1, 450);

        // 设置地址
        headCell = head(12, Alignment.CENTRE, false);
        sheet.addCell(new Label(0, 2, head.getAddress(), headCell));
        sheet.mergeCells(0, 2, width, 2);
        sheet.setRowView(2, 350);

        // 设置电话、传真
        sheet.addCell(new Label(0, 3, "Tel：" + head.getTelephone() + " Fax：" + head.getFax(), headCell));
        sheet.mergeCells(0, 3, width, 3);
        sheet.setRowView(3, 350);

        // 设置网址
        sheet.addCell(new Label(0, 4, "网址：" + head.getWww(), headCell));
        sheet.mergeCells(0, 4, width, 4);
        sheet.setRowView(4, 350);

        // 设置报表名称
        sheet.addCell(new Label(0, 5, reportName, headCell));
        sheet.mergeCells(0, 5, width, 5);
        sheet.setRowView(5, 350);

        // 设置打印时间
        sheet.addCell(new Label(width - 3, 6, "结算日期：" + search.getBeginTime() + "-" + search.getEndTime(), head(10, Alignment.RIGHT, false)));
        sheet.mergeCells(width - 3, 6, width, 6);
        sheet.setRowView(6, 350);
    }

    // 添加报表抬头
    public void addHead(Company head) throws Exception {
        // 抬头名称
        int width = reports.length;// 报表宽度
        CellFormat headCell = head(18, Alignment.CENTRE, true);
        sheet.addCell(new Label(0, 0, head.getName(), headCell));
        sheet.mergeCells(0, 0, width, 0);
        sheet.setRowView(0, 450);

        // 设置地址
        headCell = head(12, Alignment.CENTRE, false);
        sheet.addCell(new Label(0, 1, head.getAddress(), headCell));
        sheet.mergeCells(0, 1, width, 1);
        sheet.setRowView(1, 350);

        // 设置电话、传真
        sheet.addCell(new Label(0, 2, "Tel：" + head.getTelephone() + " Fax：" + head.getFax(), headCell));
        sheet.mergeCells(0, 2, width, 2);
        sheet.setRowView(2, 350);

        // 设置报表名称
        sheet.addCell(new Label(0, 3, reportName, headCell));
        sheet.mergeCells(0, 3, width, 3);
        sheet.setRowView(3, 350);
    }

    // 添加报表抬头
    public void addHead(String str) throws Exception {
        // 抬头名称
        int width = reports.length;// 报表宽度
        CellFormat headCell = head(18, Alignment.CENTRE, true);

        // 设置报表名称
        sheet.addCell(new Label(0, 0, reportName, headCell));
        sheet.mergeCells(0, 0, width, 0);
        sheet.setRowView(0, 350);

        // 设置查询开始时间
        sheet.addCell(new Label(0, 1, str, head(12, Alignment.CENTRE, true)));
        sheet.mergeCells(0, 1, width, 1);
        sheet.setRowView(1, 350);
    }

    /**
     * 添加表格内容
     *
     * @param beginColspan 开始列
     * @param endColspan   结束列
     * @param beginRows    开始行
     * @param endRows      结束行
     * @param value        内容
     * @param align        对齐格式(left、center、right)
     * @throws Exception
     */
    public void addCell(int beginColspan, int endColspan, int beginRows, int endRows, String value, String align) throws Exception {
        sheet.addCell(new Label(beginColspan, beginRows, value, FS_Cell_Maps.get(align)));
        sheet.mergeCells(beginColspan, beginRows, endColspan, endRows);
    }

    /**
     * 添加表格内容
     *
     * @param colspan 列
     * @param rows    行
     * @param value   内容
     * @param align   对齐格式(left、center、right)
     * @throws Exception
     */
    public void addCell(int colspan, int rows, String value, String align) throws Exception {
        addCell(colspan, colspan, rows, rows, value, align);
    }

    // 添加报表内容
    public int addData(ShipperOrder[] datas, int rows) throws Exception {
        // 添加数据表头
        int width = reports.length, i = 0;
        sheet.setColumnView(i, 6);
        sheet.addCell(new Label(i++, rows, "序号", center()));
        for (ReportSetup r : reports) {
            sheet.setColumnView(i, r.getExcelWidth());
            sheet.addCell(new Label(i++, rows, r.getFieldsName(), center()));
        }
        sheet.setRowView(rows++, 400);

        // 添加表格内容
        for (ShipperOrder data : datas) {
            sheet.addCell(new Number(0, rows, data.getCount(), center()));
            for (int j = 0; j < width; j++) {
                String o = toString(data.getDatas().get(j));
                CellFormat dataCell = FS_Cell_Maps.get(getReportsAlign(j));
                if (data.getDatasMark().size() > 0 && data.getDatasMark().size() >= j) {//标记中有有数据才处理
                    if (data.getDatasMark().get(j).equals("writeOff")) { //调度大表费用已核销变颜色
                        if (FS_Cell_Maps.containsKey(getReportsAlign(j) + "_col")) {//存在样式时才设置
                            dataCell = FS_Cell_Maps.get(getReportsAlign(j) + "_col");
                        }
                    }
                }
                if (isNumeric(o) && o.length() < 11 && (o.indexOf("0") != 0 || (o.indexOf("0") == 0 && new Double(o) < 1))) {
                    sheet.addCell(new Number(j + 1, rows, new Double(o), dataCell));
                } else {
                    sheet.addCell(new Label(j + 1, rows, o, dataCell));
                }
            }
            // 孖拖-多点装的单子添加行高
            if (data.getIsDoubleCon() == 2
                    || data.getFactoryShortName().indexOf("<br>") != -1) {
                sheet.setRowView(rows++, 600);
            } else if ("".equals(data.getTogetherId())) {
                sheet.setRowView(rows++, 600);
            } else {
                sheet.setRowView(rows++, 400);
            }
        }
        return rows;
    }

    private String getReportsAlign(int j) {
        if (reports != null && reports.length > j && FS_Cell_Maps.containsKey(reports[j].getAlign())) {
            return reports[j].getAlign();
        }
        return "center";
    }

    // 添加费用总计
    public int addTotal(ReportFeeSearch search, List<Object> totals, int rows) throws Exception {
        return addTotal(search, new ArrayList<Object>(), totals, rows);
    }

    // 添加费用总计
    public int addTotal(ReportFeeSearch search, List<Object> beforeTotals, List<Object> totals, int rows) throws Exception {
        int index = search.getColspan() + 1;
        sheet.addCell(new Label(0, rows, "合计:", right()));
        sheet.mergeCells(0, rows, search.getColspan(), rows);

        int isExcelFormula = search.getIsExcelFormula();// 是否使用公式
        int beginRows = search.getExcelBeginRows();// 累加的开始行
        // 添加费用之前的数据
        for (Object o : beforeTotals) {
            CellFormat dataCell = FS_Cell_Maps.get(getReportsAlign(index - 1));
            if ("".equals(o.toString())) {
                if (isExcelFormula == 1) {
                    sheet.addCell(new Formula(index, rows, sumFormula(index, beginRows, rows), right()));
                    index++;
                } else {
                    sheet.addCell(new Number(index++, rows, new Double(o.toString()), dataCell));
                }
            } else {
                sheet.addCell(new Label(index++, rows, o.toString(), dataCell));
            }
        }

        // 添加应收费用合计
        List<IncomeFee> incomeFees = search.getIncomeFee();
        for (IncomeFee fee : incomeFees) {
            if (isExcelFormula == 1) {
                sheet.addCell(new Formula(index, rows, sumFormula(index, beginRows, rows), right()));
                index++;
            } else {
                sheet.addCell(new Number(index++, rows, fee.getMoney(), right()));
            }
        }

        // 添加应付费用合计
        List<PayoutFee> payoutFees = search.getPayoutFee();
        for (PayoutFee fee : payoutFees) {
            if (isExcelFormula == 1) {
                sheet.addCell(new Formula(index, rows, sumFormula(index, beginRows, rows), right()));
                index++;
            } else {
                sheet.addCell(new Number(index++, rows, fee.getMoney(), right()));
            }
        }

        // 添加费用小计合计
        for (Object o : totals) {
            if ("".equals(o.toString())) {
                if (isExcelFormula == 1) {
                    sheet.addCell(new Formula(index, rows, sumFormula(index, beginRows, rows), right()));
                    index++;
                } else {
                    sheet.addCell(new Number(index++, rows, new Double(o.toString()), right()));
                }
            } else {
                sheet.addCell(new Label(index++, rows, o.toString(), right()));
            }
        }
        sheet.setRowView(rows++, 400);
        return rows;
    }

    /**
     * 添加费用总计计算公式(从开始行累加到此单元格行数的上一行)
     *
     * @param search    查询条件
     * @param totals    合计数组
     * @param rows      行数
     * @param beginRows 开始合计行
     * @return
     * @throws Exception
     */
    public int addTotalFormula(ReportFeeSearch search, List<Object> totals, int rows, int beginRows) throws Exception {
        int index = search.getColspan() + 1;
        sheet.addCell(new Label(0, rows, "合计:", right()));
        sheet.mergeCells(0, rows, search.getColspan(), rows);

        // 添加应收费用合计
        List<IncomeFee> incomeFees = search.getIncomeFee();
        for (int i = 0; i < incomeFees.size(); i++) {
            sheet.addCell(new Formula(index, rows, sumFormula(index, beginRows, rows), right()));
            index++;
        }

        // 添加应付费用合计
        List<PayoutFee> payoutFees = search.getPayoutFee();
        for (int i = 0; i < payoutFees.size(); i++) {
            sheet.addCell(new Formula(index, rows, sumFormula(index, beginRows, rows), right()));
            index++;
        }

        // 添加费用小计合计
        for (Object o : totals) {
            if ("".equals(o.toString())) {
                sheet.addCell(new Formula(index, rows, sumFormula(index, beginRows, rows), right()));
                index++;
            } else {
                sheet.addCell(new Label(index++, rows, o.toString(), right()));
            }
        }
        sheet.setRowView(rows++, 400);
        return rows;
    }


    // 添加费用总计
    public int addTotal(ReportFeeSearch search, List<Object> beforeTotals, List<Object> totals, int rows, int beginRows) throws Exception {
        int index = search.getColspan() + 1;
        sheet.addCell(new Label(0, rows, "合计:", right()));
        sheet.mergeCells(0, rows, search.getColspan(), rows);

        // 添加费用之前的数据
        for (Object o : beforeTotals) {
            CellFormat dataCell = FS_Cell_Maps.get(getReportsAlign(index - 1));
            if ("".equals(o.toString())) {
                sheet.addCell(new Number(index++, rows, new Double(o.toString()), dataCell));
            } else {
                sheet.addCell(new Label(index++, rows, o.toString(), dataCell));
            }
        }

        // 添加应收费用合计
        List<IncomeFee> incomeFees = search.getIncomeFee();
        for (IncomeFee fee : incomeFees) {
            sheet.addCell(new Number(index++, rows, fee.getMoney(), right()));
        }

        // 添加应付费用合计
        List<PayoutFee> payoutFees = search.getPayoutFee();
        for (PayoutFee fee : payoutFees) {
            sheet.addCell(new Number(index++, rows, fee.getMoney(), right()));
        }

        // 添加费用小计合计
        for (Object o : totals) {
            if ("".equals(o.toString())) {
                sheet.addCell(new Number(index++, rows, new Double(o.toString()), right()));
            } else {
                sheet.addCell(new Label(index++, rows, o.toString(), right()));
            }
        }
        sheet.setRowView(rows++, 400);
        return rows;
    }

    /**
     * 获取计算公式
     *
     * @param cols
     * @param endRows
     * @param beginRow
     * @return
     */
    public String sumFormula(int cols, int beginRow, int endRows) {
        String colsLetter = getExcelColumnLabel(cols);
        return "SUM(" + colsLetter + beginRow + ":" + colsLetter + endRows + ")";
    }

    /**
     * 获取列对应的字母
     *
     * @param num 第几列(从0开始)
     * @return
     */
    public String getExcelColumnLabel(int num) {
        String temp = "";
        double i = Math.floor(Math.log(25.0 * (num) / 26.0 + 1) / Math.log(26)) + 1;
        if (i > 1) {
            double sub = num - 26 * (Math.pow(26, i - 1) - 1) / 25;
            for (double j = i; j > 0; j--) {
                temp = temp + (char) (sub / Math.pow(26, j - 1) + 65);
                sub = sub % Math.pow(26, j - 1);
            }
        } else {
            temp = temp + (char) (num + 65);
        }
        return temp;
    }

    // 添加合计列
    public int addCommonTotal(int beforeCoslpan, int endCoslpan, List<Object> totals, int rows) throws Exception {
        sheet.addCell(new Label(0, rows, "合计:", right()));
        sheet.mergeCells(0, rows, beforeCoslpan, rows);

        // 添加数据
        beforeCoslpan++;
        for (Object o : totals) {
            if ("".equals(o.toString())) {
                sheet.addCell(new Number(beforeCoslpan++, rows, new Double(o.toString()), right()));
            } else {
                sheet.addCell(new Label(beforeCoslpan++, rows, o.toString(), right()));
            }
        }

        // 添加费用后合并列
        if (endCoslpan > 0) {
            sheet.addCell(new Label(beforeCoslpan, rows, "", right()));
            sheet.mergeCells(beforeCoslpan, rows, beforeCoslpan + endCoslpan, rows);
        }
        sheet.setRowView(rows++, 400);
        return rows;
    }

    // 创建表格样式
    public CellFormat createCellFormat(Alignment alignment, int font,
                                       boolean border, boolean bold, boolean col, Object... isCol) throws Exception {
        WritableFont writableFont;
        if (bold) {
            writableFont = bold_Font(font);
        } else {
            if (isCol.length > 0 && isCol[0].toString().equals("1")) {//是否字体要标识颜色
                writableFont = no_Bold_Font_Colour(font);
            } else {
                writableFont = no_Bold_Font(font);
            }
        }
        WritableCellFormat cellFormat = new WritableCellFormat(writableFont);
        cellFormat.setWrap(true);
        cellFormat.setAlignment(alignment);
        cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
        if (border) {
            cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
        }
        return cellFormat;
    }

    private WritableFont bold_Font(int font) {
        return new WritableFont(WritableFont.createFont("宋体"), font,
                WritableFont.BOLD, false);
    }

    private WritableFont no_Bold_Font(int font) {
        return new WritableFont(WritableFont.createFont("宋体"), font,
                WritableFont.NO_BOLD, false);
    }

    private WritableFont no_Bold_Font_Colour(int font) {
        return new WritableFont(WritableFont.createFont("宋体"), font,
                WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.RED);
    }

    // 设置工作表纸张
    public void setPageSetup() {
        // 设置纸张
        PageOrientation page = PageOrientation.LANDSCAPE;
        sheet.setPageSetup(page, PaperSize.A4, 0.5d, 0.5d);

        // 设置页边距
        sheet.getSettings().setTopMargin(0.2d);
        sheet.getSettings().setBottomMargin(0.2d);
        sheet.getSettings().setLeftMargin(0.2d);
        sheet.getSettings().setRightMargin(0.2d);
        sheet.getSettings().setHeaderMargin(0);
        sheet.getSettings().setFooterMargin(0);
    }

    // 报表抬头样式
    public CellFormat head(int fontSize, Alignment alignment, boolean bold)
            throws Exception {
        return createCellFormat(alignment, fontSize, false, bold, false);
    }

    // 报表内容样式
    public CellFormat data(Alignment alignment, int fontSize, boolean bold, Object... isCol)
            throws Exception {
        return createCellFormat(alignment, fontSize, true, bold, false, isCol);
    }

    // 获取居中样式
    public CellFormat center() {
        return FS_Cell_Maps.get("center");
    }

    // 获取居左样式
    public CellFormat left() {
        return FS_Cell_Maps.get("left");
    }

    // 获取居右样式
    public CellFormat right() {
        return FS_Cell_Maps.get("right");
    }

    // 处理自定义报表导出excel中的换行符号
    public String toString(Object param) {
        if (param == null) {
            return "";
        }
        return param.toString().replace("<br>", "\r\n");
    }

    // 判断传入字符串是否是数字
    public boolean isNumeric(String $) {
        Pattern pattern = Pattern.compile("-?\\d+\\.?\\d*");
        return pattern.matcher($).matches();
    }

    // 根据字段名称、excel长度返回对象
    public ReportSetup getReport(String fieldsName, int excelWidth) {
        return getReport(fieldsName, excelWidth, "");
    }

    // 根据字段名称、excel长度、对齐样式返回对象
    public ReportSetup getReport(String fieldsName, int excelWidth, String align) {
        ReportSetup report = new ReportSetup();
        report.setExcelWidth(excelWidth);
        report.setFieldsName(fieldsName);
        if ("".equals(align)) {
            report.setAlign(align);
        } else {
            report.setAlign("center");
        }
        return report;
    }

    /**
     * 导出Excel后动态插入图片
     *
     * @param filePath 已生成的excel文件
     * @param image    需插入的图片地址
     * @throws Exception
     */
    public static void createPicture(String filePath, String image,
                                     Object... anchorArray) throws Exception {
        if ("".equals(filePath) || "".equals(image)) {
            throw new Exception("文件地址,公司logo不能为空.");
        }
        ByteArrayOutputStream baos = null;
        FileOutputStream fos = null;
        try {
            // 设置图片地址
            int endIndex = filePath.indexOf("excelfile");
            String imagePath = filePath.substring(0, endIndex);
            imagePath = imagePath + "image/logo/" + image;

            // 设置需要插入的图片
            baos = new ByteArrayOutputStream();
            ImageIO.write(ImageIO.read(new File(imagePath)),
                    imagePath.substring(imagePath.lastIndexOf(".") + 1), baos);

            // 创建工作薄
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
                    filePath));
            HSSFSheet hssfSheet = workbook.getSheetAt(0);

            // 设置插入图片的显示位置
            int dx1 = 0, dy1 = 10, dx2 = 0, dy2 = 10, col1 = 4, col2 = 5;
            if (anchorArray.length > 0) {
                dx1 = (Integer) anchorArray[0];
                if (anchorArray.length > 1) {
                    dy1 = (Integer) anchorArray[1];
                }
                if (anchorArray.length > 2) {
                    dx2 = (Integer) anchorArray[2];
                }
                if (anchorArray.length > 3) {
                    dy2 = (Integer) anchorArray[3];
                }
                if (anchorArray.length > 4) {
                    col1 = (Integer) anchorArray[4];
                }
                if (anchorArray.length > 5) {
                    col2 = (Integer) anchorArray[5];
                }
            }

            // 插入图片
            HSSFClientAnchor anchor = new HSSFClientAnchor(dx1, dy1, dx2, dy2,
                    (short) col1, 0, (short) col2, 3);
            HSSFPatriarch patriarch = hssfSheet.createDrawingPatriarch();
            patriarch.createPicture(anchor, workbook.addPicture(
                    baos.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
            fos = new FileOutputStream(filePath);
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                baos.flush();
                baos.close();
            }
            if (fos != null) {
                fos.flush();
                fos.close();
            }
        }
    }

}
