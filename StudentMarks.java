import java.util.Arrays;
import java.util.Scanner;

// Class to sort student marks
public class StudentMarks {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user inputs
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        int[] marks = new int[n];

        // loop to take marks input
        for(int i=0;i<n;i++) {
            System.out.print("Enter marks of Student " + (i+1) + ": ");
            marks[i] = input.nextInt();
        }

        // bubble sort to sort marks
        bubbleSort(marks);

        // Display the result
        System.out.print("Students marks in ascending order: ");
        System.out.println(Arrays.toString(marks));

        input.close();
    }

    // method to sort marks using bubble sort
    static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swap; // to check if swap happened

        for(int i=0;i<n-1;i++) {
            swap = false;
            for(int j=i+1;j<n;j++) {
                if(marks[i]>marks[j]) {
                    int temp = marks[i];
                    marks[i] = marks[j];
                    marks[j] = temp;
                    swap = true;
                }
            }
            if(!swap) break;
        }
    }
}
// Sample Output ->
// Enter number of students: 7
// Enter marks of Student 1: 90
// Enter marks of Student 2: 45
// Enter marks of Student 3: 67
// Enter marks of Student 4: 88
// Enter marks of Student 5: 54
// Enter marks of Student 6: 65
// Enter marks of Student 7: 12
// Students marks in ascending order: [12, 45, 54, 65, 67, 88, 90]