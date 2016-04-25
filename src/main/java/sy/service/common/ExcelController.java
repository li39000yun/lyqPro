package sy.service.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.PageOrientation;
import jxl.format.PaperSize;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * excel控制器
 * 
 * @author liyunqiang
 * 
 * @Date 2016-2-14
 */
public class ExcelController {

	public static void main(String[] args) throws Exception {
		List<List<Object>> b = new ArrayList<List<Object>>();
		List<Object> a = new ArrayList<Object>();
		a.add("aa");
		a.add("bb");
		a.add("cc");
		b.add(a);
		a = new ArrayList<Object>();
		a.add("aa1");
		a.add("bb1");
		a.add("cc1");
		b.add(a);
		ExcelController e = new ExcelController();
		e.exportExcel(b);
	}

	public void exportExcel(List<List<Object>> datas) throws Exception {
		if (datas.size() == 0) {
			return;
		}
		String path = "C:\\Users\\lyq\\Desktop\\zcd.xls";
		File file = new File(path);
		WritableWorkbook wb = Workbook.createWorkbook(file);
		WritableSheet sheet = wb.createSheet("Data ", 0);
		sheet.setPageSetup(PageOrientation.LANDSCAPE, PaperSize.A4, 0.5d, 0.5d);

		// 设置表头宽度
		for (int i = 0; i < datas.get(0).size(); i++) {
			sheet.setColumnView(i, 10);
		}

		// 设置居中样式
		WritableCellFormat center = new WritableCellFormat(new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD, false));
		center.setBorder(Border.ALL, BorderLineStyle.THIN);
		center.setAlignment(Alignment.CENTRE);
		center.setVerticalAlignment(VerticalAlignment.CENTRE);
		center.setWrap(true);

		// 设置居左样式
		WritableCellFormat left = new WritableCellFormat(new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD, false));
		left.setBorder(Border.ALL, BorderLineStyle.THIN);
		left.setAlignment(Alignment.LEFT);
		left.setVerticalAlignment(VerticalAlignment.CENTRE);
		left.setWrap(true);

		// 设置居右样式
		WritableCellFormat right = new WritableCellFormat(new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD, false));
		right.setBorder(Border.ALL, BorderLineStyle.THIN);
		right.setAlignment(Alignment.RIGHT);
		right.setVerticalAlignment(VerticalAlignment.CENTRE);
		right.setWrap(true);

		// 设置表格标头
		int len = 0;
		int rows = 0;
		for (List<Object> data : datas) {
			len = 0;
			for (Object o : data) {
				if (o.toString().matches("\\d+\\.?\\d*")) {
					sheet.addCell(new jxl.write.Number(len, rows, new Double(o.toString()), right));
				} else {
					sheet.addCell(new Label(len, rows, o.toString(), right));
				}
				len++;
			}
			sheet.setRowView(rows, 400);
			rows++;
		}
		wb.write();
		wb.close();
	}

}
