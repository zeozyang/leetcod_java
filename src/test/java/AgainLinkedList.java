import b_链表.ListNode;

/**
 * @author yang 2021-10-09 9:32
 */
public class AgainLinkedList {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode temp = sentinel;
        while (temp.next.val != val)
            temp = temp.next;
        temp.next = temp.next.next;
        return sentinel.next;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a.next != null ? a.next : headB;
            b = b.next != null ? b.next : headA;
        }
        return a;
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode latter = head, former = head;
        for (int i = 0; i < k; i++)
            former = former.next;
        while (former != null) {
            latter = latter.next;
            former = former.next;
        }
        return latter;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode temp = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return sentinel.next;
    }


    public ListNode reverseList(ListNode head) {
        return recur(null, head);
    }
    private ListNode recur(ListNode pre, ListNode cur) {
        if (cur == null) return pre;
        ListNode res = recur(cur, cur.next);
        cur.next = pre;
        return res;
    }
}
