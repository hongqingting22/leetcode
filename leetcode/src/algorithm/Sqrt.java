package algorithm;

/**
 * 二分法求平方根
 */
public class Sqrt {
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
        int i = mySqrt(100000000);
        System.out.println(i);
    }
}
