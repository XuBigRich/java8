package headlessMode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * 运行时入参:
 * [create/read,true/false]
 */
public class TestCHSGraphic {
    /**
     * 读取图片有两种方式
     * 有时可能会用到显示器，有时候用不到显示器。
     * 所以如果用到显示器时，那么将配置参数设置为false。
     * 如果用不到显示器，那么配置参宿和设置为true
     *
     * @param arg
     */
    public static void readImg(String arg) {
        //设置Headless模式
        System.setProperty("java.awt.headless", arg);
        //拿到默认工具包，通过工具包的方法把硬盘上的图片拿到内存中来
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Map<String, Image> map = new HashMap<String, Image>();
        String path = TestCHSGraphic.class.getClassLoader().getResource("test.jpg").getPath();
        System.out.println(path);
        Image exploreImage = toolkit.getImage(TestCHSGraphic.class.getClassLoader().getResource("test.jpg"));
        map.put("1", exploreImage);
        System.out.println(exploreImage);
    }

    public static void createImg() throws Exception {
        BufferedImage bi = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        String s = "Headless模式测试";
        g.drawString(new String(s.getBytes(), "utf-8"), 50, 50);
        ImageIO.write(bi, "jpeg", new File("test.jpg"));
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            args = new String[]{"read","false"};
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