package Stack;

import java.util.ArrayList;

public class StackWithArrayList<T> {

    private ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size() - 1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    public void push(T value) {
        stackList.add(value);
    }

    public T pop() {
        if (stackList.size() == 0)
            return null;
        return stackList.remove(stackList.size() - 1);
    }

    public String reverseString(String value) {
        StackWithArrayList<Character> stack = new StackWithArrayList<Character>();
        StringBuilder reversedString = new StringBuilder();
        for (char c : value.toCharArray()) {
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        return reversedString.toString();

    }

    public boolean isBalancedParentheses(String parentheses) {
        StackWithArrayList<Character> stack = new StackWithArrayList<>();
        for (char p : parentheses.toCharArray()) {
            if (p == '(') {
                stack.push(p);
            } else if (p == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public void sortStack(StackWithArrayList<Integer> stack) {
        StackWithArrayList<Integer> additionalStack = new StackWithArrayList<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!additionalStack.isEmpty() && additionalStack.peek() > temp) {
                stack.push(additionalStack.pop());
            }

            additionalStack.push(temp);
        }

        while (!additionalStack.isEmpty()) {
            stack.push(additionalStack.pop());
        }
    }

}
