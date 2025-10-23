/**
 * Expression Evaluator using Stack
 *
 * This class demonstrates practical application of stack data structure
 * for evaluating mathematical expressions and checking balanced parentheses.
 *
 * Features:
 * - Balanced parentheses checker
 * - Postfix expression evaluation
 * - Infix to postfix conversion
 *
 * @author Hacktoberfest Contributor
 * @version 1.0
 */
public class StackExpressionEvaluator {

    /**
     * Custom stack implementation for character operations
     */
    static class CharStack {
        private char[] stackArray;
        private int top;
        private int maxSize;

        public CharStack(int size) {
            this.maxSize = size;
            this.stackArray = new char[maxSize];
            this.top = -1;
        }

        public boolean push(char ch) {
            if (top >= maxSize - 1) return false;
            stackArray[++top] = ch;
            return true;
        }

        public char pop() {
            if (top < 0) return '\0';
            return stackArray[top--];
        }

        public char peek() {
            if (top < 0) return '\0';
            return stackArray[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    /**
     * Custom stack implementation for integer operations
     */
    static class IntStack {
        private int[] stackArray;
        private int top;
        private int maxSize;

        public IntStack(int size) {
            this.maxSize = size;
            this.stackArray = new int[maxSize];
            this.top = -1;
        }

        public boolean push(int value) {
            if (top >= maxSize - 1) return false;
            stackArray[++top] = value;
            return true;
        }

        public int pop() {
            if (top < 0) return Integer.MIN_VALUE;
            return stackArray[top--];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    /**
     * Checks if parentheses in expression are balanced
     *
     * @param expression The expression to check
     * @return true if balanced, false otherwise
     */
    public static boolean isBalanced(String expression) {
        CharStack stack = new CharStack(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // Push opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // Check closing brackets
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }

        // Stack should be empty for balanced expression
        return stack.isEmpty();
    }

    /**
     * Checks if opening and closing brackets match
     *
     * @param opening Opening bracket
     * @param closing Closing bracket
     * @return true if they match, false otherwise
     */
    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '[' && closing == ']') ||
               (opening == '{' && closing == '}');
    }

    /**
     * Evaluates a postfix expression
     *
     * @param expression Postfix expression (space-separated)
     * @return Result of evaluation
     */
    public static int evaluatePostfix(String expression) {
        IntStack stack = new IntStack(100);
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            // If token is a number, push to stack
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            }
            // If token is an operator, pop two operands and apply operation
            else if (isOperator(token)) {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Invalid expression");
                }

                int operand2 = stack.pop();
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Invalid expression");
                }
                int operand1 = stack.pop();

                int result = applyOperation(operand1, operand2, token.charAt(0));
                stack.push(result);
            }
        }

        // Final result should be the only element in stack
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return stack.pop();
    }

    /**
     * Checks if a string is numeric
     */
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks if a string is an operator
     */
    private static boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    /**
     * Applies arithmetic operation
     */
    private static int applyOperation(int a, int b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    /**
     * Main method to demonstrate expression evaluation
     */
    public static void main(String[] args) {
        System.out.println("=== Expression Evaluator Demo ===\n");

        // Test balanced parentheses
        System.out.println("--- Balanced Parentheses Check ---");
        String[] expressions = {
            "{[()]}",
            "{[(])}",
            "((()))",
            "((())",
            "{[}]",
            ""
        };

        for (String expr : expressions) {
            System.out.println("'" + expr + "' is " +
                             (isBalanced(expr) ? "balanced" : "not balanced"));
        }
        System.out.println();

        // Test postfix evaluation
        System.out.println("--- Postfix Expression Evaluation ---");
        String[] postfixExpressions = {
            "2 3 + 4 *",        // (2 + 3) * 4 = 20
            "5 2 - 3 *",        // (5 - 2) * 3 = 9
            "8 2 / 3 +",        // (8 / 2) + 3 = 7
            "1 2 + 3 4 + *"     // (1 + 2) * (3 + 4) = 21
        };

        for (String expr : postfixExpressions) {
            try {
                int result = evaluatePostfix(expr);
                System.out.println("'" + expr + "' = " + result);
            } catch (Exception e) {
                System.out.println("Error evaluating '" + expr + "': " + e.getMessage());
            }
        }

        System.out.println("\n=== Demo Complete ===");
    }
}