package mx.tec.com.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Expense implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6060749632245782029L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@NotNull
	private String recipient;
	
	@NotNull
	private double amount;
	
	@NotNull
	private String reason;
	
	@NotNull
	private String category;
	
	@NotNull
	private String method;
	
	@NotNull
	private Date date;
	
	private String notes;
	
	public Expense() {
	}
	
	public Expense(
		Long id,
		User user,
		String recipient,
		double amount,
		String reason,
		String category,
		String method,
		Date date,
		String notes
			) {
		this.id = id;
		this.user = user;
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
	 * @return the user_id
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser(User user) {
		this.user = user;
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
		return Objects.hash(amount, category, date, id, method, notes, reason, recipient, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Expense)) {
			return false;
		}
		Expense other = (Expense) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(category, other.category) && Objects.equals(date, other.date)
				&& Objects.equals(id, other.id) && Objects.equals(method, other.method)
				&& Objects.equals(notes, other.notes) && Objects.equals(reason, other.reason)
				&& Objects.equals(recipient, other.recipient) && Objects.equals(user, other.user);
	}
}
