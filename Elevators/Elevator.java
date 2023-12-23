package Elevators;

public abstract class Elevator {
    Condition condition;
    Feature feature;
    String name;

    public void changeCondition() {
        if (condition == Condition.Free) condition = Condition.Busy;
        else condition = Condition.Free;
    }

    public void isFreeNow() {
        condition = Condition.Free;
    }

    public String toString() {
        return "Лифт c названием \"" + name + "\". Он для " + feature + ". Статус - " + condition;
    }
}
