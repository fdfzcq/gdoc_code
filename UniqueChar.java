import java.util.*;
class UniqueChar{
  public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     String strToCheck = sc.nextLine().trim();
     System.out.println(uniqueChar3(strToCheck));
  }

  // abesdb => true
  // asaef => false
  // O(N^2)
  public static boolean uniqueChar(String strToCheck){
     for(int i=0;i<strToCheck.length();i++){
       String charString = strToCheck.substring(i, i+1);
       if(strToCheck.split(charString).length>2){
         return false;
       }
     }
     return true;
  }

  // O(NlogN)
  public static boolean uniqueChar2(String strToCheck){
     char[] charList = strToCheck.toCharArray();
     Arrays.sort(charList);
     for(int i=0;i<strToCheck.length();i++){
       char charToCheck = charList[i];
       if(i != strToCheck.length()-1 && charList[i+1] == charToCheck){
         return false;
       }
     }
     return true;
  }

  // O(N)
  public static boolean uniqueChar3(String strToCheck){
    char[] charList = strToCheck.toCharArray();
    int checker = 0;
    for(int i=0;i<strToCheck.length();i++){
      int val = charList[i] - 'a';
      if((checker & (1 << val)) > 0) return false;
      checker |= 1 << val;
    }
    return true;
  }
}


