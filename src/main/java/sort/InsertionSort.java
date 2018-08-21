package sort;

import java.util.Arrays;

/**
 * 1. 从第一个元素开始，该元素可以认为已经被排序；
 * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 5. 将新元素插入到该位置后；
 * 6. 重复步骤2~5。
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {7, 10, 3, 5, 4, 6, 2, 8, 1, 9};
        insertTwo(a);
        System.out.println(Arrays.toString(a));
    }

    public static void insert(int[] a) {
        int length = a.length;
        // 从第二个开始
        for (int i = 1; i < length; i ++) {
            int pre = i - 1;
            int current = a[i];
            while (pre >= 0 && a[pre] > current) {
                a[pre + 1] = a[pre];
                pre--;
            }
            a[pre + 1] = current;
        }
    }

    public static void insertTwo(int[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            int num = a[i];
            int j = i - 1;
            for (; j >= 0 && a[j] > num; j--)
                a[j + 1] = a[j];
            a[j + 1] = num;
        }
    }
}

