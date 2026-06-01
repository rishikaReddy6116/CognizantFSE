import java.io.*;
class FileReading{
    public static void main(String[] args){
        try{
            FileReader fr = new FileReader("output.txt");
            int ch;
            while((ch=fr.read())!=-1){
                System.out.print((char)ch);
            }
            fr.close();
            System.out.println();
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}