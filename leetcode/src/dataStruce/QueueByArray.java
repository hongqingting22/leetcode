package dataStruce;

public class QueueByArray {
    int[] data;
    int head;
    int tail;
    int len;
    int size;

    public QueueByArray( int size) {
        this.data = new int[size];
        this.head = 0;
        this.tail = 0;
        this.len = 0;
        this.size = size;
    }

    public int push(int item){
        if(isFull())throw new RuntimeException("queue full");
        if(tail + 1 > size){
            tail = 0;
            data[tail] = item;
        }else{
            data[tail++] = item;
        }
        len++;
        return item;
    }

    public int pop(){
        if(isEmpty())throw new RuntimeException("queue empty");
        if(head == 0){

        }
        int datum = data[head--];
        len--;
        return datum;

    }

    public int peek(){
        if(isEmpty())throw new RuntimeException("queue empty");
        int datum = data[head];
        return datum;
    }

    public boolean isEmpty(){
        return len == 0;
    }

    public boolean isFull(){
        return len == size;
    }

    public static void main(String[] args) {
        QueueByArray queue = new QueueByArray(8);
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
