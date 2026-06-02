public class VirtualThreadDemo {

    public static void main(String[] args)
            throws InterruptedException {

        long start = System.currentTimeMillis();

        for (int i = 1; i <= 100000; i++) {

            Thread.startVirtualThread(() -> {
                // simulate work
            });
        }

        Thread.sleep(2000);

        long end = System.currentTimeMillis();

        System.out.println(
            "Created 100000 virtual threads in "
            + (end - start) + " ms");
    }
}