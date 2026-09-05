import java.util.*;
public class merge_sort{

    public static void mergeSort(int[] arr){
        int length=arr.length;
        if(length<=1){
            return;
        }
        int mid=length/2;
        int[] leftArray=new int[mid];
        int[] rightArray=new int[length-mid];

        int i=0;
        int j=0;
        for(;i<length;i++){
            if(i<mid){
                leftArray[i]=arr[i];
            }
            else{
                rightArray[j]=arr[i];
                j++;
            }
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray,rightArray,arr);


    }

    public static void merge(int[] leftArray, int[] rightArray, int[] arr){
        int length=arr.length;
        int left=length/2;
        int right=length-left;
        int i=0, l=0, r=0;
        while(l<left && r<right){
            if(leftArray[l]<rightArray[r]){
                arr[i]=leftArray[l];
                i++;
                l++;
            }
            else{
                arr[i]=rightArray[r];
                i++;
                r++;
            }
        }
        while(l<left){
            arr[i]=leftArray[l];
            i++;
            l++;
        }
        while(r<right){
            arr[i]=rightArray[r];
            i++;
            r++;
        }
    }
    public static void main(String args[]){
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size=scanner.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println("Original arrays is: "+Arrays.toString(arr));

        mergeSort(arr);
        System.out.println("Merge sort array is: "+ Arrays.toString(arr));
    }
}