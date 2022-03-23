package bin;

import java.util.Arrays;
import java.util.List;

/**
 * 在n个整数中，仅有1个整数出现1次，其余的整数都出现了偶数次，求这个仅出现1次的整数。要求时空复杂度尽可能低。
 */
public class 异或 {

    public int findData(List<Integer> datas){

        int rs = 0;
        for (int d:datas){
            rs ^= d;
        }

        return rs;
    }

    public static void main(String[] args) {
        int data = new 异或().findData(Arrays.asList(12, 4, 4, 8, 9, 3, 6, 8, 3, 6, 9));
        System.out.println(data);
    }

}
