import java.util.*;
class SortedArrayFindNumber{
  // [14,15,16,17,1,2,3,4,5,6,7,8,9,10,11,12,13]
  // check head - tail, cases
  // a. n > head -> traverse the array in order -> worst: O(N)
  // b. n < head -> traverse backward -> worst: O(N)
  public static int findIndex(int[] arr, int n){
    if(arr.length == 0){ return -1; }
    if(arr[0] <= n){
      //traverse forward
      for(int i=0;i<arr.length;i++){
        if(arr[i] == n){ return i; }
        if(arr[i] > n){ return -1; }
      }
    }
    if(arr[0] > n){
      for(int i=arr.length-1;i>=0;i--){
        if(arr[i] == n){ return i; }
        if(arr[i] < n){ return -1; }
      }
    }
    return -1;
  }

  public static int findIndex2(int[] arr, int n){
    return search(arr, 0, arr.length - 1, n);
  }

  public static int search(int[] arr, int a, int b, int n){
    if(arr.length == 0){ return -1; }
    while(a < b){
      int m = (a + b)/2;
      if(arr[m] == n){ return m; }
      if(arr[a] < arr[m]){
        if(arr[m] < n){
          a = m + 1; 
        } else {
          b = m - 1;
        }
      } else {
        if(arr[a] <= n){
          b = m - 1;
        } else if(arr[m] > n){
          b = m - 1;
        } else {
          a = m + 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args){
    testCase1();
    testCase2();
    testCase3();
    testCase4();
  }

  public static void testCase1(){
    System.out.println("Test Case 1:");
    int[] arr = new int[0];
    int n = 0;
    System.out.println(findIndex(arr, n));
    System.out.println(findIndex2(arr, n));
  }

  public static void testCase2(){
    System.out.println("Test Case 2:");
    int[] arr = {14,15,16,17,1,2,3,4,5,6,7,8,9,10,11,12,13};
    int n = 5;
    System.out.println(findIndex(arr, n));
    System.out.println(findIndex2(arr, n));
  }

  public static void testCase3(){
    System.out.println("Test Case 3:");
    int[] arr = {14,15,16,17,1,2,3,4,5,6,7,8,9,10,11,12,13};
    int n = 17;
    System.out.println(findIndex(arr, n));
    System.out.println(findIndex2(arr, n));
  }

  public static void testCase4(){
    System.out.println("Test Case 4:");
    int[] arr = {14,15,16,17,1,2,3,4,5,6,7,8,9,10,11,12,13};
    int n = 20;
    System.out.println(findIndex(arr, n));
    System.out.println(findIndex2(arr, n));
  }
}


