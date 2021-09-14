package erchashu;

public class 二分查找 {

    /**
     * 描述
     * 请实现有重复数字的升序数组的二分查找
     * 给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的第一个出现的target，如果目标值存在返回下标，否则返回 -1
     * 示例1
     * 输入：
     * [1,2,4,4,5],4
     * 返回值：
     * 2
     * 说明：
     * 从左到右，查找到第1个为4的，下标为2，返回2
     * 示例2
     * 输入：
     * [1,2,4,4,5],3
     * 返回值：
     * -1
     * 示例3
     * 输入：
     * [1,1,1,1,1],1
     * 返回值：
     * 0
     */

    public static void main(String[] args) {
        int[] target = {1,2,3,3,3,5};
        System.out.println(new 二分查找().search(target, 5));
    }

    public int search(int[] nums, int target) {
        // write code here
        int end = nums.length - 1;
        return searchHalf(0, end, nums, target);
    }

    private int searchHalf(int start, int end, int[] nums, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (end + start) / 2;
        if (nums[mid] > target) {
            // 左边找
            end = mid - 1;
            return searchHalf(start, end, nums, target);
        } else if (nums[mid] < target) {
            // 右边找
            start = mid + 1;
            return searchHalf(start, end, nums, target);
        } else {
            // 还得看看前面是否还有重复的 记住返回的是第一个

            while (mid >= 0 && nums[mid] == target) {
                mid--;
            }
            if (mid == -1){
                return 0;
            }
            return mid+1;
        }
    }
}
