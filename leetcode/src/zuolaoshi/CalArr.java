package zuolaoshi;

import java.util.Arrays;

/**
 * 给定数组，元素中任意两个元素可以组成新的元素对
 * 如：{1,2,3}可以组成{1,1}，{1,2}，{1,3}，{2,1}，{2,2}，{2,3}，{3,1}，{3,2}，{3,3}
 * 需要找出排序后第K小的元素对
 *
 * 思路：
 * 1.排序
 * 2.计算元素对的第一个元素，如{1,1,1,2,2,3,4}，找到第22小的元素对，找到第一个元素应该是第一个2
 *      每个元素能组成的元素对有length个，前i个有i*length个，则第k小的元素对的首元素为：k/length,
 *      数组中表示为：arr[(k-1)/length]
 * 3.计算元素对第二个元素:
 *      先计算出比第一个元素小的元素个数lessNum，和第一个元素相等的元素个数equalNum
 *      lessNum可以组成的元素对个数 :lessNum * length
 *      则，从equalNum开始计算，需要计算的个数为：rest = k - lessNum * length
 *
 *      从数组第一个元素开始，每个元素能组成的元素对为：equalNum
 *      则，元素对的第二个元素下标为：(rest-1)/equalNum
 */
public class CalArr {
    /**
     * O(n*lgn)
     * @param nums
     * @param k
     * @return
     */
    public static int[] calArr(int[] nums,int k){
        int length = nums.length;
        if(nums == null || length == 0)return null;
        if(length * length < k)return null;
        Arrays.sort(nums);
        //找到元素对的第一个元素
        int firstNum = nums[(k -1)/length];
        //计算比firstNum小的个数
        int lessFirstNumSize = 0;
        //计算和firstNum相等的元素个数
        int firstNumSize = 0;

        for(int i = 0;i < length && nums[i] <= firstNum; i++){
            if(nums[i] < firstNum){
                lessFirstNumSize++;
            }else {
                firstNumSize++;
            }
        }
        //计算在第一个元素的范围内需要罗列的元素个数

        int rest = k - lessFirstNumSize * length;
        return new int[]{firstNum, nums[(rest - 1)/firstNumSize]};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,4,2,3,1,1};
        int[] ints = calArr(nums, 26);
        System.out.println(Arrays.toString(ints));
    }
}
