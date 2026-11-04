# University Enrollment Fee Calculator

## Project structure

```text
EnrollmentFeeCalculator/
└── src/
    ├── EnrollmentFeeCalculator.java
    ├── FeeService.java
    ├── InvalidStudentNameException.java
    └── InvalidUnitsException.java
```

## Run

Open the project folder in your Java IDE. Make sure all four `.java` files are in the same source folder and have no package declaration.

Run `EnrollmentFeeCalculator.java`.

Requires a JDK with Swing support. No external libraries are needed.

## Exercise rules implemented

- Tuition: PHP 500 per unit
- Scholar discount: 20% of tuition only
- Library fee: PHP 50
- Lab fee: PHP 75
- Units: whole numbers from 1 through 30
- Student name: required
