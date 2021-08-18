package QR;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.FileOutputStream;

import java.net.URL;
import java.util.Hashtable;

import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;

/**
 * 二维码生成类
 * 这个类包含在原有图片上追加 资源、生成二维码 、导出二维码到文件
 *
 * @author LiuXue
 * @since 2021/2/24
 */
public class CreateQRCodeUtil {

    private static final String CHARSET = "utf-8";

    //二维码尺寸
    private static final int QR_CODE_SIZE = 920;

    //logo宽度
//    private static final int WIDTH = 200;
//
//    //logo高度
//    private static final int HEIGHT = 200;

    private static final String backUrl = "background.jpg";

    /**
     * 创建二维码
     *
     * @param content
     * @return
     * @throws Exception
     */
    public static BufferedImage createImage(String content) throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QR_CODE_SIZE, QR_CODE_SIZE, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return image;
    }

    /**
     * 在一张图片上添加二维码
     *
     * @return
     * @throws Exception
     */
    public static BufferedImage addWater(String path, BufferedImage image) throws Exception {
        //读取原图片信息
        File file = new File(path + "background.jpg");
        Image srcImg;
        if (!file.exists()) {
            srcImg = ImageIO.read(new URL(backUrl));
        } else {
            //文件转化为图片
            srcImg = ImageIO.read(file);
        }
        //获取图片的宽
        int srcImgWidth = srcImg.getWidth(null);
        //获取图片的高
        int srcImgHeight = srcImg.getHeight(null);
        //加水印
        BufferedImage bufferedImage = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
        //生成二维码
        // Image image = CreateQRCodeUtil.createImage(content);
        //将小图片绘制到大图片上， 表示图片在大图片上的位置
        graphics2D.drawImage(image, 490, 690, null);
        //设置颜色
        graphics2D.setColor(Color.WHITE);
        graphics2D.dispose();
        return bufferedImage;
    }

    /**
     * 插入logo
     *
     * @param source  二维码图片
     * @param imgPath logo图片地址
     * @throws Exception
     */
    private static void insertImage(BufferedImage source, String imgPath) throws Exception {
        File file = new File(imgPath);
        if (!file.exists()) {
            System.out.println(imgPath + " : 文件不存在");
            return;
        }
        Image src = ImageIO.read(file);
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        if (true) { //压缩logo
            if (width > WIDTH) {
                width = WIDTH;
            }
            if (height > HEIGHT) {
                height = HEIGHT;
            }
            Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics graphics = tag.getGraphics();
            graphics.drawImage(image, 0, 0, null);  //绘制缩小后的图
            graphics.dispose();
            src = image;
        }
        //插入logo
        Graphics2D graphics2D = source.createGraphics();
        int x = (QR_CODE_SIZE - width) / 2;
        int y = (QR_CODE_SIZE - height) / 2;
        graphics2D.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graphics2D.setStroke(new BasicStroke(3f));
        graphics2D.draw(shape);
        graphics2D.dispose();
    }

    /**
     * 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
     *
     * @param destPath 存放目录
     */
    public static void mkdirs(String destPath) {
        File file = new File(destPath);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }

    public static String drawString(String courseId, String title, String path, BufferedImage img) throws Exception {
        BufferedImage image = CreateQRCodeUtil.addWater(path, img);
        Graphics2D graphics2D = image.createGraphics();
        //设置对线段的锯齿状边缘处理
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        //设置水印文字颜色
        graphics2D.setColor(Color.WHITE);
        //设置水印文字颜色
        graphics2D.setFont(new Font("微软雅黑", Font.PLAIN, 62));
        //第一参数 设置的内容， 后面两个参数， 文字在图片上的坐标位置（x,y)
        if (title.length() >= 18) {
            title = title.substring(0, 8) + "...";
        }
        graphics2D.drawString("课程：" + title, 1750, 830);
        graphics2D.drawString("用微信或浏览器扫描左侧二维码即可", 1750, 950);
        graphics2D.drawString("观看完整视频", 1750, 1070);
        graphics2D.dispose();
        String filePath = path + "course" + courseId + ".png";
        //输出图片
        FileOutputStream outputStream = new FileOutputStream(filePath);
        ImageIO.write(image, "png", outputStream);
        outputStream.flush();
        outputStream.close();
        return filePath;
    }

    public static String qrCodeToPhoto(BufferedImage image, String path) throws Exception {
        //BufferedImage image = createImage(content);
        // 以图片的形式输出二维码
        FileOutputStream outputStream = new FileOutputStream(path);
        ImageIO.write(image, "png", outputStream);
        outputStream.flush();
        outputStream.close();
        return path;
    }

}