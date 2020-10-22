package XML.simulationMysqlByJDOM2;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * 基于dom的方式解析xml   使用第三方包jdom2的方式
 * 从数据库中查询出数据 放入xml中
 */
public class ReadDB {
	public static void main(String[] args) {
		try {
			Document doc=new Document();//XML文档对象
			Element root=new Element("class");//元素对象
			root.setAttribute("cid","1606");//设置属性

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&relaxAutoCommit=true&zeroDateTimeBehavior=CONVERT_TO_NULL&allowMultiQueries=true";
			Connection con=DriverManager.getConnection(url,"root","rr998xhz1997");

			String sql="select * from students";
			ResultSet rs=con.createStatement().executeQuery(sql);
				while(rs.next()){
				Element stu=new Element("student");
				stu.setAttribute("sid",rs.getString("sid"));

				Element n=new Element("name");
				n.setText(rs.getString("name"));
				Element s=new Element("sex");
				s.setText(rs.getString("sex"));

				stu.addContent(n);
				stu.addContent(s);
				root.addContent(stu);
			}

			doc.setRootElement(root);
			XMLOutputter xo=new XMLOutputter(Format.getPrettyFormat());
			String path=System.getProperty("user.dir")+"/studb.xml";
			FileOutputStream fos=new FileOutputStream(path);
			xo.output(doc, fos);

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
