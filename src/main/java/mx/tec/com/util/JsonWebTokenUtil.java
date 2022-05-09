package mx.tec.com.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author Usuario
 *
 */
@Component
public class JsonWebTokenUtil implements Serializable {

	/**Set of token validity*/
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	
	/**
	 *Takes secret from properties 
	 */
	@Value("${jwt.secret}")
	private String secret;
	
	/**
	 * Generates the token with the userdetails of the user
	 * @param userDetails From the user to crate token for
	 * @return token created for user
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}
	
	/**
	 * Generate token with the claims and the subject
	 * @param claims Claims to set token
	 * @param subject Subject to set token
	 * @return The token builder
	 */
	public String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System .currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	/**
	 * Validate token with user details
	 * @param token Token to test validity
	 * @param userDetails identifying user
	 * @return true or false if the token is valid
	 */
	public boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	/**
	 * Get username from token
	 * @param token to obtain the username
	 * @return the claims related with the token
	 */
	public String getUsernameFromToken (String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	/**
	 * Get the claims with the token, claims, and claims resolver
	 * @param <T> Function to use
	 * @param token to obtain the claims
	 * @param claimsResolver to get the claims
	 * @return claims resolver to apply the claims
	 */
	public <T> T getClaimFromToken (String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	/**
	 * Get all the claims from a specific token
	 * @param token to find all the claims
	 * @return all the claims with the token
	 */
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	/**
	 * Check if a specific token is expired
	 * @param token to check
	 * @return true or false if the token is expired
	 */
	private Boolean isTokenExpired (String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	/**
	 * Obtain the expiration date of the token
	 * @param token which is checked
	 * @return The date expiration of the token
	 */
	public Date getExpirationDateFromToken (String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

}