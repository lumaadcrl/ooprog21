public class FeeService {

    private static final double TUITION_PER_UNIT = 500.00;
    private static final double LIBRARY_FEE = 50.00;
    private static final double LAB_FEE = 75.00;
    private static final double SCHOLAR_DISCOUNT = 0.20;

    public double calculateFee(
            String studentName,
            String unitsInput,
            boolean isScholar,
            boolean hasLibrary,
            boolean hasLab
    ) throws InvalidStudentNameException {

        if (studentName == null || studentName.trim().isEmpty()) {
            throw new InvalidStudentNameException(
                    "Student name cannot be empty."
            );
        }

        int units;

        try {
            units = Integer.parseInt(unitsInput.trim());
        } catch (NumberFormatException e) {
            throw new InvalidUnitsException(
                    "Units must be a valid whole number."
            );
        }

        if (units < 1 || units > 30) {
            throw new InvalidUnitsException(
                    "Units must be between 1 and 30."
            );
        }

        double tuition = units * TUITION_PER_UNIT;
        double discount = isScholar ? tuition * SCHOLAR_DISCOUNT : 0.00;
        double libraryFee = hasLibrary ? LIBRARY_FEE : 0.00;
        double labFee = hasLab ? LAB_FEE : 0.00;

        return tuition - discount + libraryFee + labFee;
    }
}
