package mx.tec.com.manager;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import mx.tec.com.dao.UserDAO;
import mx.tec.com.vo.UserVO;
import mx.tec.com.util.SecurityHelper;

@Service
public class UserManager {

	@Resource
	private UserDAO userDao;
	
	
	@Resource
	private SecurityHelper encoder;
	
	public Optional<UserVO> addUser(UserVO user) {
		if(userDao.findByEmail(user.getEmail()).isPresent()){
			user.setPassword(encoder.hashPassword(user.getPassword()));
			userDao.saveUser(user);
			return Optional.of(user);
		} else {
			return Optional.empty();
		}
	}
	
	public Long findUserIdByUsername(String username) {
		Optional<UserVO> foundUser = userDao.findByUsername(username);
		if (foundUser.isPresent()) {
			return foundUser.get().getId();
		} else {
			return (long) -1;
		}
	}
}
