package dataStruce;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 队列实现栈
 * @param <T>
 */
public class StackByQueue<T> extends Stack<T> {

    Queue<T> queue1 = new LinkedList<>();
    Queue<T> queue2 = new LinkedList<>();

    @Override
    public T push(T item) {
        if(queue1.isEmpty()){
            queue2.add(item);
        }else{
            queue1.add(item);
        }
        return item;
    }

    @Override
    public synchronized T pop() {
        if(queue1.isEmpty() && queue2.isEmpty()){
            return null;
        }
        if(queue1.isEmpty()){
            int size = queue2.size();
            for(int i = 1;i<size;i++){
                T poll = queue2.poll();
                queue1.add(poll);
            }
            return queue2.poll();
        }else {
            int size = queue1.size();
            for(int i = 1;i<size;i++){
                T poll = queue1.poll();
                queue2.add(poll);
            }
            return queue1.poll();
        }
    }

    @Override
    public synchronized T peek() {
        if(queue1.isEmpty() && queue2.isEmpty()){
            return null;
        }
        if(queue1.isEmpty()){
            int size = queue2.size();
            T poll = null;
            for(int i = 0;i<size;i++){
                poll = queue2.poll();
                queue1.add(poll);
            }
            return poll;
        }else {
            int size = queue1.size();
            T poll = null;
            for(int i = 1;i<size;i++){
                poll = queue1.poll();
                queue2.add(poll);
            }
            return poll;
        }
    }

    @Override
    public boolean isEmpty() {
        return queue2.isEmpty() && queue1.isEmpty();
    }

//    @Override
//    public String toString(){
//
//    }

    public static void main(String[] args) {
        StackByQueue<Integer> stack = new StackByQueue();
        stack.push(1);

        stack.push(2);
        System.out.println(stack.isEmpty());
        Integer pop = stack.pop();
        System.out.println(pop);
        stack.push(3);
        Integer pop1 = stack.pop();
        System.out.println(pop1);
        Integer pop2 = stack.pop();
        System.out.println(pop2);
        System.out.println(stack.isEmpty());
    }
}
