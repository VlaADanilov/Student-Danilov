package Elevators;

public enum Feature {

    Even("Чётных этажей"), Odd("Нечётных этажей"), Personal("Персонала");

    private String message;

    Feature(String message){
        this.message=message;
    }

    @Override
    public String toString() {
        return message;
    }
}