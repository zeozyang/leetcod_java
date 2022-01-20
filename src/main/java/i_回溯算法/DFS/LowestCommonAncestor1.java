package i_回溯算法.DFS;

import e_树.TreeNode;

/**
 * @author yang 2021-07-27 9:18 于22-1-19 9:39 重写
 */
public class LowestCommonAncestor1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val) return p;
        else if (q.val == root.val) return q;
        else if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}

/*
剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉搜索树中。
 */