package InterviewPractice.Arrays;

public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int i=0;i<accounts.length;i++){
            int sum = 0;
            for(int j=0;j<accounts[0].length;j++){
                sum += accounts[i][j];
            }
            if(sum>max){
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] accounts = new int[][]{{1,2,3},{3,2,1}};
        System.out.println(maximumWealth(accounts));
    }
}
