import java.util.Arrays;
import java.util.Scanner;

// Class to sort applications of expected salary demands
public class SalaryApplicants {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user inputs
        System.out.print("Enter number of applicants: ");
        int n = input.nextInt();

        int[] salaries = new int[n];

        // loop to take salary inputs
        for(int i=0;i<n;i++) {
            System.out.print("Enter Salary demand of applicant " + (i+1) + ": ");
            salaries[i] = input.nextInt();
        }

        // method to sort salary demands of applicants
        heapSort(salaries);

        // Display the result
        System.out.print("Salary demands after sorting: ");
        System.out.println(Arrays.toString(salaries));

        input.close();
    }

    // method to sort salaries using heap sort
    static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from the heap
        for (int i = n - 1; i > 0; i--) {
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;
            heapify(salaries, i, 0);
        }
    }

    // helper method to heapify
    static void heapify(int[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;
            heapify(salaries, n, largest);
        }
    }
}
// Sample Output ->
// Enter number of applicants: 7
// Enter Salary demand of applicant 1: 45000
// Enter Salary demand of applicant 2: 35000
// Enter Salary demand of applicant 3: 42500
// Enter Salary demand of applicant 4: 37600
// Enter Salary demand of applicant 5: 40000
// Enter Salary demand of applicant 6: 38600
// Enter Salary demand of applicant 7: 42000
// Salary demands after sorting: [35000, 37600, 38600, 40000, 42000, 42500, 45000]