import java.util.*;
class HashMaps{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,String> map = new HashMap<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter key : ");
            int key = sc.nextInt();
            System.out.println("Enter value : ");
            String value = sc.next();
            sc.nextLine();
            map.put(key,value);
        }
        int k = sc.nextInt();
        if(map.containsKey(k)){
            System.out.println(map.get(k));
        }
        else{
            System.out.println("Not found");
        }
    }
}