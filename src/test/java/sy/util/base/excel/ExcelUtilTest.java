package sy.util.base.excel;

import org.junit.Test;
import sy.model.account.Daily;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/6/5.
 */
public class ExcelUtilTest {

   // @Test
    public void export2Excel() throws Exception {
        ExcelUtil.ExportSetInfo exportSetInfo = new ExcelUtil.ExportSetInfo();
        exportSetInfo.setTitles(new String[]{"测试标题"});
        List<String[]> headNames = new ArrayList<String[]>();
        headNames.add(new String[]{"主键", "金额"});
        List<String[]> fieldNames = new ArrayList<String[]>();
        fieldNames.add(new String[]{"id", "money"});
        LinkedHashMap<String, List> objsMap = new LinkedHashMap<String, List>();
        List<Daily> dailys = new ArrayList<Daily>();
        Daily daily = new Daily();
        daily.setId("1");
        daily.setMoney(400.0);
        dailys.add(daily);
        daily = new Daily();
        daily.setId("2");
        daily.setMoney(300.0);
        dailys.add(daily);
        objsMap.put("日记账", dailys);

        exportSetInfo.setHeadNames(headNames);
        exportSetInfo.setFieldNames(fieldNames);
        exportSetInfo.setObjsMap(objsMap);
        exportSetInfo.setOut(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\t1.xls"));
        ExcelUtil.export2Excel(exportSetInfo);
    }
}