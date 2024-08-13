import java.util.*
;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      Solution output = new Solution();
      Scanner scanner = new Scanner(System.in);
      String input = scanner.next();
      System.out.println(output.solution(input));
    }
}


class Solution {
    public String solution(String numStr) {
        int[] fq = new int[10];
        for (char c : numStr.toCharArray()) {
            fq[c - '0']++;
        }
        String palindrome = getPalindrome(fq);
        //it removes the trailing zeros
        String str = palindrome.replaceAll("0*$", "");
        if (str.isEmpty()) {
            str = "0";
        }
        int result = Integer.parseInt(str);
        return String.valueOf(result);
    }
    // It calculates the Maximum Palindrome for a given frequency
    private String getPalindrome(int[] fq){
        StringBuilder half = new StringBuilder();
        char middle = 0;
        boolean hasMiddle = false;
        for (int i = 9; i >= 0; i--) {
            if (fq[i] % 2 != 0) {
                if (!hasMiddle) {
                    middle = (char) (i + '0');
                    hasMiddle = true;
                }
                fq[i]--;
            }
            for (int j = 0; j < fq[i] / 2; j++) {
                half.append((char) (i + '0'));
            }
        }
        StringBuilder palindrome = new StringBuilder(half);
        if (hasMiddle) {
            palindrome.append(middle);
        }
        palindrome.append(half.reverse());
        return palindrome.toString();
    }
}