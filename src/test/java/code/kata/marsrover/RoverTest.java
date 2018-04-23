package code.kata.marsrover;

import org.junit.Test;

import static code.kata.marsrover.Direction.*;
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
    public void aMarsRover_shouldAcceptSingleLetterCommandsToChangePosition() {
        Rover rover = new Rover(5, 10, EAST);

        rover.executeCommands("f");
        assertThat(rover.getPositionX(), equalTo(6));
        assertThat(rover.getPositionY(), equalTo(10));
        assertThat(rover.getDirection(), equalTo(EAST));

        rover.executeCommands("b");
        assertThat(rover.getPositionX(), equalTo(5));
        assertThat(rover.getPositionY(), equalTo(10));
        assertThat(rover.getDirection(), equalTo(EAST));
    }

    @Test
    public void aMarsRover_shouldAcceptSingleLetterCommandsToChangeDirection() {
        Rover rover = new Rover(5, 10, EAST);

        rover.executeCommands("l");
        assertThat(rover.getDirection(), equalTo(NORTH));
        assertThat(rover.getPositionX(), equalTo(5));
        assertThat(rover.getPositionY(), equalTo(10));

        rover.executeCommands("r");
        assertThat(rover.getDirection(), equalTo(EAST));
        assertThat(rover.getPositionX(), equalTo(5));
        assertThat(rover.getPositionY(), equalTo(10));

        rover.executeCommands("r");
        assertThat(rover.getDirection(), equalTo(SOUTH));
        assertThat(rover.getPositionX(), equalTo(5));
        assertThat(rover.getPositionY(), equalTo(10));

        rover.executeCommands("r");
        assertThat(rover.getDirection(), equalTo(WEST));
        assertThat(rover.getPositionX(), equalTo(5));
        assertThat(rover.getPositionY(), equalTo(10));

        rover.executeCommands("r");
        assertThat(rover.getDirection(), equalTo(NORTH));
        assertThat(rover.getPositionX(), equalTo(5));
        assertThat(rover.getPositionY(), equalTo(10));

        rover.executeCommands("l");
        assertThat(rover.getDirection(), equalTo(WEST));
        assertThat(rover.getPositionX(), equalTo(5));
        assertThat(rover.getPositionY(), equalTo(10));

        rover.executeCommands("l");
        assertThat(rover.getDirection(), equalTo(SOUTH));
        assertThat(rover.getPositionX(), equalTo(5));
        assertThat(rover.getPositionY(), equalTo(10));

        rover.executeCommands("l");
        assertThat(rover.getDirection(), equalTo(EAST));
        assertThat(rover.getPositionX(), equalTo(5));
        assertThat(rover.getPositionY(), equalTo(10));
    }
}
