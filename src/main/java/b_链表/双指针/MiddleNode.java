package b_链表.双指针;

import b_链表.ListNode;

/**
 * @author yang 2021-10-12 10:20
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) { //快慢双指针
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

/*
主站 876. 链表的中间结点
给定一个头结点为 head 的非空单链表，返回链表的中间结点。

如果有两个中间结点，则返回第二个中间结点。
 */