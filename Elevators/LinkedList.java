package Elevators;

public class LinkedList {
    public Node root;
    public int count = 0;

    LinkedList() {

    }

    LinkedList(Elevator elevator) {
        root = new Node(elevator);
        count += 1;
    }

    public void add(Elevator elevator) {
        if (root == null) {
            root = new Node(elevator);
            count += 1;
        } else {
            Node temp = root;
            while (temp.next != root) {
                temp = temp.next;
            }
            temp.next = new Node(elevator);
            count += 1;
        }
        close();
    }

    public void close() {
        Node temp = root;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = root;
    }
}