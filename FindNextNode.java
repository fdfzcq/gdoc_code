import java.util.*;
class FindNextNode{
  static class BinarySearchTree{
    Node root;
    public BinarySearchTree(){}
    void add(int v){
      if(root == null){
        this.root = new Node(v);
      } else {
        this.root.add(v);
      }
    }
    Node next(int v){
      if(this.root == null){ return null; }
      Node node = this.root.search(v);
      if(node == null){ return null; }
      // case 1: left child node wo right child -> parent
      // case 2: parent with right child -> right
      // case 3: right child node wo children ->
      //           if parent <<< grandparent -> grandparent
      //           else null
      if(node.parent == null){
        // loop through all the possible numbers > node.value
        // assume all the values are smaller than 100
        for(int i = node.value + 1;i < 100;i++){
          if(node.search(i) != null){ return node.search(i); }
        }
        return null;
      }
      int pValue = node.parent.value;
      if(pValue > node.value){
        for(int i = node.value + 1;i<pValue;i++){
          if(node.search(i) != null){ return node.search(i); }
        }
        return node.parent;
      }
      if(pValue < node.value){
        Node parent = node.parent;
        while(parent != null && parent.value < node.value){
          parent = parent.parent;
        }
        if(parent == null){return null;}
        for(int i = node.value + 1;i<parent.value;i++){
          if(node.search(i) != null){ return node.search(i); }
        }
        return parent;
      }
      return null;
    }
  }

  static class Node{
    int value;
    Node parent;
    private Node left;
    private Node right;
    public Node(int v){ this.value = v; }
    void add(int v){
      if(v < this.value){
        if(this.left == null){
          this.left = new Node(v);
          this.left.parent = this;
        } else {
          this.left.add(v);
        }
      } else if(v > this.value){
        if(this.right == null){
          this.right = new Node(v);
          this.right.parent = this;
        } else {
          this.right.add(v);
        }
      }
    }

    Node search(int v){
      if(v < this.value){
        return this.left == null ? null : this.left.search(v);
      } else if(v > this.value){
        return this.right == null ? null : this.right.search(v);
      } else { return this; }
    }
  }

  public static void main(String[] args){
    testCase1();
    testCase2();
    testCase3();
    testCase4();
  }

  public static void testCase1(){
    System.out.println("Test Case 1:");
    BinarySearchTree t = new BinarySearchTree();
    System.out.println(t.next(1));
  }

  public static void testCase2(){
    System.out.println("Test Case 2:");
    BinarySearchTree t = new BinarySearchTree();
    t.add(5);
    t.add(1);
    t.add(6);
    System.out.println(t.next(5).value);
  }

  public static void testCase3(){
    System.out.println("Test Case 3:");
    BinarySearchTree t = new BinarySearchTree();
    t.add(5);
    t.add(3);
    t.add(1);
    t.add(4);
    System.out.println(t.next(5));
    System.out.println(t.next(3).value);
    System.out.println(t.next(1).value);
    System.out.println(t.next(4).value);
  }

  public static void testCase4(){
    System.out.println("Test Case 4:");
    BinarySearchTree t = new BinarySearchTree();
    t.add(10);
    t.add(3);
    t.add(5);
    t.add(7);
    t.add(12);
    t.add(14);
    t.add(11);
    System.out.println(t.next(7).value);
    System.out.println(t.next(14));
  }
}
