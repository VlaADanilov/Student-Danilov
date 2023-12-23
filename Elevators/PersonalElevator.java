package Elevators;

public class PersonalElevator extends Elevator {

    PersonalElevator(AllElevators list, String name) throws NameIsOccupiedException {
        if (list.thisNameFound(name)) throw new NameIsOccupiedException();
        this.name = name;
        condition = Condition.Free;
        feature = Feature.Personal;
        list.elevators.add(this);// list - это все лифты в этом здании,
        // Когда мы создаём этот лифт, мы должны сказать,
        // куда, в какое здание создаётся лифт
    }
}