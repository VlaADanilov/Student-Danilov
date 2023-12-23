package Elevators;

public class Main {
    public static void main(String[] args) throws NameIsOccupiedException {
        AllElevators KFU = new AllElevators();

        EvenElevator even1 = new EvenElevator(KFU, "лифт 12 для чётных этажей");
        EvenElevator even2 = new EvenElevator(KFU, "лифт 38 для чётных этажей");
        EvenElevator even3 = new EvenElevator(KFU, "лифт 99999 для чётных этажей");

        OddElevator odd1 = new OddElevator(KFU, "лифт 15 для нечётных этажей");
        OddElevator odd2 = new OddElevator(KFU, "лифт 28 для нечётных этажей");
        OddElevator odd3 = new OddElevator(KFU, "лифт 88 для нечётных этажей");

        PersonalElevator person1 = new PersonalElevator(KFU, "Лифт 1 для персонала");

        KFU.call(Feature.Personal);
        System.out.println(person1);
        KFU.call(Feature.Personal);
        person1.isFreeNow();
        System.out.println(person1);
        KFU.call(Feature.Personal);
        KFU.call(Feature.Personal);

        System.out.println();

        KFU.call(Feature.Even);
        KFU.call(Feature.Even);
        KFU.call(Feature.Even);
        even2.isFreeNow();
        even1.isFreeNow();
        KFU.call(Feature.Even);
        KFU.call(Feature.Even);
        KFU.call(Feature.Even);
        KFU.call(Feature.Even);


        System.out.println();

        KFU.call(Feature.Odd);
        KFU.call(Feature.Odd);
        odd1.isFreeNow();
        KFU.call(Feature.Odd);
        KFU.call(Feature.Odd);
        KFU.call(Feature.Odd);
        odd3.isFreeNow();
        KFU.call(Feature.Odd);
        odd2.isFreeNow();
        KFU.call(Feature.Odd);
    }
}