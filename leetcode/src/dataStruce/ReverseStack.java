package dataStruce;

import java.util.Stack;

/**
 * 仅用递归，实现将栈逆转，不能使用其他数据结构
 */
public class ReverseStack {

    /**
     * 拿到并移除栈低元素
     *
     * 利用递归时产生的  函数栈
     * @param stack
     * @return
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        Integer pop = stack.pop();
        if(stack.isEmpty()){
            return pop;
        }else{
            int result = getAndRemoveLastElement(stack);
            stack.push(pop);
            return result;
        }

    }

    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty())return;
        int e = getAndRemoveLastElement(stack);
        reverseStack(stack);
        stack.push(e);
    }
}
