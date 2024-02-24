class BS {
    static void bubbleSort(int arr[], int n){
        int i,j,temp;
        boolean swapped;
        for(i=0;i<n-1;i++) {
            swapped=false;
            for(j=0;j<n-i-1;j++) {
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if (swapped==false)
                break;
        }
    }
 
    static void printArray(int arr[],int size){
        int i;
        for (i=0;i<size;i++)
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