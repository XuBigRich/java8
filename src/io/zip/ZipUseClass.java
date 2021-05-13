package io.zip;


import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 这个类是对Java压缩文件的学习，他将会创建两个文件在家目录下，然后进行压缩
 *
 * @Author： hongzhi.xu
 * @Date: 2021/3/21 上午10:05
 * @Version 1.0
 */
public class ZipUseClass {
    //学习压缩文件的根目录
    private static String rootPath = File.separator + "Users" + File.separator + "xuhongzhi" + File.separator + "zip";
    //要压缩的文件目录位置
    private static String source = rootPath + File.separator + "source";
    //要压缩的文件目录位置
    private static String zipPath = rootPath + File.separator + "target.zip";

    /**
     * 创建要压缩的文件
     *
     * @throws IOException
     */
    public static void createFile() throws IOException {
        File file = new File(source);
        if (!file.exists()) {
            file.mkdirs();
        }
        for (int i = 0; i <= 2; i++) {
            String fileName = source + File.separator + i;
            File chileFile = new File(fileName);
            chileFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(chileFile);
            fos.write("许".getBytes());
            fos.close();
        }
    }

    public static void zipFile() throws IOException {
        File file = new File(source);
        File[] files = file.listFiles();
        FileOutputStream fileOutputStream = null;
        ZipOutputStream zos = null;
        FileInputStream fos = null;
        try {
            fileOutputStream = new FileOutputStream(zipPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        zos = new ZipOutputStream(fileOutputStream);
        byte[] bufs = new byte[1024 * 10];
        for (int i = 0; i < files.length; i++) {
            ZipEntry zipEntry = new ZipEntry(files[i].getName());
            zos.putNextEntry(zipEntry);
            fos = new FileInputStream(files[i]);
            int p = -1;
            while ((p = fos.read(bufs)) != -1) {
                zos.write(bufs, 0, p);
            }
        }
        zos.close();
        fos.close();
        fileOutputStream.close();
    }

    public static void main(String[] args) throws IOException {
        createFile();
        zipFile();
    }
}
