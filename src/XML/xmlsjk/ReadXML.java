package XML.xmlsjk;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ReadXML {
	public static void main(String[] args) {
		try {
			ParseDB mp=new ParseDB();
			
			SAXParserFactory sfp=SAXParserFactory.newInstance();
			SAXParser sp=sfp.newSAXParser();
			
			sp.parse("e:/studb.xml", mp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
