package Elevators;

public abstract class Elevator {
    protected Condition condition;
    protected Feature feature;
    protected String name;

    public Condition getCondition() {
        return condition;
    }

    public Feature getFeature() {
        return feature;
    }

    public String getName() {
        return name;
    }

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
