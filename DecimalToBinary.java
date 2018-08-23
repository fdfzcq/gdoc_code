import java.util.*;
class DecimalToBinary{
  public static String convert(String decString){
    if(decString.trim().equals("")){ return "ERROR"; }
    String[] decList = decString.split("\\.");
    System.out.println(decList[0]);
    if(decList.length == 1){ return toBinary(Integer.valueOf(decList[0])); }
    if(Integer.valueOf(decList[1]) > 0){
      return decToBinary(Integer.valueOf(decList[0]), Double.parseDouble("0." + decList[1]));
    }
    if(Integer.valueOf(decList[0]) == 0){ return "0"; }
    return toBinary(Integer.valueOf(decList[0]));
  }

  public static String toBinary(int num){
    StringBuilder sb = new StringBuilder();
    while(num > 0){
      sb.insert(0, (num % 2));
      num = num/2;
    }
    return sb.toString();
  }
  // 0.101 = 1*(2^-1) + 0*(2^-2) + 1*(2^-3) = 0.5 + 0.125 = 0.625
  // 1.01 = 2*0.625 = 1.25
  // 10.1 = 2.5
  // 101 = 5
  public static String decToBinary(int i, double f){
    StringBuilder sb = new StringBuilder();
    while(f<1){
      if(sb.length() > 32){ return "ERROR"; }
      if(f*2.0 > 1){
        sb.append(1);
        f = f*2.0 - 1.0;
      } else if(f*2.0 < 1){
        sb.append(0);
        f = f*2.0;
      } else { sb.append(1); break; }
    }
    return Integer.valueOf(i) + "." + sb.toString();
  }

  public static void main(String[] args){
    runTestCase1();
    runTestCase2();
    runTestCase3();
    runTestCase4();
  }

  public static void runTestCase1(){
    String decString = " ";
    System.out.println("Test case 1:");
    System.out.println("Decimal: " + decString);
    System.out.println("Binary: " + convert(decString));
  }

  public static void runTestCase2(){
    String decString = "5.0";
    System.out.println("Test case 2:");
    System.out.println("Decimal: " + decString);
    System.out.println("Binary: " + convert(decString));
  }

  public static void runTestCase3(){
    String decString = "5.009";
    System.out.println("Test case 3:");
    System.out.println("Decimal: " + decString);
    System.out.println("Binary: " + convert(decString));
  }

  public static void runTestCase4(){
    String decString = "5.625";
    System.out.println("Test case 4:");
    System.out.println("Decimal: " + decString);
    System.out.println("Binary: " + convert(decString));
  }
}


