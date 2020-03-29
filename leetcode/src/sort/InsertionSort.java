package sort;

/**
 * 插入排序
 */
public class InsertionSort {
    public static int[] sort(int[] arr){
        int length = arr.length;
        for(int i = 1;i< length;i++){
            int current = arr[i];
            int pre = i - 1;
            while (pre >= 0 && arr[pre] > current){//与当前值比较
                arr[pre + 1] = arr[pre];//前一个值后移
                pre--;
            }
            arr[pre + 1] = current;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,2,7,1,9};
        int[] sort = sort(arr);
        for( int i = 0;i<sort.length;i++){
            System.out.println(sort[i]);
        }
    }
}
