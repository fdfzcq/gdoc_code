import java.util.*;
class BitSubString{
  public static int convert(int n, int m, int i, int j){
    if(i == j){ return n; }
    int n2 = i > 0 ? ((n >> (i - 1)) << (i - 1)) : n;
    int n1 = ((n >> j) << j);
    int diff2 = n - n2;
    int diff1 = n - n1;
    return ((n - diff1 + diff2) | (m << (i - 1)));
  }

  public static void main(String[] args){
    runTestCase1();
    runTestCase2();
    runTestCase3();
  }

  public static void runTestCase1(){
    int m = 0;
    int n = 0;
    int i = 0;
    int j = 0;
    System.out.println(convert(n, m, i, j));
  }

  public static void runTestCase2(){
    int n = 0;
    int m = 5; //101
    int i = 2;
    int j = 4;  //1010 = 10
    System.out.println(convert(n, m, i, j));
  }

  public static void runTestCase3(){
    int n = 76;
    int m = 5;
    int i = 3;
    int j = 5;
    System.out.println(convert(n, m, i, j));
  }
}



