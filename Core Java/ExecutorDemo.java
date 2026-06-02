import java.util.concurrent.*;

public class ExecutorDemo {

    public static void main(String[] args)
    throws Exception {

        ExecutorService ex =
            Executors.newFixedThreadPool(3);

        Future<Integer> f1 =
            ex.submit(() -> 100);

        Future<Integer> f2 =
            ex.submit(() -> 200);

        System.out.println(f1.get());

        System.out.println(f2.get());

        ex.shutdown();
    }
}