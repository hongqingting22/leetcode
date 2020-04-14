package wei;

/**
 * 使用加减乘除完成位运算
 */
public class AddMinusMultiDivideByBit {

    /**
     * a^b  a&b << 1
     * 异或  进位  直到左移为0得到结果
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b){
        int sum = 0;
        while (b != 0){
            sum = a^b;
            b = (a&b) << 1;
            a = sum;
        }
        return sum;
    }

    /**
     * 相反数，取反加一
     *
     * 系统最小值取反加一还是自己
     * @param a
     * @return
     */
    public static int negNum(int a){
        return add(~a , 1);
    }

    /**
     * a+b的相反数
     * @param a
     * @param b
     * @return
     */
    public static int minus(int a,int b){
        return add(a, negNum(b));
    }



}
