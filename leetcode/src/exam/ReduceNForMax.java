package exam;

import java.util.Arrays;

/**
 * 给定一个m位数字和一个数字n，求出m位数字去掉n个数字后的最大值
 * 例：m=532709  n=1  结果：53709
 *
 * 思路：
 *  左侧数字比右侧小时，删除左侧数字
 */
public class ReduceNForMax {

    public static int process(int[] arr, int n){
        int length = arr.length;
        if(length < n)return 0;
        int[] temp = Arrays.copyOf(arr, length);
        while (n >0){
            for(int i = 1;i<= length; i++){
                if(i == length){
                    length--;
                    break;
                }
                if(temp[i - 1] < temp[i]){
                    int idx = i;
                    while (idx < length){
                        temp[idx - 1] = temp[idx++];
                    }
                    length--;
                    break;
                }
            }
            n--;
        }

        int ans = 0;
        for(int i = 0;i< length;i++){
            ans = 10 * ans + temp[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {9, 2, 7, 6, 8, 4, 3, 5, 1};
        System.out.println("原数字： " + 927684351);
        for (int k = 1; k < 9; k++)
            System.out.println("当K为：" + k + " 时" + "最大的数为： " + process(num, k));

    }
}
