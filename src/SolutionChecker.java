import java.util.*;

public class SolutionChecker {
    // Replace this function with your function for testing
    public static int functionToTest(int A, int B) {
        // Implement the actual function logic here
        return 0;
    }

    // Function to find the largest square side
    public static int findLargestSquareSide(int A, int B) {
        int gcd = gcd(A, B);
        // Try the largest possible square side length which is gcd
        return gcd;
    }

    // Helper function to compute GCD
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Function to test if functionToTest is correct
    public static void answer_solution1() {
        // Test the function with various cases
        int[][] testCases = {
                {8, 9}, {1, 3}, {10, 15}, {20, 25}, {1000000, 1000000}
        };

        for (int[] testCase : testCases) {
            int A = testCase[0];
            int B = testCase[1];
            int expected = findLargestSquareSide(A, B);
            int actual = functionToTest(A, B);
            if (expected != actual) {
                System.out.println(A + " " + B);
                return;
            }
        }
        System.out.println("CORRECT");
    }

    // Define other answer_solution functions similarly for other provided functions
    // ...

    public static void main(String[] args) {
        answer_solution1();
        // Call other answer_solution functions
    }
}