package Cookie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Base64;
import java.util.List;

public class CookieManagerDemo {

    //打印cookie信息
    public static void printCookie(CookieStore cookieStore) {
        List<HttpCookie> listCookie = cookieStore.getCookies();
        listCookie.forEach(httpCookie -> {
            System.out.println("--------------------------------------");
            System.out.println("class      : " + httpCookie.getClass());
            System.out.println("comment    : " + httpCookie.getComment());
            System.out.println("commentURL : " + httpCookie.getCommentURL());
            System.out.println("discard    : " + httpCookie.getDiscard());
            System.out.println("domain     : " + httpCookie.getDomain());
            System.out.println("maxAge     : " + httpCookie.getMaxAge());
            System.out.println("name       : " + httpCookie.getName());
            System.out.println("path       : " + httpCookie.getPath());
            System.out.println("portlist   : " + httpCookie.getPortlist());
            System.out.println("secure     : " + httpCookie.getSecure());
            System.out.println("value      : " + httpCookie.getValue());
            System.out.println("version    : " + httpCookie.getVersion());
            System.out.println("httpCookie : " + httpCookie);
        });
    }

    public static void requestURL() throws Exception {
        URL url = new URL("Http://localhost:8080/login");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
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
    }

    public static void main(String[] args) throws Exception {

        CookieManager manager = new CookieManager();
        //设置cookie策略，只接受与你对话服务器的cookie，而不接收Internet上其它服务器发送的cookie
        manager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
        CookieHandler.setDefault(manager);

        printCookie(manager.getCookieStore());
        //第一次请求
        requestURL();

        printCookie(manager.getCookieStore());
        //第二次请求
        requestURL();
    }

}