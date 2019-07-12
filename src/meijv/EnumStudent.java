package meijv;
/*
* 枚举类教学
* */
public enum EnumStudent {
    SPRING("春天"),SUMMER("夏天"),FALL("秋天"),WINTER("冬天");
    
    private final String name;
    
    private EnumStudent(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
