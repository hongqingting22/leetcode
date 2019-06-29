package array;

import java.util.Collections;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinPathTriggle_120 {

    /**
     * 暴力法
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }

        int min = minPath(triangle,0,0);

        return min;
    }

    /**
     * 动态规划
     * @param triangle
     * @return
     *  * [
     *  *      [2],
     *  *     [3,4],
     *  *    [6,5,7],
     *  *   [4,1,8,3]
     *  * ]
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        for(int i = triangle.size()-2;i>=0;i--){
            for(int j = 0;j<triangle.get(i).size();j++){
                int min = Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                min += triangle.get(i).get(j);
                triangle.get(i).set(j,min);
            }
        }
        return triangle.get(0).get(0);
    }

    /**
     * [
     *       [2],
     *     [3,4],
     *   [6,5,7],
     * [4,1,8,3]
     * ]
     * @param triangle
     * @param i
     * @param j
     * @return
     */
    private int minPath(List<List<Integer>> triangle,int i,int j){
        if(i == triangle.size()-1){
            return triangle.get(i).get(j);
        }

        Integer left = minPath(triangle,i+1,j);
        Integer right = minPath(triangle,i+1,j+1);
        int min = Math.min(left, right);

        return triangle.get(i).get(j) + min;

    }
}
