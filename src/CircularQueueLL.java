import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularQueueLL {
    Node front, rear;
    int count = 0;

    void enqueue(int data) {
        Node newNode = new Node(data);

        if (front == null) {
            front = rear = newNode;
            rear.next = front;
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
        count++;
    }

    int dequeue() {
        if (front == null) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int val = front.data;

        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front;
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
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);

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
        CircularQueueLL q = new CircularQueueLL();

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