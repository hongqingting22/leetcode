package array;
//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
//
// 示例 1:
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。
//
// 示例 2:
//
// 输入: [2,7,9,3,1]
//输出: 12
//解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
//
// Related Topics 动态规划

//leetcode submit region end(Prohibit modification and deletion)

import java.util.Map;

public class Rob_198 {

    /**
     * 递归
     * 思路：抢当前店 + 隔一个店 和 抢下一个店  比较
     * @param idx
     * @param nums
     * @return
     */
    public int solve1(int idx, int[] nums){
        if(idx < 0)return 0;
        return Math.max(
                    nums[idx] + solve1(idx -2, nums),
                        solve1(idx -1, nums)
                );
    }

    /**
     * 动态规划，避免重复计算。自顶向下
     */
    public static int[] result;
    public int solve(int idx, int[] nums){
        if(idx < 0)return 0;
        if(result[idx] >= 0)return result[idx];
        result[idx] = Math.max(
                nums[idx] + solve(idx - 2, nums),
                solve(idx-1, nums));
        return result[idx];
    }

    public int rob(int[] nums) {
        result = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            result[i] = -1;
        }
        return solve(nums.length - 1, nums);

    }

    /**
     * 自底向上
     * @param nums
     * @return
     */
    public int rob2(int[] nums){
        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];
        int[] rob = new int[nums.length];
        rob[0] = nums[0];
        rob[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length;i++){
            rob[i] = Math.max(nums[i] + rob[i - 2],
                    rob[i -1]);
        }
        return rob[nums.length-1];

    }
}
