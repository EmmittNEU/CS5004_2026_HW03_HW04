import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import student.HourlyEmployee;
import student.PayStub;
import student.SalaryEmployee;

/**
 * A test of the Employee classes (Hourly and Salary).
 */
public class TestEmployee {
    private HourlyEmployee hourlyEmployee;
    private SalaryEmployee salaryEmployee;

    /**
     * Sets up fresh instances for each test.
     */
    @BeforeEach
    public void setUp() {
        hourlyEmployee = new HourlyEmployee("John", "H001", 20.00, 0, 0, 0);
        salaryEmployee = new SalaryEmployee("Jane", "S002", 60000, 0, 0, 0);
    }

    // ========== Constructor Tests ==========

    /**
     * Test of the HourlyEmployee constructor with valid data.
     */
    @Test
    public void testHourlyEmployeeConstructor_ValidData() {
        HourlyEmployee emp = new HourlyEmployee("Test", "001", 15.50, 1000, 200, 50);
        assertNotNull(emp);
        assertEquals("Test", emp.getName());
        assertEquals("001", emp.getID());
        assertEquals(15.50, emp.getPayRate(), 0.001);
    }

    /**
     * Test of the SalaryEmployee constructor with valid data.
     */
    @Test
    public void testSalaryEmployeeConstructor_ValidData() {
        SalaryEmployee emp = new SalaryEmployee("Test", "002", 50000, 5000, 1000, 100);
        assertNotNull(emp);
        assertEquals("Test", emp.getName());
        assertEquals("002", emp.getID());
        assertEquals(50000, emp.getPayRate(), 0.001);
    }

    /**
     * Test of the HourlyEmployee constructor with a pay rate of 0.
     * This test should trigger an exception to be thrown.
     */
    @Test
    public void testHourlyEmployeeConstructor_ZeroPayRate_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HourlyEmployee("Test", "003", 0.00, 0, 0, 0);
        });
    }

    /**
     * Test of the HourlyEmployee constructor with a negative pay rate.
     * This test should trigger an exception to be thrown.
     */
    @Test
    public void testHourlyEmployeeConstructor_NegativePayRate_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HourlyEmployee("Test", "004", -10.00, 0, 0, 0);
        });
    }

    /**
     * Test of the SalaryEmployee constructor with a zero pay rate.
     * This test should trigger an exception to be thrown.
     */
    @Test
    public void testSalaryEmployeeConstructor_ZeroPayRate_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new SalaryEmployee("Test", "005", 0.00, 0, 0, 0);
        });
    }

    /**
     * Test of the SalaryEmployee constructor with a negative pay rate.
     * This test should trigger an exception to be thrown.
     */
    @Test
    public void testSalaryEmployeeConstructor_NegativePayRate_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new SalaryEmployee("Test", "006", -50000, 0, 0, 0);
        });
    }

    // ========== Getter Tests ==========

    /**
     * Test of HourlyEmployee getName().
     */
    @Test
    public void testHourlyEmployee_GetName() {
        assertEquals("John Doe", hourlyEmployee.getName());
    }

    /**
     * Test of HourlyEmployee getID().
     */
    @Test
    public void testHourlyEmployee_GetID() {
        assertEquals("E001", hourlyEmployee.getID());
    }

    /**
     * Test of HourlyEmployee getPayRate().
     */
    @Test
    public void testHourlyEmployee_GetPayRate() {
        assertEquals(20.00, hourlyEmployee.getPayRate(), 0.001);
    }

    /**
     * Test of HourlyEmployee getEmployeeType().
     */
    @Test
    public void testHourlyEmployee_GetEmployeeType() {
        assertEquals("Hourly", hourlyEmployee.getEmployeeType());
    }

    /**
     * Test of HourlyEmployee getYTDEarnings() under initial conditions.
     */
    @Test
    public void testHourlyEmployee_GetYTDEarnings_Initial() {
        assertEquals(0.0, hourlyEmployee.getYTDEarnings(), 0.001);
    }

    /**
     * Test of HourlyEmployee getYTDTaxesPaid() under initial conditions.
     */
    @Test
    public void testHourlyEmployee_GetYTDTaxesPaid_Initial() {
        assertEquals(0.0, hourlyEmployee.getYTDTaxesPaid(), 0.001);
    }

    /**
     * Test of HourlyEmployee getPretaxDeductions().
     */
    @Test
    public void testHourlyEmployee_GetPretaxDeductions() {
        HourlyEmployee emp = new HourlyEmployee("Test", "007", 20.00, 0, 0, 100);
        assertEquals(100.0, emp.getPretaxDeductions(), 0.001);
    }

    /**
     * Test of SalaryEmployee getName().
     */
    @Test
    public void testSalaryEmployee_GetName() {
        assertEquals("Jane Smith", salaryEmployee.getName());
    }

    /**
     * Test of SalaryEmployee getID().
     */
    @Test
    public void testSalaryEmployee_GetID() {
        assertEquals("E002", salaryEmployee.getID());
    }

    /**
     * Test of SalaryEmployee getPayRate().
     */
    @Test
    public void testSalaryEmployee_GetPayRate() {
        assertEquals(60000, salaryEmployee.getPayRate(), 0.001);
    }

    /**
     * Test of SalaryEmployee getEmployeeType().
     */
    @Test
    public void testSalaryEmployee_GetEmployeeType() {
        assertEquals("Salary", salaryEmployee.getEmployeeType());
    }

    /**
     * Test of SalaryEmployee getYTDEarnings() under initial conditions.
     */
    @Test
    public void testSalaryEmployee_GetYTDEarnings_Initial() {
        assertEquals(0.0, salaryEmployee.getYTDEarnings(), 0.001);
    }

    /**
     * Test of SalaryEmployee getYTDTaxesPaid() under initial conditions.
     */
    @Test
    public void testSalaryEmployee_GetYTDTaxesPaid_Initial() {
        assertEquals(0.0, salaryEmployee.getYTDTaxesPaid(), 0.001);
    }

    /**
     * Test of SalaryEmployee getPretaxDeductions().
     */
    @Test
    public void testSalaryEmployee_GetPretaxDeductions() {
        SalaryEmployee emp = new SalaryEmployee("Test", "008", 60000, 0, 0, 200);
        assertEquals(200.0, emp.getPretaxDeductions(), 0.001);
    }

    // ========== Hourly Employee Payroll Tests ==========

    /**
     * Test of HourlyEmployee with negative payroll hours returns null.
     */
    @Test
    public void testHourlyEmployee_Payroll_NegativeHours_ReturnsNull() {
        IPayStub stub = hourlyEmployee.runPayroll(-5.0);
        assertNull(stub);
    }

    /**
     * Test of HourlyEmployee with zero hour payroll returns 0 pay stub.
     */
    @Test
    public void testHourlyEmployee_Payroll_ZeroHours_ReturnsZeroPayStub() {
        IPayStub stub = hourlyEmployee.runPayroll(0.0);
        assertNotNull(stub);
        assertEquals(0.0, stub.getPay(), 0.01);
        assertEquals(0.0, stub.getTaxesPaid(), 0.01);
    }

    /**
     * Test of HourlyEmployee payroll with under 40 hours.
     * Makes sure that taxes are properly calculated.
     */
    @Test
    public void testHourlyEmployee_Payroll_Under40Hours() {
        // 30 hours * $20 = $600 gross
        // Taxes: $600 * 0.2265 = $135.90
        // Net: $600 - $135.90 = $464.10
        IPayStub stub = hourlyEmployee.runPayroll(30.0);
        assertNotNull(stub);
        assertEquals(464.10, stub.getPay(), 0.01);
        assertEquals(135.90, stub.getTaxesPaid(), 0.01);
    }

    /**
     * Test of HourlyEmployee payroll with exactly 40 hours.
     * Makes sure that taxes are properly calculated.
     */
    @Test
    public void testHourlyEmployee_Payroll_Exactly40Hours() {
        // 40 hours * $20 = $800 gross
        // Taxes: $800 * 0.2265 = $181.20
        // Net: $800 - $181.20 = $618.80
        IPayStub stub = hourlyEmployee.runPayroll(40.0);
        assertNotNull(stub);
        assertEquals(618.80, stub.getPay(), 0.01);
        assertEquals(181.20, stub.getTaxesPaid(), 0.01);
    }

    /**
     * Test of HourlyEmployee payroll with overtime.
     * Makes sure that payroll overtime rate and taxes are properly calculated.
     */
    @Test
    public void testHourlyEmployee_Payroll_WithOvertime() {
        // 50 hours: 40 * $20 + 10 * $20 * 1.5 = $800 + $300 = $1100 gross
        // Taxes: $1100 * 0.2265 = $249.15
        // Net: $1100 - $249.15 = $850.85
        IPayStub stub = hourlyEmployee.runPayroll(50.0);
        assertNotNull(stub);
        assertEquals(850.85, stub.getPay(), 0.01);
        assertEquals(249.15, stub.getTaxesPaid(), 0.01);
    }

    /**
     * Test of HourlyEmployee payroll with pretax deductions calculated.
     */
    @Test
    public void testHourlyEmployee_Payroll_WithPretaxDeductions() {
        HourlyEmployee emp = new HourlyEmployee("Test", "009", 20.00, 0, 0, 100.00);
        // 40 hours * $20 = $800 gross
        // After pretax: $800 - $100 = $700
        // Taxes: $700 * 0.2265 = $158.55
        // Net: $700 - $158.55 = $541.45
        IPayStub stub = emp.runPayroll(40.0);
        assertNotNull(stub);
        assertEquals(541.45, stub.getPay(), 0.01);
        assertEquals(158.55, stub.getTaxesPaid(), 0.01);
    }

    /**
     * Test of HourlyEmployee payroll with updates to YTD earnings.
     */
    @Test
    public void testHourlyEmployee_Payroll_UpdatesYTDEarnings() {
        hourlyEmployee.runPayroll(40.0);
        // Net pay should be added to YTD: $618.80
        assertEquals(618.80, hourlyEmployee.getYTDEarnings(), 0.01);
    }

    /**
     * Test of HourlyEmployee with payroll with updates to YTD taxes.
     */
    @Test
    public void testHourlyEmployee_Payroll_UpdatesYTDTaxes() {
        hourlyEmployee.runPayroll(40.0);
        // Taxes paid should be added to YTD: $181.20
        assertEquals(181.20, hourlyEmployee.getYTDTaxesPaid(), 0.01);
    }

    /**
     * Test of HourlyEmployee with payroll with multiple pay periods that accumulates in YTD factors.
     */
    @Test
    public void testHourlyEmployee_Payroll_MultiplePayPeriods_AccumulatesYTD() {
        hourlyEmployee.runPayroll(40.0);
        hourlyEmployee.runPayroll(40.0);
        // Two pay periods: 2 * $618.80 = $1237.60
        assertEquals(1237.60, hourlyEmployee.getYTDEarnings(), 0.01);
        // Taxes: 2 * $181.20 = $362.40
        assertEquals(362.40, hourlyEmployee.getYTDTaxesPaid(), 0.01);
    }

    // ========== Salary Employee Payroll Tests ==========

    /**
     * Test of SalaryEmployee with payroll with negative hours returns a null.
     */
    @Test
    public void testSalaryEmployee_Payroll_NegativeHours_ReturnsNull() {
        IPayStub stub = salaryEmployee.runPayroll(-1.0);
        assertNull(stub);
    }

    /**
     * Test of SalaryEmployee with zero hour payroll returns 0 pay stub.
     */
    @Test
    public void testSalaryEmployee_Payroll_ZeroHours_ReturnsZeroPayStub() {
        IPayStub stub = salaryEmployee.runPayroll(0.0);
        assertNotNull(stub);
        assertEquals(0.0, stub.getPay(), 0.01);
        assertEquals(0.0, stub.getTaxesPaid(), 0.01);
    }

    /**
     * Test of SalaryEmployee with payroll with positive hours.
     */
    @Test
    public void testSalaryEmployee_Payroll_PositiveHours() {
        // $60000 / 24 = $2500 gross
        // Taxes: $2500 * 0.2265 = $566.25
        // Net: $2500 - $566.25 = $1933.75
        IPayStub stub = salaryEmployee.runPayroll(40.0);
        assertNotNull(stub);
        assertEquals(1933.75, stub.getPay(), 0.01);
        assertEquals(566.25, stub.getTaxesPaid(), 0.01);
    }

    /**
     * Test of SalaryEmployee's hours not affecting pay rate.
     */
    @Test
    public void testSalaryEmployee_Payroll_HoursDoNotAffectPay() {
        IPayStub stub1 = salaryEmployee.runPayroll(40.0);
        IPayStub stub2 = salaryEmployee.runPayroll(35.0);
        IPayStub stub3 = salaryEmployee.runPayroll(50.0);

        assertEquals(stub1.getPay(), stub2.getPay(), 0.01);
        assertEquals(stub1.getPay(), stub3.getPay(), 0.01);
    }

    /**
     * Test of SalaryEmployee payroll with pretax deductions.
     */
    @Test
    public void testSalaryEmployee_Payroll_WithPretaxDeductions() {
        SalaryEmployee emp = new SalaryEmployee("Test", "010", 60000, 0, 0, 250.00);
        // $60000 / 24 = $2500 gross
        // After pretax: $2500 - $250 = $2250
        // Taxes: $2250 * 0.2265 = $509.63
        // Net: $2250 - $509.63 = $1740.37
        IPayStub stub = emp.runPayroll(40.0);
        assertNotNull(stub);
        assertEquals(1740.37, stub.getPay(), 0.01);
        assertEquals(509.63, stub.getTaxesPaid(), 0.01);
    }

    /**
     * Test of SalaryEmployee payroll with updates to ytd earnings.
     */
    @Test
    public void testSalaryEmployee_Payroll_UpdatesYTDEarnings() {
        salaryEmployee.runPayroll(40.0);
        assertEquals(1933.75, salaryEmployee.getYTDEarnings(), 0.01);
    }

    /**
     * Test of SalaryEmployee payroll with updates to ytd taxes.
     */
    @Test
    public void testSalaryEmployee_Payroll_UpdatesYTDTaxes() {
        salaryEmployee.runPayroll(40.0);
        assertEquals(566.25, salaryEmployee.getYTDTaxesPaid(), 0.01);
    }

    /**
     * Test of SalaryEmployee payroll with multiple pay periods that accumulate.
     */
    @Test
    public void testSalaryEmployee_Payroll_MultiplePayPeriods_AccumulatesYTD() {
        salaryEmployee.runPayroll(40.0);
        salaryEmployee.runPayroll(40.0);
        assertEquals(3867.50, salaryEmployee.getYTDEarnings(), 0.01);
        assertEquals(1132.50, salaryEmployee.getYTDTaxesPaid(), 0.01);
    }

    // ========== CSV Tests ==========

    /**
     * Test of HourlyEmployee's information being properly converted to the correct CSV format (7 parts).
     */
    @Test
    public void testHourlyEmployee_toCSV_Format() {
        String csv = hourlyEmployee.toCSV();
        String[] parts = csv.split(",");
        assertEquals(7, parts.length);
    }

    /**
     * Test of HourlyEmployee's content being properly converted to CSV format.
     */
    @Test
    public void testHourlyEmployee_toCSV_Content() {
        String csv = hourlyEmployee.toCSV();
        assertTrue(csv.contains("Hourly"));
        assertTrue(csv.contains("John Doe"));
        assertTrue(csv.contains("E001"));
        assertTrue(csv.contains("20.0") || csv.contains("20.00"));
    }

    /**
     * Test of HourlyEmployee's content being properly converted to CSV format in the correct order.
     */
    @Test
    public void testHourlyEmployee_toCSV_CorrectOrder() {
        // Format: employee_type,name,ID,payRate,pretaxDeductions,YTDEarnings,YTDTaxesPaid
        String csv = hourlyEmployee.toCSV();
        String[] parts = csv.split(",");
        assertEquals("Hourly", parts[0]);
        assertEquals("John Doe", parts[1]);
        assertEquals("E001", parts[2]);
    }

    /**
     * Test of SalaryEmployee's information being properly converted to the correct CSV format (7 parts).
     */
    @Test
    public void testSalaryEmployee_toCSV_Format() {
        String csv = salaryEmployee.toCSV();
        String[] parts = csv.split(",");
        assertEquals(7, parts.length);
    }

    /**
     * Test of SalaryEmployee's content being properly converted to CSV format.
     */
    @Test
    public void testSalaryEmployee_toCSV_Content() {
        String csv = salaryEmployee.toCSV();
        assertTrue(csv.contains("Salary"));
        assertTrue(csv.contains("Jane Smith"));
        assertTrue(csv.contains("E002"));
        assertTrue(csv.contains("60000"));
    }

    /**
     * Test of SalaryEmployee's content being properly converted to CSV format in the correct order.
     */
    @Test
    public void testEmployee_toCSV_AfterPayroll_UpdatedYTD() {
        hourlyEmployee.runPayroll(40.0);
        String csv = hourlyEmployee.toCSV();
        assertTrue(csv.contains("618.8") || csv.contains("618.80"));
        assertTrue(csv.contains("181.2") || csv.contains("181.20"));
    }
}