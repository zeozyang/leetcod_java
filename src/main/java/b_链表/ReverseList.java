package b_链表;

/**
 * @author yang 2021-07-14 13:51
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode a = null, b, temp = head;
        while (temp != null) {
            b = temp.next;
            temp.next = a;

            a = temp;
            temp = b;
        }
        return a;
    }


    public ListNode reverseList1(ListNode head) {
        return recur(null, head);
    }
    private ListNode recur(ListNode pre, ListNode cur) {
        if (cur == null) return pre;
        ListNode res = recur(cur, cur.next);
        cur.next = pre;
        return res;
    }
}

/*
剑指 Offer 24. 反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 */