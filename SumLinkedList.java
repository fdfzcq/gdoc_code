import java.util.*;
class SumLinkedList{
  public static LinkedList<Integer> mergeLists(LinkedList<Integer> l1, LinkedList<Integer> l2){
    LinkedList<Integer> l = new LinkedList<Integer>();
    while(l1.peek() != null){
     int v1 = l1.peek();
     int v2 = l2.peek();
     l.add((v1 + v2) % 10);
     l1.pop();
     l2.pop();
    }
    return l;
  }

  public static void main(String[] args){
    runTestCase1();
    runTestCase2();
    runTestCase3();
  }

  public static void printList(LinkedList l){
    StringBuffer sb = new StringBuffer();
    for(int i=0;i<l.size();i++){
      if(i == l.size()-1){
        sb.append(l.get(i));
      } else {
        sb.append(l.get(i) + " -> ");
      }
    }
    System.out.println(sb.toString());
  }

  public static void runTestCase1(){
    LinkedList<Integer> l1 = new LinkedList<Integer>();
    LinkedList<Integer> l2 = new LinkedList<Integer>();
    LinkedList<Integer> l = mergeLists(l1, l2);
    printList(l);
  }

  public static void runTestCase2(){
    LinkedList<Integer> l1 = new LinkedList<Integer>();
    l1.add(2);
    l1.add(3);
    l1.add(5);
    LinkedList<Integer> l2 = new LinkedList<Integer>();
    l2.add(1);
    l2.add(4);
    l2.add(2);
    LinkedList<Integer> l = mergeLists(l1, l2);
    printList(l);
  }

  public static void runTestCase3(){
    LinkedList<Integer> l1 = new LinkedList<Integer>();
    l1.add(2);
    l1.add(2);
    l1.add(1);
    l1.add(6);
    LinkedList<Integer> l2 = new LinkedList<Integer>();
    l2.add(8);
    l2.add(7);
    l2.add(2);
    l2.add(6);
    LinkedList<Integer> l = mergeLists(l1, l2);
    printList(l);
  }
}
