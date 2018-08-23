import java.util.*;
class ConvertBitReq{
  public static int convert(int a, int b){
    // a = 11, b = 1010
    // count the number of '1's in binary, and diff
    int bitA = getBitNo(a);
    int bitB = getBitNo(b);
    return Math.abs(bitB - bitA);
  }

  public static int getBitNo(int n){
    int bits = 0;
    while(n > 0){
      bits = (n % 2) == 1 ? bits + 1 : bits;
      n = n/2;
    }
    return bits;
  }

  public static void main(String[] args){
    testCase1();
    testCase2();
  }

  public static void testCase1(){
    int a = 0;
    int b = 1;
    System.out.println("Test Case 1:");
    System.out.println(convert(a, b));
  }
  public static void testCase2(){
    int a = 14;
    int b = 31;
    System.out.println("Test Case 1:");
    System.out.println(convert(a, b));
  }
}
