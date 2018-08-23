import java.util.*;
class ZerofyMatrix{
  static class Matrix{
    int noOfLines;
    int noOfRows;
    int[][] matrix;
    public Matrix(int noOfRows, int noOfLines){
      this.noOfRows = noOfRows;
      this.noOfLines = noOfLines;
      this.matrix = new int[noOfRows][noOfLines];
    }
    void populateMatrix(int factor){
      Random rn = new Random();
      for(int i=0;i<this.noOfRows;i++){
        for(int j=0;j<this.noOfLines;j++){
          this.matrix[i][j] = (Math.abs(rn.nextInt()) % factor);
        }
      }
    }
    void zerofy(){
      int[] rows = new int[this.noOfRows];
      int[] lines = new int[this.noOfLines];
      // O(M*N)
      for(int i=0;i<this.noOfRows;i++){
        for(int j=0;j<this.noOfLines;j++){
          if(rows[i] == 1){ break; }
          if(lines[j] != 1 && this.matrix[i][j] == 0){
            lines[j] = 1;
          }
          if(this.matrix[i][j] == 0){ rows[i] = 1; }
        }
      }
      for(int i=0;i<noOfRows;i++){
        int[] arr = new int[noOfLines];
        Arrays.fill(arr, 0);
        if(rows[i] == 1){ this.matrix[i] = arr; }
      }
      // O(M*N)
      for(int j=0;j<noOfLines;j++){
        if(lines[j] == 1){
          for(int i=0; i<this.noOfRows;i++){
            if(rows[i] != 1){ this.matrix[i][j] = 0; }
          }
        }
      }
    }
  }

  public static void main(String[] args){
    runTestCase1();
    runTestCase2();
    runTestCase3();
  }

  public static void printMatrix(Matrix matrix){
    for(int i =0;i<matrix.noOfRows;i++){
      StringBuffer row = new StringBuffer();
      for(int j=0;j<matrix.noOfLines;j++){
        row.append(matrix.matrix[i][j]);
        row.append(" ");
      }
      System.out.println(row.toString());
    }
  }

  public static void runTestCase1(){
    System.out.println("Test case 1:");
    Matrix matrix = new Matrix(0, 0);
    printMatrix(matrix);
    matrix.zerofy();
    System.out.println("after:");
    printMatrix(matrix);
  }

  public static void runTestCase2(){
    System.out.println("Test case 2:");
    Matrix matrix = new Matrix(5, 5);
    matrix.populateMatrix(1);
    printMatrix(matrix);
    matrix.zerofy();
    System.out.println("after:");
    printMatrix(matrix);
  }
  
  public static void runTestCase3(){
    System.out.println("Test case 3:");
    Matrix matrix = new Matrix(10,10);
    matrix.populateMatrix(30);
    printMatrix(matrix);
    matrix.zerofy();
    System.out.println("after:");
    printMatrix(matrix);
  }
}
