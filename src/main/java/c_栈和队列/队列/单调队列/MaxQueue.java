package c_栈和队列.队列.单调队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yang 2021-08-07 10:09
 */
public class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque; // 单调队列

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && value >= deque.peekLast())
            deque.removeLast();
        deque.offerLast(value);
    }

    public int pop_front() {
        if (!queue.isEmpty() && queue.peek().equals(deque.peekFirst()))
            deque.removeFirst();
        return queue.isEmpty() ? -1 : queue.poll();
    }
}

/*
剑指 Offer 59 - II. 队列的最大值
请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1

示例 1：
输入:
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
 */