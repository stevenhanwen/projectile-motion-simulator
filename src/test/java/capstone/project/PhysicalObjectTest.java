package capstone.project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class PhysicalObjectTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    public PhysicalObject createPhysicalObject(double heightOfLaunch, double angleOfLaunch, double initialVelocity) {
        PhysicalObject obj = new PhysicalObject(heightOfLaunch, angleOfLaunch, initialVelocity);
        return obj;
    }

    @Test
    public void TestGetAngleOfFinalVelocityRounded() {
        double[][] inputObjectParameters = {
                // height, angle, initial velocity
                { 0, 25, 10 },
                { 10, 10, 20 },
                { 5, 0, 15 },
                // negative angle
                { 5, -20, 15 },
                // straight up
                { 10, 90, 15 },
        };

        double[] expectedFinalAngles = { -25.0, -36.88, -33.15, -38.24, -90.0};

        for (int i = 0; i < inputObjectParameters.length; i++) {
            PhysicalObject testObject = createPhysicalObject(inputObjectParameters[i][0],
                    inputObjectParameters[i][1], inputObjectParameters[i][2]);

            assertEquals(expectedFinalAngles[i], testObject.getAngleOfFinalVelocityRounded());
        }

    }

    @Test
    public void TestGetFinalSpeed() {
        double[][] inputObjectParameters = {
                // height, angle, initial velocity
                { 0, 25, 10 },
                { 10, 10, 20 },
                { 5, 0, 15 },
                // negative angle
                { 5, -20, 15 },
                // straight up
                { 10, 90, 15 },
        };

        double[] expectedFinalSpeeds = { 10, 24.42, 17.97, 17.97, 20.52 };

        for (int i = 0; i < inputObjectParameters.length; i++) {
            PhysicalObject testObject = createPhysicalObject(inputObjectParameters[i][0],
                    inputObjectParameters[i][1], inputObjectParameters[i][2]);

            assertEquals(expectedFinalSpeeds[i], testObject.getFinalSpeedRounded());
        }

    }

    @Test
    public void TestGetMaxHeight() {
        double[][] inputObjectParameters = {
                // height, angle, initial velocity
                { 0, 25, 10 },
                { 10, 10, 20 },
                { 5, 0, 15 },
                // negative angle
                { 5, -20, 15 },
                // straight up
                { 10, 90, 15 },
        };

        double[] expectedHeights = { 0.91, 10.61, 5, 5, 21.47 };

        for (int i = 0; i < inputObjectParameters.length; i++) {
            PhysicalObject testObject = createPhysicalObject(inputObjectParameters[i][0],
                    inputObjectParameters[i][1], inputObjectParameters[i][2]);

            assertEquals(expectedHeights[i], testObject.getMaxHeight());
        }
    }

    @Test
    public void TestGetHorizontalDistanceTravelled() {
        double[][] inputObjectParameters = {
                // height, angle, initial velocity
                { 0, 25, 10 },
                { 10, 10, 20 },
                { 5, 0, 15 },
                // negative angle
                { 5, -20, 15 },
                // straight up or down
                { 10, 90, 15 },
                { 5, -90, 15 }
        };

        double[] expectedDistances = { 7.81, 35.95, 15.14, 8.66, 0, 0 };

        for (int i = 0; i < inputObjectParameters.length; i++) {
            PhysicalObject testObject = createPhysicalObject(inputObjectParameters[i][0],
                    inputObjectParameters[i][1], inputObjectParameters[i][2]);

            assertEquals(expectedDistances[i], testObject.getHorizontalDistanceTravelled());
        }

    }

    @Test
    public void TestGetTimeOfFlightRounded() {

        // PhysicalObject[] arrayOfPhysicalObjects = {
        // createPhysicalObject(0, 25, 10),
        // createPhysicalObject(10, 10, 20),
        // createPhysicalObject(5, 0, 15)
        // };

        double[][] inputObjectParameters = {
                // height, angle, initial velocity
                { 0, 25, 10 },
                { 10, 10, 20 },
                { 5, 0, 15 },
                // negative angle
                { 5, -20, 15 }
        };

        double[] expectedTimes = {
                0.86,
                1.83,
                1.01,
                0.61
        };

        for (int i = 0; i < inputObjectParameters.length; i++) {

            PhysicalObject testObject = createPhysicalObject(inputObjectParameters[i][0],
                    inputObjectParameters[i][1], inputObjectParameters[i][2]);
            assertEquals(expectedTimes[i], testObject.getTimeOfFlightRounded());
        }

        PhysicalObject testObject = createPhysicalObject(5, 20, 10);
        double calculatedTime = testObject.getTimeOfFlightRounded();
        double expectedTime = 1.42;
        assertEquals(expectedTime, calculatedTime);

    }

}
