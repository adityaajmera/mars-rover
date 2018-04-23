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

    public void executeCommands(String commands) {
        switch (commands) {
            case "f":
                this.x++;
                break;
            case "b":
                this.x--;
                break;
            case "l":
                rotateCounterClockwise();
                break;
            case "r":
                rotateClockwise();
                break;
        }
    }

    private void rotateCounterClockwise() {
        int positionOfDirectionInArray = this.direction.ordinal();
        int indexOfPreviousDirection = (4 + positionOfDirectionInArray - 1) % 4;
        this.direction = Direction.values()[indexOfPreviousDirection];
    }

    private void rotateClockwise() {
        int positionOfDirectionInArray = this.direction.ordinal();
        int indexOfNextDirection = (positionOfDirectionInArray + 1) % 4;
        this.direction = Direction.values()[indexOfNextDirection];
    }
}
