import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class MergeSort{

    // Method to perform Merge-sort on a queue of integers
    public static Queue<Integer> mergeSort(Queue<Integer> queue) {
        if (queue.size() <= 1) {
            // Base case: If the queue has 0 or 1 element, it is already sorted
            return queue;
        }

        // Split the queue into two halves
        Queue<Integer> L = new LinkedList<>();
        Queue<Integer> G = new LinkedList<>();

        int size = queue.size();
        int mid = size / 2;

        // Populating queues L and G with elements from the original queue
        for (int i = 0; i < mid; i++) {
            L.add(queue.poll());
        }

        for (int i = mid; i < size; i++) {
            G.add(queue.poll());
        }

        // Recursively sort the two halves
        L = mergeSort(L);
        G = mergeSort(G);

        // Merge the sorted halves
        return mergeSortedQueues(L, G);
    }

    // Method to merge two sorted queues into a single sorted queue
    public static Queue<Integer> mergeSortedQueues(Queue<Integer> queueA, Queue<Integer> queueB) {
        Queue<Integer> queueS = new LinkedList<>();

        // Merge elements from queues A and B while they are not empty
        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            int elementA = queueA.peek();
            int elementB = queueB.peek();

            // Compare elements from A and B, add the smaller one to the result queue
            if (elementA < elementB) {
                queueS.add(queueA.poll());
            } else {
                queueS.add(queueB.poll());
            }
        }

        // Add remaining elements from queue A
        while (!queueA.isEmpty()) {
            queueS.add(queueA.poll());
        }

        // Add remaining elements from queue B
        while (!queueB.isEmpty()) {
            queueS.add(queueB.poll());
        }

        // Return the merged and sorted queue
        return queueS;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example usage
        Queue<Integer> inputQueue = new LinkedList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
        // Call mergeSort on the input queue
        Queue<Integer> sortedQueue = mergeSort(inputQueue);

        // Print the sorted queue
        System.out.println("Sorted Queue: " + sortedQueue);
    }
}
