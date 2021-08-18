package headlessMode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 若想体验非无头模式，，运行请在linux下查看错误
 * <p>
 * <p>
 * 运行时入参:
 * [create/read,true/false]
 */
public class TestCHSGraphic {
    public static String projectPath = System.getProperty("user.dir");

    /**
     * 读取图片有两种方式
     * 有时可能会用到显示器，有时候用不到显示器。
     * 所以如果用到显示器时，那么将配置参数设置为false。
     * 如果用不到显示器，那么配置参宿和设置为true
     *
     * @param arg
     */
    public static void readImg(String arg) throws MalformedURLException {
        //设置Headless模式
        System.setProperty("java.awt.headless", arg);
//        //拿到默认工具包，通过工具包的方法把硬盘上的图片拿到内存中来
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Map<String, Image> map = new HashMap<String, Image>();
        Image exploreImage = toolkit.getImage(new URL("file://" + projectPath + "/test.jpg"));
        map.put("1", exploreImage);
        System.out.println(exploreImage);
    }

    public static void createImg() throws Exception {
        //可以理解为生成一个宽度为200高度为100的画布
        BufferedImage bi = new BufferedImage(500, 300, BufferedImage.TYPE_INT_RGB);
        //获取画布上生成资源的接口
        Graphics g = bi.getGraphics();
        String s = "Headless模式测试";
        g.setColor(Color.WHITE);
        //设置水印文字颜色
        g.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        //设置要写资源的位置与内容
        g.drawString(new String(s.getBytes(), "utf-8"), 100, 50);

        g.setColor(Color.RED);
        //设置水印文字颜色
        g.setFont(new Font("宋体", Font.PLAIN, 10));
        String n = "继续添加资源内容";
        g.drawString(new String(n.getBytes(), "utf-8"), 10, 50);

        //将画布写入到test文件中保存后缀为jpeg格式的
        ImageIO.write(bi, "jpeg", new File("test.jpg"));
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            args = new String[]{"create", "false"};
        }
        switch (args[0]) {
            case "create":
                createImg();
                break;
            case "read":
                readImg(args[1]);
                break;
            case "all":
                createImg();
                readImg(args[1]);
        }
    }

}