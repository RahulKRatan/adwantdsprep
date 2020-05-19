package Bootcamp.DP;

/**
 * 91. Decode Ways
 * 70. Climbing Stairs
 * 509. Fibonacci Number
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
       return paths(m,n,1,1);
    }

    public static int paths(int m, int n, int x, int y){
        if(x==m && y == n){
            return 1;
        }
        if(x<m && y<n){
           return paths(m,n,x+1,y) + paths(m,n,x,y+1);
        }
        if(x<m){
            return paths(m,n,x+1,y);
        }
        if(y<n){
            return paths(m,n,x,y+1);
        }
        return 0;
    }

    //DP solution

    /**
     * The assumptions are
     *
     * When (n==0||m==0) the function always returns 1 since the robot
     * can't go left or up.
     * For all other cells. The result = uniquePaths(m-1,n)+uniquePaths(m,n-1)
     * Therefore I populated the edges with 1 first and use DP to get the full 2-D array.
     *
     */
    public static int uniquePathsDP(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }


    public static void main(String[] args) {
        int result = uniquePaths(3,2);
        System.out.println(result);
    }
}
