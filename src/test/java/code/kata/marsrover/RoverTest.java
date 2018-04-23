package code.kata.marsrover;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RoverTest {
    @Test
    public void aMarsRover_shouldShowItsPositionAndDirection() {
        Rover rover1 = new Rover(5, 10, Direction.EAST);
        Rover rover2 = new Rover(10, 5, Direction.WEST);

        assertThat(rover1.getPositionX(), equalTo(5));
        assertThat(rover1.getPositionY(), equalTo(10));
        assertThat(rover1.getDirection(), equalTo(Direction.EAST));

        assertThat(rover2.getPositionX(), equalTo(10));
        assertThat(rover2.getPositionY(), equalTo(5));
        assertThat(rover2.getDirection(), equalTo(Direction.WEST));
    }
}
