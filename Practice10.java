import java.lang.*;

public class Practice10{
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.print("Ping "));
        thread1.start();
        Thread thread2 = new Thread(() -> System.out.print("Pong"));
        thread2.start();
    }
}