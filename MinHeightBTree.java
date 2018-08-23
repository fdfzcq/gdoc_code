import java.util.*;
class MinHeightBTree{
  // [0,1,2,3,4,5,6]
  public static Tree toBinaryTree(int[] arr){
    if(arr.length == 0){return null;}
    Node root = new Node(arr[arr.length/2]);
    int[] arr1 = new int[arr.length/2];
    if(arr.length > 0){
      int[] arr2 = new int[arr.length - arr.length/2 - 1];
      for(int i=0;i<arr.length;i++){
        if(i < arr.length/2){
          arr1[i] = arr[i];
        } else if(i > arr.length/2){
          arr2[i - arr.length/2 - 1] = arr[i];
        }
      }
      root.left = arr1.length == 0 ? null : toBinaryTree(arr1).root;
      root.right = arr2.length == 0 ? null : toBinaryTree(arr2).root;
    }
    Tree t = new Tree(root);
    return t;
  }

  public static void main(String[] args){
    runTestCase1(); //empty array
    runTestCase2(); //array w odd number
    runTestCase3(); //array w even number
  }

  public static void runTestCase1(){
    System.out.println("Run Test Case 1: empty array");
    int[] arr=new int[0];
    Tree t = toBinaryTree(arr);
    printTree(t);
  }
  public static void runTestCase2(){
    System.out.println("Run Test Case 2: array with odd number of elements");
    int[] arr=new int[6];
    for(int i=0;i<6;i++){ arr[i] = i; }
    Tree t = toBinaryTree(arr);
    printTree(t);
  }
  public static void runTestCase3(){
    System.out.println("Run Test Case 3: array w even number of elements");
    int[] arr=new int[7];
    for(int i=0;i<7;i++){ arr[i] = i; }
    Tree t = toBinaryTree(arr);
    printTree(t);
  }

  public static void printTree(Tree t){
    if(t == null){
      System.out.println("empty tree"); 
    } else {
      t.root.print(1);
    }
  }

  static class Tree{
    Node root;
    public Tree(Node root){ this.root = root; }
  }
  
  static class Node{
    int value;
    Node left;
    Node right;
    public Node(int value){ this.value = value; }
    void print(int h){
      System.out.println("Line " + h + ": " + this.value);
      if(this.left != null){ this.left.print(h+1); }
      if(this.right != null){ this.right.print(h+1); }
    }
  }
}
