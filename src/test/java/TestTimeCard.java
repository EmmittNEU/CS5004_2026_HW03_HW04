import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import student.TimeCard;

/**
 * A test of the TimeCard class.
 */
public class TestTimeCard {

    /**
     * Test of TimeCard getEmployeeID().
     */
    @Test
    public void testTimeCard_GetEmployeeID() {
        // You'll need to create a concrete TimeCard class
        TimeCard card = new TimeCard("E001", 40.0);
        assertEquals("E001", card.getEmployeeID());
    }

    /**
     * Test of TimeCard getHoursWorked().
     */
    @Test
    public void testTimeCard_GetHoursWorked() {
        TimeCard card = new TimeCard("E001", 40.0);
        assertEquals(40.0, card.getHoursWorked(), 0.001);
    }

    /**
     * Test of TimeCard with negative hours.
     */
    @Test
    public void testTimeCard_NegativeHours() {
        TimeCard card = new TimeCard("E001", -5.0);
        assertEquals(-5.0, card.getHoursWorked(), 0.001);
    }

    /**
     * Test of TimeCard with zero hours.
     */
    @Test
    public void testTimeCard_ZeroHours() {
        TimeCard card = new TimeCard("E001", 0.0);
        assertEquals(0.0, card.getHoursWorked(), 0.001);
    }

    /**
     * Test of TimeCard with decimal hours.
     */
    @Test
    public void testTimeCard_DecimalHours() {
        TimeCard card = new TimeCard("E001", 37.5);
        assertEquals(37.5, card.getHoursWorked(), 0.001);
    }
}
