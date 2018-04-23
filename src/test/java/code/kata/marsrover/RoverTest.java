package code.kata.marsrover;

import org.junit.Test;

import static code.kata.marsrover.Direction.*;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RoverTest {
    @Test
    public void aMarsRover_shouldShowItsPositionAndDirection() {
        Rover rover1 = new Rover(5, 10, EAST);
        Rover rover2 = new Rover(10, 5, WEST);

        assertThat(rover1.getPositionX(), equalTo(5));
        assertThat(rover1.getPositionY(), equalTo(10));
        assertThat(rover1.getDirection(), equalTo(EAST));

        assertThat(rover2.getPositionX(), equalTo(10));
        assertThat(rover2.getPositionY(), equalTo(5));
        assertThat(rover2.getDirection(), equalTo(WEST));
    }

    @Test
    public void aMarsRover_shouldMoveForwardInADirectionThatIsTheSameAsMovingBackwardsInAnOppositeDirection() {
        asList(
                asList(EAST, WEST),
                asList(WEST, EAST),
                asList(NORTH, SOUTH),
                asList(SOUTH, NORTH)
        ).forEach((opposites) -> {
            Direction direction = opposites.get(0);
            Direction oppositeDirection = opposites.get(1);

            Rover roverFacingDirection = new Rover(5, 5, direction);
            Rover roverFacingOppositeDirection = new Rover(5, 5, oppositeDirection);

            roverFacingDirection.executeCommands("f");
            roverFacingOppositeDirection.executeCommands("b");

            assertThat(roverFacingDirection.getPositionX(), equalTo(roverFacingOppositeDirection.getPositionX()));
            assertThat(roverFacingDirection.getPositionY(), equalTo(roverFacingOppositeDirection.getPositionY()));
        });
    }

    @Test
    public void aMarsRover_shouldReturnToItsOriginalPositionWhenMovingForwardsAndThenBackwards() {
        asList(EAST, WEST, NORTH, SOUTH).forEach((direction -> {
            Rover rover = new Rover(0, 0, direction);

            rover.executeCommands("f");
            rover.executeCommands("b");

            assertThat(rover.getPositionX(), equalTo(0));
            assertThat(rover.getPositionY(), equalTo(0));
            assertThat(rover.getDirection(), equalTo(direction));
        }));
    }

    @Test
    public void aMarsRover_shouldAcceptSingleLetterCommandsToChangePosition() {
        Rover eastFacingRover = new Rover(5, 10, EAST);

        eastFacingRover.executeCommands("f");
        assertThat(eastFacingRover.getPositionX(), equalTo(6));
        assertThat(eastFacingRover.getPositionY(), equalTo(10));
        assertThat(eastFacingRover.getDirection(), equalTo(EAST));

        eastFacingRover.executeCommands("b");
        assertThat(eastFacingRover.getPositionX(), equalTo(5));
        assertThat(eastFacingRover.getPositionY(), equalTo(10));
        assertThat(eastFacingRover.getDirection(), equalTo(EAST));

        Rover westFacingRover = new Rover(5, 10, WEST);

        westFacingRover.executeCommands("f");
        assertThat(westFacingRover.getPositionX(), equalTo(4));
        assertThat(westFacingRover.getPositionY(), equalTo(10));
        assertThat(westFacingRover.getDirection(), equalTo(WEST));

        westFacingRover.executeCommands("b");
        assertThat(westFacingRover.getPositionX(), equalTo(5));
        assertThat(westFacingRover.getPositionY(), equalTo(10));
        assertThat(westFacingRover.getDirection(), equalTo(WEST));

        Rover northFacingRover = new Rover(5, 10, NORTH);

        northFacingRover.executeCommands("f");
        assertThat(northFacingRover.getPositionX(), equalTo(5));
        assertThat(northFacingRover.getPositionY(), equalTo(11));
        assertThat(northFacingRover.getDirection(), equalTo(NORTH));

        northFacingRover.executeCommands("b");
        assertThat(northFacingRover.getPositionX(), equalTo(5));
        assertThat(northFacingRover.getPositionY(), equalTo(10));
        assertThat(northFacingRover.getDirection(), equalTo(NORTH));

        Rover southFacingRover = new Rover(5, 10, SOUTH);

        southFacingRover.executeCommands("f");
        assertThat(southFacingRover.getPositionX(), equalTo(5));
        assertThat(southFacingRover.getPositionY(), equalTo(9));
        assertThat(southFacingRover.getDirection(), equalTo(SOUTH));

        southFacingRover.executeCommands("b");
        assertThat(southFacingRover.getPositionX(), equalTo(5));
        assertThat(southFacingRover.getPositionY(), equalTo(10));
        assertThat(southFacingRover.getDirection(), equalTo(SOUTH));
    }

    @Test
    public void aMarsRover_shouldAcceptSingleLetterCommandsToChangeDirection() {
        Rover rover = new Rover(5, 10, EAST);

        asList(NORTH, WEST, SOUTH, EAST).forEach(nextExpectedDirection -> {
            rover.executeCommands("l");
            assertThat(rover.getDirection(), equalTo(nextExpectedDirection));
            assertThat(rover.getPositionX(), equalTo(5));
            assertThat(rover.getPositionY(), equalTo(10));
        });

        asList(SOUTH, WEST, NORTH, EAST).forEach(nextExpectedDirection -> {
            rover.executeCommands("r");
            assertThat(rover.getDirection(), equalTo(nextExpectedDirection));
            assertThat(rover.getPositionX(), equalTo(5));
            assertThat(rover.getPositionY(), equalTo(10));
        });
    }
}
