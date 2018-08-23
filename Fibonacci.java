import java.util.*;
class Fibonacci{
  public static long fibonacci(int n){
    if(n < 1){return 0L;}
    return fibonacci(0L,1L,n,1);
  }

  public static long fibonacci(long prev1, long prev2, int n, int m){
    if(n == m){ return prev2; }
    return fibonacci(prev2, prev1 + prev2, n, m + 1);
  }

  public static long iterativeFib(int n){
    long n1 = 0L;
    long n2 = 1L;
    if(n==0){return 0L;}
    for(int i = 1;i<n;i++){
      long fib = n1 + n2;
      n1 = n2;
      n2 = fib;
    }
    return n2;
  }

  public static void main(String[] args){
    runTestCase1();
    runTestCase2();
    runTestCase3();
  }

  public static void runTestCase1(){
    int n = 0;
    System.out.println("Test case 1:");
    System.out.println("The " + n + "th fibonacci: " + fibonacci(n));
    System.out.println("Iterative: " + iterativeFib(n));
  }
  public static void runTestCase2(){
    int n = 5;
    System.out.println("Test case 2:");
    System.out.println("The " + n + "th fibonacci: " + fibonacci(n));
    System.out.println("Iterative: " + iterativeFib(n));
  }
  public static void runTestCase3(){
    int n = 100;
    System.out.println("Test case 3:");
    System.out.println("The " + n + "th fibonacci: " + fibonacci(n));
    System.out.println("Iterative: " + iterativeFib(n));
  }
}


