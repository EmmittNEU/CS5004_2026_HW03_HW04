package student;

/** 
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {
    
    private Builder() {
    }


     /**
     * Builds an employee object from a CSV string.
     * 
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     * 
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {

        // Validate input
        if (csv == null || csv.trim().isEmpty()) {
            return null;
        }

        try {
            // Split the CSV string by comma
            String[] parts = csv.split(",");

            // Check correct number of fields
            // Format: employee_type,name,ID,payRate,pretaxDeductions,YTDEarnings,YTDTaxesPaid
            if (parts.length != 7) {
                System.err.println("Invalid CSV format: Expected 7 fields, got " + parts.length);
                return null;
            }

            // Parse the fields
            String employeeType = parts[0].trim();
            String name = parts[1].trim();
            String id = parts[2].trim();
            double payRate = Double.parseDouble(parts[3].trim());
            double pretaxDeductions = Double.parseDouble(parts[4].trim());
            double ytdEarnings = Double.parseDouble(parts[5].trim());
            double ytdTaxesPaid = Double.parseDouble(parts[6].trim());

            // Create the appropriate employee type based on the first field
            if (employeeType.equalsIgnoreCase("Hourly")) {
                return new HourlyEmployee(name, id, payRate, ytdEarnings,
                        ytdTaxesPaid, pretaxDeductions);
            } else if (employeeType.equalsIgnoreCase("Salary")) {
                return new SalaryEmployee(name, id, payRate, ytdEarnings,
                        ytdTaxesPaid, pretaxDeductions);
            } else {
                System.err.println("Unknown employee type: " + employeeType);
                return null;
            }

        } catch (NumberFormatException e) {
            System.err.println("Error parsing numbers from CSV: " + e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating employee: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Unexpected error parsing employee CSV: " + e.getMessage());
            return null;
        }
    }

   /**
     * Converts a TimeCard from a CSV String.
     * 
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {

        // Validate input
        if (csv == null || csv.trim().isEmpty()) {
            return null;
        }

        try {
            // Split the CSV string by comma
            String[] parts = csv.split(",");

            // Check the correct number of fields
            // Format: employeeID,hoursWorked
            if (parts.length != 2) {
                System.err.println("Invalid TimeCard CSV format: Expected 2 fields, got " + parts.length);
                return null;
            }

            // Parse the fields
            String employeeID = parts[0].trim();
            double hoursWorked = Double.parseDouble(parts[1].trim());

            // Create and return the TimeCard
            return new TimeCard(employeeID, hoursWorked);

        } catch (NumberFormatException e) {
            System.err.println("Error parsing hours from TimeCard CSV: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Unexpected error parsing TimeCard CSV: " + e.getMessage());
            return null;
        }
    }
}
