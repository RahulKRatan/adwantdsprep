package Bootcamp.StringManipulation;

//https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/

public class FindPeakElement {

    static int findPeakElement(int[] nums) {
    int max = nums[0];
    int index = 0;
    for(int i=1;i<nums.length-1;i++){
        if(nums[i] > nums[i-1] && nums[i] > nums[i+1] && nums[i] > max){
            index = i;
            max = nums[i];
        }
    }
    if(nums[nums.length-1] > max){
        index = nums.length-1;
    }

    return index;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,3,5,6,4};
        int result = findPeakElement(arr);
        System.out.println(result);
    }
}

/*
Can we find a peak element in worst time complexity better than O(n)?
We can use Divide and Conquer to find a peak in O(Logn) time. The idea is Binary Search based, we compare middle element with its neighbors.
If middle element is not smaller than any of its neighbors, then we return it. If the middle element is smaller than the its left neighbor, then there is always a peak in left half (Why? take few examples).
If the middle element is smaller than the its right neighbor, then there is always a peak in right half (due to same reason as left half). Following are C and Java implementations of this approach.
 */


//
//// A Java program to find a peak element element using divide and conquer
//import java.util.*;
//import java.lang.*;
//import java.io.*;
//
//class PeakElement
//{
//	// A binary search based function that returns index of a peak
//	// element
//	static int findPeakUtil(int arr[], int low, int high, int n)
//	{
//		// Find index of middle element
//		int mid = low + (high - low)/2; /* (low + high)/2 */
//
//// Compare middle element with its neighbours (if neighbours
//// exist)
//		if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 ||
//                arr[mid+1] <= arr[mid]))
//                return mid;
//
//                // If middle element is not peak and its left neighbor is
//                // greater than it,then left half must have a peak element
//                else if (mid > 0 && arr[mid-1] > arr[mid])
//                return findPeakUtil(arr, low, (mid -1), n);
//
//                // If middle element is not peak and its right neighbor
//                // is greater than it, then right half must have a peak
//                // element
//                else return findPeakUtil(arr, (mid + 1), high, n);
//                }
//
//// A wrapper over recursive function findPeakUtil()
//static int findPeak(int arr[], int n)
//        {
//        return findPeakUtil(arr, 0, n-1, n);
//        }
//
//// Driver method
//public static void main (String[] args)
//        {
//        int arr[] = {1, 3, 20, 4, 1, 0};
//        int n = arr.length;
//        System.out.println("Index of a peak point is " +
//        findPeak(arr, n));
//        }
//        }