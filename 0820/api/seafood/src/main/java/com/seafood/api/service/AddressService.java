package com.seafood.api.service;

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

}
