package ru.module_two.task_one;

import java.util.Arrays;
import java.util.Collection;

// Реализация собственного ArrayList с динамическим массивом
public class CustomArrayList<T> {
    // Массив для хранения элементов
    private Object[] elements;
    // Текущий размер списка (количество элементов)
    private int size;
    // Начальная емкость массива
    private static final int INITIAL_CAPACITY = 10;

    // Конструктор: инициализация пустого списка
    @SuppressWarnings("unchecked")
    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // Метод для добавления элемента в конец списка
    public void add(T element) {
        // Проверяем, нужно ли расширить массив
        if (size == elements.length) {
            resize();
        }
        // Добавляем элемент в конец и увеличиваем размер
        elements[size] = element;
        size++;
    }

    // Метод для получения элемента по индексу
    @SuppressWarnings("unchecked")
    public T get(int index) {
        // Проверяем корректность индекса
        checkIndex(index);
        return (T) elements[index];
    }

    // Метод для удаления элемента по индексу
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        // Проверяем корректность индекса
        checkIndex(index);
        // Сохраняем удаляемый элемент
        T removedElement = (T) elements[index];
        // Сдвигаем элементы влево, чтобы заполнить пустое место
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        // Очищаем последний элемент и уменьшаем размер
        elements[size - 1] = null;
        size--;
        return removedElement;
    }

    // Метод для добавления всех элементов из коллекции
// Изменяем сигнатуру addAll для совместимости с CustomArrayList
    public void addAll(CustomArrayList<? extends T> otherList) {
        if (size + otherList.size() > elements.length) {
            resize(otherList.size());
        }
        for (int i = 0; i < otherList.size(); i++) {
            elements[size + i] = otherList.get(i);
        }
        size += otherList.size();
    }

    // Метод для получения текущего размера списка
    public int size() {
        return size;
    }

    // Метод для проверки корректности индекса
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Метод для увеличения размера массива
    @SuppressWarnings("unchecked")
    private void resize() {
        resize(0);
    }

    // Метод для увеличения размера массива с учетом дополнительной емкости
    private void resize(int additionalCapacity) {
        // Удваиваем текущую емкость или учитываем дополнительную емкость
        int newCapacity = Math.max(elements.length * 2, elements.length + additionalCapacity);
        // Копируем элементы в новый массив
        elements = Arrays.copyOf(elements, newCapacity);
    }
}