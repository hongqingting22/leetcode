package zuolaoshi;

import java.util.Arrays;

/**
 * 给定字符串str，str1，str长度大于str1，计算str中是否包含连续子串，满足该连续子串是str1的同源异构词
 */
public class ContainSameSubStr {
    /**
     * 罗列str中长度为str1长度的子串，判断是否为同源异构词
     * O(N*M)
     * @param str
     * @param str1
     * @return
     */
    public static int contain(String str, String str1){
        if(str == null || str1 == null || str.length() < str1.length()){
            return -1;
        }
        char[] strArr = str.toCharArray();
        char[] strArr1 = str1.toCharArray();
        for(int l = 0;l <= str.length() - str1.length();l++){
            if(equalsStr(strArr, l, strArr1)){
               return l;
            }
        }
        return -1;
    }

    private static boolean equalsStr(char[] source,int l, char[] aim){
        int[] count = new int[256];
        for(int i = 0;i< aim.length;i++){
            count[aim[i]] ++;
        }
        for(int i = 0;i< aim.length;i++){
            if(count[source[l + i]]-- == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * O(N)
     * 目标字符串建立欠债表count[]
     * 源字符串的第一个长度为目标长度的子串组成滑动窗口，尝试清空欠债表count[i]--
     *      记录每个字符还债数是否过限，出现负数  inValidTimes
     * 如果出现inValidTimes == 0，表示正好还完，满足要求返回；
     * 不满足，则滑动窗口向右移动，右侧字符--，最左侧字符++
     * 直到出现inValidTimes == 0
     * @param source
     * @param target
     * @return
     */
    public static int contain2(String source, String target){
        if(source == null || target == null || source.length() < target.length()){
            return -1;
        }
        //建立欠债表
        char[] targetArray = target.toCharArray();
        int[] count = new int[256];
        for(int i = 0;i< targetArray.length;i++){
            count[targetArray[i]] ++;
        }
        int m = targetArray.length;
        int inValidTimes = 0;
        char[] arr = source.toCharArray();
        int r = 0;
        for(;r< m;r++){
            if(count[arr[r]] -- <= 0){
                inValidTimes++;
            }
        }
        for(;r < arr.length;r++){
            if(inValidTimes == 0){
                return r - m;
            }
            if(count[arr[r]] -- <= 0){
                inValidTimes++;
            }
            if(count[arr[r - m]] ++ < 0){
                inValidTimes--;
            }
        }
        return inValidTimes == 0 ? r - m : -1;
    }

    public static void main(String[] args) {
        String str = "acbcabc";
        String str1 = "bcc";
        int i = contain2(str, str1);
        System.out.println(i);

        char a = '1';
        System.out.println(a);
        System.out.println('a');
        System.out.println('A');
        int[] arr = new int[256];
        arr['a'] = 10;
        arr['1'] = 1;
        arr['s'] = 2;
        System.out.println(Arrays.toString(arr));

    }
}
