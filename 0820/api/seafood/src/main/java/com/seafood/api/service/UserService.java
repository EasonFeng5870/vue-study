package com.seafood.api.service;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seafood.api.entity.User;
import com.seafood.api.mapper.UserMapper;

import org.springframework.stereotype.Service;

import static com.seafood.api.utils.Constants.USER_DISABLED;

/**
 *
 * @author eason
 * @date 2022/09/10
 **/
@Service
public class UserService {

	@Resource
	private UserMapper userMapper;

	/**
	 * check if user is validate by userId
	 * @param userId user id
	 * @return
	 * 	True is validate account, False is invalidate account;
	 */
	public boolean checkUserState(long userId) {
		User user = userMapper.selectById(userId);
		if (user == null) {
			return Boolean.FALSE;
		}
		if (user.getIsDisable() == USER_DISABLED) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public User getUserByIdAuthorityWithType(String idAuthority, int idType) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("id_type", idType).eq("id_authority", idAuthority);
		try {
			return userMapper.selectOne(queryWrapper);
		} catch (Exception e) {
			return null;
		}
	}
}
