package mx.tec.com.vo;
import java.io.Serializable;

/**
 * @author Usuario
 *
 */
public class CredentialsVO implements Serializable {
	/** Credentials username */
	private String username;
	
	/** Credentials password */
	private String password;
	
	/**
	 * No arguments constructor
	 */
	public CredentialsVO() {
	}
	
	/**
	 * All arguments constructor
	 * @param username credentials username
	 * @param password credentials password
	 */
	public CredentialsVO (final String username, final String password) {
		this.setPassword(password);
		this.setUsername(username);
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
}