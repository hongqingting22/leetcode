package dp;

/**
 * 给定正整数数组arr[],以及给定的值n，计算可以使用数组内元素组成给定值n的方法数，数组内元素可以任意次使用
 *
 *
 */
public class CoinsExchange {

    public static int method1(int[] arr, int aim){
        if(arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        return exchange(arr, 0, aim);
    }

    /**
     * 暴力法
     * @param arr
     * @param index
     * @param aim
     * @return
     */
    public static int exchange(int[] arr, int index, int aim){
        int res = 0;
        if(index == arr.length){
            return 0 == aim ? 1 : 0;
        }else {
            for(int i = 0;arr[index] * i <= aim;i++){
                res += exchange(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    public static int method2(int[] arr, int aim){
        if(arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        int[][] map = new int[arr.length + 1][aim + 1];
        return exchange(arr, 0, aim, map);
    }

    /**
     * 使用缓存数据--记忆化搜索
     * 例：20,10,5,1   100
     * 使用1个20，或者2个10，则后面两位计算的都是组成80的方法数
     * 因此可以记为map[2][80],则可以减少计算次数
     * @param arr
     * @param index
     * @param aim
     * @param map
     * @return
     */
    public static int exchange(int[] arr, int index, int aim, int[][] map){
        int res = 0;
        if(index == arr.length){
            return 0 == aim ? 1 : 0;
        }else {
            int mapValue = 0;
            for(int i = 0;arr[index] * i <= aim;i++){
                mapValue = map[index + 1][aim - arr[index] * i];
                if(mapValue != 0){
                    res += mapValue == -1 ? 0 : mapValue;
                }else{
                    res += exchange(arr, index + 1, aim - arr[index] * i);
                }
            }
        }
        map[index][aim] = res == 0 ? -1 : 0;
        return res;
    }


}
