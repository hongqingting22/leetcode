package exam;

import java.util.Arrays;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//
//
// 示例 1：
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 限制：
//
//
// 0 <= matrix.length <= 100
// 0 <= matrix[i].length <= 100
//
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
// Related Topics 数组
public class M29_shunshizhendayinjuzhen {
    public static int[] spiralOrder(int[][] matrix) {
        int high = matrix.length;
        int len = matrix[0].length;
        int[] result = new int[len * high];
        int l = 0,r = len - 1,t = 0,b = high - 1,x = 0;
        while (true){
            for(int i = l;i<= r;i++)result[x++] = matrix[t][i];
            if(b < t++)break;
            for(int i = t;i <= b;i++)result[x++] = matrix[i][r];
            if(l > r--)break;
            for(int i = r;i >=l;i--)result[x++] = matrix[b][i];
            if(t > b--)break;
            for(int i = b; i >= t;i--)result[x++] = matrix[i][l];
            if(r < l++)break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] result = spiralOrder(arr);
        System.out.println(Arrays.toString(result));
    }
}
