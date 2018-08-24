import java.util.*;
class StringPermutation{
  public static void printPermutations(String str){
    char[] charArray = str.toCharArray();
    Queue<Character> queue = new LinkedList<Character>();
    for(char c:charArray){ queue.offer(c); }
    Set<StringBuilder> res =
     getPermutations(queue, new HashSet<StringBuilder>(), 0);
    for(StringBuilder s: res){
  if(!(s.toString()).equals(str)){ System.out.println(s.toString()); }
    }
  }
  // get permutations of substring -> insert char at different places
  // abc, acb, bac, bca, acb

  public static Set<StringBuilder> getPermutations(Queue<Character> queue, Set<StringBuilder> arr, int i){
    if(i == queue.size()){ return arr; }
    char a = queue.poll(); //a
    if(queue.size() == 0){
      StringBuilder sb = new StringBuilder();
      sb.append(a);
      arr.add(sb);
      return arr;
    }
    Set<StringBuilder> subArr =
      getPermutations(new LinkedList<>(queue), new HashSet<StringBuilder>(), 0); //b
    for(StringBuilder str:subArr){
      str.append(a);
      arr.add(str);
    }
    queue.offer(a);
    return getPermutations(queue, arr, i+1);
  }
  
  public static void testCase1(){
    System.out.println("Test Case 1:");
    String str = "";
    printPermutations(str);
  }

  public static void testCase2(){
    System.out.println("Test Case 2:");
    String str = "abcd";
    printPermutations(str);
  }

  public static void main(String[] args){
    testCase1();
    testCase2();
  }
}
