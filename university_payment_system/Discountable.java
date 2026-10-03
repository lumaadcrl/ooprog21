package university_payment_system;

public @interface Discountable {
    double discountPercentage() default 3.0;
}
