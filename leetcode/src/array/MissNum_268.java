package array;

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
