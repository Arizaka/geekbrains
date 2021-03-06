package ru.geekbrains;


import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

    /**** Создать массив (тысячу элементов).
     **** Описать метод который бы удалял все вхождения данного значения в массив
     **** Написать методы удаления, добавления, поиска элемента массива.
     **** Заполнить массив случайными числами.
     **** Написать методы, сортировок и вывести на экран количество
     действий и сравнить его со сложностью сортировки.


     **** Создать программу, которая переворачивает вводимые строки
     **** Создать класс для реализации дека
     **** Описать класс с реализацией приоритетной очереди



     **** Реализовать класс итератора
     **** Написать программу, использующую двусвязный список через методы итератора
     */

    public static void main(String[] args) {
        Bag bag = new Bag(5,
                new Bag.Item(1,6),
                new Bag.Item(3,12),
                new Bag.Item(2,10));
        System.out.println(bag.getBag());
    }

    private static void task4() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.putRight(3);
        linkedList.putRight(3);
        linkedList.putRight(3);

        LinkedList.Iterator iterator = linkedList.getIterator();

        for (; iterator.hasNext(); ) {
            iterator.remove();
        }
        System.out.println(linkedList.getSize());
        System.out.println(iterator);
        linkedList.putRight(1);
        System.out.println(iterator);
    }

    private static void task3() {
        Reverser reverser = new Reverser();
        reverser.reverse(reverser.setString());


        Deque deque = new Deque(15);
        for (int i = 0; i < 15; i++) {
            deque.insertLeft(i);
        }
        System.out.println(deque);
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeRight());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeRight());
        deque.insertLeft(22);
        System.out.println(deque.getTail());
        deque.insertLeft(33);
        System.out.println(deque.getTail());
        deque.insertLeft(44);
        System.out.println(deque.getTail());
        deque.insertRight(55);
        System.out.println(deque.getTail());
        System.out.println(deque);
        for (int i = 0; i < 15; i++) {
            deque.removeRight();
        }

        for (int i = 0; i < 15; i++) {
            deque.insertLeft(i + 10);
        }
        System.out.println(deque);

        System.out.println(deque.getCapacity() + " " + deque.getSize());
        System.out.println(deque.isFull());
        System.out.println(deque.getHead() + " " + deque.getTail());
        deque.removeRight();
        System.out.println(deque.getHead() + " " + deque.getTail());
        deque.insertLeft(77);
        System.out.println(deque.getHead() + " " + deque.getTail());
        System.out.println(deque);
        //
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.insert(1);
        priorityQueue.insert(3);
        priorityQueue.insert(2);
        priorityQueue.insert(4);
        priorityQueue.insert(5);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.remove());
        priorityQueue.insert(6);
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue);
        priorityQueue.insert(1);
        priorityQueue.insert(15);
        priorityQueue.remove();
        System.out.println(priorityQueue);
    }

    private static void task2() {
        int N = 1000;
        ///
        MyArray<Integer> arrayInsert = new MyArray<Integer>(N);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < arrayInsert.getSize(); i++) {
            arrayInsert.insert(random.nextInt());
        }
        long timeBefore = System.currentTimeMillis();
        arrayInsert.sortInsert();
        System.out.println("sortInsert for " + arrayInsert.getSize() + " elements:");
        System.out.println("Expect O(n^2) = " +
                BigInteger.valueOf(arrayInsert.getSize()).pow(2) +
                " Actual = " +
                arrayInsert.getIterations());
        System.out.println("Time cost: " + (System.currentTimeMillis() - timeBefore) + " ms");
        System.out.println();
        ///
        ///
        MyArray<Integer> arraySelect = new MyArray<Integer>(N);
        for (int i = 0; i < arraySelect.getSize(); i++) {
            arraySelect.insert(random.nextInt());
        }
        timeBefore = System.currentTimeMillis();
        arrayInsert.sortInsert();
        arraySelect.sortSelect();
        System.out.println("sortSelect for " + arrayInsert.getSize() + " elements:");
        System.out.println("Expect O(n^2) = " +
                BigInteger.valueOf(arraySelect.getSize()).pow(2) +
                " Actual = " +
                arraySelect.getIterations());
        System.out.println("Time cost: " + (System.currentTimeMillis() - timeBefore) + " ms");
        System.out.println();
        ///
        ///
        MyArray<Integer> arrayBubble = new MyArray<Integer>(N);
        for (int i = 0; i < arrayBubble.getSize(); i++) {
            arrayBubble.insert(random.nextInt());
        }
        timeBefore = System.currentTimeMillis();
        arrayInsert.sortInsert();
        arrayBubble.sortBubble();
        System.out.println("sortBubble for " + arrayInsert.getSize() + " elements:");
        System.out.println("Expect O(n^2) = " +
                BigInteger.valueOf(arrayBubble.getSize()).pow(2) +
                " Actual = " +
                arrayBubble.getIterations());
        System.out.println("Time cost: " + (System.currentTimeMillis() - timeBefore) + " ms");
        System.out.println();
        ///
        ///
        MyArray<Integer> myArray = new MyArray<Integer>(10);
        for (int i = 0; i < myArray.getSize() - 1; i++) {
            myArray.insert(i);
        }
        myArray.insert(1);
        System.out.println(myArray);
        myArray.deleteAll(1);
        System.out.println(myArray);
        ///
    }

    //power: O(n) - выполняем действие n-раз
    private static long power(int a, int n) {
        long res = a;
        for (int i = 0; i < n - 1; i++) {
            res *= a;
        }

        return res;
    }

    //Оптимизация: алгоритм быстрого возведения в степень
    //Так как каждые две итерации степень сокращается в двое, сложность такого алгоритма логарифмическая
    //O(logn)
    private static long fast(int a, int n) {
        long res = 1;
        while (n != 0) {
            if ((n & 1) != 0)
                res *= a;
            a *= a;
            n >>= 1;
        }
        return res;
    }

    //min O(n) - выполняем действие n-раз
    private static int min(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (i < array[i]) min = i;
        }
        return min;
    }
    //Оптимизация: бинарный поиск

    //median O(n) - выполняем действие n-раз
    private static float median(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += i;
        }
        return sum / array.length;
    }
    //Оптимизация: при большом массиве, наверно, Map-reduce
}
