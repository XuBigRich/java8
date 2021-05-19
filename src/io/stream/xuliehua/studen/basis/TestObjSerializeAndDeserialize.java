package io.stream.xuliehua.studen.basis;

import java.io.*;
/*
* 把对象转换为字节序列的过程称为对象的序列化。
*　把字节序列恢复为对象的过程称为对象的反序列化。
* */
public class TestObjSerializeAndDeserialize {
    public static void main(String[] args) throws Exception {
        SerializePerson();
        Person person=DeserializePerson();
        System.out.println(person.toString());
    	}
    /**
          * MethodName: SerializePerson
           * Description: 序列化Person对象
           * @author xudp
           * @throws FileNotFoundException
           * @throws IOException
           */
    private static void SerializePerson() throws FileNotFoundException, IOException, ClassNotFoundException {
        Person person = new Person("xu" ,"男",21);
        File file = new File("person.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.close();
    }
        /**
              * MethodName: DeserializePerson
              * Description: 反序列Perons对象
              * @author xudp
              * @return
              * @throws Exception
              * @throws IOException
              */
        private static Person DeserializePerson() throws Exception, IOException {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                    new File("person.txt")));
            Person person = (Person) ois.readObject();
            System.out.println("Person对象反序列化成功！");
            return person;
        }

}
