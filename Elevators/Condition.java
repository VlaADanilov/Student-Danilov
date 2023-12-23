package Elevators;

public enum Condition {
    Busy("занят"), Free("свободен");

    private String status;

    Condition(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}