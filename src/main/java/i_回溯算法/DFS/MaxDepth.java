package i_回溯算法.DFS;

import e_树.TreeNode;

/**
 * @author yang 2021-08-08 9:12
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) { // 动态规划，满足最优子结构
        if (root == null) return 0;
        // 递推工作：本质上是对树做后序遍历。
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

/*
剑指 Offer 55 - I. 二叉树的深度
输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */