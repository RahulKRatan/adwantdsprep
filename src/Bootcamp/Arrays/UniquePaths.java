package Bootcamp.Arrays;

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


    public static void main(String[] args) {
        int result = uniquePaths(3,2);
        System.out.println(result);
    }
}
