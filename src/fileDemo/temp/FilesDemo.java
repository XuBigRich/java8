package fileDemo.temp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Files 与Path
 *
 * @author 许鸿志
 * @since 2021/6/11
 */
public class FilesDemo {

    public static Path createAndWriteTemp() throws IOException {
        Path dir = Files.createTempDirectory(Paths.get("D://"), null);
        Path files = Files.createTempFile(dir, null, null);
        List<String> _list = new ArrayList<>();
        _list.add("我西牛贺洲者，不贪不杀，养气潜灵，虽无上真，人人固寿；");
        _list.add("但那南赡部洲者，贪淫乐祸，多杀多夺，正所谓口舌凶场，是非恶海。");
        Path _pathW = Files.write(files, _list, Charset.forName("utf-8"));
        System.out.println("");
        return files;
    }

    /**
     * 读取文件行数
     *
     * @param path
     * @throws IOException
     */
    public static void readTemp(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path, Charset.forName("utf-8"));
        System.out.println("Files.readAllLines()读到的行数——" + lines.size());
        Files.lines(path, Charset.forName("utf-8")).forEach(line -> System.out.print(line));
    }

    /**
     * 复制拷贝文件
     *
     * @param path
     * @throws IOException
     */
    public static void copyByStream(Path path) throws IOException {
        String targetPath = System.getProperty("user.dir") + "/copy";
        OutputStream os = new FileOutputStream(targetPath);// 工作路径下
        long copy = Files.copy(path, os);
        System.out.println("Files.copy() return value = " + copy);
        System.out.println("Files.size(源文件)：" + Files.size(path));
    }


    /**
     * 查看当前文件所占空间 若为null 则输出c盘大小
     *
     * @param path
     * @throws IOException
     */
    public static void space(Path path) throws IOException {
        FileStore cStore;
        if (path == null) {
            cStore = Files.getFileStore(Paths.get("C:"));
        } else {
            cStore = Files.getFileStore(path);
        }
        System.out.println("C:共有空间：" + cStore.getTotalSpace());
        System.out.println("C:可用空间：" + cStore.getUsableSpace());
    }

    /**
     * 获取path目录下的所有文件
     *
     * @param path
     */
    public static void allFilesByPath(Path path) throws IOException {
        Files.list(path).forEach(e -> System.out.println(e));
    }


    public static void main(String[] args) throws IOException {
        //创建临时文件并向临时文件中写入数据
        Path path = createAndWriteTemp();
        copyByStream(path);
        readTemp(path);
        space(null);
        allFilesByPath(path);
    }
}
