package student;

/**
 * A class for hourly employees.
 */
public class HourlyEmployee implements IEmployee{
    /** Holds the name of the Employee. */
    private final String name;

    /** Holds the id of the Employee. */
    private final String id;

    /** Holds the pay rate of the Employee. */
    private final double payRate;

    /** Holds the year to date (ytd) earnings of the Employee. */
    private double ytdEarnings;

    /** Holds the year to date (ytd) taxes paid of the Employee. */
    private double ytdTaxesPaid;

    /** Holds the pre-tax deductions of the Employee. */
    private final double pretaxDeductions;

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

    /**
     * Method to calculate the gross pay of an employee.
     * @param hoursWorked number of hours worked by the employee.
     * @return the gross pay of the employee.
     */
    public double calculateGrossPay(double hoursWorked){
        return this.payRate * hoursWorked;
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
        return this.ytdEarnings;
    }

    @Override
    public double getYTDTaxesPaid() {
        return this.ytdTaxesPaid;
    }

    @Override
    public double getPretaxDeductions() {
        return this.pretaxDeductions;
    }

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        // Skip negative hours
        if (hoursWorked < 0) {
            return null;
        }

        // Handle zero hours
        if (hoursWorked == 0) {
            return new PayStub(this.name, 0.0, 0.0,
                    this.ytdEarnings, this.ytdTaxesPaid);
        }

        // Calculating gross pay
        double grossPay = calculateGrossPay(hoursWorked);

        // Applying pretax deductions
        double afterPretax = grossPay - this.pretaxDeductions;

        // Calculating taxes (22.65%)
        double taxes = Math.round(afterPretax * 0.2265 * 100.0) / 100.0;

        // Calculating net pay
        double netPay = Math.round((afterPretax - taxes) * 100.0) / 100.0;

        // Update YTD values
        this.ytdEarnings += netPay;
        this.ytdTaxesPaid += taxes;

        // Create and return PayStub (concrete class implementing IPayStub)
        return new PayStub(this.name, netPay, taxes,
                this.ytdEarnings, this.ytdTaxesPaid);
    }

    @Override
    public String toCSV() {
        return "";
    }
}
