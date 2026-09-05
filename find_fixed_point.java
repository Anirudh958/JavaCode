import java.util.Scanner;
import java.util.Arrays;
public class find_fixed_point{


    private static int findFixedPoint(int[] arr, int low, int high){
        if(high<low) return -1;
        int mid=low+(high-low)/2;
            if(arr[mid]==mid){
                return mid;
            }
            int right=-1;
            if(arr[mid]< mid){
                right=findFixedPoint(arr,mid+1,high);
            }
            int left=-1;
            if(arr[mid]>mid){
                left=findFixedPoint(arr,low,mid-1);
            }
        return (left!=-1)?left:right;
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size=scanner.nextInt();
        int[] arr=new int[size];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<size;i++){
            arr[i]=scanner.nextInt();
        }
        Arrays.sort(arr);
        int fixedPoint=findFixedPoint(arr,0,size-1);
        System.out.println("The fixed point is: "+fixedPoint);
    }
}