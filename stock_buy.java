import java.util.*;

public class stock_buy{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size=scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<size;i++){
            arr[i]=scanner.nextInt();
        }

        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<size;i++){
            if(arr[i]<minPrice){
                minPrice=arr[i];
            }
            else{
                int profit=arr[i]-minPrice;
                if(profit>maxProfit){
                    maxProfit=profit;
                }
            }
        }
        System.out.println("The maximum profit is: "+maxProfit);
    }
}