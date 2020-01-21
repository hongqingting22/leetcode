package array;
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
// 示例 1:
//
// 输入: [3,2,3]
//输出: 3
//
// 示例 2:
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
//
// Related Topics 位运算 数组 分治算法


import java.util.HashMap;
import java.util.Map;

public class ItemMore_169 {
    public int majorityElement(int[] nums) {
        if(nums == null)return -1;
        if(nums.length == 1)return nums[0];
        int len = nums.length / 2;
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            String value = String.valueOf(num);
            if(map.containsKey(value)){
                int count = map.get(value)+ 1;
                if(count > len)return num;
                map.put(value, count);
            }else{
                map.put(value, 1);
            }
        }
        return -1;
    }
}
