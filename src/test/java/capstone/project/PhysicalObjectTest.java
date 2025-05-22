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
    public void TestGetTimeOfFlight() {

        PhysicalObject[] arrayOfPhysicalObjects = {
            createPhysicalObject(0, 25, 10), 
            createPhysicalObject(10, 10, 20), 
            createPhysicalObject(5, 0, 15)
        }; 

        double[] expectedTimes = {
            0.86, 
            1.83,
            1.01
        };

        for (int i = 0; i < arrayOfPhysicalObjects.length; i++) {
            assertEquals(expectedTimes[i], arrayOfPhysicalObjects[i].getTimeOfFlight());
        }

        
        PhysicalObject testObject = createPhysicalObject(5, 20, 10);
        double calculatedTime = testObject.getTimeOfFlight(); 
        double expectedTime = 1.42; 
        assertEquals(expectedTime, calculatedTime);

    }

}
