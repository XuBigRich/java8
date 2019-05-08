package interfaceAndAbstractDemo.shixianjiekou;

public class Student implements Person {
    private String book;
    public Student(){}
    @Override
    public void say() {
        System.out.println("我叫许鸿志");
    }
    public void see(){
        System.out.println("学习"+this.book);
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
