package b_链表.双指针;

import b_链表.ListNode;

/**
 * @author yang 2021-07-25 10:19
 */
public class GetIntersectionNode { //浪漫相遇
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA, temp2 = headB;
        while (temp1 != temp2) {
            temp1 = temp1 != null ? temp1.next : headB;
            temp2 = temp2 != null ? temp2.next : headA;
        }
        return temp1;
    }
}

/*
剑指 Offer 52. 两个链表的第一个公共节点
输入两个链表，找出它们的第一个公共节点。
如果两个链表不相交，返回 null。
 */