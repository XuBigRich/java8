package headlessMode;

import javax.swing.*;

/**
 * 如果在linux 命令行模式下 关闭无头模式，那么当有JFrame窗口生成时，将会报错
 * 在无头模式下运行JFrame 那么 无头模式会抛出 异常 : Exception in thread "main" java.awt.HeadlessException
 * 在关闭无头模式下运行JFrame 那么 会越过模式检查直接抛出 Exception in thread "main" java.awt.AWTError: Can't connect to X11 window server using ':0.0' as the value of the DISPLAY variable.
 * <p>
 * <p>
 * [create/read,true/false]
 *
 * @author 许鸿志
 * @since 2021/6/7
 */
public class Config {
    public static void config(String args) {
        System.setProperty("java.awt.headless", args);
    }

    private static void createAndShowGUI() {
        // 确保一个漂亮的外观风格
        JFrame.setDefaultLookAndFeelDecorated(true);

        // 创建及设置窗口
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 添加 "Hello World" 标签
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        // 显示窗口
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{"false"};
        }
        config(args[0]);
        createAndShowGUI();
    }
}
