import java.util.*;
public class quick_sort{

    public static void quick_sort(int[] arr,int start, int end){
        if(end<=start){
            return;
        }
        int pivot=partition(arr,start,end);
        quick_sort(arr,start,pivot-1);
        quick_sort(arr,pivot+1,end);
    }

    public static int partition(int[] arr, int start, int end){
        int pivot=arr[end];
        int i=start-1;
        for(int j=start;j<=end-1;j++){
            if(arr[j]<pivot){
                i++;
                int tmp;
                tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
            }
        }
        i++;
        int tmp;
        tmp=arr[i];
        arr[i]=arr[end];
        arr[end]=tmp;
        return i;

    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size=scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements for the array: ");
        for(int i=0;i<size;i++){
            arr[i]=scanner.nextInt();
        }

        System.out.println("The original array is: ");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        quick_sort(arr,0,arr.length-1);
        System.out.println("\nThe sorted array is: ");
        System.out.println(Arrays.toString(arr));
    }
}