//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static int mySqrt(int x) {
        double mid = x/2;
        double left = 0;
        double right = x;
        while ((int)left < (int)right){
            double temp = mid * mid;
            if(temp > x){
                right = mid;
                mid = (double)(left + right)/2;
            }else{
                left = mid;
                mid = (double)(left + right)/2;
            }
        }
        return (int)mid;
    }

    public static void main(String[] args) {
        int i = mySqrt(4);
        System.out.println(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
