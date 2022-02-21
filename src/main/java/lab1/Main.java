package lab1;

import lab1.move.MovingByFlightStrategy;
import lab1.move.MovingByFootStrategy;
import lab1.move.MovingByRidingStrategy;

public class Main {
    public static void main(String[] args) {
        Hero ivan = new Hero("Ivan", new MovingByFootStrategy());
        ivan.move();
        ivan.setMoveStrategy(new MovingByRidingStrategy());
        ivan.move();
        ivan.setMoveStrategy(new MovingByFlightStrategy());
        ivan.move();

        Hero denis = new Hero("Denis", new MovingByRidingStrategy());
        ivan.move();
        denis.move();
    }
}
