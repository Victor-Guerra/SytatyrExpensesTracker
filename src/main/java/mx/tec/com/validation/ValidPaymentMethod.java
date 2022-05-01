package mx.tec.com.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = PaymentMethodValidator.class)
public @interface ValidPaymentMethod {
	String message() default "Invalid Payment Method";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
