import java.util.*;
class Calculator{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 numbers");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Choose an option : ");
        System.out.print("\n1.Addition\n 2.Subtraction\n 3.Multiplication\n 4.Division");
        int ch = sc.nextInt();
        switch(ch){
            case 1: 
            System.out.println(a+b);
            break;
            case 2: 
            System.out.println(a-b);
            break;
            case 3: 
            System.out.println(a*b);
            break;
            case 4: 
            System.out.println(a/b);
            break;
            default:
            System.out.println("Invalid");
        }
    }
}