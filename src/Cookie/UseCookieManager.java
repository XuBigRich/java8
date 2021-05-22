package Cookie;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;

/**
 * @Author： hongzhi.xu
 * @Date: 2021/1/17 上午8:47
 * @Version 1.0
 */
public class UseCookieManager {
    static Map<String, List<String>> requestHeaders = new HashMap<String, List<String>>(16);
    final static CookieManager manager = new CookieManager();
    static URI url;

    static {
        try {
            url = new URI("Http://localhost.:8080/login");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public void testGetCookie() throws URISyntaxException {
        CookieStore cookieStore = manager.getCookieStore();
        List<HttpCookie> httpCookies = cookieStore.get(url);
        httpCookies.forEach(e -> {
            System.out.println(e);
        });
        httpCookies = cookieStore.get(new URI("Http://localhost:8080/wdwt"));
        httpCookies.forEach(e -> {
            System.out.println(e);
        });
    }

    // 发送请求并获取Cookie 将其保存给 CookieManager来管理cookie。
    // 你只管发送请求保存cookie的任务CookieManager会自动保存
    public void testSaveCookie1() throws URISyntaxException, IOException {
        HttpURLConnection conn = (HttpURLConnection) url.toURL().openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ReqUser reqUser = new ReqUser("root", "root");
        String pro = reqUser.toString();
        byte[] bytes = pro.getBytes();
        conn.setDoOutput(true);
        conn.getOutputStream().write(bytes);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = null;
        while ((line = br.readLine()) != null) {
//            System.out.println(line);
        }
        br.close();
        conn.disconnect();
    }

    // 发送请求并获取Cookie 将其保存给 CookieManager来管理cookie。
    //这一步是 关键
    public void testSaveCookie2() throws URISyntaxException, IOException {
        URI urli = new URI("Http://localhost:8080/wdwt");
        HttpURLConnection conn = (HttpURLConnection) urli.toURL().openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        //关键 从CookieManager中取出存储的cookie 发送给新的URI
//        conn.setRequestProperty("Cookie", manager.getCookieStore().get(url).get(0).getName() + ":" + manager.getCookieStore().get(url).get(0).getValue() + ";");
        Map<String, List<String>> requestHeaders = new HashMap<>();
        conn.setRequestProperty("Cookie", manager.get(url, requestHeaders).get("Cookie").get(0));
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = null;
        while ((line = br.readLine()) != null) {
//            System.out.println(line);
        }
        br.close();
        conn.disconnect();
    }

    public static void main(String[] args) throws Exception {
        UseCookieManager test = new UseCookieManager();
        // 创建默认的CookieManager
        // 保存这个定制的CookieManager
        // 创建一个 CookieManager对象 接收所有的Cookie
        manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        // 保存这个定制的CookieManager
        CookieHandler.setDefault(manager);
        test.testSaveCookie1();

        test.testGetCookie();
        // 进行下一步操作时将cookies携带着    这一步是 关键
        test.testSaveCookie2();

        test.testGetCookie();
    }
}
