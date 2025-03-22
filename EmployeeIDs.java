import java.util.Arrays;
import java.util.Scanner;

// Class to sort Employee IDs
public class EmployeeIDs {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user inputs
        System.out.print("Enter number of employees: ");
        int n = input.nextInt();

        int[] empId = new int[n];

        // loop to take id input
        for(int i=0;i<n;i++) {
            System.out.print("Enter ID of Employee " + (i+1) + ": ");
            empId[i] = input.nextInt();
        }

        // insertion sort to sort employee id
        insertionSort(empId);

        // Display the result
        System.out.print("Employee IDs after sorting: ");
        System.out.println(Arrays.toString(empId));

        input.close();
    }

    // method to sort employee id using insertion sort
    static void insertionSort(int[] empId) {
        int n = empId.length;

        for(int i=0;i<n-1;i++) {
            int key = empId[i];
            int j = i+1;
            while(j<n && empId[j]<key) {
                empId[j-1] = empId[j];
                j++;
            }
            empId[j-1] = key;
        }
    }
}
// Sample Outut ->
// Enter number of employees: 7
// Enter ID of Employee 1: 1001
// Enter ID of Employee 2: 101
// Enter ID of Employee 3: 243
// Enter ID of Employee 4: 254
// Enter ID of Employee 5: 689
// Enter ID of Employee 6: 901
// Enter ID of Employee 7: 777
// Employee IDs after sorting: [101, 243, 254, 689, 777, 901, 1001]