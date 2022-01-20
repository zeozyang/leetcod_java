import e_树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang 2022-01-17 17:17
 */
public class AgainDFS {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
    /*
    剑指 Offer 26. 树的子结构
    输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     */


    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    boolean isSymmetric(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        else if (A == null || B == null || A.val != B.val) return false;
        else return isSymmetric(A.left, B.right) && isSymmetric(A.right, B.left);
    }
    /*
    剑指 Offer 28. 对称的二叉树
    请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     */


    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    boolean exist(char[][] board, String word, int ini, int inj, int ink) {
        if (ini < 0 || ini >= board.length || inj >= board[0].length || inj < 0 || board[ini][inj] != word.charAt(ink))
            return false;
        if (ink == word.length() - 1) return true;
        board[ini][inj] = '\0';
        boolean res = exist(board, word, ini, inj - 1, ink + 1)
                || exist(board, word, ini, inj + 1, ink + 1)
                || exist(board, word, ini - 1, inj, ink + 1)
                || exist(board, word, ini + 1, inj, ink + 1);
        board[ini][inj] = word.charAt(ink);
        return res;
    }
    /*
    剑指 Offer 12. 矩阵中的路径
    https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
    给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word存在于网格中，返回 true ；否则，返回 false 。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
    例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
    */

    public int KthLargest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(list.size() - k);
    }

    void inOrder(TreeNode root, List<Integer> list) {
        if (root.left != null)
            inOrder(root.left, list);
        list.add(root.val);
        if (root.right != null)
            inOrder(root.right, list);
    }
    /*
    剑指 Offer 54. 二叉搜索树的第k大节点
    给定一棵二叉搜索树，请找出其中第k大的节点。
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val || q.val == root.val) return root;
        else if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
    /*
    剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    所有节点的值都是唯一的。
    p、q 为不同节点且均存在于给定的二叉搜索树中。
    */

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val == root.val || q.val == root.val) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
    /*
    剑指 Offer 68 - II. 二叉树的最近公共祖先
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    所有节点的值都是唯一的。
    p、q 为不同节点且均存在于给定的二叉树中。
     */

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
    /*
    剑指 Offer 55 - I. 二叉树的深度
    输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
    */

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(root.left);
        return root;
    }
    /*
    剑指 Offer 27. 二叉树的镜像
    请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     */
}


