import java.util.ArrayDeque;
import java.util.Deque;

public class ParenMatcher {

    private Deque<Character> stack = new ArrayDeque<>();
    private char[] curLine;

    public boolean processLine(String line) {
        stack.clear();
        curLine = line.toCharArray();
        for(char x : curLine)
        {
            if (x == '(')
            {
                stack.add('(');
            }
            else if (x == ')')
            {
                if (stack.size() == 0)
                    return false;
                else
                    stack.pop();
            }
        }
        if (stack.size() == 0)
            return true;
        return false;
    }

    public void processArray(String[] lines) {
        int count = 0;
        for (String line : lines) {
            if (this.processLine(line)) {
                System.out.println("Line " + count + " is valid");
            } else {
                System.out.println("Line " + count + " is invalid");
            }
            count++;
        }
    }

    public static void main(String[] args) {
        ParenMatcher pm = new ParenMatcher();
        String[] expressions = new String[4];

        expressions[0] = "if ((a == b) && (x != y));";
        expressions[1] = "if ((a == b) && (x != y)));";
        expressions[2] = "if ((firstName.equals(newFirstName) && (lastName.equals(newLastName));";
        expressions[3] = "if ((firstName.equals(newFirstName) && (lastName.equals(newLastName))));";

        pm.processArray(expressions);
    }
}
