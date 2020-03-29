package array;
//给定一个非负整数数组，你最初位于数组的第一个位置。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个位置。
//
// 示例 1:
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
//
//
// 示例 2:
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
//
// Related Topics 贪心算法 数组
//leetcode submit region end(Prohibit modification and deletion)

public class CanJump_55 {

    public boolean canJump(int[] nums) {
        int k = 0;
        for(int i = 0;k<nums.length-1;i++){
            if(i > k)return false;
            k = Math.max(k, nums[i] + i);
        }
        return true;
    }

    public boolean canJump2(int i , int[] nums){
        if(i == nums.length -1)return true;
        int step = i + nums[i];
        if(step >= nums.length - 1)return true;
        for(i = i + 1;i<= step;i++){
            if(canJump2(i, nums)){
                return true;
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        return canJump2(0, nums);
    }

    public static int[] canjump;
    public int canJump3(int i , int[] nums){
        int idx = canjump[i];
        if(idx == 1){
            return 1;
        }else if(idx == 0){
            return 0;
        }else {
            int step = i + nums[i];
            if(step >= nums.length - 1)return 1;
            for(int j = step;j > i;j--){
                canjump[j] =  canJump3(j, nums);
                if(canjump[j] == 1){
                    return 1;
                }
            }
            return 0;
        }
    }

    public boolean canJump3(int[] nums) {
        canjump = new int[nums.length];
        for(int i = 0;i< nums.length;i++){
            canjump[i] = -1;
        }
        canjump[nums.length -1] = 1;
        return canJump3(0, nums) == 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        new CanJump_55().canJump2(nums);
    }
}
