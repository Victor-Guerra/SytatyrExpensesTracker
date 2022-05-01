package mx.tec.com.vo;

import java.sql.Date;
import java.util.Objects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import mx.tec.com.validation.ValidCategory;
import mx.tec.com.validation.ValidPaymentMethod;

public class ExpenseVO {

	private Long id;
	
	@NotBlank(message = "Recipient of the money is mandatory.")
	private String recipient;
	
	@Digits(integer = 12, fraction = 2)
	private double amount;
	
	@NotBlank(message = "The reason for the expense is mandatory.")
	private String reason;
	
	@ValidCategory
	@NotBlank(message = "The category of expense is mandatory.")
	private String category;
	
	@ValidPaymentMethod
	@NotBlank(message = "The payment method is mandatory.")
	private String method;
	
	private Date date;
	
	private String notes;
	
	public ExpenseVO() {}
	
	public ExpenseVO(
			Long id,
			String recipient,
			double amount,
			String reason,
			String category,
			String method,
			Date date,
			String notes
			) {
		this.id = id;
		this.recipient = recipient;
		this.amount = amount;
		this.reason = reason;
		this.category = category;
		this.method = method;
		this.date = date;
		this.notes = notes;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * @param recipient the recipient to set
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, category, date, id, method, notes, reason, recipient);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ExpenseVO)) {
			return false;
		}
		ExpenseVO other = (ExpenseVO) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(category, other.category)
				&& Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(method, other.method) && Objects.equals(notes, other.notes)
				&& Objects.equals(reason, other.reason) && Objects.equals(recipient, other.recipient);
	}
}
