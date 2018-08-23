import java.util.*;
public class MaxSet{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().trim().split(" ");
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for(String s : str){
      arr.add(Integer.valueOf(s));
    }
    ArrayList<Integer> max = maxset(arr);
    printArray(max);
  }

  public static void printArray(ArrayList<Integer> max){
    for(int i : max){
      System.out.println(i);
    }
  }

  public static ArrayList<Integer> maxset(ArrayList<Integer> arr){
    //skip the negative numbers
    long sumA = 0L;
    long sumB = 0L;
    ArrayList<Integer> arrayA = new ArrayList<Integer>();
    ArrayList<Integer> arrayB = new ArrayList<Integer>();
    boolean flag = true;
    for(int i=0;i<arr.size();i++){
      if(arr.get(i)>=0 && flag){
        sumA += Long.valueOf(arr.get(i));
        arrayA.add(arr.get(i));
      } else if(arr.get(i)>=0){
        sumB += Long.valueOf(arr.get(i));
        arrayB.add(arr.get(i));
      } else {
        flag = false;
        if(sumB > sumA){
          sumA = sumB;
          arrayA.clear();
          arrayA.addAll(arrayB);
        }
        sumB = 0L;
        arrayB.clear();
      }
    }
    return sumB > sumA ? arrayB : arrayA;
  }
}
