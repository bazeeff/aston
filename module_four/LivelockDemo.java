package ru.module_four;

// LivelockDemo.java
public class LivelockDemo {

    // Ресурс "ложка" принадлежит всегда ровно одному
    static class Spoon {
        private Eater owner;
        public Spoon(Eater owner) { this.owner = owner; }
        public synchronized Eater getOwner() { return owner; }
        public synchronized void setOwner(Eater owner) { this.owner = owner; }
        public synchronized void use() {
            // псевдо-использование ресурса
            try { Thread.sleep(50); } catch (InterruptedException ignored) {}
        }
    }

    static class Eater {
        private final String name;
        private volatile boolean hungry = true;

        public Eater(String name) { this.name = name; }
        public boolean isHungry() { return hungry; }
        public String getName() { return name; }

        // Симметричная логика -> livelock
        public void eatWith(Spoon spoon, Eater other) {
            while (hungry) {
                if (spoon.getOwner() != this) {
                    // Ждём своей очереди (без блокировки на долго — просто активное ожидание)
                    try { Thread.sleep(1); } catch (InterruptedException ignored) {}
                    continue;
                }

                // У меня ложка, но если другой тоже голоден — "вежливо" уступаю
                if (other.isHungry()) {
                    System.out.println(name + ": вы кушайте первым, " + other.getName());
                    spoon.setOwner(other); // передаём ресурс
                    try { Thread.sleep(10); } catch (InterruptedException ignored) {}
                    continue; // и снова по кругу -> livelock
                }

                System.out.println(name + ": ем!");
                spoon.use();
                hungry = false;
                System.out.println(name + ": наелся.");
                spoon.setOwner(other);
            }
        }
    }

    public static void main(String[] args) {
        Eater alice = new Eater("Алиса");
        Eater bob   = new Eater("Боб");

        Spoon spoon = new Spoon(alice); // старт: ложка у Алисы

        Thread t1 = new Thread(() -> alice.eatWith(spoon, bob), "AliceThread");
        Thread t2 = new Thread(() -> bob.eatWith(spoon, alice), "BobThread");

        t1.start();
        t2.start();

        // Мониторинг происходящего
        while (true) {
            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
            System.out.println("main: оба потока активны, ложка туда-сюда, никто не ест -> LIVELOCK");
        }
    }
}

