import java.util.Scanner;

public class MinProductSubset {

    /**
     * Finds the minimum possible product from any subset of the array.
     * A subset can be a single element.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    static int minProductSubset(int a[], int n) {
        // If there's only one element, that's the answer
        if (n == 1) {
            return a[0];
        }

        // Variables to track:
        // - negmax: largest (closest to zero) negative number
        // - posmin: smallest positive number
        // - count_neg: total negative numbers
        // - count_zero: total zeros
        // - product: product of all non-zero numbers
        int negmax = Integer.MIN_VALUE;
        int posmin = Integer.MAX_VALUE;
        int count_neg = 0;
        int count_zero = 0;
        int product = 1;

        for (int i = 0; i < n; i++) {
            // If element is zero, count it but do NOT multiply
            if (a[i] == 0) {
                count_zero++;
                continue;
            }

            // Count negatives and track the largest (closest to zero) negative
            if (a[i] < 0) {
                count_neg++;
                negmax = Math.max(negmax, a[i]);
            }

            // Track the smallest positive number
            if (a[i] > 0 && a[i] < posmin) {
                posmin = a[i];
            }

            // Multiply all non-zero numbers
            product *= a[i];
        }

        // Case 1: All elements are zero, OR zeros with no negatives (only positives)
        if (count_zero == n || (count_neg == 0 && count_zero > 0)) {
            return 0;
        }

        // Case 2: All numbers are positive (no negatives, no zeros)
        if (count_neg == 0) {
            return posmin; // smallest positive gives the minimum product
        }

        // Case 3: Odd number of negatives → product of all non-zero numbers is the minimum
        if (count_neg % 2 == 1) {
            return product;
        }

        // Case 4: Even number of negatives (and at least one negative)
        // → Remove the largest negative (closest to zero) to make the product negative
        product = product / negmax;
        return product;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of the array: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int result = minProductSubset(a, n);
        System.out.println("Minimum product subset: " + result);

        sc.close();
    }
}