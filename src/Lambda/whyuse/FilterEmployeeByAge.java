package Lambda.whyuse;

public class FilterEmployeeByAge implements MyPredicate<Employee> {


    @Override
    public boolean test(Employee o) {
        return o.getAge()>=35;
    }
}
