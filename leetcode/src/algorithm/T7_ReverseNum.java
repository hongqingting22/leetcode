package algorithm;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T7_ReverseNum {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x = x / 10;
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop == Integer.MAX_VALUE % 10)){
                rev = 0;
                break;
            }else if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop == Integer.MIN_VALUE % 10)){
                rev = 0;
                break;
            }
            rev = rev * 10 + pop;
        }
        return  rev;
    }

    public int reverse2(int x) {
        long res = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while (x != 0){
            res = res * 10 + x % 10;
            x /= 10;
        }
        if(res > max || res < min){
            return 0;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int reverse = new T7_ReverseNum().reverse2(-123456789);
        System.out.println(reverse);
        System.out.println(Math.pow(2,31));

    }
}
