import java.util.*;
class RobotMovement{
  public static int move(int n){
    if(n==0){ return 0; }
    return move(n, n, 1);
  }

  public static int moveWithObs(int n, int[][] obs){
    if(n==0){ return 0; }
    int disabled = 0;
    for(int[] point:obs){
      disabled += move(point[0], point[1], 1);
    }
    return move(n, n, 1) - disabled;
  }

  public static int move(int right, int down, int n){
    if(right == 1 || down == 1){ return n; }
    return move(right - 1, down, 1) + move(right, down - 1, 1);
  }

  public static void main(String[] args){
    System.out.println("Simple movements:");
    System.out.println(move(4));
    System.out.println("WithObstacles");
    int[] point = {3,3};
    int[][] obs = new int[1][2];
    obs[0] = point;
    System.out.println(moveWithObs(4, obs));
  }
}
