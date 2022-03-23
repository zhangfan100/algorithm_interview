package stack;

import java.util.Stack;

public class 大鱼吃小鱼 {
    /**
     * 有N条鱼每条鱼的位置及大小均不同，他们沿着X轴游动，有的向左，有的向右。游动的速度是一样的，两条鱼相遇大鱼会吃掉小鱼。
     * 从左到右给出每条鱼的大小和游动的方向（0表示向左，1表示向右）。问足够长的时间之后，能剩下多少条鱼？
     * size[i] 表示第i条鱼的大小
     * dir[i]  表示第i条鱼游动方向  0表示向左，1表示向右
     */

    public int remain(int size[],int dir[]){
        int remainTotal = 0;
        Stack<Integer> rightSize = new Stack<>();
        for (int index=0;index<size.length ;index++){
            int currentSize = size[index];
            int eachDir = dir[index];
            if (eachDir == 1){//右走 直接入栈
                rightSize.push(currentSize);
            }else{
                // 网左走 需要和向右的比较大小
                int count = rightSize.size()-1;
                int i = count+1;
                while(i>0){
                    i--;
                    Integer peek = rightSize.get(count);
                    if (peek > currentSize) {// 吃掉这个小的  也就不记录啥
                        break;
                    } else {
                        // 右移动的鱼小  被吃掉
                        rightSize.pop();
                        count--;
                    }
                }
                if (rightSize.isEmpty()){
                    // 说明被吃完了，当前元素计数
                    remainTotal++;
                }
            }
        }
        remainTotal+=rightSize.size();
        return remainTotal;
    }

    public static void main(String[] args) {
        int size[] = new int[]{13,14,8,9};
        int dir[] = new int[]{1,1,1,0};//0表示向左，1表示向右
        System.out.println(new 大鱼吃小鱼().remain(size, dir));
    }
}
