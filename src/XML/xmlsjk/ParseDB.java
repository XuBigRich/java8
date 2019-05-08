package XML.xmlsjk;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ParseDB extends DefaultHandler {

	private String ename;//当前正在解析的元素名称
	private String sql;
	private Connection con;
	private PreparedStatement ps;

	//执行时机：在开始解析文档前执行
	public void startDocument() throws SAXException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1:3306/leguanbeiguan?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
			con=DriverManager.getConnection(url,"root","root");
			sql="insert into students values(?,?,?)";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//执行时机：在遇到元素开始时执行
	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException {
		ename=qName;
		try {
			if(qName.equals("student")){
				ps=con.prepareStatement(sql);
				ps.setString(1,attributes.getValue("sid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//执行时机：在遇到文本内容时执行
	public void characters(char[] ch, int start, int length) throws SAXException {
		String v=new String(ch,start,length);
		try {
			if(!v.trim().equals("")){
				if(ename.equals("name"))ps.setString(2,v);
				else if(ename.equals("sex"))ps.setString(3,v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//执行时机：在元素结束时执行
	public void endElement(String uri, String localName, String qName)throws SAXException {
		try {
			if(qName.equals("student"))ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//执行时机：在解析文档完毕时执行
	public void endDocument() throws SAXException {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


