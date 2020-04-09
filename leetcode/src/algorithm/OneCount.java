package algorithm;

/**
 * 题意：
 *
 * 　　给定一个整数n，求1~n这n个整数中十进制表示中1出现的次数。
 *
 * 思路：
 *     个位： 0-9有一个1，则包含n个10，各位就有n个1；
 *     十位：10-99，十位有10个数，即：11-19，则包含n个100,10位就有n*10个1；
 *     ……
 *     =高位*10的i-1次方，i表示从各位开始向前的位数
 *
 */
public class OneCount {

    public static int culOne(int n){
        if(n <=0)return 0;
        int count = 0;
        int i = 1;
        while (n > 0){
           int low = n % 10;
           n /= 10;
           if(low > 1){
               count += (n+1) * Math.pow(10, i -1);
           }else if(low == 1){
               count += n * Math.pow(10, i - 1) + 1;
           }else{
               count += n*Math.pow(10,i-1);
           }
           i++;
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(Math.pow(10, 2));

        System.out.println(culOne(210));
    }
}
