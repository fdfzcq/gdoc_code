import java.util.*;
class BucketSortExample{
  public static int[] sort(int[] arr){
    int[] bucket = new int[130];
    for(int i=0;i<arr.length;i++){
      bucket[arr[i]] = bucket[arr[i]] + 1;
    }
    int index = 0;
    for(int i=0;i<bucket.length;i++){
      if(bucket[i] != 0){
        for(int j=0;j<bucket[i];j++){
          index += j;
          arr[index] = i;
        }
        index ++;
      }

    }
    return arr;
  }

  public static void main(String[] args){
    runTestCase1();
    runTestCase2();
  }

  public static void printArray(int[] arr){
    StringBuilder sb = new StringBuilder();
    for(int n:arr){
      sb.append(n);
      sb.append(" ");
    }
    System.out.println(sb.toString());
  }

  public static void runTestCase1(){
    System.out.println("Test Case 1:");
    int[] arr = new int[0];
    System.out.println("Before sort:");
    printArray(arr);
    int[] sorted = sort(arr);
    System.out.println("After sort:");
    printArray(sorted);
  }
  public static void runTestCase2(){
    System.out.println("Test Case 2:");
    int[] arr = {1,1,3,24,17,100,38,42,11,54,24,11,2,4};
    System.out.println("Before sort:");
    printArray(arr);
    int[] sorted = sort(arr);
    System.out.println("After sort:");
    printArray(sorted);
  }
}
