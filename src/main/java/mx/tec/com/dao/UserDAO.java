package mx.tec.com.dao;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mx.tec.com.controller.UserController;
import mx.tec.com.entity.User;
import mx.tec.com.mapper.UserMapper;
import mx.tec.com.repository.UserRepository;
import mx.tec.com.vo.UserVO;

@Component
public class UserDAO implements UserDetailsService {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);
	
	@Resource
	private UserRepository userRepo;
	
	@Resource
	private UserMapper userMapper;
	
	public UserVO findUserById(Long id) {
		return userMapper.convertToVO(userRepo.findById(id).get());
	}
	
	public void saveUser(UserVO user) {
		userRepo.save(userMapper.convertToEntity(user));
	}
	
	public Optional<UserVO> findByEmail(String email) {
		return userMapper.convertToOptionalVO(userRepo.findByEmail(email));
	}

	public Optional<UserVO> findByUsername(String username) {
		Optional<User> xd = userRepo.findByUsername(username);
		if (xd.isPresent()) {
			Long elId = xd.get().getId();	
			log.info("UserID: " + xd.get().getId());
			UserVO user2 = userMapper.convertToVO(xd.get());
			user2.setId(elId);
			return Optional.of(user2);
		}
		return userMapper.convertToOptionalVO(xd);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUsername(username);
		if(!user.isPresent()) {
			throw new UsernameNotFoundException(username);	
		}
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		User foundUser = user.get();
		
		return new org.springframework.security.core.userdetails.User(
				foundUser.getUsername(),
				foundUser.getPassword(),
				grantedAuthorities);	
	}
}
