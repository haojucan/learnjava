package com.data.structure.data_structure;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.BitSet;

public class BitSetTest {
    public static void main(String[] args) {
        /**
         * Java Bitset类
         * 一个Bitset 类创建一种特殊的数组来保存位置。BitSet中数组大小会随意增加。这和位向量（vector of bits）
         * 比较类似。
         * 这是一个传统的类，但在java2中重新设计。
         * BitSet 定义了两构造方法
         *
         */
//        boolean[] bits = new boolean[2048];
//        String[] str = new String[]{"yello", "green", "red"};
//        System.out.println(VM.current().hashCode());
//        System.out.println();
//        System.out.println(ClassLayout.parseInstance(str).toPrintable());
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);
        for (int i = 0; i < 16; i++) {
            if ((i % 2) == 0 ) bits1.set(i);
            if ((i % 5) != 0) bits2.set(i);
        }
        System.out.println("Initial pattern in bits1:");
        System.out.println(bits1);
        System.out.println("Initial pattern in bits2:");
        System.out.println(bits2);
        bits2.and(bits1);
        System.out.println("\nbits2 AND bits1:");

//        System.out.println(bits2);
//        bits2.or(bits1);
//        System.out.println("\nbits2 OR bits1:");
//        System.out.println(bits2);
        bits2.xor(bits1);
        System.out.println("\nbits2 XOR bits1:");
        System.out.println(bits2);

    }
}
