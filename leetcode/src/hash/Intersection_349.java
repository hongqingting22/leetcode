package hash;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Intersection_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return new int[]{};
        Set<Integer> set = new HashSet<Integer>();

        for(int i : nums1){
            set.add(i);
        }

        List<Integer> arr = new ArrayList<>();
        for(int i : nums2){
            if(set.contains(i)){
                arr.add(i);
                set.remove(i);
            }
        }
        int[] re = new int[arr.size()];
        for(int i = 0 ;i<arr.size();i++){
            re[i] = arr.get(i);
        }

        return re;
    }

    public static void main(String[] args) {
    }
}
