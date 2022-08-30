package com.data.structure.data_structure.Generic;

import java.util.Arrays;

public class GenericMethodTest {
    //泛型方法 printArray
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static <E> void printArr(E[] printArr) {
        for (E el : printArr) {
            System.out.printf("%s", el);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //创建不同类型的数组 Integer、Double和 Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 3.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        System.out.println("Array integerArray contains:");
        printArray(intArray);
        System.out.println(Arrays.toString(intArray));
        System.out.println("Array doubleArray contains:");
        printArray(doubleArray);
        System.out.println(Arrays.toString(doubleArray));
        System.out.println("\nArray characterArray contains:");
        printArr(charArray);
        System.out.println(Arrays.toString(charArray));

    }
}
