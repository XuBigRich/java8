package qianming;

import java.util.HashMap;
import java.util.Map;

/**
 * http请求
 */
public class BKQApi {
    public static void main(String[] args) {
        String appkey = "czYMYYeRGrfFsmY";
        String secret = "fREcEFP4G9WUQFDuqe8mitSvuwMAWX2H";
        // 加签
        Long timestamp = System.currentTimeMillis() / 1000;
        System.out.println(timestamp);
        HashMap<String, String> params = new HashMap();
        params.put("idfa", "a1a8ea8e368db312");
        String sign = BKQApi.getSign(appkey, secret, timestamp, params, "GET");
        System.out.println(sign);
        // 验签
        System.out.println(BKQApi.verifySign(appkey, secret, timestamp, params, "GET", sign));
    }


    /**
     *
     * @param appKey appkey
     * @param appSecret secret
     * @param timeStamp 时间戳
     * @param params 请求参数
     * @param requestMethod GET/POST
     * @return
     */
    public static String getSign(String appKey, String appSecret, Long timeStamp, Map<String, String> params, String requestMethod) {
        HashMap<String, String> paramsMap = new HashMap();
        if (params != null) {
            paramsMap.putAll(params);
        }
        paramsMap.put("app_key", appKey);
        paramsMap.put("time_stamp", timeStamp.toString());
        paramsMap.remove("sign");
        SignHelper.codePayValue(paramsMap);
        try {
            return SignHelper.makeSign(requestMethod, paramsMap, appSecret);
        } catch (Exception e) {
            System.out.println("加签失败");
        }
        return null;
    }

    /**
     *
     * @param appKey appkey
     * @param appSecret secret
     * @param timeStamp 时间戳
     * @param params 请求参数
     * @param requestMethod GET/POST
     *  @param sign 签名
     * @return
     */
    public static boolean verifySign(String appKey, String appSecret, Long timeStamp, Map<String, String> params, String requestMethod, String sign) {
        HashMap<String, String> paramsMap =new HashMap();
        if (params != null) {
            paramsMap.putAll(params);
        }
        paramsMap.put("app_key", appKey);
        paramsMap.put("time_stamp", timeStamp.toString());
        try {
            return SignHelper.verifySign(requestMethod, paramsMap, appSecret, sign);
        } catch (Exception e) {
            System.out.println("加签失败");
        }
        return false;
    }

}
