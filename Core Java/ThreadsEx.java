class Threads extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Thread1 Running...");
        }
    }
}
class Threads2 extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Thread2 Running...");
        }
    }
}
class ThreadsEx{
    public static void main(String[] args){
        Threads th = new Threads();
        Threads2 th2 = new Threads2();
        th.start();
        th2.start();
    }
}