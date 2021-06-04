package headlessMode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TestCHSGraphic {

    public static void main(String[] args) throws Exception {
        //设置Headless模式
        System.setProperty("java.awt.headless", "false");
        //拿到默认工具包，通过工具包的方法把硬盘上的图片拿到内存中来
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Map<String, Image> map = new HashMap<String, Image>();
        String path = TestCHSGraphic.class.getClassLoader().getResource("test.jpg").getPath();
        System.out.println(path);
        Image exploreImage = toolkit.getImage(TestCHSGraphic.class.getClassLoader().getResource("test.jpg"));
        map.put("1", exploreImage);

        BufferedImage bi = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        String s = "Headless模式测试";
        g.drawString(new String(s.getBytes(), "utf-8"), 50, 50);
        ImageIO.write(bi, "jpeg", new File("test.jpg"));
    }

}