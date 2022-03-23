package stack;

import java.util.Arrays;
import java.util.Stack;

public class 比我小的 {

    /**
     * 找出数组右边比自身第一个小的数字的下标  没有用-1表示
     * @param a
     * 输入 【5,2】
     * 输出 【1，-1】
     * @return
     */
    int[] findRightSmall(int[] a){
        int[] rs = new int[a.length];
        if (a.length<2){
            rs[0]=-1;
            return rs;
        }
        int len = a.length;
        Stack<Integer> smallData = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            int curData = a[i];
            if (smallData.isEmpty()) {// 说明为空 第一次元素
                smallData.push(i);
                rs[i] = -1;
                continue;
            }
            Integer count = smallData.size()-1;
            boolean find = false;
            while(count >= 0){
                if (curData > a[smallData.get(count)]){// 找到了第一个比当前值小的了
                    rs[i] = smallData.get(count);
                    find = true;
                    break;
                }
                count--;
            }

            if (!find){
                rs[0]=-1;
            }
            // 找没找到 都要把当前元素放入到栈中
            smallData.push(i);
        }
        return rs;
    }


    public static void main(String[] args) {
        Arrays.stream(new 比我小的().findRightSmall(new int[]{1,5,6,3})).forEach(System.out::println);
    }

}
