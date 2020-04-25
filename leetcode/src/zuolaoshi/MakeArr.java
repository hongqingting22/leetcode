package zuolaoshi;

import java.util.Arrays;

/**
 * 给定一个整数N，生成数组arr[N],满足条件：任意i<k<j,arr[i] + arr[j] != arr[k] * 2
 */
public class MakeArr {

    public static int[] makeArr(int n){
        if(n == 1){
            return new int[]{1};
        }
        int halfSize = (n + 1)/2;
        int[] baseArr = makeArr(halfSize);
        int[] res = new int[n];
        int index = 0;
        for(;index < halfSize;index++){
            res[index] = baseArr[index] * 2 + 1;
        }
        for(int i = 0;index < n;i++){
            res[index++] = baseArr[i] * 2;
        }
        return res;
    }

    public static boolean isValid(int[] arr){
        int n = arr.length;
        for(int i = 0;i< n;i++){
            for(int k = i + 1;k<n;k++){
                for(int j = k+ 1;j< n;j++){
                    if(arr[i] + arr[j] == arr[k] * 2){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] ints = makeArr(2871);
        System.out.println(Arrays.toString(ints));
        System.out.println(isValid(ints));
    }

}
