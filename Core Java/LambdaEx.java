import java.util.*;
class LambdaEx{
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("Darvic");
        list.add("Charlie");
        list.add("Bob");
        list.add("Eric");
        list.add("Alice");
        Collections.sort(list,(s1,s2) -> s1.compareTo(s2));
        System.out.println("Sorted List : ");
        for(String s : list){
            System.out.println(s);
        }
    }
}