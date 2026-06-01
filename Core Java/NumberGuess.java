import java.util.*;
class NumberGuess{
    public static void main(String[] args){
        Random rm = new Random();
        Scanner sc = new Scanner(System.in);
        int num = rm.nextInt(101);
        int guess = sc.nextInt();
        if(guess>num){
            System.out.println("Too high");
        }
        else if(guess == num){
            System.out.println("Correct guess!!");
        }
        else{
            System.out.println("Too Low");
        }
    }
}