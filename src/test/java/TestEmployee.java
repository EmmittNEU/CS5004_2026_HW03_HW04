package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestEmployee {
    private HourlyEmployee hourlyEmployee;
    private SalaryEmployee salaryEmployee;

    @BeforeEach
    public void setUp() {
        // Fresh instances for each test
        hourlyEmployee = new HourlyEmployee("John", "H001", 20.00, 0, 0, 0);
        salaryEmployee = new SalaryEmployee("Jane", "S002", 60000, 0, 0, 0);
    }

    // ========== Constructor Tests ==========

    @Test
    public void testHourlyEmployeeConstructor_ValidData() {
        HourlyEmployee emp = new HourlyEmployee("Test", "001", 15.50, 1000, 200, 50);
        assertNotNull(emp);
        assertEquals("Test", emp.getName());
        assertEquals("001", emp.getID());
        assertEquals(15.50, emp.getPayRate(), 0.001);
    }

    @Test
    public void testSalaryEmployeeConstructor_ValidData() {
        SalaryEmployee emp = new SalaryEmployee("Test", "002", 50000, 5000, 1000, 100);
        assertNotNull(emp);
        assertEquals("Test", emp.getName());
        assertEquals("002", emp.getID());
        assertEquals(50000, emp.getPayRate(), 0.001);
    }

    @Test
    public void testHourlyEmployeeConstructor_ZeroPayRate_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HourlyEmployee("Test", "003", 0.00, 0, 0, 0);
        });
    }

    @Test
    public void testHourlyEmployeeConstructor_NegativePayRate_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HourlyEmployee("Test", "004", -10.00, 0, 0, 0);
        });
    }

    @Test
    public void testSalaryEmployeeConstructor_ZeroPayRate_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new SalaryEmployee("Test", "005", 0.00, 0, 0, 0);
        });
    }

    @Test
    public void testSalaryEmployeeConstructor_NegativePayRate_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new SalaryEmployee("Test", "006", -50000, 0, 0, 0);
        });
    }
}