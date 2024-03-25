package dp;

public class 接雨水 {

    public int trap(int[] height) {
        if (height == null || height.length <3){
            return 0;
        }
        int[] left_max = new int[height.length];
        left_max[0]=height[0];
        int[] right_max = new int[height.length];
        right_max[height.length-1]=height[height.length-1];
        // 从左到右 找到最高度
        for (int i= 1;i<height.length;i++) {
            left_max[i] = Math.max(left_max[i-1],height[i]);
        }
        // 从右到左 找到最高度
        for (int i=height.length-2;i>=0;i--) {
            right_max[i] = Math.max(right_max[i+1],height[i]);
        }
        int ans = 0;
        for (int i= 1;i<height.length;i++) {
            ans += Math.min(left_max[i],right_max[i])-height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[]{4,2,0,3,2,5};
//        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new 接雨水().trap(height));

    }

}
