import java.util.*;
class GradeCalc{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int res = sc.nextInt();
        if(res<60){
            System.out.println('F');
        }
        else if(res>=60 && res<70){
            System.out.println('D');
        }
        else if(res>=70 && res<80){
            System.out.println('C');
        }
        else if(res>=80 && res<90){
            System.out.println('B');
        }
        else {
            System.out.println('A');
        }
    }
}