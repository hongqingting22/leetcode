package dataStruce;

import java.util.Stack;

/**
 * 实现一个栈，满足栈所有操作，且需要加一个方法：返回栈中最小值
 * 思路1：使用两个栈，一个为data栈，一个为min栈，
 *          两个栈同步入栈和出栈，
 *          但是min栈入栈的是栈顶元素与入栈元素中较小的值
 * 思路2：使用两个栈，一个为data栈，一个为min栈，
 *          data入栈值，如果比min栈顶大，则不入栈，小于等于则入栈
 *          data出栈时，如果出栈
 */
public class StackDemo {

    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public Integer push(Integer item){
        dataStack.push(item);
        if(minStack.isEmpty() || minStack.peek() >= item){
            minStack.push(item);
        }
        return item;
    }

    public Integer pop(){
        Integer pop = dataStack.pop();
        if(pop == minStack.peek()){
            minStack.pop();
        }
        return pop;
    }

    public Integer peekMin(){
       return minStack.peek();
    }


    public static void main(String[] args) {
        StackDemo demo = new StackDemo();
        demo.push(2);
        demo.push(4);
        Integer integer = demo.peekMin();
        System.out.println(integer);
        demo.push(1);
        Integer integer1 = demo.peekMin();
        System.out.println(integer1);
        demo.push(1);
        demo.pop();
        integer1 = demo.peekMin();
        System.out.println(integer1);
        demo.pop();
        integer1 = demo.peekMin();
        System.out.println(integer1);
    }
}
