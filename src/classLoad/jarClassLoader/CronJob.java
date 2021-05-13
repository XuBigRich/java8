package classLoad.jarClassLoader;


import java.net.URL;
import java.util.Map;

/**
 * 可以通过定时任务获取网络资源及时更新装载最新的class文件
 */
public class CronJob {
    private String jarUrl;

    // 更新函数的定时任务
    public void updateFunction() {
        try {
            UpdateFunctionUtil.updateIfModified(jarUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 更新函数的内部工具类
    private static class UpdateFunctionUtil extends FunctionUtil {
        private static long lastModified = 0L;

        private static synchronized void updateIfModified(String jarUrl) throws Exception {
            URL jar = new URL("jar:" + jarUrl + "!/");
            long modified = jar.openConnection().getLastModified();
            // 判断jar是否发生变化
            if (lastModified == modified) {
                return;
            } else {
                // 保存最新的修改时间
                lastModified = modified;
            }
            Map<String, IFunction> functions = loadFunctions(jar);
            setFunctions(functions);
        }
    }
}