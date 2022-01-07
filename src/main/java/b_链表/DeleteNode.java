package b_链表;

/**
 * @author yang 2021-07-14 14:13
 */
public class DeleteNode {

    //2021-10-9 在公司，有哨兵的版本，推荐使用
    public ListNode deleteNode(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode temp = sentinel;
        while (temp.next.val != val) //当退出循环后，temp.next的val=val
            temp = temp.next;
        temp.next = temp.next.next;
        return sentinel.next;
    }


    public ListNode deleteNode1(ListNode head, int val) {
        ListNode temp = head;
        while (true) {
            if (head.val == val)
                head = head.next;
            if (temp.next == null)
                break;
            else if (temp.next.val == val) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}


/*
剑指 Offer 18. 删除链表的节点
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

示例 1:

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */