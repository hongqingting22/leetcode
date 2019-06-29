package array;

public class Question136 {

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
        int i = new Question136().singleNumber(nums);
        System.out.println(i);
    }
}
