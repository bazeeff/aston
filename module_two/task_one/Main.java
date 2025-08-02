package ru.module_two.task_one;

// Предполагается, что классы CustomArrayList и CustomHashSet определены
// (их код предоставлен ранее, повторять не буду для краткости)

public class Main {
    public static void main(String[] args) {
        // === Демонстрация CustomArrayList ===
        System.out.println("=== Работа с CustomArrayList ===");

        // Создаем CustomArrayList для хранения строк (названий фруктов)
        CustomArrayList<String> fruitList = new CustomArrayList<>();

        // Добавляем элементы с помощью метода add
        fruitList.add("Apple");
        fruitList.add("Banana");
        fruitList.add("Orange");
        System.out.println("После добавления фруктов: size = " + fruitList.size());

        // Получаем элемент по индексу с помощью get
        System.out.println("Фрукт с индексом 1: " + fruitList.get(1)); // Ожидается: Banana

        // Удаляем элемент по индексу с помощью remove
        String removedFruit = fruitList.remove(0);
        System.out.println("Удален фрукт: " + removedFruit); // Ожидается: Apple
        System.out.println("После удаления: size = " + fruitList.size());

        // Создаем другую коллекцию для демонстрации addAll
        CustomArrayList<String> moreFruits = new CustomArrayList<>();
        moreFruits.add("Mango");
        moreFruits.add("Grape");

        // Добавляем все элементы из moreFruits в fruitList
        fruitList.addAll(moreFruits);
        System.out.println("После addAll: size = " + fruitList.size());

        // Выводим все элементы списка
        System.out.println("Все фрукты в списке:");
        for (int i = 0; i < fruitList.size(); i++) {
            System.out.println("  " + fruitList.get(i));
        }

        // === Демонстрация CustomHashSet ===
        System.out.println("\n=== Работа с CustomHashSet ===");

        // Создаем CustomHashSet для хранения уникальных чисел
        CustomHashSet<Integer> numberSet = new CustomHashSet<>();

        // Добавляем элементы с помощью add
        numberSet.add(10);
        numberSet.add(20);
        numberSet.add(10); // Дубликат, не добавится
        numberSet.add(30);
        System.out.println("После добавления чисел: size = " + numberSet.size()); // Ожидается: 3

        // Удаляем элемент
        boolean removed = numberSet.remove(20);
        System.out.println("Удалено число 20: " + removed); // Ожидается: true
        System.out.println("После удаления: size = " + numberSet.size()); // Ожидается: 2

        // Проверяем удаление несуществующего элемента
        removed = numberSet.remove(100);
        System.out.println("Удалено число 100: " + removed); // Ожидается: false

        // === Интеграция CustomArrayList и CustomHashSet ===
        System.out.println("\n=== Интеграция CustomArrayList и CustomHashSet ===");

        // Создаем CustomArrayList с числами
        CustomArrayList<Integer> numberList = new CustomArrayList<>();
        numberList.add(30); // Дубликат с numberSet
        numberList.add(40);
        numberList.add(50);

        // Добавляем все числа из numberList в numberSet
        for (int i = 0; i < numberList.size(); i++) {
            numberSet.add(numberList.get(i));
        }
        System.out.println("После добавления чисел из numberList в numberSet: size = " + numberSet.size());
    }
}