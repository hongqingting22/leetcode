package sort;

/**
 * 快速排序
 * 思想：分治法
 * 1）以某个元素为基准点，在元素列表中，找到该基准点的位置，
 *      达到基准点左边都小于基准点元素，基准点右边都大于基准点元素
 * 2）分别在左右两侧，再次执行1
 *
 */
public class QuickSort {
    public void sort(int[] arr) {
        quickSort(arr,0, arr.length-1);
    }

    public void quickSort(int[] arr, int start, int end){
        if(start < end){
            int index = getIndex(arr, start, end);
             quickSort(arr, start, index);
             quickSort(arr, index +1, end);
        }
    }

    public int getIndex(int[] arr, int start, int end){
        int temp = arr[start];
        while (start < end){
            while (start < end && arr[end] > temp){
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] < temp){
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = temp;
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,2,7,1,9};
        new QuickSort().sort(arr);
        for( int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
