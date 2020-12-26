package basic_algorithm.dp;

import java.util.Arrays;

/**
 * @Classname Solution92_Lin
 * @Description TODO
 * @Date 2020/12/25 21:18
 * @Created by laohuang
 */
// 该题为linCode
public class Solution92_Lin {
    // 注意，该题为0/1 背包问题，只能选择放或者不放，放最多只能一件
    // 单比重量和价值题目稍微轻松一点，此时，重量=价值
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {

        int len = A.length;
        // dp[i][j] 表示前i件物品，当容量为j的时候的最大价值（重量）
        int[][] dp = new int[len+1][m+1];

        // 初始化
        dp[0][0]=0;

        for(int j=1;j<=m;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<=len;i++){
            dp[i][0]=0;
        }

        //
        for(int i=1;i<=len;i++){
            for(int j=1;j<=m;j++){
                if(j>=A[i-1]){
                    // 此时容量够,可以选择放或者不放这件物品
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-A[i-1]]+A[i-1]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        // 状态转移

        return dp[len][m];
    }

    public static void main(String[] args){
        Solution92_Lin solution92_lin = new Solution92_Lin();
        solution92_lin.backPack(10,new int[]{3,4,8,5});
    }
}
