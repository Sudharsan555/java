import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinearQueueLL {
    Node front, rear;
    int count = 0;

    void enqueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        count++;
    }

    int dequeue() {
        if (front == null) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int val = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        count--;
        return val;
    }

    void display() {
        if (front == null) {
            System.out.println("Empty Queue");
            return;
        }

        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    int peek() {
        if (front == null) return -1;
        return front.data;
    }

    boolean isEmpty() {
        return front == null;
    }

    int count() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearQueueLL q = new LinearQueueLL();

        int choice, val;

        while (true) {
            System.out.println("\n1.Enqueue 2.Dequeue 3.Display 4.Peek 5.isEmpty 6.Count 7.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    val = sc.nextInt();
                    q.enqueue(val);
                    break;

                case 2:
                    val = q.dequeue();
                    System.out.println("Deleted: " + val);
                    break;

                case 3:
                    q.display();
                    break;

                case 4:
                    System.out.println("Front: " + q.peek());
                    break;

                case 5:
                    System.out.println(q.isEmpty());
                    break;

                case 6:
                    System.out.println("Count: " + q.count());
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}