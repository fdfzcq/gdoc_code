import java.util.*;
class SwapOddEvenBit{
  // 0101 -> 1010 1010 | 0010
  // 1001 -> 0110 0100 | 10010
  // 0000 -> 0000
  // 0111 -> 1011 0011 | 1110
  // a*(2^((2n-1) - 1)) + b*2(2^((2n+1) - 1))
  // b*(2^((2n-1) - 1)) + a*2(2^((2n+1) - 1))
  // n + (b-a)*n1 + (a-b)*n2
  public static int swap(int n){
    int p1 = 0;// ..01010101
    int p2 = 0;// ..10101010
    for(int i=0;i<32;i++){
      if(i%2 == 1){ p2 = p2 | (1 << i); }
      if(i%2 == 0){ p1 = p1 | (1 << i); }
    }

    return (((n >> 1) & p1) | ((n << 1) & p2));
  }

  public static void main(String[] args){
    System.out.println("Test Case 1:");
    System.out.println(swap(5));
    System.out.println("Test Case 2:");
    System.out.println(swap(9));
    System.out.println("Test Case 3:");
    System.out.println(swap(0));
    System.out.println("Test Case 4:");
    System.out.println(swap(7));
  }
}
