package Bootcamp.Design;

/*
The basic idea is to maintain two heaps: a max-heap and a min-heap.
The max heap stores the smaller half of all numbers while the min heap stores the larger half.
The sizes of two heaps need to be balanced each time when a new number is inserted so that their size will not be different by more than 1.
Therefore each time when findMedian() is called we check if two heaps have the same size. If they do,
we should return the average of the two top values of heaps. Otherwise we return the top of the heap which has one more element.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianfromDataStream {

    // max queue is always larger or equal to min queue
    PriorityQueue<Integer> largerHalf = new PriorityQueue();
    PriorityQueue<Integer> smallerHalf = new PriorityQueue(Comparator.reverseOrder());

    public void addNum(int num) {
        smallerHalf.add(num);
        largerHalf.add(smallerHalf.poll());
        if (smallerHalf.size() < largerHalf.size()){
            smallerHalf.add(largerHalf.poll());
        }
    }

    public double findMedian() {
        if (smallerHalf.size() == largerHalf.size()) return (smallerHalf.peek() + largerHalf.peek()) /  2.0;
        else return smallerHalf.peek();
    }

    public static void main(String[] args) {
        MedianfromDataStream mm = new MedianfromDataStream();
        mm.addNum(10);
        mm.addNum(20);
        mm.addNum(30);
        mm.addNum(40);
        mm.addNum(50);
        System.out.println(mm.findMedian());
    }

}

/*
class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if(minHeap.size() >= maxHeap.size()+2) {
            maxHeap.add(minHeap.remove());
        } else if(maxHeap.size() >= minHeap.size()+2){
            minHeap.add(maxHeap.remove());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        } else if(minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }
};
 */