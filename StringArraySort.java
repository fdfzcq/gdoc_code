import java.util.*;
class StringArraySort{
  //["a", "b", "c", "ab", "bc", "cb", "ba"] ->
  //  ["a", "b", "c", "ab", "ba", "bc", "cb"]
  //1. brute force: create a map and traverse the list and
  //   check if the word is an anagram of any in the list -> O(N^2) & space
  //2. calculate the anagram of strings -> search in the rest of the list
  //    O(N*M^2) how long are the words? assume it's short -> O(N^2)
  //3. loop through the list and swap and check O(N) - O(N^2)
  public static String[] sort(String[] arr){
    for(int i=0; i<arr.length;i++){
      for(int j=i+1; j<arr.length;j++){
        if(isAnagram(arr[i], arr[j])){
          String temp = arr[j];
          arr[j] = arr[i+1];
          arr[i+1] = temp;
          j=arr.length;
        }
      }
    }
    return arr;
  }

  public static boolean isAnagram(String a, String b){
    if(a.length() != b.length()){ return false; }
    if(a.equals(b)){ return true; }
    HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
    char[] aList = a.toCharArray();
    char[] bList = b.toCharArray();
    for(char c:aList){
      int n = hm.containsKey(c) ? hm.get(c) + 1 : 1;
      hm.put(c, n);
    }
    for(char c:bList){
      if(!hm.containsKey(c)){ return false; }
      if(hm.get(c) == 0){ return false; }
      hm.put(c, hm.get(c) - 1);
    }
    return true;
  }

  public static void main(String[] args){
    testCase1();
    testCase2();
    testCase3();
  }

  public static void testCase1(){
    System.out.println("Test Case 1:");
    String[] arr = new String[0];
    printArray(sort(arr));
  }

  public static void testCase2(){
    System.out.println("Test Case 2:");
    String[] arr = {"a", "b", "c"};
    printArray(sort(arr));
  }

  public static void testCase3(){
    System.out.println("Test Case 3:");
    String[] arr = {"ab", "ac", "abc", "bca", "ca", "ba", "b", "cab"};
    printArray(sort(arr));
  }

  public static void printArray(String[] arr){
    StringBuilder sb = new StringBuilder();
    for(String s:arr){
      sb.append(s);
      sb.append(" ");
    }
    System.out.println(sb.toString());
  }
}
