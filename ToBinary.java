import java.util.*;
class ToBinary{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    String bitString = toBinary(number);
    System.out.println(bitString);
  }
  public static String toBinary(int number){
    String bit = "";
    while(number > 1){
      bit = (number % 2) + bit;
  number = number/2;
    }
    return (1 + bit);
  }
}
