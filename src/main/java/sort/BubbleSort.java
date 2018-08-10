package sort;

import java.util.Arrays;

/**
 * 1. 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 3. 针对所有的元素重复以上的步骤，除了最后一个；
 * 4. 重复步骤1~3，直到排序完成。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {7, 10, 3, 5, 4, 6, 2, 8, 1, 9};
        bubble(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bubble(int[] a) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟 " + Arrays.toString(a));
        }
    }
}
