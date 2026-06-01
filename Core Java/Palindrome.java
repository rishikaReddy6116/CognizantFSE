import java.util.*;
class Palindrome{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str);
        String s = sb.reverse().toString();
        if(s.equalsIgnoreCase(str)){
            System.out.println("Palindrome!");
        }
        else{
            System.out.println("Not a Palindrome");
        }
    }
}