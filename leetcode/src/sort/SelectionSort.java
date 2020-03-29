package sort;

public class SelectionSort {
    public static int[] sort(int[] arr){
        int temp = 0;
        for(int i = 0;i<arr.length - 1;i++){
            for(int j = i +1;j<=arr.length-1;j++){
                if (arr[i] > arr[j]) {
                    temp = arr[i] ^ arr[j];
                    arr[i] = arr[i] ^ temp;
                    arr[j] = temp ^ arr[j];
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] arr = {3,6,2,7,1,9};
//        int[] sort = sort(arr);
//        for( int i = 0;i<sort.length;i++){
//            System.out.println(sort[i]);
//        }

        int i = 3,j=4;
        int t = i ^ j;
        i = t ^ i;
        j = t ^ j;
        System.out.println(i + ":" + j);
    }
}
