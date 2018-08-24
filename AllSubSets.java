import java.util.*;
class AllSubSets{
  public static ArrayList<ArrayList<Integer>> getSubSets(int[] arr){
    @SuppressWarnings("unchecked")
    ArrayList<ArrayList<Integer>> res = new ArrayList();
    return getSubSets(arr, 0, res);
  }
  //[1,2,3,4] -> [1] [2,3,4] -> [1], [[2,3], [3,4], []]
  public static ArrayList<ArrayList<Integer>> getSubSets(int[] arr, int index, ArrayList<ArrayList<Integer>> res){
    if(index == arr.length){ return res; }
    int n = arr[index];
    int size = res.size();
    for(int i=0;i<size;i++){
      ArrayList<Integer> newArr = new ArrayList<>(res.get(i));
      newArr.add(n);
      res.add(newArr);
    }
    ArrayList<Integer> l = new ArrayList<Integer>();
    l.add(arr[index]);
    res.add(l);
    return getSubSets(arr, index + 1, res);
  }

  public static void main(String[] args){
    testCase1();
    testCase2();
  }

  public static void testCase1(){
    System.out.println("Test Case 1:");
    int[] arr = new int[0];
    printArrays(getSubSets(arr));
  }

  public static void testCase2(){
    System.out.println("Test Case 2:");
    int[] arr = {1,2,3,4};
    printArrays(getSubSets(arr));
  }

  public static void printArrays(ArrayList<ArrayList<Integer>> arr){
    for(ArrayList<Integer> a:arr){
      StringBuilder sb = new StringBuilder();
      for(int i:a){
        sb.append(i);
        sb.append(" ");
      }
      System.out.println(sb.toString());
    }
  }
}
