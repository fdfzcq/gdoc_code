import java.util.*;
class BitNextSmallerLarger{
  public static void nextLarger(int n){
    if(n<0){
      if(smaller(-n) != 0){
        System.out.println("Larger: " + (-smaller(-n)));
      } else {
        System.out.println("Not applicable!");
      }
    } else {
      if(larger(n) != 0){
        System.out.println("Larger: " + larger(n));
      } else {
        System.out.println("Not applicable!");
      }
    }
  }

  public static void nextSmaller(int n){
    if(n<0){
      if(larger(-n) != 0){
        System.out.println("Smaller: " + (-larger(-n)));
      } else {
        System.out.println("Not applicable!");
      }
    } else {
     if(smaller(n) != 0){
       System.out.println("Smaller: " + smaller(n));
     } else {
       System.out.println("Not applicable!");
     }
    }
  }
  //101 -> 011
  public static int smaller(int n){
    if(n == 0){ return 0; }
    int i = 1;
    int v = n; //101
    while(((v >> i) << i) != v){
      if(i==31){return -n;}
      v = ((v >> i) << i); // 100
      i++; // i=2
    }
    int res = ((1 << (i - 1)) | n) & (Integer.MAX_VALUE - (1 << i));
    if(res > n){return -n;}
    return res;
  }

  public static int larger(int n){
    if(n == 0){ return 0; }
    if(n == Integer.MAX_VALUE){ return 0; }
    int v = 2; //10
    int i = 2;
    while((n | v) == n){
      v = v << 1; //100
      i++;
    }
    int res = ((n | v) & (Integer.MAX_VALUE - (1 << (i-2))));
    return res;
  }

  public static void main(String[] args){
    runTestCase1(); //0
    runTestCase2(); //largest
    runTestCase3(); // 101
    runTestCase4(); // 110
  }

  public static void runTestCase1(){
    System.out.println("Test Case 1: 0");
    int n = 0;
    nextLarger(n);
    nextSmaller(n);
  }
  public static void runTestCase2(){
    System.out.println("Test Case 2: 0");
    int n = Integer.MAX_VALUE;
    nextLarger(n);
    nextSmaller(n);
  }
  public static void runTestCase3(){
    System.out.println("Test Case 3: 0");
    int n = 5;
    nextLarger(n);
    nextSmaller(n);
  }
  public static void runTestCase4(){
    System.out.println("Test Case 4: 0");
    int n = 7;
    nextLarger(n);
    nextSmaller(n);
  }
}
