package InterviewPractice.Arrays;



public class GroupTheNumbers {

    static int[] solve(int[] arr) {

        int i=0;
        int j=arr.length-1;
        while(i<=j){
            if(arr[i]%2==1 && arr[j]%2==0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            if(arr[i]%2==0){
                i++;
            }
            if(arr[j]%2==1){
                j--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,3,5,6};
        int[] result = solve(arr);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }

}
