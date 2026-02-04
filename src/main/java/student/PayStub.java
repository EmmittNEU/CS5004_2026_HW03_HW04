package student;

/**
 * A concrete implementation of IPayStub.
 */
public class PayStub implements IPayStub {
    /** A string that contains the employee name. */
    private String employeeName;

    /** A double that contains net pay of the employee. */
    private double netPay;

    /** A double that contains taxes paid by the employee. */
    private double taxesPaid;

    /** A double that contains ytd earnings of the employee. */
    private double ytdEarnings;

    /** A double that contains ytd taxes paid of the employee. */
    private double ytdTaxesPaid;

    /**
     * Constructor for PayStub.
     *
     * @param employeeName the name of the employee
     * @param netPay the net pay for this pay period
     * @param taxesPaid the taxes paid for this pay period
     * @param ytdEarnings the year-to-date earnings
     * @param ytdTaxesPaid the year-to-date taxes paid
     */
    public PayStub(String employeeName, double netPay, double taxesPaid,
                   double ytdEarnings, double ytdTaxesPaid) {
        this.employeeName = employeeName;
        this.netPay = netPay;
        this.taxesPaid = taxesPaid;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    @Override
    public double getPay() {
        return netPay;
    }

    @Override
    public double getTaxesPaid() {
        return taxesPaid;
    }

    @Override
    public String toCSV() {
        // Format: employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid
        return String.format("%s,%.2f,%.2f,%.2f,%.2f",
                employeeName, netPay, taxesPaid, ytdEarnings, ytdTaxesPaid);
    }
}
