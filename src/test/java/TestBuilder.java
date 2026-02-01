import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import student.*;

/**
 * A test of the Builder class.
 */
public class TestBuilder {

    /**
     * Test of building an employee from CSV (Hourly).
     */
    @Test
    public void testBuildEmployeeFromCSV_HourlyEmployee() {
        String csv = "Hourly,John Doe,E001,20.00,0.00,0.00,0.00";
        IEmployee emp = Builder.buildEmployeeFromCSV(csv);
        assertNotNull(emp);
        assertTrue(emp instanceof HourlyEmployee);
        assertEquals("John Doe", emp.getName());
        assertEquals("E001", emp.getID());
        assertEquals(20.00, emp.getPayRate(), 0.001);
    }

    /**
     * Test of building an employee from CSV (Salary).
     */
    @Test
    public void testBuildEmployeeFromCSV_SalaryEmployee() {
        String csv = "Salary,Jane Smith,E002,60000.00,0.00,0.00,0.00";
        IEmployee emp = Builder.buildEmployeeFromCSV(csv);
        assertNotNull(emp);
        assertTrue(emp instanceof SalaryEmployee);
        assertEquals("Jane Smith", emp.getName());
        assertEquals("E002", emp.getID());
        assertEquals(60000.00, emp.getPayRate(), 0.001);
    }

    /**
     * Test of building an employee from CSV with correct ytd values.
     */
    @Test
    public void testBuildEmployeeFromCSV_WithYTDValues() {
        String csv = "Hourly,Test Person,E003,25.50,50.00,5000.00,1132.50";
        IEmployee emp = Builder.buildEmployeeFromCSV(csv);
        assertEquals(5000.00, emp.getYTDEarnings(), 0.001);
        assertEquals(1132.50, emp.getYTDTaxesPaid(), 0.001);
        assertEquals(50.00, emp.getPretaxDeductions(), 0.001);
    }

    /**
     * Test of building an employee with an invalid type, which should return null.
     */
    @Test
    public void testBuildEmployeeFromCSV_InvalidType_ReturnsNull() {
        String csv = "Invalid,Test,E004,20.00,0.00,0.00,0.00";
        IEmployee emp = Builder.buildEmployeeFromCSV(csv);
        assertNull(emp);
    }

    /**
     * Test of building employee from malformed CSV, which returns null.
     */
    @Test
    public void testBuildEmployeeFromCSV_MalformedCSV_ReturnsNull() {
        String csv = "Hourly,Test";
        IEmployee emp = Builder.buildEmployeeFromCSV(csv);
        assertNull(emp);
    }

    /**
     * Test of building employee from an empty string, which returns null.
     */
    @Test
    public void testBuildEmployeeFromCSV_EmptyString_ReturnsNull() {
        IEmployee emp = Builder.buildEmployeeFromCSV("");
        assertNull(emp);
    }

    /**
     * Test of building an employee from a null string, which returns null.
     */
    @Test
    public void testBuildEmployeeFromCSV_NullString_ReturnsNull() {
        IEmployee emp = Builder.buildEmployeeFromCSV(null);
        assertNull(emp);
    }

    /**
     * Test of building a time card with enough valid CSV info.
     */
    @Test
    public void testBuildTimeCardFromCSV_Valid() {
        String csv = "E001,40.0";
        ITimeCard card = Builder.buildTimeCardFromCSV(csv);
        assertNotNull(card);
        assertEquals("E001", card.getEmployeeID());
        assertEquals(40.0, card.getHoursWorked(), 0.001);
    }

    /**
     * Test of building time card with negative hours.
     */
    @Test
    public void testBuildTimeCardFromCSV_NegativeHours() {
        String csv = "E001,-5.0";
        ITimeCard card = Builder.buildTimeCardFromCSV(csv);
        assertNotNull(card);
        assertEquals(-5.0, card.getHoursWorked(), 0.001);
    }

    /**
     * Test of building a time card from CSV with decimal hours.
     */
    @Test
    public void testBuildTimeCardFromCSV_DecimalHours() {
        String csv = "E001,37.5";
        ITimeCard card = Builder.buildTimeCardFromCSV(csv);
        assertNotNull(card);
        assertEquals(37.5, card.getHoursWorked(), 0.001);
    }

    /**
     * Test of building a time card from CSV with malformed data, returns null.
     */
    @Test
    public void testBuildTimeCardFromCSV_MalformedCSV_ReturnsNull() {
        String csv = "E001";
        ITimeCard card = Builder.buildTimeCardFromCSV(csv);
        assertNull(card);
    }

    /**
     * Test of building a time card from CSV with an empty string, returns null.
     */
    @Test
    public void testBuildTimeCardFromCSV_EmptyString_ReturnsNull() {
        ITimeCard card = Builder.buildTimeCardFromCSV("");
        assertNull(card);
    }

    /**
     * Test of building time card from CSV from null string, returns null.
     */
    @Test
    public void testBuildTimeCardFromCSV_NullString_ReturnsNull() {
        ITimeCard card = Builder.buildTimeCardFromCSV(null);
        assertNull(card);
    }
}
