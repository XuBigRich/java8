package XML.sax.method2;


import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PersomTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        //1),获得解析工厂 SAXParserFactory
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        //2),工厂获取解析器SAXParser
        SAXParser saxParser = parserFactory.newSAXParser();
        //3),得到解读器
        XMLReader reader = saxParser.getXMLReader();
        //4),加载DTD处理器
        PersonHandler handler = new PersonHandler();
        reader.setDTDHandler(handler);
        //5),设置内容处理器
        reader.setContentHandler(handler);
        //6),编写处理器

        String path = System.getProperty("user.dir") + "/studb.xml";
        InputStream inputStream=new FileInputStream(path);
        InputSource inputSource=new InputSource(inputStream);
        reader.parse(inputSource);

        List<Person> personList = handler.getPersonList();
        personList.forEach(e -> System.out.println(e.getName() + "--->" + e.getAge()));

    }
}

