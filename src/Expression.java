import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

  private final List<String> leftBrackets = Arrays.asList("(", "[", "{", "<");
  private final List<String> rightBrackets = Arrays.asList(")", "]", "}", ">");

  public boolean isBalanced(String input) {
    Stack<Character> stack = new Stack<>();
    for (char ch : input.toCharArray()) {
      if (leftBrackets.contains((ch + ""))) {
        stack.push(ch);
      }

      if (rightBrackets.contains(ch + "")) {
        if (stack.isEmpty()) {
          return false;
        }

        char top = stack.pop();
        if (!this.bracketsMatch(top, ch)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean bracketsMatch(char left, char right) {
    return leftBrackets.indexOf(left + "") == rightBrackets.indexOf(right + "");
  }
}
