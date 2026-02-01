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
        hourlyEmployee = new HourlyEmployee("John Doe", "E001", 20.00, 0, 0, 0);
        salaryEmployee = new SalaryEmployee("Jane Smith", "E002", 60000, 0, 0, 0);
    }
}