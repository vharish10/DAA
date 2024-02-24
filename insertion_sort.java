public class InsertionSort {
    void sort(int arr[]){
        int n=arr.length;
        for (int i=1;i<n;++i) {
            int key=arr[i];
            int j=i-1;
            while (j>=0 && arr[j]>key) {
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
    }
    
    static void printArray(int arr[]){
        int n=arr.length;
        for (int i=0;i<n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
 
    public static void main(String args[]){
         Random rand=new Random();
        int arr[]=new int[50];
        for(int i=0;i<n;i++){
            arr[i]=rand.nextInt(50);
        }
        int n=arr.length;
        long start_time=System.currentTimeMillis();
        bubbleSort(arr, n);
        long end_time=System.currentTimeMillis();
        System.out.println("Sorted array: ");
        printArray(arr, n);
        System.out.println("Time Taken:"+(end_time-start_time));
    }
}