
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnlineSolution {

    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        // String inputFilePath = getPath("example", directory);
        int result1 = 0;
        int result2 = 0;
        String regex = "mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)";
        Pattern pattern = Pattern.compile(regex);
        Pattern pattern1 = Pattern.compile("\\d+");
        boolean doOperation = true;
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
            for (String line : br.lines().toList()) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String match = matcher.group();
                    if (match.equals("do()")) {
                        doOperation = true;
                    } else if (match.equals("don't()")) {
                        doOperation = false;
                    } else {
                        Matcher matcher1 = pattern1.matcher(match);
                        int[] nums = { 0, 0 };
                        int i = 0;
                        while (matcher1.find()) {
                            nums[i] = Integer.parseInt(matcher1.group());
                            i++;
                        }
                        int mul = nums[0] * nums[1];
                        result1 += mul;
                        if (doOperation)
                            result2 += mul;
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("Result of part 1: %d\n", result1);
        System.out.printf("Result of part 2: %d\n", result2);

    }
}