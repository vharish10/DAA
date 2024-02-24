public class SelectionSort {

    void sort(int arr[]){ 
        int n = arr.length; 
        for (int i=0;i<n-1;i++){ 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
  
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
    } 
  
    void printArray(int arr[]){ 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
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
        sort(arr);
        long end_time=System.currentTimeMillis();
        System.out.println("Sorted array: ");
        printArray(arr);
        System.out.println("Time Taken:"+(end_time-start_time));
    } 
}