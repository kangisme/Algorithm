package sort;

import java.util.Arrays;

/**
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
 * 若将两个有序表合并成一个有序表，称为2-路归并。
 * 1. 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 2. 对这两个子序列分别采用归并排序；
 * 3. 将两个排序好的子序列合并成一个最终的排序序列。
 */
public class MergeSortTwo {
    public static void main(String[] args) {
        int[] a = {7, 10, 3, 5, 4, 6, 2, 8, 1, 9};
        int[] temp = new int[a.length];
        merge(a, 0, a.length - 1, temp);
        System.out.println(Arrays.toString(a));
    }

    public static void merge(int[] array, int start, int end, int[] tmp) {
        if (start >= end)
            return;
        int middle = ((end + start) >> 1);
        merge(array, start, middle, tmp);// 递归划分左边的数组
        merge(array, middle + 1, end, tmp);// 递归划分右边的数组
        mergearray(array, start, middle, end, tmp);// 对有序的两个数组进行合并成一个有序的数组
    }

    private static void mergearray(int[] array, int start, int middle, int end, int[] tmp) {
        int first = start;
        int second = middle + 1;
        int index = start;

        while ((first <= middle) && (second <= end)) {
            if (array[first] >= array[second])
                tmp[index++] = array[second++];
            else
                tmp[index++] = array[first++];
        }
        while (first <= middle)
            tmp[index++] = array[first++];
        while (second <= end)
            tmp[index++] = array[second++];

        for (first = start; first <= end; first++)
            array[first] = tmp[first];

        System.out.println("merge is " + Arrays.toString(array));
    }
}
