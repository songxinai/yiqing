package servlet;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

 
public class paquc {

    public static void main(String args[]) {
        // TODO Auto-generated method stub
        String sheng="";
        String xinzeng="";
        String leiji="";
        String zhiyu="";
        String siwang="";
         String url = "https://wp.m.163.com/163/page/news/virus_report/index.html?_nw_=1&_anw_=1";
        
        int i=0;
        
        try {
            //构造一个webClient 模拟Chrome 浏览器
            WebClient webClient = new WebClient(BrowserVersion.CHROME);
            //支持JavaScript
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setActiveXNative(false);
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            webClient.getOptions().setTimeout(8000);
            HtmlPage rootPage = webClient.getPage(url);
            //设置一个运行JavaScript的时间
            webClient.waitForBackgroundJavaScript(6000);
            String html = rootPage.asXml();
            Document doc = Jsoup.parse(html);
            //System.out.println(doc);
            Element listdiv11 = doc.getElementById("world_block");
            Elements listdiv22 =listdiv11.select(".chart_table_nation");
            for(Element s:listdiv22) 
            {
                Elements real_name=s.select(".chart_table_name");
                Elements real_newconfirm=s.select(".chart_table_today_confirm");
                Elements real_confirm=s.select(".chart_table_confirm");
                Elements real_dead=s.select(".chart_table_dead");
                Elements real_heal=s.select(".chart_table_heal");
                sheng=real_name.text();
                xinzeng=real_newconfirm.text();
                leiji=real_confirm.text();
                zhiyu=real_heal.text();
                siwang=real_dead.text();
                //System.out.println(sheng+" 新增确诊:"+xinzeng+" 累计确诊:"+leiji+" 累计治愈:"+zhiyu+" 累计死亡:"+siwang);
                Date currentTime=new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String time = formatter.format(currentTime);//获取当前时间
                AddService1 dao=new AddService1();
                dao.add("info1", sheng, xinzeng, leiji, zhiyu, siwang,time);//将爬取到的数据添加至数据库
            }
            
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("爬取失败");
        }
    }
    
}