package io.getImageType;

import com.sun.imageio.plugins.gif.GIFImageReader;
import com.sun.imageio.plugins.jpeg.JPEGImageReader;
import com.sun.imageio.plugins.png.PNGImageReader;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.MemoryCacheImageInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * 读取二进制获取图片类型
 *
 * @author 许鸿志
 * @since 2022/5/24
 */
public class GetFileType {

    public static String base64 = "data:image/jpeg;base64,/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAAA8AAD/4QOIaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA1LjYtYzE0MiA3OS4xNjA5MjQsIDIwMTcvMDcvMTMtMDE6MDY6MzkgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcE1NPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvbW0vIiB4bWxuczpzdFJlZj0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL3NUeXBlL1Jlc291cmNlUmVmIyIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bXBNTTpPcmlnaW5hbERvY3VtZW50SUQ9InhtcC5kaWQ6NWYyNGJhMWQtZjYwYi0xNDRiLTk3ZTMtYjI0NjM2NGFiYTkxIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkJGRTEzRDFCQTRCNzExRUE4RThFRUNDRjcwQzI3QjU0IiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkJGRTEzRDFBQTRCNzExRUE4RThFRUNDRjcwQzI3QjU0IiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBob3Rvc2hvcCBDQyAoV2luZG93cykiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo4ZmYwMmQzOS1iM2QzLTIxNDctOTM3OC02NWU5MzhiYjlmYTYiIHN0UmVmOmRvY3VtZW50SUQ9ImFkb2JlOmRvY2lkOnBob3Rvc2hvcDoxYjkxZTQ4Yy1mZDYxLWQxNDItODZmZC02ZDcxNDNlYTZhMTciLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7/7gAOQWRvYmUAZMAAAAAB/9sAhAAGBAQEBQQGBQUGCQYFBgkLCAYGCAsMCgoLCgoMEAwMDAwMDBAMDg8QDw4MExMUFBMTHBsbGxwfHx8fHx8fHx8fAQcHBw0MDRgQEBgaFREVGh8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx//wAARCAEGAL4DAREAAhEBAxEB/8QAtgAAAgMAAwEAAAAAAAAAAAAABQYDBAcBAggAAQACAwEBAQAAAAAAAAAAAAACAwABBAUGBxAAAgEDAwIDBQUEBwUGBQUAAQIDEQQFABIGIRMxQSJRYTIUB3GBQiMVkVIzFqGx0WJyJAjBgqJDU/DhsnM0F/GSRFQlwmODkyYRAAICAQMCAwUIAgEDBAMAAAABEQIDITESQQRRYSJxgZETBfChscHR4TJCUhQG8WIjcoKi0jNDFf/aAAwDAQACEQMRAD8A8+BjrKeiOTXVEOKHVyQ+FdUWHeHcTv8AlOetsTaloxO+2S62M6RAgkM+3wB200rNmWOssG9uKkOZ36Q8pw+CGUljaZlef5i2iQt2reABvmGkUsmxlYH/AOB0mneUtaAK5U3AFwPB+QZu3hvLK37llLdixMivEH72wSlUjd42du3VgB40Om5M9auHvEh2ukEOS/TPNYSS9kN1Z3GNtlL21+LiFFulDBW+XRn3OyMaMo8wQK9Kji7qto3n8Aa5ExP660jIOyo7sFQFmY0CjqSdUQd+b/SrL8W4/iMtMXk+cSmRj2/+mnarpGaeRTp/iB92sPafUsWfJelHrjcP9V79AU316iN11vkIe1+lGYP04PLqP3+7vFjt6my+Ez/vV39afuerWD/+li/2f9efXxn9vbGvsBnr0EXrrfIQ8cF+lmW5XgsvlIS0Qs46Y5Kf+puR6mjBPls6V/eK+/XP7z6li7e9KXeuRwv1fvhAtvp0Eh0kjdkdSrqaMrChBHkQddAIbPprwG65lnTZdx7ewgjaW8vFXdsFKIor0LM5HT2VPlrF9Q7/AB9rieS+34lOdluL2bw+Qw2VusXfxmK7tJGikU+BKmm5T5q3iD5jWql1aqsnKZE5J+L8dyHI87Z4exUma6kCs9CVjTxeRv7qLUnQ5s1cdHezitVLI9Al9QeFXXEeST4xy8toQJbG6cU7sLeBNOm5SCre8aR2XeU7nFXLTa33eRF4PcWuutZZ8a6hD7rqFn2qIcAaso76hDjUIfU1CzUfoHKttyO7vZ7KGWysoknuL+S378lvRiirCwI7by76VAJ6eHmOV9VfoST1fSd/+gnNsaNbzNd7eI32MuBa3QyWKbPPJGk7XMtZriNbc9D8EbRlmqyL9o1zrXhfMVlK424+Wy1/HzEx1FjhuZTjuNigx0E7x3HLbg2VpCkjSyWkFv2mPZb81lQyJu86injXWruFzerWmJT7W/";

    public static void getImgType() throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        //若想正确的获得执行这些方法base64一定要去掉消息头 如：data:image/jpeg;base64
        base64 = base64.replace("data:image/jpeg;base64,", "");
        //将base64转换成二进制
        byte[] bytes = decoder.decodeBuffer(base64);
        //将二进制加载到内存当中
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        String end = "";
        //取出前32个（比特/位/bit） 4个字节 的数据  1个字节 = FF
        byte[] b = new byte[4];
        bis.read(b, 0, b.length);
        //将二进制映射成为16进制字符串
        String type = byteArrayToHexString(b).toUpperCase();
        //判断映射成的字符串所包含的图片 类型信息
        if (type.contains("FFD8FF")) {
            end = "jpg";
        } else if (type.contains("89504E47")) {
            end = "png";
        } else if (type.contains("47494638")) {
            end = "gif";
        } else if (type.contains("424D")) {
            end = "bmp";
        }
    }

    // 十六进制下数字到字符的映射数组
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    //遍历每个字节
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        //转成 int类型
        int n = b;
        if (n < 0) {
            //取模  （+256是因为 256是一模）
            n = 256 + n;
        }
        //找到所映射的 16进制字符
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }


    //通过图片流的形式获取图片类型  图片流与普通流并列 不相关
    public static void getImgTypeBySteam() throws IOException {
        base64 = base64.replace("data:image/jpeg;base64,", "");
        BASE64Decoder decoder = new BASE64Decoder();
        //将base64转换成二进制
        byte[] bytes = decoder.decodeBuffer(base64);
        //将图片以二进制的形式存储在流中
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        //包装成图片流
        MemoryCacheImageInputStream iis = new MemoryCacheImageInputStream(bis);
        String type = "";
        //读取图片流
        Iterator itr = ImageIO.getImageReaders(iis);
        //遍历图片流
        while (itr.hasNext()) {
            ImageReader reader = (ImageReader) itr.next();
            if (reader instanceof GIFImageReader) {
                type = "image/gif";
            } else if (reader instanceof JPEGImageReader) {
                type = "image/jpeg";
            } else if (reader instanceof PNGImageReader) {
                type = "image/png";
            } else {
                try {
                    throw new Exception("未知的图片类型");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
