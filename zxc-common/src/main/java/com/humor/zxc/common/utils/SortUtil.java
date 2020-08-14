package com.humor.zxc.common.utils;

import java.util.Iterator;
import java.util.TreeSet;

public class SortUtil {

    /**
     * top k 算法，获取前k个值
     *
     * @param array 源数组
     * @param n     获取靠前的个数
     * @return 前n个值的集合
     */
    private static TreeSet<Integer> topk(int[] array, int n) {

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < array.length; i++) {

            int value = array[i];
            if (set.size() < n)
                set.add(value);
            else {
                set.remove(2);
                Iterator<Integer> it = set.descendingIterator();
                int setMax = it.next();
                if (setMax > value) {
                    it.remove();
                    set.add(value);
                }
            }
        }
        return set;

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 7, 8, 9, 0, 5};
        int n = 4;
        TreeSet<Integer> treeSet = topk(array, n);
        System.out.println(treeSet);
    }
}
