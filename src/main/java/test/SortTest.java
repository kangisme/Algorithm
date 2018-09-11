package test;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] a = {5, 3, 6, 2, 0, 8, 1, 9, 4, 7};
//        bubble(a);
//        select(a);
//        insert(a);
//        shell(a);
//        quick(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void heap(int[] a) {
    }

    private static void adjustHeap(int a[], int parent, int length) {
        int temp = a[parent];
        for (int i = parent * 2 + 1; i <= length; i = i * 2 + 1) {
            if (a[i] < a[i + 1]) {
                i++;
            }
            if (temp >= a[i]) {
                break;
            }
            a[parent] = a[i];
            parent = i;
        }
        a[parent] = temp;
    }

    private static void merge(int[] a, int start, int end, int[] result) {

    }

    private static void quick(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int p = part(a, start, end);
        quick(a, start, p - 1);
        quick(a, p + 1, end);
    }

    private static int part(int a[], int start, int end) {
        int key = a[start];
        while (start < end) {
            while (a[end] > key && start < end) {
                end--;
            }
            a[start] = a[end];
            while (a[start] < key && start < end) {
                start++;
            }
            a[end] = a[start];
        }
        a[end] = key;
        return end;
    }

    private static void shell(int[] a) {
        for (int gap = a.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < a.length; i += gap) {
                int pre = i - gap;
                int cur = a[i];
                for (;pre >= 0 && a[pre] > cur; pre -= gap) {
                    a[pre + gap] = a[pre];
                }
                a[pre + gap] = cur;
            }
        }
    }

    private static void insert(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int pre = i - 1;
            int cur = a[i];
            for (;pre >= 0 && a[pre] > cur; pre--) {
                a[pre + 1] = a[pre];
            }
            a[pre + 1] = cur;
        }
    }

    private static void select(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }

    private static void bubble(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
