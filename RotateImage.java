import java.util.*;
class RotateImage{
  // * y y y y y
  // x 1 4 5 6 8
  // x 2 5 4 1 9
  // x 4 2 7 6 1
  // x 1 5 2 9 4
  // x 3 2 9 8 1
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    //int size = sc.nextInt();
    int size = 3;
    int[][] arr = new int[size][size];
    for(int i=0;i<size;i++){
      String[] strList = sc.nextLine().trim().split(" ");
  for(int j=0;j<size;j++){
        arr[i][j] = Integer.valueOf(strList[j]);
      }
    }
    arr = rotateImage(arr);
    printMatrix(arr);
  }

  public static void printMatrix(int[][] arr){
    for(int[] row : arr){
      StringBuffer sb = new StringBuffer();
      for(int i : row){
        sb.append(" ");
        sb.append(i);
      }
      System.out.println(sb.toString());
    }
  }

  //O(1+2+...N) = O((N)*(N+1)/2) = O(N^2)
  public static int[][] rotateImage(int[][] arr){
    int size = arr.length;
    for(int i=0;i<size/2;i++){
      for(int j=i;j<size-i-1;j++){
        if(i == j && i + j == size - 1) { return arr; }
        int i1 = arr[i][j]; // 0,0 => 1
        int i2 = arr[j][size-1-i]; //0,1 => 3
        int i3 = arr[size-1-i][size-1-j]; //1,1 => 5
        int i4 = arr[size-1-j][i]; //1,0 => 4
        arr[j][size-1-i] = i1;
        arr[size-1-i][size-1-j] = i2;
        arr[size-1-j][i] = i3;
        arr[i][j] = i4;
        //4 1
        //5 3
      }
    }
    return arr;
  }
}
