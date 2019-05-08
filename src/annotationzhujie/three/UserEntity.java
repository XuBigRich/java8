package annotationzhujie.three;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserEntity.java
 * @Description TODO
 * @createTime 2019年01月28日 14:59:00
 */
//这样设值只能为value 才可以读取
    //项目中使用注解一定会使用反射
@SetTable("User_Entity")
public class UserEntity {
    @SetProperty(name="user_name",leng = 10)
    private String name;
    @SetProperty(name="user_old",leng = 10)
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
