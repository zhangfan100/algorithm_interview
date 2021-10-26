package dui;

/**
 * 小头堆  构建
 */
public class MinHeap {
    public static int Left(int i)//返回左子结点
    {
        return 2 * i + 1;
    }

    public static int Right(int i)//返回右子节点
    {
        return 2 * i + 2;
    }

    public static void Minx_Heapify(int[] a, int i)//以数组a 和i为参数   i为数组内坐标
    {
        int length = a.length;
        int minIndex = 0;
        int left = MinHeap.Left(i);//左子树
        int right = MinHeap.Right(i);//右子树
        if (left < length && a[i] > a[left]) {// 没越界并且当前节点大于左子树
            minIndex = left;
        } else {
            minIndex = i;
        }

        if (right < length && a[minIndex] > a[right]) {// 没越界并且当前节点大于右子树
            minIndex = right;
        }
        if (minIndex != i) {
            swap(a, i, minIndex);
            // 交换后需要看后面的是否排序正确 继续递归
            Minx_Heapify(a, minIndex);
        }
    }

    public static void swap(int[] a, int i, int j)//交换函数
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void build_Minx_Heap(int[] a)//以数组int[]a为参数调用
    {
        // 从中间开始算
        int mid = a.length /2;
        for (int i = mid; i >= 0; i--) {
            Minx_Heapify(a, i);
        }
    }

    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] a = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        MinHeap.build_Minx_Heap(a);
        for (int p : a)
            System.out.println(p);//输出函数
    }

}