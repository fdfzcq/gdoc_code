import java.util.*;
class BTreeToLinkedList{
  //1
  //2 5
  //0 3 4 6
  public static Collection<LinkedList<Integer>> toLinkedList(Tree t){
    if(t == null){ return null; }
    HashMap<Integer, LinkedList<Integer>> hm =
      new HashMap<Integer, LinkedList<Integer>>();
    hm = populate(t.root, 1, hm);
    return hm.values();
  }
  
  public static HashMap<Integer, LinkedList<Integer>> populate(Node node,
    int height, HashMap<Integer, LinkedList<Integer>> hm){
    LinkedList<Integer> ll =
      hm.containsKey(height) ? hm.get(height) : new LinkedList<Integer>();
    if(node != null){
      ll.add(node.value);
      hm.put(height, ll);
      hm = populate(node.left, height + 1, hm);
      hm = populate(node.right, height + 1, hm);
    }
    return hm;
  }

  public static void printResult(Collection<LinkedList<Integer>> res){
    for(LinkedList<Integer> ll: res){
      StringBuilder sb = new StringBuilder();
      while(ll.size() != 1){
        sb.append(ll.peek());
        ll.pop();
        sb.append(" -> ");
      }
      sb.append(ll.peek());
      System.out.println(sb.toString());
    }
  }

  public static void main(String[] args){
    testCase1();
    testCase2();
  }

  public static void testCase1(){
    System.out.println("Test Case 1:");
    Tree t = new Tree();
    printResult(toLinkedList(t));
  }

  public static void testCase2(){
    System.out.println("Test Case 2:");
    Tree t = new Tree();
    t.add(3);
    t.add(1);
    t.add(4);
    t.add(2);
    t.add(5);
    printResult(toLinkedList(t));
  }

  static class Tree{
    Node root;
    public Tree(){}
    void add(int v){
      if(this.root == null){ this.root = new Node(v); }
      this.root = this.root.add(v);
    }
  }
  static class Node{
    int value;
    Node right;
    Node left;
    public Node(int v){ this.value = v; }
    Node add(int v){
      if(v < this.value){
        this.left = this.left == null? new Node(v) : this.left.add(v);
      } else if(v > this.value){
        this.right = this.right == null ? new Node(v) : this.right.add(v);
      }
      return this;
    }
  }
}
