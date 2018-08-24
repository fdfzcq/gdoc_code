import java.util.*;
class QueueFromStacks{
  // queues -> enqueue, dequeue LILO FIFO
  // stack1 -> insert order, stack2 -> reversed
  static class MyQueue{
    Stack<Integer> enqueue;
    Stack<Integer> dequeue;
    public MyQueue(){
      this.enqueue = new Stack<Integer>();
      this.dequeue = new Stack<Integer>();
    }
    void enqueue(int v){
      this.enqueue.push(v);
      this.dequeue.add(enqueue.size() - 1, v);
    }
    int dequeue(){
      int v = dequeue.peek();
      this.dequeue.pop();
      this.enqueue.remove(enqueue.size() - 1);
      return v;
    }
  }

  public static void main(String[] args){
    testCase();
  }

  public static void testCase(){
    System.out.println("Run test case:");
    MyQueue mq = new MyQueue();
    System.out.println("Initializing queue by enqueuing values: ");
    for(int i=1;i<11;i++){ mq.enqueue(i); }
    while(!mq.enqueue.isEmpty()){
      System.out.println("Dequeuing element: " + mq.dequeue());
    }
  }
}
