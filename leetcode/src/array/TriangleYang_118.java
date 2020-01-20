package array;
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
//
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
//
// 示例:
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// Related Topics 数组
//leetcode submit region end(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

public class TriangleYang_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows == 0)return list;
        list.add(new ArrayList<>());
        list.get(0).add(1);
        for(int i = 1;i<numRows;i++){
            List<Integer> rowList = new ArrayList<>();
            List<Integer> integers = list.get(i - 1);
            rowList.add(1);
            for(int j = 1;j < i;j++){
                rowList.add(integers.get(j-1) + integers.get(j));
            }
            rowList.add(1);
            list.add(rowList);
        }
        return list;
    }
}
