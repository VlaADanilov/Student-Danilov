package Elevators;

public class OddElevator extends Elevator {

    public OddElevator(AllElevators list, String name) throws NameIsOccupiedException {
        if (list.thisNameFound(name)) throw new NameIsOccupiedException();
        this.name = name;
        condition = Condition.Free;
        feature = Feature.Odd;
        list.elevators.add(this);// list - это все лифты в этом здании,
        // Когда мы создаём этот лифт, мы должны сказать,
        // куда, в какое здание создаётся лифт
    }
}