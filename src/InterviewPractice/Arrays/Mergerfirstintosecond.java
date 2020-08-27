package InterviewPractice.Arrays;

public class Mergerfirstintosecond {

    static int[] merger_first_into_second(int[] arr1, int[] arr2) {

        if(helper(arr1,arr2)){
            int size1 = arr1.length;
            int size1Half = arr1.length/2;
            int size2 = arr2.length;

            while ( size2 > 0 && size1Half > 0){
                if(arr1[size1Half-1] > arr2[size2-1]){
                    arr1[size1-1] = arr1[size1Half-1];
                    size1Half--;
                    size1--;
                }
                else {
                    arr1[size1-1] = arr2[size2-1];
                    size2--;
                    size1--;
                }
            }
            while (size1 > 0 && size2 > 0){
                arr1[size1-1] = arr2[size1-1];
                size1--;
            }
            return arr1;
        }
        else {
            int size1 = arr2.length;
            int size1Half = arr2.length/2;
            int size2 = arr1.length;
            while ( size2 > 0 && size1Half > 0){
                if(arr2[size1Half-1] > arr1[size2-1]){
                    arr2[size1-1] = arr2[size1Half-1];
                    size1Half--;
                    size1--;
                }
                else {
                        arr2[size1 - 1] = arr1[size2 - 1];
                        size2--;
                        size1--;
                }
            }
            while (size1 > 0 && size2 > 0){
                arr2[size1-1] = arr1[size1-1];
                size1--;
            }
            return arr2;
        }

    }

    static boolean helper(int[] arr1, int[] arr2){
        if(arr1.length > arr2.length){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,5};
        int[] arr2 = new int[]{2,4,6,0,0,0};
        int[] result = merger_first_into_second(arr1,arr2);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
