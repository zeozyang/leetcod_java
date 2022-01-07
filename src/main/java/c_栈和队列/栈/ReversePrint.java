package c_栈和队列.栈;

import b_链表.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author yang 2021-07-10 21:52
 */
public class ReversePrint {
    /*
    递归法
     */
    ArrayList<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }

    void recur(ListNode head) {
        if (head == null) return;
        recur(head.next);
        list.add(head.val);
    }

    /*
    辅助栈法
     */
    Stack<Integer> stack = new Stack<>();

    public int[] reversePrint2(ListNode head) {
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] re = new int[stack.size()];
        for (int i = 0; i < re.length; i++)
            re[i] = stack.pop();
        return re;
    }
}


/*
剑指 Offer 06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]

Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 */