import java.util.Arrays;
import java.util.Scanner;

// Class to sort book prices
public class BookPrices {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user inputs
        System.out.print("Enter number of books: ");
        int n = input.nextInt();

        int[] prices = new int[n];

        // loop to take price input
        for(int i=0;i<n;i++) {
            System.out.print("Enter price of Book " + (i+1) + ": ");
            prices[i] = input.nextInt();
        }

        // merge sort to sort book prices
        mergeSort(prices, 0 , n-1);

        // Display the result
        System.out.print("Book Prices after sorting: ");
        System.out.println(Arrays.toString(prices));

        input.close();
    }

    // method to sort book prices using merge sort
    static void mergeSort(int[] prices, int left, int right) {
        if(left<right) {
            int mid = left + (right - left) / 2;
            mergeSort(prices, left, mid);
            mergeSort(prices, mid+1, right);
            merge(prices, left, mid, right);
        }
    }

    // helper function to merge divided arrays
    static void merge(int[] prices, int left, int mid, int right) {
        int l = mid - left + 1, r = right - mid;
        int[] L = new int[l];
        int[] R = new int[r];

        System.arraycopy(prices, left, L, 0, l);
        System.arraycopy(prices, mid+1, R, 0, r);

        int i = 0, j = 0, k = left;
        while(i<l && j<r) {
            if(L[i] <= R[j]) {
                prices[k++] = L[i++];
            } else {
                prices[k++] = R[j++];
            }
        }
        while(i<l) prices[k++] = L[i++];
        while(j<r) prices[k++] = R[j++];
    }
}
// Sample Output ->
// Enter number of books: 7
// Enter price of Book 1: 78
// Enter price of Book 2: 50
// Enter price of Book 3: 105
// Enter price of Book 4: 250
// Enter price of Book 5: 35
// Enter price of Book 6: 56
// Enter price of Book 7: 342
// Book Prices after sorting: [35, 50, 56, 78, 105, 250, 342]