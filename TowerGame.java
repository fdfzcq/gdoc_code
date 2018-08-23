import java.util.*;
class TowerGame{
  public static Stack<Integer>[] moveToLast(int n, Stack<Integer>[] rods){
    for(int i=0;i<rods.length-1;i++){
      while(!rods[i].isEmpty()){
        if(rods[i].peek() > n){ break; }
        rods[i+1].push(rods[i].peek());
        rods[i].pop();
      }
    }
    return rods;
  }

  public static void printStack(Stack<Integer> stack){
    StringBuilder sb = new StringBuilder();
    while(!stack.isEmpty()){
      sb.append(stack.peek());
      sb.append(" ");
      stack.pop();
    }
    System.out.println(sb.toString());
  }

  public static void main(String[] args){
    runTestCase();
  }
  
  //e.g. rod1: [1,2,3,4,5,6,7]
  public static void runTestCase(){
    System.out.println("Run Test Case:");
    @SuppressWarnings("unchecked")
    Stack<Integer>[] rods=new Stack[3];
    rods[0] = new Stack<Integer>();
    rods[1] = new Stack<Integer>();
    rods[2] = new Stack<Integer>();
    for(int i=10;i>=1;i--){ rods[0].push(i); }
    rods = moveToLast(7, rods);
    System.out.println("Result in rod3:");
    printStack(rods[2]);
  }
}



