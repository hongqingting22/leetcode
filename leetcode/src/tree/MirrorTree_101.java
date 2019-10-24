package tree;
//给定一个二叉树，检查它是否是镜像对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
// 说明:
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
// Related Topics 树 深度优先搜索 广度优先搜索
public class MirrorTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        if(root.left == null && root.right== null)return true;
        if(root.left == null || root.right == null) return false;
        if(root.right.val != root.left.val)return false;
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode r1,TreeNode r2){
        if(r1 == null && r2 == null)return true;
        if(r1 == null || r2 == null)return false;
        return r1.val == r2.val && isMirror(r1.left,r2.right) && isMirror(r1.right,r2.left);
    }
}
