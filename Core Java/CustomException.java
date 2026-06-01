import java.util.*;
class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}
class CustomException{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        try{
            Validate(age);
        }
        catch(InvalidAgeException e){
            System.out.println("Exception : "+e.getMessage());
        }
    }
    public static void Validate(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Age must be above 18");
        }
        System.out.println("Valid age");
    }
}