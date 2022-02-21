package lab1;

import lab1.move.MoveStrategy;

public class Hero {

    private String name;
    private MoveStrategy moveStrategy;

    public Hero(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    void move() {
        System.out.print(name + ": ");
        moveStrategy.move();
    }
}
