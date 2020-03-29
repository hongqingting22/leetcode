package sort;

/**
 * 归并排序
 * 将列表分为2段，合并左右两侧
 */
public class MergeSort {

    public void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[arr.length];
        int p1 = left, p2 = mid + 1, k = left;
        while(p1 <= mid && p2 <= right){
            if(arr[p1] >= arr[p2]){
                temp[k++] = arr[p2++];
            }else{
                temp[k++] = arr[p1++];
            }
        }

        while (p1 <= mid)temp[k++] = arr[p1++];
        while (p2 <= right)temp[k++] = arr[p2++];
        for(int i = left;i<= right;i++){
            arr[i] = temp[i];
        }
    }

    public void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (right + left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void sort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {3,6,2,7,1,9};
        new MergeSort().sort(arr);
        for( int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }


}
