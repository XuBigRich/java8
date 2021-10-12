package scanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * @author 许鸿志
 * @since 2021/10/12
 */
public class ScannerLearn {
    public ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    public URL filePath = classLoader.getResource("print");

    public static void main(String[] args) throws URISyntaxException, IOException {
        ScannerLearn scannerLearn = new ScannerLearn();
        //java11
//        Scanner scanner = new Scanner(FileChannel.open(Path.of(scannerLearn.filePath.toURI())));
        Scanner scanner = new Scanner(new FileInputStream(new File(scannerLearn.filePath.toURI())));
        scanner.useDelimiter(" ");
        while (scanner.hasNext()) {
            //若要scanner.nextInt() 不报错，必须print文件中一定要是数字
            System.out.println(scanner.nextInt());
            System.out.println(scanner.next());

        }
    }
}
