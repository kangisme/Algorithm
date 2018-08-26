package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        //定义整型数组
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50, 1000};
        //调用堆排序数组
        HeapSort(a);
        //输出排序后的数组
        System.out.println(Arrays.toString(a));
    }

    //堆排序函数
    public static void HeapSort(int[] arr) {
        int n = arr.length - 1;
        // 非叶子节点
        for (int i = n / 2 - 1; i >= 0; i--) {
            //构造大顶堆，从下往上构造
            //i为最后一个根节点，n为数组最后一个元素的下标
            HeapAdjust(arr, i, n);
        }
        for (int i = n; i > 0; i--) {
            //把最大的数，也就是顶放到最后
            //i每次减一，因为要放的位置每次都不是固定的
            swap(arr, i);
            //再构造大顶堆
            HeapAdjust(arr, 0, i - 1);
        }
    }

    //构造大顶堆函数，parent为父节点，length为数组最后一个元素的下标
    public static void HeapAdjust(int[] arr, int parent, int length) {
        //定义临时变量存储父节点中的数据，防止被覆盖
        int temp = arr[parent];
        //2*parent+1是其左孩子节点
        for (int i = parent * 2 + 1; i <= length; i = i * 2 + 1) {
            //如果左孩子大于右孩子，就让i指向右孩子
            if (i < length && arr[i] < arr[i + 1]) {
                i++;
            }
            //如果父节点大于或者等于较大的孩子，那就退出循环
            if (temp >= arr[i]) {
                break;
            }
            //如果父节点小于孩子节点，那就把孩子节点放到父节点上
            arr[parent] = arr[i];
            //把孩子节点的下标赋值给parent
            //让其继续循环以保证大根堆构造正确
            parent = i;
        }
        //将刚刚的父节点中的数据赋值给新位置
        arr[parent] = temp;
    }

    //定义swap函数
    //功能：将跟元素与最后位置的元素交换
    //注意这里的最后是相对最后，是在变化的
    public static void swap(int[] arr, int i) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
    }
}