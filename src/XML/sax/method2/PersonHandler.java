package XML.sax.method2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理xinl数据的handler
 *
 * @author 晓电脑
 */
public class PersonHandler extends DefaultHandler2 {
    //接受保存数据的集合
    private List<Person> personList;

    //创建person对象
    private Person person;

    //记录这个标签
    private String tag;


    @Override
    public void startDocument() throws SAXException {
        //创建保存数据的集合对象
        personList = new ArrayList<>();
    }


    @Override
    /**
     * uri - 名称空间 URI，如果元素没有任何名称空间 URI，或者没有正在执行名称空间处理，则为空字符串。
     *
     * localName - 本地名称（不带前缀），如果没有正在执行名称空间处理，则为空字符串。
     *
     * qName - 限定的名称（带有前缀），如果限定的名称不可用，则为空字符串。
     *
     * attributes - 附加到元素的属性。如果没有属性，则它将是空的 Attributes 对象。
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("startElement: " + "uri >" + uri + " localName >" + localName + " qName>" + qName + " attributes>" + attributes.getValue(1)+ attributes.getValue("sid"));
        if (null != qName) {
            tag = qName;
        }
        if (null != qName && qName.equals("h:student")) {
            person = new Person();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
        System.out.println("characters: " + s);
        if (null != tag && tag.equals("h:name")) {
            person.setName(s);
        } else if (null != tag && tag.equals("h:age")) {
            person.setAge(Integer.valueOf(s));
        }

    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("endElement: " + "uri >" + uri + " localName >" + localName + " qName>" + qName);
        if (qName.equals("h:name")) {
            personList.add(person);
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("接收文件结尾的通知。 ");
    }

    public List<Person> getPersonList() {
        return personList;
    }
}

