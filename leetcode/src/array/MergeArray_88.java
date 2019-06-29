package array;

/**
 * 定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class MergeArray_88 {

    //时间复杂度O（m+n）空间复杂度O（m+n）
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] numsCopy = new int[m];
        System.arraycopy(nums1,0,numsCopy,0,m);//从源数组第0个元素开始，向目标数组从第0个位置开始填充m个元素
        //双指针
        int p1 = 0;
        int p2 = 0;

        //目标数组下标
        int p = 0;
        while(p1<m && p2 < n){
            nums1[p++] = numsCopy[p1] < nums2[p2] ? numsCopy[p1++] : nums2[p2++];
        }

        if(p1<m){
            System.arraycopy(numsCopy, p1,nums1, p1+p2,m+n-p1-p2);
        }
        if(p2<m){
            System.arraycopy(nums2, p2, nums1,p1+p2,m+n-p1-p2);
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n){
        int p1 = m-1;
        int p2 = n-1;

        int p = m+n-1;
        while(p1>=0 && p2 >=0){
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }

            System.arraycopy(nums2, 0, nums1, 0, p2+1);
    }


}
