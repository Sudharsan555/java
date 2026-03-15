import java.util.Scanner;
import java.util.Stack;

class MinStack {

    private Stack<Integer> stck;
    private Stack<Integer> aux;

    MinStack() {
        stck = new Stack<>();
        aux = new Stack<>();
    }

    void push(int val) {
        stck.push(val);

        if (aux.isEmpty() || val <= aux.peek()) {
            aux.push(val);
        }
    }

    int pop() {
        if (stck.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        int del = stck.pop();

        if (del == aux.peek()) {
            aux.pop();
        }

        return del;
    }

    int top() {
        if (stck.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return stck.peek();
    }

    int getMin() {
        if (aux.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return aux.peek();
    }
}

public class Mainstck {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MinStack ms = new MinStack();

        String choice;

        do {

            System.out.println("\n---- Min Stack Operations ----");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Get Min");
            System.out.print("Enter your choice: ");

            int op = sc.nextInt();

            switch (op) {

                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    ms.push(val);
                    break;

                case 2:
                    int popped = ms.pop();
                    if (popped != -1)
                        System.out.println("Popped element: " + popped);
                    break;

                case 3:
                    int top = ms.top();
                    if (top != -1)
                        System.out.println("Top element: " + top);
                    break;

                case 4:
                    int min = ms.getMin();
                    if (min != -1)
                        System.out.println("Minimum element: " + min);
                    break;

                default:
                    System.out.println("Invalid choice");
            }

            System.out.print("\nDo you want to continue? (yes/no): ");
            choice = sc.next();

        } while (choice.equalsIgnoreCase("yes"));

        sc.close();
    }
}