package Elevators;

public class EvenElevator extends Elevator {

    public EvenElevator(AllElevators list, String name) throws NameIsOccupiedException {
        if (list.thisNameFound(name)) throw new NameIsOccupiedException();
        this.name = name;
        feature = Feature.Even;
        condition = Condition.Free;
        list.elevators.add(this); // list - это все лифты в этом здании,
        // Когда мы создаём этот лифт, мы должны сказать,
        // куда, в какое здание создаётся лифт
    }
}