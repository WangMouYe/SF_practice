package com.example.demo.queueAndStack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 *
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 */
public class implementQueueUsingStacks {

}
class MyQueue {
    private Deque<Integer> s1;
    private Deque<Integer> s2;
    private int front = 0;

    public MyQueue() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    public void push(int x) {
        //如果s1为空,则x作为队首
        if (s1.isEmpty()){
            front = x;
        }

        s1.push(x);
    }

    public int pop() {
        //先检查s2是否为空,如果为空,弹出的是s1的栈底,非空,弹出s2的栈顶
        if (s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public int peek() {
        if (!s2.isEmpty()){
            return s2.peek();
        }
        return front;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
