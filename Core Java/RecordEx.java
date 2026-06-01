import java.util.*;
import java.util.stream.*;
record Person(String name, int age){}
class RecordEx{
    public static void main(String[] args){
        Person p1 = new Person("Rishika", 19);
        Person p2 = new Person("Pri",21);

        System.out.println(p1);
        System.out.println(p2);

        List<Person> list = List.of(p1,p2,new Person("Anjali",32),new Person("Ridhaan",28));
        list.stream().filter(p -> p.age()>25).forEach(System.out::println);
    }
}