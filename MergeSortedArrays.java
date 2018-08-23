import java.util.*;
class MergeSortedArrays{
  public static int[] mergeArr(int[] arr1, int[] arr2){
    int pointer1 = 0;
    int pointer2 = 0;
    int[] newArr = new int[arr1.length + arr2.length];
    while(pointer1<arr1.length && pointer2<arr2.length){
      int v1 = arr1[pointer1];
      while(pointer2<arr2.length && v1 > arr2[pointer2]){
        newArr[pointer1 + pointer2] = arr2[pointer2];
        pointer2++;
      }
      newArr[pointer1 + pointer2] = v1;
      pointer1++;
    }
    while(pointer1 < arr1.length){
      newArr[pointer1 + pointer2] = arr1[pointer1];
      pointer1++;
    }
    while(pointer2 < arr2.length){
      newArr[pointer1 + pointer2] = arr2[pointer2];
      pointer2++;
    }
    return newArr;
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
    int[] arr1 = new int[0];
    int[] arr2 = new int[0];
    System.out.println("Run Test Case 1:");
    System.out.println("Before merging:");
    printArray(arr1);
    printArray(arr2);
    System.out.println("After:");
    printArray(mergeArr(arr1, arr2));
  }
  public static void runTestCase2(){
    int[] arr1 = {1,1,3,4,6,12,24,36,100,240};
    int[] arr2 = {1,4,15,24,67,68,102};
    System.out.println("Run Test Case 2:");
    System.out.println("Before merging:");
    printArray(arr1);
    printArray(arr2);
    System.out.println("After:");
    printArray(mergeArr(arr1, arr2));
  }
}
