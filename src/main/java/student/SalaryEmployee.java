package student;

/**
 * A class for salary employees.
 */
public class SalaryEmployee implements IEmployee {
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
    private double pretaxDeductions;

    /**
     * The constructor for the Salary Employee class.
     *
     * @param name the name of Salary Employee.
     * @param id the id of the Salary Employee.
     * @param payRate the pay rate of the Salary Employee.
     * @param ytdEarnings the year to date (ytd) earnings of the Salary Employee.
     * @param ytdTaxesPaid the year to date (ytd) taxes paid of the Salary Employee.
     * @param pretaxDeductions the pre-tax deductions of the Salary Employee.
     * @throws IllegalArgumentException if the pay rate is negative.
     */
    public SalaryEmployee(String name,
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
        return "SALARY";
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
        // Handling negative hours
        if (hoursWorked < 0) {
            return null;
        }

        // Handling zero hours
        if (hoursWorked == 0) {
            return new PayStub(this.name, 0.0, 0.0,
                    this.ytdEarnings, this.ytdTaxesPaid);
        }

        // Calculating gross pay
        double grossPay = this.payRate / 24.0;

        // Applying pretax deductions
        double afterPretax = grossPay - this.pretaxDeductions;

        // Calculating taxes
        double taxes = afterPretax * 0.2265;
        taxes = Math.round(taxes * 100.0) / 100.0;

        // Calculating net pay
        double netPay = afterPretax - taxes;
        netPay = Math.round(netPay * 100.0) / 100.0;

        // Updating YTD values
        this.ytdEarnings += netPay;
        this.ytdTaxesPaid += taxes;

        // Rounding YTD values
        this.ytdEarnings = Math.round(this.ytdEarnings * 100.0) / 100.0;
        this.ytdTaxesPaid = Math.round(this.ytdTaxesPaid * 100.0) / 100.0;

        // Creating and returning pay stub
        return new PayStub(this.name, netPay, taxes,
                this.ytdEarnings, this.ytdTaxesPaid);
    }

    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%.2f,%.2f,%.2f",
                getEmployeeType(),    // "Hourly"
                this.name,            // Employee name
                this.id,              // Employee ID
                this.payRate,         // Pay rate
                this.pretaxDeductions,// Pretax deductions
                this.ytdEarnings,     // YTD earnings
                this.ytdTaxesPaid);   // YTD taxes paid
    }
}