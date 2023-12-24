package Elevators;

public class Node {
    public Node next;

    private Elevator elevator;

    public Elevator getElevator() {
        return elevator;
    }

    public Node(Elevator elevator) {
        this.elevator = elevator;
    }
}