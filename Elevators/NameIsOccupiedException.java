package Elevators;

public class NameIsOccupiedException extends Exception{
    public NameIsOccupiedException() {
        super("Такое имя лифта в этом здании уже есть");
    }
}
