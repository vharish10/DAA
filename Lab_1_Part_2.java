package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class Lab_1_Part_2 {
    //1. Generate 1000 integer random numbers between 1 and 10000. Compare the sorting algorithms learnt in
    // the class using the same set of numbers generated. Plot the time taken for them to complete the process.
    public long measureTime(Runnable runnable) {
        long start_time = System.currentTimeMillis();
        runnable.run();
        long end_time = System.currentTimeMillis();
        return end_time - start_time;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void bubbleSort(int arr[], int n){
        int i,j;
        boolean swapped;
        for(i=0;i<n-1;i++) {
            swapped=false;
            for(j=0;j<n-i-1;j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,i,j);
                    swapped=true;
                }
            }
            if (swapped==false)
                break;
        }
    }

    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        int i = 0, j = 0,k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
         while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    void merge_sort(int arr[], int l, int r){
        if (l < r) {
            int m = l + (r - l) / 2;
            merge_sort(arr, l, m);
            merge_sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public void quickSort(int[] arr, int low, int high){
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public int getMax(int arr[], int n){
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    public void countSort(int arr[], int n, int exp){
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
         for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    public void radixsort(int arr[], int n){
        int m = getMax(arr, n);
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    public static void main(String[] args) {
        Random rand=new Random();
        int arr[]=new int[1000];
        for(int i=0;i<1000;i++){
            arr[i]=rand.nextInt(10000);
        }
        Lab_1_Part_2 sorter = new Lab_1_Part_2();

    // Measure time for Bubble Sort
    long bubbleSortTime = sorter.measureTime(() -> sorter.bubbleSort(arr.clone(), arr.length));
    System.out.println("Bubble Sort Time: " + bubbleSortTime + " milliseconds");

    // Measure time for Selection Sort
    long selectionSortTime = sorter.measureTime(() -> sorter.selectionSort(arr.clone()));
    System.out.println("Selection Sort Time: " + selectionSortTime + " milliseconds");

    // Measure time for Insertion Sort
    long insertionSortTime = sorter.measureTime(() -> sorter.insertionSort(arr.clone()));
    System.out.println("Insertion Sort Time: " + insertionSortTime + " milliseconds");

    // Measure time for Merge Sort
    long mergeSortTime = sorter.measureTime(() -> sorter.merge_sort(arr.clone(), 0, arr.length - 1));
    System.out.println("Merge Sort Time: " + mergeSortTime + " milliseconds");

    // Measure time for Quick Sort
    long quickSortTime = sorter.measureTime(() -> sorter.quickSort(arr.clone(), 0, arr.length - 1));
    System.out.println("Quick Sort Time: " + quickSortTime + " milliseconds");

    // Measure time for Radix Sort
    long radixSortTime = sorter.measureTime(() -> sorter.radixsort(arr.clone(), arr.length));
    System.out.println("Radix Sort Time: " + radixSortTime + " milliseconds");
    }

    //2. Given ‘m’ sorted lists/ arrays, each containing ‘n’ elements, print them efficiently in sorted order

    public static ArrayList<Integer> mergeSortedLists(ArrayList<ArrayList<Integer>> lists) {
        // Priority queue to maintain the sorted order
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all elements from the lists to the priority queue
        for (ArrayList<Integer> list : lists) {
            for (Integer num : list) {
                pq.add(num);
            }
        }

        // Store the elements in the priority queue into the result list
        ArrayList<Integer> mergedList = new ArrayList<>();
        while (!pq.isEmpty()) {
            mergedList.add(pq.poll());
        }

        return mergedList;
    }

    //3. Given an array of size N, find the K largest elements in the array where K<<<N.

    public static int[] findKLargestElements(int[] arr, int k) {
        int[] result = Arrays.copyOf(arr, k);
        quickSelect(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, arr.length - k, arr.length);
    }

    public static void quickSelect(int[] arr, int low, int high, int k) {
        if (low < high) {
            int pi = partition1(arr, low, high);
            int numLargerThanPivot = high - pi + 1;

            if (numLargerThanPivot == k) {
                return;
            } else if (numLargerThanPivot > k) {
                quickSelect(arr, pi + 1, high, k);
            } else {
                quickSelect(arr, low, pi - 1, k - numLargerThanPivot);
            }
        }
    }

    public static int partition1(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low,j = high;

        while (i < j) {
            while (i <= high && arr[i] <= pivot) {
                i++;
            }
            while (j >= low && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap1(arr, i, j);
            }
        }
        swap1(arr, low, j);
        return j;
    }

    public static void swap1(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //4. Given a set of activities, along with the starting and finishing time of each activity, find the 
    //maximum number of activities performed by a single person assuming that a person can only work on a single activity at a time

    public static void MaxActivities(List<int[]> activities) {
        Collections.sort(activities,Comparator.comparingInt(a->a[1]));

        int maxActivities=1;
        int currentActivity=0;

        for (int i=1;i<activities.size();i++) {
            if (activities.get(i)[0]>=activities.get(currentActivity)[1]) {
                maxActivities++;
                currentActivity = i;
            }
        }

        System.out.println("Maximum number of activities:"+maxActivities);

        System.out.println("Activities:");
        for (int[] activity:activities) {
            System.out.print("("+activity[0]+","+activity[1]+")");
        }
    }

    //5.Given a set of intervals, print all non-overlapping intervals after merging the overlapping intervals.

    public static int[][] merge(int[][] intervals) {
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		
		for (int i=0;i<intervals.length;i++) {
			min=Math.min(min,intervals[i][0]);
			max=Math.max(max,intervals[i][0]);
		}
		
		int[] range=new int[max - min + 1];
		for (int i=0;i<intervals.length;i++) {
			range[intervals[i][0]-min]=Math.max(intervals[i][1]-min,range[intervals[i][0]-min]); 
		}
		
		int start=0,end=0;
		LinkedList<int[]> result=new LinkedList<>();
		for (int i=0;i<range.length;i++) {
			if (range[i]==0){
				continue;
			}
			if (i<=end) {
				end=Math.max(range[i],end);
			} else {
				result.add(new int[] {start+min,end+min});
				start=i;
				end=range[i];
			}
		}
		result.add(new int[] {start + min, end + min});
		return result.toArray(new int[result.size()][]);
	}
}