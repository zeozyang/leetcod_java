package c_栈和队列.栈;

import java.util.Stack;

/**
 * @author yang 2021-07-10 15:46
 */
class CQueue {
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
/*
 * 剑指 Offer 09. 用两个栈实现队列
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

