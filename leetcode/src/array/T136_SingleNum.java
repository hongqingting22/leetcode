package array;
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,1]
//输出: 1
//
//
// 示例 2:
//
// 输入: [4,1,2,1,2]
//输出: 4
// Related Topics 位运算 哈希表

public class T136_SingleNum {

    public int singleNumber(int[] nums) {
        int temp = nums[0];
        if(nums.length > 1){
            for(int i = 1;i<nums.length;i++){
                temp ^= nums[i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,2,4};
        int i = new T136_SingleNum().singleNumber(nums);
        System.out.println(i);
    }
}
