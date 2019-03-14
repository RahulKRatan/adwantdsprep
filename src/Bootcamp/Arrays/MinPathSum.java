package Bootcamp.Arrays;

public class MinPathSum {

    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int col = grid[0].length;
        return paths(rows-1,col-1,0,0,grid);
    }

    public static int paths(int m, int n, int x, int y,int[][] grid){
        if(x > m || y > n){
            return Integer.MAX_VALUE;
        }
        if(x == m && y == n){
            return grid[m][n];
        }
        int t1 = paths(m , n, x+1, y,grid);
        int t2 = paths(m , n, x, y+1,grid);
        int t3 = paths( m , n, x+1, y+1,grid);


        return grid[x][y] + min(t1,t2,t3);
    }
    private static int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }

    public static void main(String[] args) {
        int[][] values = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int result = minPathSum(values);
        System.out.println(result);
    }
}
