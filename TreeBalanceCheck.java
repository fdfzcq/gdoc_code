import java.util.*;
class TreeBalanceCheck{

  static class Tree{
    Node root;
    public Tree(int rootValue){ this.root = new Node(rootValue); }
    void add(int value){ this.root = this.root.add(value); }
    boolean isBalance(){
      if(this.root == null){ return false; }
      if(this.root.maxDepth() - this.root.minDepth() > 1){ return false; }
      return true;
    }
  }

  static class Node{
    Node left;
    Node right;
    int data;
    public Node(int data){ this.data = data; }
    Node add(int value){
      if(value > this.data){
        this.right = this.right == null ? new Node(value) : this.right.add(value);
      } else if(value < this.data){
        this.left = this.left == null ? new Node(value) : this.left.add(value);
      }
      return this;
    }
    int maxDepth(){
      int leftMaxDepth = this.left == null ? 0 : this.left.maxDepth();
      int rightMaxDepth = this.right == null ? 0 : this.right.maxDepth(); 
      return 1 + Math.max(leftMaxDepth, rightMaxDepth);
    }
    int minDepth(){
      int leftMinDepth = this.left == null ? 0 : this.left.minDepth();
      int rightMinDepth = this.right == null ? 0 : this.right.minDepth(); 
      return 1 + Math.min(leftMinDepth, rightMinDepth);
    }
  }

  // Tests
  public static void main(String[] args){
    // tree with one node;
    runTestCase1();
    // balanced tree left 1 right 2
    runTestCase2();
    // unbalanced tree left 1 right 3
    runTestCase3();
    // balanced tree left 1,2 right 1,2
    runTestCase4();
  }

  public static void runTestCase1(){
    Tree tree = new Tree(1);
    System.out.println("Test case 1: " + tree.isBalance());
  }

  public static void runTestCase2(){
    Tree tree = new Tree(5);
    tree.add(4);
    tree.add(6);
    System.out.println("Test case 2: " + tree.isBalance());
  }

  public static void runTestCase3(){
    Tree tree = new Tree(5);
    tree.add(4);
    tree.add(6);
    tree.add(7);
    tree.add(8);
    System.out.println("Test case 3: " + tree.isBalance());
  }

  public static void runTestCase4(){
    Tree tree = new Tree(5);
    tree.add(2);
    tree.add(1);
    tree.add(3);
    tree.add(4);

    tree.add(7);
    tree.add(6);
    tree.add(8);
    tree.add(9);

    System.out.println("Test case 4: " + tree.isBalance());
  }
}
