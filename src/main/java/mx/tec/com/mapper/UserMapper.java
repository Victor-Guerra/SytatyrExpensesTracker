package mx.tec.com.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import mx.tec.com.entity.User;
import mx.tec.com.vo.UserVO;

@Component
public class UserMapper {
	
	@Resource
	private ModelMapper mapper;
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public UserVO convertToVO(final User user) {
		return mapper.map(user, UserVO.class);
	}
	
	/**
	 * 
	 * @param uservo
	 * @return
	 */
	public User convertToEntity(final UserVO uservo) {
		return mapper.map(uservo, User.class);
	}
	
	/**
	 * 
	 * @param opt_user
	 * @return
	 */
	public Optional<UserVO> convertToOptionalVO(final Optional<User> opt_user) {
		Optional<UserVO> userVo = Optional.empty();
		
		if(userVo.isPresent()) {
			userVo = Optional.of(convertToVO(opt_user.get()));
		}
		
		return userVo;
	}
	
	/**
	 * 
	 * @param users
	 * @return
	 */
	public List<UserVO> convertToVOList(final List<User> users) {
		final List<UserVO> userVOs = new ArrayList<>();
		
		for (final User user : users) {
			userVOs.add(convertToVO(user));
	    }

		return userVOs;
	}
}
