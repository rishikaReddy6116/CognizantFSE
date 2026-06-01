import java.util.*;
class Arraysum{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            sum += sc.nextInt();
        }
        System.out.println(sum);
        System.out.println(sum/n);
    }
}