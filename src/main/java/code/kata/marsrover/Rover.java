package code.kata.marsrover;

public class Rover {
    private int x;
    private int y;
    private Direction direction;

    public Rover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getPositionX() {
        return x;
    }

    public int getPositionY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}
