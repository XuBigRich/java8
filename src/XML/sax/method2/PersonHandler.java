package XML.sax.method2;
 
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.helpers.DefaultHandler;
 
import java.util.ArrayList;
import java.util.List;
 
/**处理xinl数据的handler
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
        personList=new ArrayList<>();
    }
 
 
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (null != qName){
            tag=qName;
        }
        if (null != qName && qName.equals("person")){
            person=new Person();
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
        if (null != tag && tag.equals("name")){
            person.setName(s);
        }else if(null != tag && tag.equals("age")){
            person.setAge(Integer.valueOf(s));
        }
 
    }
 
 
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")){
            personList.add(person);
        }
        tag=null;
    }
 
    @Override
    public void endDocument() throws SAXException {
        System.out.println("接收文件结尾的通知。 ");
    }
 
    public List<Person> getPersonList() {
        return personList;
    }
}

