package algorithm;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 回文数
 */
public class Palindrome_9 {
    /**
     * 翻转右侧，while{原数去掉个位，翻转数加各位}，直到原数小于或等于翻转数时终止
     * 如果数字位数为奇数，翻转数/10去掉各位
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {

        if(x< 0 || (x%10 == 0 && x != 0)){
            return false;
        }
        int reverseNum = 0;
        while (x > reverseNum){
            reverseNum = reverseNum*10+x%10;
            x /= 10;
        }
        return x == reverseNum || x == reverseNum/10;
    }

    public static void main(String[] args) {
        boolean palindrome = new Palindrome_9().isPalindrome(12320);
        System.out.println(palindrome);
    }
}
