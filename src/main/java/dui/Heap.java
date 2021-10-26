package dui;

/**
 * 大头堆  构建
 */
public class Heap {
    public static int Left(int i)//返回左子结点
    {
        return 2 * i + 1;
    }

    public static int Right(int i)//返回右子节点
    {
        return 2 * i + 2;
    }

    public static void Max_Heapify(int[] a, int i)//以数组a 和i为参数   i为数组内坐标
    {
        int left = Heap.Left(i);
        int right = Heap.Right(i);
        int most;//记录最大值的数组下标
        int heapSize = a.length;
        if ((left < heapSize) && (a[left] > a[i]))//判断left<heapSize 是为了判断left是否溢出数组
            most = left;
        else
            most = i;
        if ((right < heapSize) && (a[right] > a[most]))//!注意不是>a[i]  此处为了判断出 a[i]a[left]a[right]最大值
            most = right;

        if (most != i) {
            Heap.swap(a, i, most);//交换 a[i]和a[most]
            Max_Heapify(a, most);//交换完之后 递归调用  确保交换后的a[most]满足 A[PARENT(i)]>A[i]
        }
    }

    public static void swap(int[] a, int i, int j)//交换函数
    {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void build_Max_Heap(int[] a)//以数组int[]a为参数调用
    {
        for (int i = a.length / 2; i >= 0; i--)//从i=a.length/2开始调用Max_heapify()函数，因为 i>a.length/2的节点没有子节点。
        {
            Heap.Max_Heapify(a, i);
        }


    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        Heap.build_Max_Heap(a);
        for (int p : a)
            System.out.println(p);//输出函数
    }

}