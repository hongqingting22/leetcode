package zuolaoshi;

/**
 * 给定树的后序遍历数组arr，求原树结构
 */
public class ArrToTree {

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node process(int[] arr){
        return process(arr, 0, arr.length - 1);
    }

    /**
     * 时间复杂度O(n^2)
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public Node process(int[] arr,int left, int right){
        if(left >  right){
            return null;
        }
        Node node = new Node(arr[right]);
        if(left == right)return node;
        //计算出左子树的头节点在数组中的下标
        int mid = left - 1;//可能出现所有值都比头节点大或者都比头节点小
        for(int i = left;i< right;i++){
            if(arr[i] < arr[right]){
                mid = i;
            }
        }
        node.left = process(arr, left, mid);
        node.right = process(arr, mid + 1, right - 1);
        return node;
    }

    /**
     * NLog2N
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public Node process2(int[] arr,int left, int right){
        if(left >  right){
            return null;
        }
        Node node = new Node(arr[right]);
        if(left == right)return node;
        //计算出左子树的头节点在数组中的下标
        //二分搜索查找，log2N
        int mid = left - 1;
        int l = left;
        int r = right;
        while (l <= r){
            int middle = l + (r - l) >> 1;
            if(arr[middle] > arr[right]){
                r = mid - 1;
            }else{
                mid = middle;
                l = mid + 1;
            }
        }
        node.left = process2(arr, left, mid);
        node.right = process2(arr, mid + 1, right - 1);
        return node;
    }
}
