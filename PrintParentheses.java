import java.util.*;
class PrintParentheses{
  public static Set<String> comb(int n){
    // 1: ()
    // 2: ()(), (())
    // 3: ()()(), (())(), ()(()), ((()))
    return comb(new HashSet<String>(), n);
  }

  public static Set<String> comb(Set<String> res, int n){
    if(n == 0){ return res; }
    Set<String> strSet = comb(new HashSet<String>(), n-1);
    String last = "";
    for(String s: strSet){
      res.add("()" + s);
      res.add(s + "()");
      last = s;
    }
    res.add("(" + last + ")");
    return res;
  }

  public static void printRes(Set<String> res){
    for(String s: res){
      System.out.println(s);
    }
  }

  public static void main(String[] args){
    testCase1();
    testCase2();
  }

  public static void testCase1(){
    System.out.println("Test Case 1:");
    int n = 0;
    printRes(comb(n));
  }

  public static void testCase2(){
    System.out.println("Test Case 2:");
    int n = 0;
    printRes(comb(4));
  }
}
