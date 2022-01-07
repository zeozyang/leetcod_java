import b_链表.ListNode;

import java.util.*;

/**
 * @author yang 2021-10-12 11:20
 */
public class AgainStackAndQueue {

    static class CQueue {
        Stack<Integer> a, b;

        public CQueue() {
            a = new Stack<>();
            b = new Stack<>();
        }

        public void appendTail(int value) {
            a.push(value);
        }

        public int deleteHead() {
            if (b.isEmpty()) {
                while (!a.isEmpty())
                    b.push(a.pop());
            }
            return b.isEmpty() ? -1 : b.pop();
        }
    }


    static class MinStack {
        Stack<Integer> data, min;

        public MinStack() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if (min.isEmpty() || x <= min.peek())
                min.push(x);
        }

        public void pop() {
            if (data.pop().equals(min.peek()))
                min.pop();
        }

        public int top() {
            return data.peek();
        }

        public int min() {
            return min.peek();
        }
    }


    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = stack.pop();

        return res;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n = 0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[n]) {
                stack.pop();
                n++;
            }
        }
        return stack.isEmpty();
    }


    static class MaxQueue {
        Queue<Integer> queue;
        Deque<Integer> deque;

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public int max_value() {
            return deque.isEmpty() ? -1 : deque.peekFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            while (!deque.isEmpty() && deque.peekLast() < value)
                deque.removeLast();
            deque.offerLast(value);
        }

        public int pop_front() {
            if (!deque.isEmpty() && Objects.equals(queue.peek(), deque.peekFirst()))
                deque.removeFirst();
            return queue.isEmpty() ? -1 : queue.remove();
        }
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>(); // nums2的中的每个元素一个键，对应的值为其右边第一个更大的元素
        Stack<Integer> stack = new Stack<>();

        for (int i : nums2) {
            while (!stack.isEmpty() && stack.peek() < i)
                map.put(stack.pop(), i);
            stack.push(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++)
            res[i] = map.getOrDefault(nums1[i], -1);
        return res;
    }
}


