package Stream.comparesize;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TestSize {
    public static void main(String[] args) {
        List<Person> persons=new ArrayList<>();
        Person xu=new Person("许鸿志",23);
        Person da=new Person("许大富",22);
        Person fu=new Person("许渣渣",20);
        persons.add(xu);
        persons.add(da);
        persons.add(fu);
        Optional<Person> person = persons.stream().max(Comparator.comparingDouble(Person::getAge));
        Person maxPlanInfo = person.get();
        System.out.println(maxPlanInfo.getName());
    }
}
