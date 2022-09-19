package groupby.reduce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Student {
    public Student() {
    }

    public Student(String code, String name, Long chengJi, Integer age, BigDecimal value) {
        this.code = code;
        this.name = name;
        this.chengJi = chengJi;
        this.age = age;
        this.value = value;
    }



    private String code;
    private String name;
    private Long chengJi;
    private Integer age;
    private BigDecimal value;

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList();
        studentList.add(new Student("a", "am", 1L, 2, new BigDecimal(3)));
        studentList.add(new Student("a", "am1", 1L, 2, new BigDecimal(3)));
        studentList.add(new Student("b", "bm1", 1L, 2, new BigDecimal(3)));
        Map<String, Optional<Student>> collect1 = studentList.stream().collect(Collectors.groupingBy(Student::getCode,
                Collectors.reducing((sum, s) ->
                        new Student(s.code, s.name, sum.chengJi + sum.chengJi,
                                sum.age + s.age, sum.value.add(s.value)))
        ));

        collect1.forEach(
                (e,k) -> System.out.println(e)
        );


        Map<String, Integer> collect2 = studentList.stream().collect(Collectors.groupingBy(Student::getCode,
                Collectors.summingInt((e) -> 1)));
        System.out.println(collect2);



        List<Student> collect = studentList.stream().collect(Collectors.groupingBy(Student::getCode,
                Collectors.reducing((sum, s) ->
                        new Student(s.code, s.name, sum.chengJi + sum.chengJi,
                                sum.age + s.age, sum.value.add(s.value)))
        )).entrySet().stream().map(c -> c.getValue().get()).collect(Collectors.toList());
        System.out.println(collect);
    }














    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getChengJi() {
        return chengJi;
    }

    public void setChengJi(Long chengJi) {
        this.chengJi = chengJi;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}

