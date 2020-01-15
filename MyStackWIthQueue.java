package Day4;

import java.util.LinkedList;

public class MyStackWithQueue {
    // A 始终是用来入栈的, B 始终是空的(辅助取栈顶元素和出栈的)
    private LinkedList<Integer> A = new LinkedList<>();
    private LinkedList<Integer> B = new LinkedList<>();

    /** Push element x onto stack. */
    public void push(int x) {
        A.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // 需要先把 A 中的元素往 B 中倒腾, 一直到 A 中只剩一个元素
        // 就可以真正出栈了.
        // 最后要互换 A 和 B
        // 空栈的情况, 直接返回
        if (A.isEmpty()) {
            return 0;
        }
        while (A.size() > 1) {
            int cur = A.removeFirst();
            B.addLast(cur);
        }
        // 最终要出栈的元素
        int ret = A.removeFirst();
        // 交换 AB
        swapAB();
        return ret;
    }

    private void swapAB() {
        LinkedList<Integer> tmp = A;
        A = B;
        B = tmp;
    }

    /** Get the top element. */
    public int top() {
        // 需要先把 A 中的元素往 B 中倒腾, 一直到 A 中只剩一个元素
        // 就可以真正出栈了.
        // 最后要互换 A 和 B
        // 空栈的情况, 直接返回
        if (A.isEmpty()) {
            return 0;
        }
        while (A.size() > 1) {
            int cur = A.removeFirst();
            B.addLast(cur);
        }
        // 最终要出栈的元素
        int ret = A.removeFirst();
        B.addLast(ret);
        // 交换 AB
        swapAB();
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty();
    }
}


