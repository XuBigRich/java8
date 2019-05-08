package XML.xmlsjk;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ReadDB {
	public static void main(String[] args) {
		try {
			Document doc=new Document();//XML文档对象
			Element root=new Element("class");//元素对象
			root.setAttribute("cid","1606");//设置属性

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1:3306/leguanbeiguan?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
			Connection con=DriverManager.getConnection(url,"root","root");

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
			FileOutputStream fos=new FileOutputStream("e:/studb.xml");
			xo.output(doc, fos);

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
