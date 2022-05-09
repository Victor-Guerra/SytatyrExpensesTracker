package mx.tec.com.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 633250300264648920L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	private String name;
	
	@NotNull
	private String username;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Expense> userExpenses;

	public User() {	}
	
	public User(Long id,
			@NotNull String email,
			@NotNull String password,
			@NotNull String name,
			@NotNull String username,
			@NotNull List<Expense> userExpenses) {
		super();
		
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.username = username;
		this.userExpenses = userExpenses;

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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the user_expenses
	 */
	public List<Expense> getUserExpenses() {
		return userExpenses;
	}

	/**
	 * @param user_expenses the user_expenses to set
	 */
	public void setUserExpenses(List<Expense> user_expenses) {
		this.userExpenses = user_expenses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, password, userExpenses, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(userExpenses, other.userExpenses) && Objects.equals(username, other.username);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
