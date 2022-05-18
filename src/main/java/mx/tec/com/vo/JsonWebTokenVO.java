package mx.tec.com.vo;

import java.io.Serializable;

/**
 * @author Usuario
 *
 */
public class JsonWebTokenVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7699880112770956479L;
	/** JsonWebToken token */
	private final String token;

	/**
	 * All arguments constructor
	 * @param token
	 */
	public JsonWebTokenVO(String token) {
		this.token = token;
	}
	
	/**
	 * @return the token
	 */
	public String getToken() {
		return this.token;
	}
}