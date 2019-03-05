package Bootcamp.Arrays;

import java.util.Arrays;

public class ThreeSum {


    static void threeSum(int[] arr){
        String[] strings = new String[3];

        if(arr == null || arr.length == 0){
            return;
        }
        Arrays.sort(arr);
        int size = arr.length;
        for(int i=0;i<size-2;i++){
            int l = i+1,r =size-1;
        while(l<r){
            if (arr[i] + arr[l]+arr[r] == 0) {
                System.out.print(arr[i]+","+arr[l]+","+arr[r]);
                l++;r--;
                while (l<r && arr[l] == arr[l-1])
                    l++;
                while (l<r && arr[r] == arr[r+1])
                    r--;
            }
            if(arr[i] + arr[l]+arr[r] < 0){
                l++;
            }
            else {
                r--;
            }
        }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,2,0,-2,2};
        threeSum(arr);
    }
}
