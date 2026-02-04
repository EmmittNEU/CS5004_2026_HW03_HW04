package student;

/**
 * An implementation of ITimeCard.
 */
public class TimeCard implements ITimeCard {
    /** A string that contains the Employee ID. */
    private String employeeID;

    /** A string that contains the hours worked on the employee. */
    private double hoursWorked;

    /**
     * A constructor for the TimeCard class.
     * @param employeeID the ID of the employee.
     * @param hoursWorked the number of hours worked by the employee.
     */
    public TimeCard(String employeeID, double hoursWorked) {
        this.employeeID = employeeID;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getEmployeeID() {
        return employeeID;
    }

    @Override
    public double getHoursWorked() {
        return hoursWorked;
    }
}
