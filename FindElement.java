import java.util.*;
//singly linked list
//nth to last element
//integers? -> yes
//how big is the list? -> ~100 million entries?
//bruteforce way: get the length of the list, loop through the list, counting the number until Nth element -> O(N)
class FindElement{

  static public void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().trim().split(" ");
    int[] arr = new int[str.length - 1];
    int index = Integer.valueOf(str[0]);
    for(int i=1;i<str.length;i++){
      arr[i-1]=Integer.valueOf(str[i]);
    }
    LinkedList ll = new LinkedList(arr);
    int element = findElement(index, ll);
    System.out.println(element);
  }
  // 1,2,3,4
  public static int findElement(int index, LinkedList ll){
    Node pointer1 = ll.head;
    Node pointer2 = ll.head;
    for(int i=0;i<index-1;i++){
      pointer2 = pointer2.next;
    }
    while(pointer2.next != null){
      pointer1 = pointer1.next;
      pointer2 = pointer2.next;
    }
    return pointer1.data;
  }

  static class LinkedList{
    Node head;
    public LinkedList(int[] arr){
      Node node = new Node(arr[0]);
      this.head = node;
      for(int i=1;i<arr.length;i++){
        node.next = new Node(arr[i]);
        node = node.next;
      }
    }
  }
  static class Node{
    Node next = null;
    int data;
    public Node(int data){ this.data = data; }
  }
}

