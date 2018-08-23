import java.util.*;
class BinaryTree{
  public static void main(String[] args){
    Tree tree = new Tree();
    Random rn = new Random();
    tree.traverseInOrder();
    tree.deleteNode(Math.abs(rn.nextInt()) % 14);
    //tree.traversePreOrder();
    //tree.traversePostOrder();
    //tree.traverseInsertOrder(rn.nextInt() % 20);
  }

  static class Tree{
    Node root;

    public Tree(){
      Node node = new Node(7);
      Random rn = new Random();
      for(int i=0;i<70;i++){
        node.add(Math.abs(rn.nextInt()) % 14);
      }
      this.root = node;
    }

    void deleteNode(int n){
      System.out.println("Removing node " + n + " from tree");
      if(this.root != null){ this.root = this.root.delete(n); }
      this.traverseInOrder();
    }

    void traverseInOrder(){
      System.out.println("Traverse the tree in-order:");
      this.root.traverseInOrder();
    }

    void traversePreOrder(){
      System.out.println("Traverse the tree pre-order:");
      this.root.traversePreOrder();
    }

    void traversePostOrder(){
      System.out.println("Traverse the tree post-order:");
      this.root.traversePostOrder();
    }

    void traverseInsertOrder(int n){
      System.out.println("Traverse insert order with value: " + n);
      if(this.root == null){
        this.root = new Node(n);
      } else {
        this.root.add(n);
      }
    }
  }

  static class Node{
    Node left;
    Node right;
    int data;
    public Node(int data){ this.data = data; }
    
    void add(int value){
      if(value > this.data){
        System.out.println("right: " + this.data);
        if(this.right == null){
          this.right = new Node(value);
        } else {
          this.right.add(value);
        }
      } else if(value < this.data){
        System.out.println("left: " + this.data);
        if(this.left == null){
          this.left = new Node(value);
        } else {
          this.left.add(value);
        }
      }
    }

    


    Node delete(int value){
      if(value > this.data){
        this.right =this.right == null ? null : this.right.delete(value);
      } else if(value < this.data){
        this.left = this.left == null ? null : this.left.delete(value);
      } else {
        if(this.right == null){ return this.left; }
        if(this.left == null){ return this.right; }
        this.data = this.right.left == null ? this.right.data : this.right.left.data;
        if(this.right.left == null){
          this.data = this.right.data;
          this.right = this.right.delete(this.data);
        } else {
          this.data = this.right.left.data;
          this.right.left = this.right.left.delete(this.data);
        }
      }
      return this;
    }

    void traverseInOrder(){
      if(this.left != null){ this.left.traverseInOrder(); }
      if(this != null){ System.out.println(this.data); }
      if(this.right != null){ this.right.traverseInOrder(); }
    }

    void traversePreOrder(){
      if(this != null){ System.out.println(this.data); }
      if(this.left != null){ this.left.traversePreOrder(); }
      if(this.right != null){ this.right.traversePreOrder(); }
    }

    void traversePostOrder(){
      if(this.left != null){ this.left.traversePostOrder(); }
      if(this.right != null){ this.right.traversePostOrder(); }
      if(this != null){ System.out.println(this.data); }
    }
  }
}
