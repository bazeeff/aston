package ru.module_two.task_one;

import java.util.LinkedList;



// Реализация собственного HashSet с использованием хэш-таблицы и метода цепочек для обработки коллизий
public class CustomHashSet<T> {
    // Массив списков для хранения элементов (каждый список - "корзина" для элементов с одинаковым хэшем)
    private LinkedList<T>[] buckets;
    // Текущий размер множества (количество уникальных элементов)
    private int size;
    // Начальная емкость хэш-таблицы
    private static final int INITIAL_CAPACITY = 16;
    // Фактор загрузки (когда size/capacity > LOAD_FACTOR, увеличиваем размер таблицы)
    private static final double LOAD_FACTOR = 0.75;

    // Конструктор: инициализация пустого множества
    @SuppressWarnings("unchecked")
    public CustomHashSet() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    // Вычисление индекса корзины на основе хэш-кода объекта
    private int getBucketIndex(T element) {
        if (element == null) {
            return 0; // null всегда в нулевой корзине
        }
        // Используем Math.abs для избежания отрицательных индексов
        return Math.abs(element.hashCode() % buckets.length);
    }

    // Метод для добавления элемента в множество
    public boolean add(T element) {
        // Проверяем, нужно ли расширить таблицу
        if ((double) (size + 1) / buckets.length > LOAD_FACTOR) {
            resize();
        }

        // Получаем индекс корзины для элемента
        int index = getBucketIndex(element);
        LinkedList<T> bucket = buckets[index];

        // Проверяем, есть ли элемент в корзине (чтобы избежать дубликатов)
        if (!bucket.contains(element)) {
            bucket.add(element);
            size++;
            return true; // Успешно добавлено
        }
        return false; // Элемент уже существует
    }

    // Метод для удаления элемента из множества
    public boolean remove(T element) {
        // Получаем индекс корзины
        int index = getBucketIndex(element);
        LinkedList<T> bucket = buckets[index];

        // Удаляем элемент из корзины, если он там есть
        if (bucket.remove(element)) {
            size--;
            return true; // Успешно удалено
        }
        return false; // Элемент не найден
    }

    // Метод для получения текущего размера множества
    public int size() {
        return size;
    }

    // Метод для увеличения размера хэш-таблицы при превышении фактора загрузки
    @SuppressWarnings("unchecked")
    private void resize() {
        // Создаем новый массив с удвоенной емкостью
        LinkedList<T>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0; // Сбрасываем размер, так как будем перехэшировать все элементы

        // Перемещаем все элементы из старого массива в новый
        for (LinkedList<T> bucket : oldBuckets) {
            for (T element : bucket) {
                add(element); // Перехэшируем элементы
            }
        }
    }
}