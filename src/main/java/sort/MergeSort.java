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
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {7, 10, 3, 5, 4, 6, 2, 8, 1, 9};
        merge(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 该方法会对array的first-between区间，between-last区间进行合并排序
     * （默认是这两个区间都已经分别排好序）
     *
     * @param array   表示原始数组
     * @param first   表示第一个要排序区间的第一个下标
     * @param between 表示第一个要排序区间的最后一个下标，也作为第二个排序区间的第一个下标
     * @param last    第二个待排序区间的最后一个下标
     */
    private static void mergeSort(int[] array, int first, int between, int last) {
        int n1 = between - first + 1;//因为first有可能等于零，下标可以从零开始，比如2-0=2，但其实数组大小应该为3，所以应该加1
        int n2 = last - between;//n1构造的数组已经包含了between下标的元素，所以n2就不用包含between下标的元素了
        int[] lArray = new int[n1];//该数组装载array的first到between下标的值
        int[] rArray = new int[n2];//该数组状态array的between到last的值
        int i, j, temp;
        //将first-between区间的元素拷贝到lArray数组，
        for (i = 0, temp = first; temp <= between; ) {
            lArray[i++] = array[temp++];
        }
        //将between+1到last的元素拷贝到rArray数组
        for (j = 0, temp = between + 1; temp <= last; ) {
            rArray[j++] = array[temp++];
        }
        //当i和j都没有移动到尽头时，对两个数组的第i个元素和第j个元素比较
        for (i = 0, j = 0; i < lArray.length && j < rArray.length; ) {//i和j表示lArray移动的下标和rArray数组移动的下标
            if (lArray[i] <= rArray[j]) {//如果lArray的第i个元素小于rArray的第j个元素，就将lArray的第i个元素拷贝到array中，first移动
                array[first++] = lArray[i++];
            } else {//同理
                array[first++] = rArray[j++];
            }
        }

        while (i < lArray.length) {//当上面的循环有一个已经移动到尽头（j已经移动到尽头），就将lArray的剩下的值赋值给array，因为lArray已经是有序的
            array[first++] = lArray[i++];
        }
        while (j < rArray.length) {//当上面的循环有一个已经移动到尽头（i已经移动到尽头），就将rArray的剩下的值赋值给array，因为rArray已经是有序的
            array[first++] = rArray[j++];
        }
    }

    /**
     * 归并排序的公开函数，
     *
     * @param array 原始数组
     * @param first 表示待排区间的第一个下标
     * @param last  表示待排区间的最后一个下标
     */
    public static void merge(int[] array, int first, int last) {
        if (first >= last) return;//表示array的first和last指向同一个元素，只有一个元素就不用排序了，否则就继续分割
        int between = (first + last) / 2;
        merge(array, first, between);//把要排序区间分割前一半进行递归排序
        merge(array, between + 1, last);//把要排序区间的后一半进行递归排序
        //当执行到下面这个函数时，说明first-between区间，between-last区间都已经有序了，再合并这两个有序区间成为一个新的从first-last的有序区间
        mergeSort(array, first, between, last);
    }

}
