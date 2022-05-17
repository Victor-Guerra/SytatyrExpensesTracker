package mx.tec.com.manager;
import java.util.Optional;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import mx.tec.com.util.JsonWebTokenUtil;
import mx.tec.com.util.SecurityHelper;
import mx.tec.com.vo.CredentialsVO;
import mx.tec.com.vo.JsonWebTokenVO;

/**
 * @author Usuario
 *
 */
@Service
public class LoginManager {

	/** A Reference to the User Details Service*/
	@Resource
	UserDetailsService userDS;
	
	/** A Reference to the Authentication Manager*/
	@Autowired
	private AuthenticationManager authenticationManager;
	
	/**A Reference to the Json Web Token Util*/
	@Resource
	JsonWebTokenUtil jwtTokenUtil;
	
	@Resource
	private SecurityHelper encoder;
	
	/**
	 * Method to authenticate and generate token with the credentials
	 * @param credentials Credentials of the user
	 * @return New token generated with the credentials
	 * @throws AuthenticationException
	 */
	public JsonWebTokenVO authenticate(CredentialsVO credentials) throws AuthenticationException {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
		final UserDetails userDetails = userDS.loadUserByUsername(credentials.getUsername());
		return new JsonWebTokenVO(jwtTokenUtil.generateToken(userDetails));
	}
	
	/**
	 * Method to authenticate with username and token
	 * @param username Username form the User
	 * @param token Token of the user to validate
	 * @return Valid token
	 */
	public Optional<UsernamePasswordAuthenticationToken> authenticate(final String username, final String token) {
		Optional<UsernamePasswordAuthenticationToken> authenticationToken = Optional.empty();
		UserDetails userDetails = userDS.loadUserByUsername(username);
		
		if(jwtTokenUtil.validateToken(token, userDetails)) {
			UsernamePasswordAuthenticationToken userPassQuthToken = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());
			authenticationToken = Optional.of(userPassQuthToken);
		}
		
		return authenticationToken;
	}
}