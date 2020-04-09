package array;
//给定一个非负整数数组，你最初位于数组的第一个位置。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
// 示例:
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//
//
// 说明:
//
// 假设你总是可以到达数组的最后一个位置。
// Related Topics 贪心算法 数组

//leetcode submit region end(Prohibit modification and deletion)

public class CanJump2_45 {
    public static int jump(int[] nums) {
        minStep = new int[nums.length];
        for(int i = 0;i< nums.length;i++){
            minStep[i] = -1;
        }
        return minJumpStep(0, nums);
    }
    public static int[] minStep ;
    public static int minJumpStep(int idx, int[] nums){
        if(idx == nums.length -1)return 0;
        if(nums[idx] + idx >= nums.length - 1)return 1;
        int step = -2;
        for(int i = idx+1;i<= idx + nums[idx];i++) {
            int idxStep = minStep[i];
            if (idxStep == -2) continue;
            if (idxStep == -1) {
                idxStep = minJumpStep(i, nums);
                minStep[i] = idxStep;
            }
//            if(step == -2){
//                if(idxStep != -2){
//                    step = idxStep + 1;
//                }else
//            }else if(step != -2){
//                step = Math.min(step, idxStep + 1);
//            }
        }
        minStep[idx] = step;
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        int jump = jump(nums);
        System.out.println(jump);
    }
}
