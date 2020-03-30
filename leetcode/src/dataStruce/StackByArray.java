package dataStruce;

import java.util.Arrays;

/**
 * 数组实现栈
 */
public class StackByArray {

    private Integer initCap = 8;
    int[] arr = new int[8];
    int size = 0;

    public int push(int item){
        if(size >= arr.length){
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[size++] = item;
        return item;
    }

    public int pop(){
        if(size == 0)throw new RuntimeException("stack null");
        return arr[--size];
    }

    public int peek(){
        if(size == 0)throw new RuntimeException("stack null");
        return arr[size - 1];
    }

    public boolean isEmpty(){
        return size == 0;
    }



    public static void main(String[] args) {
        StackByArray stack = new StackByArray();
        stack.push(1);
        stack.push(2);
        System.out.println(stack);
        int peek = stack.peek();
        System.out.println(peek);
        System.out.println(stack);
        int pop = stack.pop();
        System.out.println(pop);
        System.out.println(stack);

    }

    @Override
    public String toString() {
        return "StackByArray{" +
                "initCap=" + initCap +
                ", arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }
}
