package com.lyq.fetch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import sy.service.common.ExcelController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyq on 2016/5/9.
 */
public class FetchHaiGuan {
    @Test
    public void fetchKouAn() throws Exception {
        String url = "http://query.customs.gov.cn/MNFTQ/MQuery.aspx";

        Document document = Jsoup.connect(url).timeout(10000).get();
        Elements elements = document.select("select[name=MQueryCtrl1$ddlCustomCode]");
        List<List<Object>> datas = new ArrayList<List<Object>>();

//        INSERT INTO `global_variables` (`value`, `name`, `type`) VALUES ('9700', '西宁关区', '4');

        StringBuffer sb = new StringBuffer("INSERT INTO `global_variables` (`id`, `value`, `name`, `type`) VALUES ");
        if (elements.size() == 1) {
            Element element = elements.get(0);
            int i = 1;
            for (Element element1 : element.children()) {
                List<Object> data = new ArrayList<Object>();
                System.out.println(i++ + ":" + element1.text());
                if (element1.text().split(" ").length == 2) {
                    data.add(element1.text().split(" ")[0] + "#");
                    data.add(element1.text().split(" ")[1]);
                    sb.append("('4").append(element1.text().split(" ")[0]).append("', '");
                    sb.append(element1.text().split(" ")[0]).append("', '");
                    sb.append(element1.text().split(" ")[1]).append("', '4'),");
                }
                datas.add(data);
            }
            sb.replace(sb.length()-1, sb.length(), ";");
        }
        System.out.println("sql：" + sb.toString());
        ExcelController excelController = new ExcelController();
        excelController.exportExcel(datas);
    }
}
