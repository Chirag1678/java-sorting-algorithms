import java.util.Arrays;
import java.util.Scanner;

// Class to sort ages of students
public class StudentAges {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user inputs
        System.out.print("Enter number of Students: ");
        int n = input.nextInt();

        int[] ages = new int[n];
        int maxAge = 0;
        // loop to take age input
        for(int i=0;i<n;i++) {
            System.out.print("Enter age of Student " + (i+1) + ": ");
            ages[i] = input.nextInt();
            maxAge = Math.max(maxAge, ages[i]);
        }

        // method to sort ages of students
        countingSort(ages, maxAge);

        // Display the result
        System.out.print("Student ages after sorting: ");
        System.out.println(Arrays.toString(ages));

        input.close();
    }

    // method to sort ages of students using counting sort
    static void countingSort(int[] ages, int maxAge) {
        int n = ages.length;
        int[] count = new int[maxAge + 1];
        int[] output = new int[n];

        // Count occurrences
        for (int age : ages) {
            count[age]++;
        }

        // Modify count array to store the position of elements
        for (int i=1;i<=maxAge;i++) {
            count[i] += count[i-1];
        }

        // Build output array
        for (int i=n-1;i>=0;i--) {
            output[count[ages[i]]-1] = ages[i];
            count[ages[i]]--;
        }

        // Copy sorted elements back to original array
        System.arraycopy(output, 0, ages, 0, n);
    }
}
// Sample Output ->
// Enter number of Students: 7
// Enter age of Student 1: 10
// Enter age of Student 2: 18
// Enter age of Student 3: 12
// Enter age of Student 4: 15
// Enter age of Student 5: 18
// Enter age of Student 6: 17
// Enter age of Student 7: 14
// Student ages after sorting: [10, 12, 14, 15, 17, 18, 18]