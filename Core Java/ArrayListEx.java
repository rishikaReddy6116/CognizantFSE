import java.util.*;
class ArrayListEx{
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            String name = sc.next();
            list.add(name);
        }
        System.out.println();
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}