import java.util.*;
class AnagramCheck{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] wordsToCheck = sc.nextLine().trim().split(" ");
    String w1 = wordsToCheck[0];
    String w2 = wordsToCheck[1];
    System.out.println(checkAnagram(w1, w2));
  }

  //O(N) - O(N^2)
  public static boolean checkAnagram(String word1, String word2){
    if(word1.length() != word2.length()){ return false; }
    Hashtable<Character, Integer> ht= new Hashtable<Character, Integer>();
    char[] word1Chars = word1.toCharArray();
    for(char c:word1Chars){
      int value = ht.containsKey(c) ? ht.get(c) + 1 : 1;
      ht.put(c, value);
    }
    char[] word2Chars = word2.toCharArray();
    for(char c:word2Chars){
      if(!ht.containsKey(c)){ return false; }
      ht.put(c, ht.get(c) - 1);
      if(ht.get(c) < 0){ return false; }
    }
    return true;
  }

  // Not working for (ttse tsse)
  public static boolean checkAnagram2(String word1, String word2){
    if(word1.length() != word2.length()){ return false; }
    int checker = 0;
    char[] word1Chars = word1.toCharArray();
    for(char c:word1Chars){
      checker |= 1 << (c - 'A');
    }
    char[] word2Chars = word2.toCharArray();
    for(char c:word2Chars){
      if((checker & 1 << (c - 'A')) == 0){ return false; }
    }
    return true;
  }

}
