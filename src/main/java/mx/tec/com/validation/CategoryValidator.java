package mx.tec.com.validation;


import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<ValidCategory, String> {
	private final List<String> validCategories = Arrays.asList("Housing", "Food", "Clothing", "Personal Care", "Autommobile", "Property Tax",
													"Utilities", "Entertainment", "Business Expenses", "Alimony", "Child Support", "Childrens Expenses", "Gifts",
													"Charitable Contributions", "Medical Expenses", "Insurance", "Credit Cards", "Other Liabilities");
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return validCategories.contains(value);
	}
}