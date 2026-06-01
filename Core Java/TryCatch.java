import java.util.*;
class TryCatch{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        try{
            int div = n/d;
            System.out.println(div);
        }
        catch(ArithmeticException e){
            e.printStackTrace();
        }
    }
}