import java.util.*;
class SingleLinkedList{
  Node head;

  class Node{
    Node next = null;
    int data;

    public Node(int d) { this.data = d; }

    void appendTail(int n){
      Node newNode = new Node(n);
      Node node = this;
      while(node.next != null){
        node = node.next;
      }
      node.next = newNode;
    }
  }

  public SingleLinkedList(int[] arr){
    head = new Node(arr[0]);
    for(int i=1;i<arr.length;i++) { head.appendTail(arr[i]); }
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().trim().split(" ");
    int[] arr = new int[str.length];
    for(int i=0;i<str.length;i++) { arr[i] = Integer.valueOf(str[i]); }
    SingleLinkedList linkedList = new SingleLinkedList(arr);
    linkedList.deleteNodes(5);
    printList(linkedList);
  }

  public static void printList(SingleLinkedList l){
    Node node = l.head;
    while(node.next != null){
      System.out.println(node.data);
      node = node.next;
    }
    System.out.println(node.data);
  }

  void insertNode(int index, int data){
    Node node = this.head;
    Node newNode = new Node(data);
    for(int i = 0; i < index; i++){
      if(i == index - 1) {
        newNode.next = node.next;
        node.next = newNode;
      }
      node = node.next;
    }
  }

  void deleteNodes(int data){
    Node node = this.head.data == data ? this.head.next : this.head;
    while(node.next != null){
      if(node.next.data == data){
        node.next = node.next.next;
      }
      node = node.next == null ? node : node.next;
    }
  }
}

