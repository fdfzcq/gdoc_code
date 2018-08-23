import java.util.*;
class StackAndQueue{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] strList = sc.nextLine().trim().split(" ");
    int[] arr = new int[strList.length - 1];
    for(int i=1;i<strList.length;i++){ arr[i-1] = Integer.valueOf(strList[i]); }
    if(strList[0].equals("stack")){
      MyStack stack = new MyStack(arr);
      stack.pop();
      stack.push(99);
      printStack(stack);
    } else if(strList[0].equals("queue")) {
      MyQueue queue = new MyQueue(arr);
      queue.poll();
      queue.offer(99);
      printQueue(queue);
    } else {
      System.out.println("operation not supported: " + strList[0]);
    }
  }

  public static void printStack(MyStack stack){
    Node node = stack.head;
    while(node != null){
      System.out.println(node.data);
      node = node.next;
    }
  }

  public static void printQueue(MyQueue queue){
    Node node =queue.head;
    while(node != null){
      System.out.println(node.data);
      node = node.next;
    }
  }

  static class MyStack{
    Node head;
    public MyStack(int[] arr){
      Node node = new Node(arr[0]);
      Node nextNode = null;
      for(int i=1;i<arr.length;i++){
        nextNode = new Node(arr[i]);
        nextNode.next = node;
        node = nextNode;
      }
      this.head = node;
    }

    void pop(){
      this.head = this.head.next;
    }
    
    void push(int data){
      Node newNode = new Node(data);
      newNode.next = this.head;
      this.head = newNode;
    }
  }

  static class MyQueue{
    Node head;
    Node tail;
    public MyQueue(int[] arr){
      Node node = new Node(arr[0]);
      this.head = node;
      for(int i=1;i<arr.length;i++){
        node.next = new Node(arr[i]);
        node = node.next;
      }
      this.tail = node;
    }

    void poll(){
      this.head = this.head.next;
    }

    void offer(int data){
      this.tail.next = new Node(data);
    }
  }

  static class Node{
    Node next = null;
    int data;
    public Node(int data){ this.data = data; }
  }
}
