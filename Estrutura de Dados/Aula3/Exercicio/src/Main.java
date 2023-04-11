import java.util.Stack;

public class Main {
    public static void reverse(Stack<Integer> stack) {
        if (!stack.empty()) {
            int temp = stack.pop();
            reverse(stack);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        System.out.println(stack);
    }
}
