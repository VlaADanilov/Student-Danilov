package Elevators;

public class Node {
    public Node next;

    public Elevator elevator;

    Node(Elevator elevator) {
        this.elevator = elevator;
    }
}