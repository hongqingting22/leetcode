package array;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class Question53_zuidazixuhe {
//[-2,1,-3,4,-1,2,1,-5,4],
    public int maxSubArray(int[] nums) {
        if(null == nums || nums.length == 0){
            return 0;
        }
        if(nums.length == 1)return nums[0];
        int[] re = new int[nums.length];
        re[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            re[i] = Math.max(re[i-1] + nums[i], nums[i]);
        }
        int max= re[0];
        for(int i = 1;i<re.length;i++){
            if(max <re[i]){
                max = re[i];
            }
        }
        return max;
    }

    public static int maxSubArray2(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {100,0,100};
        System.out.println( maxSubArray2(nums));
    }
}
