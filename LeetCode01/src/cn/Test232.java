package cn;

import org.junit.Test;

import java.util.Stack;

/**
 * 仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 */
public class Test232 {

    private Stack<Integer> stack1;//临时
    private Stack<Integer> stack2;//总的
    public Test232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * 将元素 x 推到队列的末尾
     * @param x
     */
    public void push(int x) {
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        stack2.push(x);

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    /**
     * 从队列的开头移除并返回元素
     * @return
     */
    public int pop() {
        return  stack2.pop();
    }

    /**
     *  返回队列开头的元素
     * @return
     */
    public int peek() {
       return stack2.peek();
    }

    /**
     * 如果队列为空，返回 true ；否则，返回 false
     * @return
     */
    public boolean empty() {
        return stack2.isEmpty();
    }

    public void printStack(){
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop()+" ");
        }
        System.out.println();
    }


    @Test
    public void test(){
        Test232 test232 = new Test232();
        test232.push(1);
        test232.push(2);
        test232.push(3);

        test232.printStack();
    }
}



/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */