package com.lyq.fetch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;

/**
 * 抓取天津物流信息网
 * Created by lyq on 2016/5/6.
 */
public class FecthTjportnet {

    @Test
    public void fetch() throws IOException {
//        String loginUrl = "http://wl.tjportnet.com/cas/login?service=http%3A%2F%2Fwl.tjportnet.com%2Fj_spring_cas_security_check%3Bjsessionid%3DgYJQXwyMSKQpsdJZBfBDnHCyLVrqhxCvRndnjchkvfL4rh05TBpp%21-1704326175%211462774041278";
        String loginUrl = "http://wl.tjportnet.com";
        Document document = Jsoup.connect(loginUrl).timeout(5000).get();
        loginUrl = "http://wl.tjportnet.com/navi/login.jsp";
        document = Jsoup.connect(loginUrl).timeout(5000).get();
        System.out.println(document.html());

    }

}
