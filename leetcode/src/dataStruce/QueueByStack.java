package dataStruce;

import java.util.Stack;

/**
 * 栈实现队列
 * @param <T>
 */
public class QueueByStack<T> {

    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    public Integer push(int item){
        if(dataStack.isEmpty()){
            dataStack.push(item);
        }else{
            while (!dataStack.isEmpty()){
                stack.push(dataStack.pop());
            }
            dataStack.push(item);
            while (!stack.isEmpty()){
                dataStack.push(stack.pop());
            }
        }
        return item;
    }

    public Integer pop(){
        return dataStack.pop();
    }

    public boolean isEmpty(){
        return dataStack.isEmpty();
    }

    public static void main(String[] args) {
        QueueByStack<Integer> queue = new QueueByStack<>();
        queue.push(1);

        queue.push(2);
        System.out.println(queue.isEmpty());
        Integer pop = queue.pop();
        System.out.println(pop);
        queue.push(3);
        Integer pop1 = queue.pop();
        System.out.println(pop1);
        Integer pop2 = queue.pop();
        System.out.println(pop2);
        System.out.println(queue.isEmpty());
    }
}
