package lab1.move;

public class MovingByFlightStrategy implements MoveStrategy {

    @Override
    public void move() {
        System.out.println("I am flying!");
    }
}
