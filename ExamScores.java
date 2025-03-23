import java.util.Arrays;
import java.util.Scanner;

// Class to sort exam scores of students
public class ExamScores {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user inputs
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        int[] scores = new int[n];

        // loop to take scores input
        for(int i=0;i<n;i++) {
            System.out.print("Enter Score of Student " + (i+1) + ": ");
            scores[i] = input.nextInt();
        }

        // method to sort scores of students
        selectionSort(scores);

        // Display the result
        System.out.print("Student scores after sorting: ");
        System.out.println(Arrays.toString(scores));

        input.close();
    }

    // method to sort marks of students using selection sort
    static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i=0;i<n-1;i++) {
            int minIndex = i;
            for (int j=i+1;j<n;j++) {
                if (scores[j]<scores[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }
}
// Sample Output ->
// Enter number of students: 7
// Enter Score of Student 1: 98
// Enter Score of Student 2: 56
// Enter Score of Student 3: 45
// Enter Score of Student 4: 78
// Enter Score of Student 5: 23
// Enter Score of Student 6: 90
// Enter Score of Student 7: 38
// Student scores after sorting: [23, 38, 45, 56, 78, 90, 98]