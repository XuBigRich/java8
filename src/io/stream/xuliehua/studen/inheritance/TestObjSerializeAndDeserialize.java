package io.stream.xuliehua.studen.inheritance;


import jar.getPath.GetPath;

import java.io.*;

/*
 * 把对象转换为字节序列的过程称为对象的序列化。
 *　把字节序列恢复为对象的过程称为对象的反序列化。
 * */
public class TestObjSerializeAndDeserialize {
    public static void main(String[] args) throws Exception {
        SerializePerson();
        Man person = DeserializePerson();
        System.out.println(person.toString());
    }

    /**
     * MethodName: SerializePerson
     * Description: 序列化Person对象
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @author xudp
     */
    private static void SerializePerson() throws FileNotFoundException, IOException, ClassNotFoundException {
        Man man = new Man("男",100);
        man.setAge(23);
        man.setName("许鸿志");
        String path = ClassLoader.getSystemClassLoader().getResource("").getPath();
        File file = new File(path + "/man.ser");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(man);
        oos.close();
    }

    /**
     * MethodName: DeserializePerson
     * Description: 反序列Perons对象
     *
     * @return
     * @throws Exception
     * @throws IOException
     * @author xudp
     */
    private static Man DeserializePerson() throws Exception, IOException {
        String path = ClassLoader.getSystemClassLoader().getResource("").getPath();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File(path + "/man.ser")));
        Man person = (Man) ois.readObject();
        System.out.println("Person对象反序列化成功！");
        return person;
    }

}
