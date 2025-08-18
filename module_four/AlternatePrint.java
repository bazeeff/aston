package ru.module_four;

// AlternatePrint.java
import java.util.concurrent.Semaphore;

public class AlternatePrint {
    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(1); // разрешает начать с "1"
        Semaphore s2 = new Semaphore(0);

        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    s1.acquire();
                    System.out.print("1");
                } catch (InterruptedException ignored) {
                } finally {
                    s2.release();
                }
            }
        }, "Printer-1");

        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    s2.acquire();
                    System.out.print("2");
                } catch (InterruptedException ignored) {
                } finally {
                    s1.release();
                }
            }
        }, "Printer-2");

        t1.start();
        t2.start();
    }
}
