package mx.tec.com.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PaymentMethodValidator implements ConstraintValidator<ValidPaymentMethod, String> {
	private final List<String> validPaymentMethods = Arrays.asList("Cash", "Debit Card", "Credit Card", "Check", "Bank Transfer");
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return validPaymentMethods.contains(value);
	}
}
