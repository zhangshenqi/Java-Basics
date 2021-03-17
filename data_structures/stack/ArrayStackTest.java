/**
 * Code for testing ArrayStack.
 * @author Shenqi Zhang
 *
 */
public class ArrayStackTest {
    /**
     * Test ArrayStack.
     * @param args arguments
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<Integer>(3);
        System.out.println("Stack is empty");
        System.out.println(stack.empty());
        System.out.println("Add 1");
        System.out.println(stack.push(1));
        System.out.println("Add 2");
        System.out.println(stack.push(2));
        System.out.println("Add 3");
        System.out.println(stack.push(3));
        System.out.println("Add 4");
        System.out.println(stack.push(4));
        System.out.println("Add 5");
        System.out.println(stack.push(5));
        System.out.println("Peek");
        System.out.println(stack.peek());
        System.out.println("Stack is empty");
        System.out.println(stack.empty());
        System.out.println("Pop");
        System.out.println(stack.pop());
        System.out.println("Pop");
        System.out.println(stack.pop());
        System.out.println("Pop");
        System.out.println(stack.pop());
        System.out.println("Pop");
        System.out.println(stack.pop());
    }
}
