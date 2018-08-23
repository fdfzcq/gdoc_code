import java.util.*;
class RemoveDuplicateChar{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String strToProcess = sc.next();
    strToProcess = removeDuplicateChar(strToProcess);
    System.out.println(strToProcess);
  }

  //jdk 64 : 97 + 25 - 64 = 58
  //O(N)
  public static String removeDuplicateChar(String strToProcess){
    char[] charList = strToProcess.toCharArray();
    int bitValue = 0;
    for(int i=0;i<charList.length;i++){
      int charDiff = charList[i] - 'A';
      if((bitValue & (1 << charDiff)) > 0){ charList[i] = '\0'; }
      bitValue |= 1 << charDiff;
    }
    String res = "";
    for(char c:charList){
      if(c != '\0'){res += c;}
    }
    return res;
  }
}
