import java.util.Arrays;

public class StringCalculator {
    public static int addNumbers(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] numArray = numbers.split("[\n,]");
        int total = 0;

        for (String num : numArray) {
            total += Integer.parseInt(num);
        }

        return total;
    }

    public static void main(String[] args) {
        // Test case: Empty string
        System.out.println(addNumbers(""));        // Output: 0

        // Test cases: One and two numbers
        System.out.println(addNumbers("1"));       // Output: 1
        System.out.println(addNumbers("2"));       // Output: 2
        System.out.println(addNumbers("1\n2"));    // Output: 3

        // Additional test cases
        System.out.println(addNumbers("1\n2,3"));  // Output: 6
        System.out.println(addNumbers("5\n10\n15"));// Output: 30
        System.out.println(addNumbers("100"));     // Output: 100
    }
}
