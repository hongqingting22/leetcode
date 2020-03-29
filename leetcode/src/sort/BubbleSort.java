package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static int[] sort(int[] nums){
        int temp = 0;
        for(int i = 0;i< nums.length-1;i++){
            for(int j = 0;j < nums.length - 1 - i;j++){
                if(nums[j + 1] < nums[j]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,2,7,1,9};
        int[] sort = sort(arr);
        for( int i = 0;i<sort.length;i++){
            System.out.println(sort[i]);
        }
    }
}
