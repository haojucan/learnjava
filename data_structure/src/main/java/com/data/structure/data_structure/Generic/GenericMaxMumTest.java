package com.data.structure.data_structure.Generic;

import java.util.Comparator;

public class GenericMaxMumTest {
    //比较三个值并返回最大值
    public static <T extends Comparable<T>> T maxnmum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) >0) {
            max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maxnmum(3, 4, 5));
        System.out.printf("Maxm of %.1f,%.1f and %.1f is %.1f\n\n",6.6,8.8,7.7,maxnmum(6.6,7.7,8.0));
        System.out.printf("Max of %s,%s and %s is %s\n","pear","apple","orange",maxnmum("pear","apple","orange"));
    }

}
