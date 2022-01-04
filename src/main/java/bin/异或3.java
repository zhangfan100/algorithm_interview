package bin;

import java.util.Arrays;
import java.util.List;

/**
 * 在n个整数中，有2个不同的整数分别出现1次，其余的整数都出现了偶数次，求仅出现1次的2个整数。要求时空复杂度尽可能低。
 * 分析见https://mp.weixin.qq.com/s/YewSHYfKB7k44bqry8nF7A
 */
public class 异或3 {



    int getOXR(int a[], int n)
    {
        int result = 0;
        for(int i = 0; i < n; i++)
        {
            result ^= a[i];
        }

        return result;
    }

    int getMask(int r)
    {
        int mask = 1;
        while((mask & r) == 0)
        {
            mask <<= 1;
        }

        return mask;
    }

    void getResult(int[] a, int n, int a1, int b1)
    {
        int result = getOXR(a, n);
        int mask = getMask(result);

        for (int i = 0; i < n; i++)
        {
            if ((mask & a[i]) == 0)
            {
                a1 ^= a[i];
            }
        }

        b1 = a1 ^ result;
        System.out.println("a1="+a1);
        System.out.println("b1="+b1);
    }



    public static void main(String[] args) {
        int a[] = {3, 8, 4, 6, 2, 2, 4, 6};
        int n = a.length;
        int a1 = 0, b1 = 0;
        new 异或3().getResult(a, n, a1, b1);
    }

}
