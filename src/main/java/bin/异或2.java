package bin;

import java.util.Arrays;
import java.util.List;

/**
 * 在n个整数中，有1个奇数仅出现一次，有1个偶数仅出现一次，其余的整数都出现了偶数次，求奇数和偶数的值。要求时空复杂度尽可能低。
 */
public class 异或2 {

    public void findData(List<Integer> datas){

        int jrs = 0;
        int ors = 0;
        for (int d:datas){
            if (d%2==0){// 偶数
                ors^=d;
            }else {
                jrs ^= d;
            }
        }

        System.out.println("基数="+jrs);
        System.out.println("偶数="+ors);
    }

    public static void main(String[] args) {
        new 异或2().findData(Arrays.asList(12, 4, 4, 8, 9, 3, 6, 8, 3, 6, 9,7,11,13,11,13));
    }

}
