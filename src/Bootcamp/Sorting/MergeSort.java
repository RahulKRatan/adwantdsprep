package Bootcamp.Sorting;

public class MergeSort {

    public static void merge(int[] arr,int start, int mid, int end){

        if(start == end)
            return;
        merge(arr,start,mid/2,mid);
        merge(arr,mid+1,mid+end/2, end);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{15,20,2,4,25,3,14,19};
        merge(arr,0,arr.length/2,arr.length-1);
    }

}
