import java.util.Arrays;
import java.util.Scanner;

// Class to sort prices of products
public class ProductPrices {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user inputs
        System.out.print("Enter number of Products: ");
        int n = input.nextInt();

        int[] prices = new int[n];

        // loop to take prices input
        for(int i=0;i<n;i++) {
            System.out.print("Enter Price of Product " + (i+1) + ": ");
            prices[i] = input.nextInt();
        }

        // method to sort prices of product using quick sort
        quickSort(prices, 0, n-1);

        // Display the result
        System.out.print("Product Prices after sorting: ");
        System.out.println(Arrays.toString(prices));

        input.close();
    }

    // method to sort product prices using quick sort
    static void quickSort(int[] prices, int low, int high) {
        if(low<high) {
            int pi = partition(prices, low, high);
            quickSort(prices, low, pi-1);
            quickSort(prices, pi+1, high);
        }
    }

    // helper to find pivot and partition
    static int partition(int[] prices, int low, int high) {
        int pivot = prices[high], i = low-1;
        for(int j=low;j<high;j++) {
            if(prices[j]<pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        int temp = prices[i+1];
        prices[i+1] = prices[high];
        prices[high] = temp;
        return i+1;
    }
}
// Sample Output ->
// Enter number of Products: 7
// Enter Price of Product 1: 78
// Enter Price of Product 2: 50
// Enter Price of Product 3: 25
// Enter Price of Product 4: 105
// Enter Price of Product 5: 220
// Enter Price of Product 6: 48
// Enter Price of Product 7: 55
// Product Prices after sorting: [25, 48, 50, 55, 78, 105, 220]