package com.seafood.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.seafood.api.entity.Address;
import com.seafood.api.mapper.AddressMapper;

import org.springframework.stereotype.Service;

/**
 *
 * @author eason
 * @date 2022/09/14
 **/
@Service
public class AddressService {

	@Resource
	private AddressMapper addressMapper;

	public int saveAddress(Address address) {
		return addressMapper.insert(address);
	}

	public List<Address> getAddressesByUserId(long userId) {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", userId);
		return addressMapper.selectByMap(map);
	}
}
