import java.util.*;
public class stock_buy_infinite_transaction{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size=scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<size;i++){
            arr[i]=scanner.nextInt();
        }
        int maxProfit=0;
        for(int i=0;i<size-1;i++){
            if(arr[i]<arr[i+1]){
                maxProfit+=(arr[i+1]-arr[i]);
            }
        }
        System.out.println("The maximum profit is: "+maxProfit);
    }
}