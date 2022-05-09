package mx.tec.com.vo;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserVO {
	private Long id;
	
	@Email
	@NotBlank(message = "User email is mandatory.")
	private String email;
	
	@NotBlank(message = "User password is mandatory.")
	private String password;
	
	@NotBlank(message = "Name is mandatory.")
	private String name;
	
	@NotBlank(message = "Username is mandatory.")
	private String username;
	
	private List<ExpenseVO> userExpenses;
	
	public UserVO() {
	}
	
	public UserVO(Long id, String email, String password, String name, String username, List<ExpenseVO> userExpenses) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.userExpenses = userExpenses;
		this.username = username;
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

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof UserVO)) {
			return false;
		}
		UserVO other = (UserVO) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}

	/**
	 * @return the user_expenses
	 */
	public List<ExpenseVO> getUserExpenses() {
		return userExpenses;
	}

	/**
	 * @param user_expenses the user_expenses to set
	 */
	public void setUserExpenses(List<ExpenseVO> userExpenses) {
		this.userExpenses = userExpenses;
	}
}
