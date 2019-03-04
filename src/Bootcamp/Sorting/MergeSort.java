package Bootcamp.Sorting;

public class MergeSort {

    public static void mergeSort(int[] arr,int start, int end){
        if(start >= end)
            return;
        int mid = start + (end-start)/2; // ** this is to avoid overflow problem.. if start and end are two large integers.
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }

    public static void merge(int[] arr, int start, int mid, int end){
    }

    public static void main(String[] args) {
        int[] arr = new int[]{15,20,2,4,25,3,14,19};
        mergeSort(arr,0,arr.length-1);
    }

}
