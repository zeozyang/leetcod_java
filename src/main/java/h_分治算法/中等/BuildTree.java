package h_分治算法.中等;

import e_树.TreeNode;

import java.util.HashMap;

/**
 * @author yang 2021-07-27 14:08
 */
public class BuildTree {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i : inorder)
            map.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }

    TreeNode recur(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) return null; // 相等的话就是自己
        TreeNode root = new TreeNode(preorder[pre_root]);//获取root节点
        int idx = map.get(preorder[pre_root]); // 获取在中序遍历中根节点所在索引，以方便获取左子树的数量
        root.left = recur(pre_root + 1, in_left, idx - 1);
        root.right = recur(pre_root + (idx - in_left) + 1, idx + 1, in_right);
        return root;
    }
}

/*
剑指 Offer 07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。

假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */