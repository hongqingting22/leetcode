package dp;
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
// 示例:
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
//
// Related Topics 数组 动态规划

//leetcode submit region end(Prohibit modification and deletion)

public class T64_MinPathSum {
    public static int minPathSum(int[][] grid) {
        int length = grid[0].length;
        int high = grid.length;

        int[][] dp = new int[high][length];
        dp[0][0] =grid[0][0];
        for(int i = 1;i < high;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j = 1;j < length;j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i = 1;i< high;i++){
            for(int j = 1;j< length;j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[high-1][length-1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,5},{3,2,1}};
        System.out.println(arr.length);
        System.out.println(arr[0].length);
        int i = minPathSum(arr);
        System.out.println(i);
    }
}
