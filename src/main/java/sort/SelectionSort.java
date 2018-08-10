package sort;

import java.util.Arrays;

/**
 * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度
 * 所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。
 * 理论上讲，选择排序可能也是平时排序一般人想到的最多的排序方法了吧。
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {7, 10, 3, 5, 4, 6, 2, 8, 1, 9};
        select(a);
        System.out.println(Arrays.toString(a));
    }

    public static void select(int[] a) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            // 交换
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }
}
