package ru.module_four;

public class DeadlockDemo {
    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK_A) {
                sleep(200);
                synchronized (LOCK_B) {
                    System.out.println("T1: получил A и B");
                }
            }
        }, "T1");

        Thread t2 = new Thread(() -> {
            synchronized (LOCK_B) {
                sleep(200);
                synchronized (LOCK_A) {
                    System.out.println("T2: получил B и A");
                }
            }
        }, "T2");

        t1.start();
        t2.start();

        while (true) {
            sleep(1000);
            System.out.println("main: оба потока живы, но ничего не происходит -> DEADLOCK");
        }
    }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}
