import java.util.*;
class RecursiveFibonacci{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = fib(n);
        System.out.println(res);
    }
    static int fib(int n){
        if(n<=1) return n;
        else{
            return fib(n-1)+fib(n-2);
        }
    }
}