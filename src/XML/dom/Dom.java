package XML.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * 利用dom的方式解析xml
 */
public class Dom {
    static String path = System.getProperty("user.dir") + "/studb.xml";
    static String multpath = System.getProperty("user.dir") + "/students.xml";

    //一下子只可以解析一个
    public void dom1() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();//利用DocumentBuilderFactory.newInstance();
        try {
            //利用Builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            //读取文件
            Document doc = builder.parse(path);
            //寻找节点
            NodeList nodelist = doc.getElementsByTagName("student");
            Element e = (Element) nodelist.item(0);
            //解析节点
            System.out.println("姓名：" + e.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
            //解析年龄
            System.out.println("年龄：" + e.getElementsByTagName("age").item(0).getFirstChild().getNodeValue());
            //解析性别
            System.out.println("性别：" + e.getElementsByTagName("sex").item(0).getFirstChild().getNodeValue());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void printNode(Node node) {
        NamedNodeMap nodemap = node.getAttributes();
        for (int i = 0; i < nodemap.getLength(); i++) {
            Node e = nodemap.item(i);
            System.out.println(e.getNodeName() + " : " + e.getFirstChild().getNodeValue());
        }

    }

    //一下子可以解析多个
    public void dom2() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(multpath);
            NodeList nodelist = doc.getElementsByTagName("students");
            Element element = (Element) nodelist.item(0);
            NodeList nodelists = element.getElementsByTagName("student");
            for (int i = 0; i < nodelists.getLength(); i++) {
                Element e = (Element) nodelists.item(i);
                System.out.println("姓名: " + e.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
                printNode(e.getElementsByTagName("name").item(0));
                System.out.println("年龄: " + e.getElementsByTagName("age").item(0).getFirstChild().getNodeValue());
                System.out.println("性别: " + e.getElementsByTagName("sex").item(0).getFirstChild().getNodeValue());
                System.out.println("===============================================");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Dom dom=new Dom();
        dom.dom1();
        dom.dom2();
    }
}