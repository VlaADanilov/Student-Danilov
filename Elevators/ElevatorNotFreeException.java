package Elevators;

public class ElevatorNotFreeException extends Exception{
    public ElevatorNotFreeException() {
        super("Свободного лифта нет");
    }
}