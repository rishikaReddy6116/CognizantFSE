import java.util.*;
import java.io.*;
class FileWriting{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String str = sc.nextLine();
        try{
            FileWriter fw = new FileWriter("output.txt");
            fw.write(str);
            fw.close();
            System.out.println("Successfully written in output.txt");
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}