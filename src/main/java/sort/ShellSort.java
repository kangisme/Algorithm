package sort;

import java.util.Arrays;

/**
 * 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。
 * 它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {7, 10, 3, 5, 4, 6, 2, 8, 1, 9};
        shell(a);
        System.out.println(Arrays.toString(a));
    }

    public static void shell(int[] a) {
        int length = a.length;
        int gap = 1;
        while (gap < length / 3) {
            gap = gap * 3 + 1;
        }
        for (; gap > 0; gap = gap / 3) {
            // 以下就是步长为gap的插入排序
            for (int i = gap; i < length; i += gap) {
                int pre = i - gap;
                int current = a[i];
                for (;pre >= 0 && a[pre] > current; pre -= gap) {
                    a[pre + gap] = a[pre];
                }
                a[pre + gap] = current;
            }
            System.out.println("gap=" + gap + "  " + Arrays.toString(a));
        }
    }
}
