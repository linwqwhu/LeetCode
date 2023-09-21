package cn;

import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class Test225 {
    private ArrayDeque<Integer> queue1;
    private ArrayDeque<Integer> queue2;


    public Test225() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public void push(int x) {
        while(!queue2.isEmpty())
            queue1.add(queue2.poll());
        queue2.add(x);
        while(!queue1.isEmpty())
            queue2.add(queue1.poll());
    }

    public int pop() {
        return queue2.poll();
    }

    public int top() {
        return queue2.peek();
    }

    public boolean empty() {
        return queue2.isEmpty();
    }

    public void print(){
        while (!queue2.isEmpty()){
            System.out.print(queue2.poll()+" ");
        }
        System.out.println();
    }
    @Test
    public void test(){
        Test225 test225 = new Test225();
        test225.push(3);

        print();
    }

}
