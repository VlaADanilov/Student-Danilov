package Elevators;

public interface Call {
    void call(Feature feature) throws ElevatorNotFreeException;
}