package b_链表.双指针;

import b_链表.ListNode;

/**
 * @author yang 2021-10-12 9:52
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) { //快慢双指针
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}

/*
主站 141. 环形链表
给定一个链表，判断链表中是否有环。

如果链表中存在环，则返回 true 。 否则，返回 false 。
 */