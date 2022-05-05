package mx.tec.com.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import mx.tec.com.entity.User;
import mx.tec.com.mapper.UserMapper;
import mx.tec.com.repository.UserRepository;
import mx.tec.com.vo.UserVO;

@Component
public class UserDAO {
	
	@Resource
	private UserRepository userRepo;
	
	@Resource
	private UserMapper userMapper;
	
	public UserVO findUserById(Long id) {
		return userMapper.convertToVO(userRepo.findById(id).get());
	}
}
