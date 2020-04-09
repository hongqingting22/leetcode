package array;
//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
//
// 示例 1:
//
// 输入: [3,0,1]
//输出: 2
//
//
// 示例 2:
//
// 输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
//
//
// 说明:
//你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
// Related Topics 位运算 数组 数学
public class MissNum_268 {

    public int miss(int[] nums){
        int res = 0;
        for(int i = 0;i<=nums.length;i++){
            res ^= i;
        }
        for(int i = 0;i<nums.length;i++){
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,2};
        int miss = new MissNum_268().miss(nums);
        System.out.println(miss);
    }
}
