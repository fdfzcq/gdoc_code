import java.util.*;
class LinkedListRemoveDuplicates{
   public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     String[] str = sc.nextLine().trim().split(" ");
     int[] arr = new int[str.length];
     for(int i=0;i<str.length;i++){ arr[i] = Integer.valueOf(str[i]); }
     LinkedList linkedList = new LinkedList(arr);
     linkedList.removeDuplicates();
     printList(linkedList);
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
    Node end;

    // 1 -> 2 -> 3 -> 4 -> 1 O(N^2)
    // external buffer O(N) -> HashTable O(1) ~ O(N)
    //                                      if values < 64, bit operations 
    void removeDuplicates(){
      Node node = this.head;
      Hashtable<Integer, Boolean> hm = new Hashtable<Integer, Boolean>();
      while(node.next != null){
        hm.put(node.data, true);
        if(hm.containsKey(node.next.data)){
          node.next = node.next.next;
        } else {
          node = node.next;
        }
      }
    }
    
    public LinkedList(int[] arr){
      Node node = new Node(arr[0]);
      head = node;
      for(int i=1;i<arr.length;i++){
        node.next = new Node(arr[i]);
        node.next.prev = node;
        node = node.next;
      }
      end = node;
    }
  }

  static class Node{
       Node next = null;
       Node prev = null;
       int data;
       public Node(int data) { this.data = data; };
       void appendTail(int data) {
         Node newNode = new Node(data);
         Node node = this;
         while(node.next != null){ node = node.next; }
         node.next = newNode;
         node.next.prev = node;
       }
    }
}
