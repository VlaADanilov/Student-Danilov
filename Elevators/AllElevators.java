package Elevators;

public class AllElevators implements CheckFree, Call {

    public LinkedList elevators;

    public AllElevators(Elevator elevator) {
        elevators = new LinkedList(elevator);
    }

    public AllElevators() {
        elevators = new LinkedList();
    }

    public Elevator elevatorFree(Feature feature) {
        Node temp = elevators.root;
        for (int a = 0; a < elevators.count; a += 1) {
            if (temp.elevator.condition == Condition.Free && temp.elevator.feature == feature) {
                return temp.elevator;
            }
            temp = temp.next;
        }
        return null; // Метод возвращает первый попавшийся свободный лифт
        // который нужен человеку в зависимости от ситуации
        // НО, если он не нашёл такого, он возвращает пустоту
        // то есть свободных лифтов нет
    }

    public boolean thisNameFound(String name) {
        Node temp = elevators.root;
        for (int i = 0; i < elevators.count; i += 1) {
            if (temp.elevator.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    private void caller(Feature feature) throws ElevatorNotFreeException {
        Elevator now = elevatorFree(feature);
        if (now == null) {
            throw new ElevatorNotFreeException();
        }
        System.out.println("Лифт к вам уже едет");
        now.changeCondition();
    }


    public void call(Feature feature) {
        try {
            caller(feature);
        } catch (ElevatorNotFreeException e) {
            System.out.println("Все лифты для " + feature + " заняты, просим вас подождать");
        } catch (Exception e) {
            System.err.println("Not definded Error");
        }
    }
}