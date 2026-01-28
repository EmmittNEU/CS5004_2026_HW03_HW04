package student;

public class HourlyEmployee {
    /** Holds the name of the Employee. */
    private String name;

    /** Holds the id of the Employee. */
    private String id;

    /** Holds the pay rate of the Employee. */
    private double payRate;

    /** Holds the year to date (ytd) earnings of the Employee. */
    private double ytdEarnings;

    /** Holds the year to date (ytd) taxes paid of the Employee. */
    private double ytdTaxesPaid;

    /** Holds the pre-tax deductions of the Employee. */
    private double pretaxDeductions;

    public HourlyEmployee(String name,
                          String id,
                          double payRate,
                          double ytdEarnings,
                          double ytdTaxesPaid,
                          double pretaxDeductions) {
        if (payRate <= 0) {
            throw new IllegalArgumentException("Pay rate must be greater than $0.00.");
        }
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }
}
