package dp;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 描述
 * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 * 示例1
 * 输入：
 * [2,3,4,5]
 * 返回值：
 * 4
 * 说明：
 * [2,3,4,5]是最长子数组
 * 示例2
 * 输入：
 * [2,2,3,4,3]
 * 返回值：
 * 3
 * 说明：
 * [2,3,4]是最长子数组
 * 示例3
 * 输入：
 * [9]
 * 返回值：
 * 1
 * 示例4
 * 输入：
 * [1,2,3,1,2,3,2,2]
 * 返回值：
 * 3
 * 说明：
 * 最长子数组为[1,2,3]
 * 示例5
 * 输入：
 * [2,2,3,4,8,99,3]
 * 返回值：
 * 5
 * 说明：
 * 最长子数组为[2,3,4,8,99]
 * 备注：
 * 1 \leq n \leq 10^51≤n≤10
 * 5
 */
public class 最长无重复子数组 {

    // 利用map去重
    public int maxLength(int[] arr) {
        // write code here
        Map<Integer, Integer> dataMap = new HashMap<>();
        if (arr.length == 1) {
            return 1;
        }
        int start = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int data = arr[i];
            // 不包含
            if (dataMap.containsKey(data)) {
                start = Math.max(start, dataMap.get(data) + 1);
            }
            dataMap.put(data, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    // 利用队列去重
    public int maxLength1(int[] arr) {
        // write code here
        if (arr.length == 1) {
            return 1;
        }
        Queue<Integer> exist = new ArrayDeque<>();
        int max = 0;
        for(int data : arr){
            while (exist.contains(data)){
                exist.poll();
            }
            exist.add(data);
            max = Math.max(max,exist.size());
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 最长无重复子数组().maxLength(new int[]{3,3,3,3,3,3}));
    }
}
