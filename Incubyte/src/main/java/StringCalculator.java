import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int addNumbers(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        // Check if a custom delimiter is specified
        Pattern pattern = Pattern.compile("//(.+)\n(.+)");
        Matcher matcher = pattern.matcher(numbers);
        if (matcher.matches()) {
            String delimiter = Matcher.quoteReplacement(matcher.group(1)); // Escape delimiter
            String numberString = matcher.group(2);
            return sumNumbersWithDelimiter(numberString, delimiter);
        }

        // Default delimiter is a comma
        return sumNumbersWithDelimiter(numbers, ",");
    }

    private static int sumNumbersWithDelimiter(String numbers, String delimiter) {
        String[] numArray = numbers.split("[\n" + Pattern.quote(delimiter) + "]");
        int total = 0;

        for (String num : numArray) {
            total += Integer.parseInt(num);
        }

        return total;
    }

    public static void main(String[] args) {
        // Test case: Empty string
        System.out.println(addNumbers(""));                 // Output: 0

        // Test cases: One and two numbers
        System.out.println(addNumbers("1"));                // Output: 1
        System.out.println(addNumbers("2"));                // Output: 2
        System.out.println(addNumbers("1\n2"));             // Output: 3

        // Additional test cases
        System.out.println(addNumbers("1\n2,3"));           // Output: 6
        System.out.println(addNumbers("5\n10\n15"));        // Output: 30
        System.out.println(addNumbers("100"));              // Output: 100

        // Test cases with custom delimiters
        System.out.println(addNumbers("//;\n1;2"));         // Output: 3
        System.out.println(addNumbers("//-\n4-6-8"));       // Output: 18
        System.out.println(addNumbers("//|\n10|20|30"));    // Output: 60
    }
}
