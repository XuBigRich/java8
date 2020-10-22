package XML.sax.method1;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * sax 同时放入数据源 与 处理类 的解析方式
 */
public class ReadXML {
	public static void main(String[] args) {
		try {
			ParseDB mp=new ParseDB();
			SAXParserFactory sfp=SAXParserFactory.newInstance();
			SAXParser sp=sfp.newSAXParser();
			String path=System.getProperty("user.dir")+"/studb.xml";
			sp.parse(path, mp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
