package XML.simulationMysqlByJDOM2;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * 根据studb.xml 配置文件将 数据写入数据库
 */
public class WriteDB {
	public static void main(String[] args) {
		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			String url="jdbc:sqlserver://localhost:1433;databaseName=test";
//			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&relaxAutoCommit=true&zeroDateTimeBehavior=CONVERT_TO_NULL&allowMultiQueries=true";
			Connection con=DriverManager.getConnection(url,"root","rr998xhz1997");
			SAXBuilder sb=new SAXBuilder();
			String path=System.getProperty("user.dir")+"/studb.xml";
			Document doc=sb.build(new File(path));//载入整个文档到内存
			Element root=doc.getRootElement();//获取根元素class
			List stus=root.getChildren();
			for(int i=0;i<stus.size();i++){
				Element stu=(Element)stus.get(i);//<student></student>
				List chs=stu.getChildren();
				Element n=(Element)chs.get(0);//<name></name>
				Element s=(Element)chs.get(1);//<sex></sex>
				
				String sql="insert into students values(?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, stu.getAttributeValue("sid"));
				ps.setString(2, n.getText());
				ps.setString(3, s.getText());
				ps.execute();
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
