/**
 * 动态规划 背包问题
 */
public class dp {

    /**
     * 有一个容量为 V 的背包，和一些物品。这些物品分别有两个属性，体积 w 和价值 v，每种物品只有一个。
     * 要求用这个背包装下价值尽可能多的物品，求该最大价值，背包可以不被装满。
     */
    // size 表示背包容量
    // w[i] 表示物品i+1体积
    // v[i] 表示物品i+1价值
    public void findMaxVal(int size,int[] w,int[] v){
        //  物品数量
        int length = w.length;
        // dp[i][j] 值表示用物品0～i的组合到容量为j的最大价值数
        int[][] dp = new int[length][size+1];
        for (int i=0;i<size+1;i++){
            dp[0][i] = 0;// 第一列是0  因为没有物品 装啥啊
        }
        // 遍历物品
        for(int i=1;i<length;i++){
            // 遍历容量
            for (int j=1;j<size+1;j++){
                // 表示不用第i个物品
                dp[i][j] = dp[i-1][j];
                // 要转的 肯定的比当前物品对应的体积大吧
                if (j >= w[i]){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-w[i]]+v[i]);
                }
            }
        }
        System.out.println("可以装入最大容量："+dp[length-1][size]);
    }

    public static void main(String[] args) {
        new dp().findMaxVal(8,new int[]{2,3,4,5,8},new int[]{3,4,5,6,90});
    }
}
