import java.util.*;
class ReverseString{
   //"abcd/0" => "dbca/0"
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      String strToProcess = sc.nextLine().trim();
  char endChar = '\0';
      strToProcess += endChar;
      System.out.println(reverseStr(strToProcess));
   }

   //O(N)
   public static String reverseStr(String strToProcess){
      char[] charList = strToProcess.toCharArray();
      StringBuffer reversed = new StringBuffer();
      for(int i=strToProcess.length()-2;i>=0;i--){
        reversed.append(charList[i]);
      }
      return reversed.toString();
   }
}
