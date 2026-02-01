package student;

public class HourlyEmployee implements IEmployee{
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

    /**
     * The constructor for the Hourly Employee class.
     *
     * @param name the name of Hourly Employee.
     * @param id the id of the Hourly Employee.
     * @param payRate the pay rate of the Hourly Employee.
     * @param ytdEarnings the year to date (ytd) earnings of the Hourly Employee.
     * @param ytdTaxesPaid the year to date (ytd) taxes paid of the Hourly Employee.
     * @param pretaxDeductions the pre-tax deductions of the Hourly Employee.
     * @throws IllegalArgumentException if the pay rate is negative.
     */
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

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public double getPayRate() {
        return this.payRate;
    }

    @Override
    public String getEmployeeType() {
        return "Hourly";
    }

    @Override
    public double getYTDEarnings() {
        return 0;
    }

    @Override
    public double getYTDTaxesPaid() {
        return 0;
    }

    @Override
    public double getPretaxDeductions() {
        return 0;
    }

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        return null;
    }

    @Override
    public String toCSV() {
        return "";
    }
}
