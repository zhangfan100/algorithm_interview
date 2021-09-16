package dp;

/**
 * 描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 数据范围：
 * 要求：时间复杂度： ，空间复杂度：
 * 示例1
 * 输入：
 * 2
 *
 * 返回值：
 * 2
 *
 * 说明：
 * 青蛙要跳上两级台阶有两种跳法，分别是：先跳一级，再跳一级或者直接跳两级。因此答案为2
 * 示例2
 * 输入：
 * 7
 *
 * 返回值：
 * 21
 */
public class 跳台阶 {

    /**
     * 题目分析
     *        写出前面几级时的跳法：
     *
     * 一级台阶时，此时只有一种跳法。
     * 二级台阶时，当第一次跳一级时，还剩一级台阶，利用一级台阶的跳法，此时有一种跳法；当第一次跳二级时，此时只有一种跳法。所以共有2种跳法(1+1)。
     * 三级台阶时，当第一次跳一级时，还剩两级台阶，利用两次台阶的跳法，此时有两种跳法；当第一次跳二级时，还剩一级台阶，利用一级台阶的跳法，此时只有一种跳法。所以共有三种跳法(2+1)。
     * 四级台阶时，当第一次跳一级时，还剩三级台阶，此时利用三级台阶的跳法，此时有三种跳法；当第一次跳二级时，此时还剩二级台阶，利用二级台阶的跳法，此时有两种跳法。所以共有五种跳法(3+2)。
     * 五级台阶时，当第一次跳一级时，还剩四级台阶，此时利用四级台阶的跳法，此时有五种跳法；当第一次跳二级时，此时还剩三级台阶，此时利用三级台阶的跳法，此时有三种跳法。所以总共有八种跳法(5+3)。
     * … …
     *        看到这里应该发现规律了，当n大于一时，跳上n阶台阶的跳法等于跳上n-1阶台阶的跳法加上跳上n-2阶台阶的跳法。
     * @param target
     * @return
     */
    public int jumpFloor(int target) {
        if(target == 0){
            return 0;
        }else if (target==1){
            return 1;
        }else if (target==2){
            return 2;
        }else {
            return jumpFloor(target-1)+jumpFloor(target-2);
        }
    }


    public int jumpFloor1(int target) {
        if(target == 0){
            return 0;
        }else if (target==1){
            return 1;
        }else if (target==2){
            return 2;
        }
        int first = 1;
        int two = 2;
        int index = 3;
        int sum = 0;
        while(index<=target){
            sum = first+two;
            first = two;
            two = sum;
            index++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new 跳台阶().jumpFloor1(4));
    }

}
