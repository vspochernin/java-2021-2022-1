package lab1.move;

public class MovingByFootStrategy implements MoveStrategy {

    @Override
    public void move() {
        System.out.println("I am walking!");
    }
}