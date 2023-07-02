import java.util.Arrays;

public class StringCalculator {
    public static int addNumbers(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] numArray = numbers.split(",");
        int total = 0;

        for (String num : numArray) {
            total += Integer.parseInt(num);
        }

        return total;
    }

    public static int addNumbers(int... numbers) {
        int total = 0;

        for (int num : numbers) {
            total += num;
        }

        return total;
    }

    public static void main(String[] args) {
        // Test case: Empty string
        System.out.println(addNumbers(""));        // Output: 0

        // Test cases: One and two numbers
        System.out.println(addNumbers("1"));       // Output: 1
        System.out.println(addNumbers("2"));       // Output: 2
        System.out.println(addNumbers("1,2"));     // Output: 3

        // Additional test cases
        System.out.println(addNumbers("1,2,3,4")); // Output: 10
        System.out.println(addNumbers("5,10,15")); // Output: 30
        System.out.println(addNumbers("100"));     // Output: 100

        // Test case: Unknown amount of numbers
        System.out.println(addNumbers(1, 2, 3, 4, 5));  // Output: 15
        System.out.println(addNumbers(10, 20, 30));    // Output: 60
        System.out.println(addNumbers(100, 200, 300)); // Output: 600
    }
}
