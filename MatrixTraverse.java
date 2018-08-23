import java.util.*;
class MatrixTraverse{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int rows = Integer.valueOf(str[0]);
        int lines = Integer.valueOf(str[1]);
        int i = 0;
        int[][] matrix = new int[rows][lines];
        for(int t=0;t < rows;t++){
            String[] line = sc.nextLine().trim().split(" ");
            for(int m=0;m<line.length;m++){
                matrix[i][m] = Integer.valueOf(line[m]);
            }
            i++;
        }
        traverse(matrix, rows, lines);
    }

    // traverse the matrix
    // a x b e
    // e f x c
    // e q t x
    // 0,0 -> 0,1;1,0 -> 0,2;1,1;2,0 -> ... -> 0,n;1,n-1;...;n-1,1;n,0-> 1,n;2,n-1; ... m;0 
    public static void traverse(int[][] matrix, int rows, int lines){
        for(int i=0; i<rows;i++){
            for(int j=i;j>=0;j--){
                if(i-j < lines){
                    System.out.println(matrix[j][i-j]);
                } else {
                    break;
                }
            }
        }
        for(int i=1; i<lines;i++){
            for(int j=rows-1;j>=0;j--){
                if(rows-1 + i - j < lines){
                    System.out.println(matrix[j][rows-1 + i - j]);
                } else {
                    break;
                }
            }
        }
    }
}
