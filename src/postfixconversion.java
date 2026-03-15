import java.util.Scanner;
import java.util.Stack;

class Solution {

    // Function to return precedence of operators
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // Function to convert infix to postfix
    static String convertPostFix(String infix) {

        Stack<Character> stk = new Stack<>();
        StringBuilder res = new StringBuilder();

        char[] infixarr = infix.toCharArray();

        for (char ch : infixarr) {

            // If operand → add to result
            if (Character.isLetterOrDigit(ch)) {
                res.append(ch);
            }

            // If '(' push to stack
            else if (ch == '(') {
                stk.push(ch);
            }

            // If ')' pop until '('
            else if (ch == ')') {
                while (!stk.isEmpty() && stk.peek() != '(') {
                    res.append(stk.pop());
                }
                stk.pop(); // remove '('
            }

            // Operator case
            else {

                while (!stk.isEmpty() &&
                       precedence(ch) <= precedence(stk.peek())) {
                    res.append(stk.pop());
                }

                stk.push(ch);
            }
        }

        // Pop remaining operators
        while (!stk.isEmpty()) {
            res.append(stk.pop());
        }

        return res.toString();
    }
}

public class postfixconversion {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter infix expression: ");
        String infix = sc.nextLine();

        String postfix = Solution.convertPostFix(infix);

        System.out.println("Postfix expression: " + postfix);

        sc.close();
    }
}