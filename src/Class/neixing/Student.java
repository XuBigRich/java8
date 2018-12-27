package Class.neixing;

public class Student {
        private String name; //这些是字段！！不是javabean的属性
        private int age;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getAbc() {
            return null;
        }
        public void aaa(){
            System.out.println("aaaa");
        }
}
