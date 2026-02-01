import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import student.PayStub;

/**
 * A test of the PayStub class.
 */
public class TestPayStub {

    /**
     * Test of PayStub getPay().
     */
    @Test
    public void testPayStub_GetPay() {
        PayStub stub = new PayStub("John Doe", 500.00, 113.25, 500.00, 113.25);
        assertEquals(500.00, stub.getPay(), 0.01);
    }

    /**
     * Test of PayStub getTaxesPaid().
     */
    @Test
    public void testPayStub_GetTaxesPaid() {
        PayStub stub = new PayStub("John Doe", 500.00, 113.25, 500.00, 113.25);
        assertEquals(113.25, stub.getTaxesPaid(), 0.01);
    }

    /**
     * Test of PayStub toCSV()'s formatting.
     */
    @Test
    public void testPayStub_toCSV_Format() {
        PayStub stub = new PayStub("John Doe", 500.00, 113.25, 500.00, 113.25);
        String csv = stub.toCSV();
        String[] parts = csv.split(",");
        assertEquals(5, parts.length);
    }

    /**
     * Test of PayStub toCSV's content.
     */
    @Test
    public void testPayStub_toCSV_Content() {
        // Format: employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid
        PayStub stub = new PayStub("John Doe", 618.80, 181.20, 618.80, 181.20);
        String csv = stub.toCSV();
        assertTrue(csv.contains("John Doe"));
        assertTrue(csv.contains("618.8") || csv.contains("618.80"));
        assertTrue(csv.contains("181.2") || csv.contains("181.20"));
    }

    /**
     * Test of PayStub toCSV's content order.
     */
    @Test
    public void testPayStub_toCSV_CorrectOrder() {
        PayStub stub = new PayStub("Jane Smith", 1933.75, 566.25, 1933.75, 566.25);
        String csv = stub.toCSV();
        String[] parts = csv.split(",");
        assertEquals("Jane Smith", parts[0]);
        assertEquals("1933.75", parts[1]);
        assertEquals("566.25", parts[2]);
    }
}