package mx.tec.com.manager;

import java.util.Optional;

import javax.annotation.Resource;
import javax.persistence.EntityExistsException;

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
	
	public Optional<UserVO> getUser(final long id) {
		return Optional.of(userDao.findUserById(id));
	}
	
	public Optional<UserVO> addUser(UserVO user) {
		Optional<UserVO> founduser = userDao.findByUsername(user.getUsername());
		
		if(founduser.isPresent()){
			throw new EntityExistsException("User already exists: " + user.getUsername());
		} else {
			user.setPassword(encoder.hashPassword(user.getPassword()));
			userDao.saveUser(user);
			return Optional.of(user);
		}
	}
	
	public Long findUserIdByUsername(String username) {
		Optional<UserVO> foundUser = userDao.findByUsername(username);
		
		UserVO userfound = new UserVO();
		if (foundUser.isPresent()) {
			return foundUser.get().getId();
		}
		
		return (long)-1;
	}
}
