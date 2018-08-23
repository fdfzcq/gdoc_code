import java.util.*;
class DeleteNodeLinkedList{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().trim().split(" ");
    int nodeToDelete = Integer.valueOf(str[0]);
    int[] arr = new int[str.length - 1];
    for(int i=1;i<str.length;i++){ arr[i-1] = Integer.valueOf(str[i]);}
    LinkedList ll = new LinkedList(arr);
    Node nodeTD = ll.findNode(nodeToDelete);
    nodeTD.deleteNode();
    printList(ll);
  }

  public static void printList(LinkedList ll){
    Node node = ll.head;
    while(node != null){
      System.out.println(node.data);
      node = node.next;
    }
  }

  static class LinkedList{
    Node head;
    public LinkedList(int[] arr){
      if(arr.length == 0){
        this.head = null;
      } else {
        Node node = new Node(arr[0]);
        this.head = node;
        for(int i=1; i<arr.length;i++){
          node.next = new Node(arr[i]);
          node = node.next;
        }
      }
    }
    Node findNode(int value){
      Node node = this.head;
      while(node != null){
        if(node.data == value){ return node; }
        node = node.next;
      }
      return null;
    }
  }
  static class Node{
    Node next = null;
    int data;
    public Node(int data){ this.data = data; }
    void deleteNode(){
      Node node = this;
      while(node != null && node.next != null){
        node.data = node.next.data;
        node.next = node.next.next == null ? null : node.next;
        node = node.next;
      }
    }
  }
}
