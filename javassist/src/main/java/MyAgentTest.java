public class MyAgentTest {
    public static void main( String[] args ) throws InterruptedException {
        while (true) {
            hello();
            Thread.sleep(1000);
        }
    }

    public static void hello() {
        System.out.println("Hello method!");
    }
}
