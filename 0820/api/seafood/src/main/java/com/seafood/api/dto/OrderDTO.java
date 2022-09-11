package com.seafood.api.dto;

import java.io.Serializable;

import com.seafood.api.vo.OrderVo;
import lombok.Data;

/**
 *
 * @author eason
 * @date 2022/09/11
 **/
@Data
public class OrderDTO extends OrderVo implements Serializable {

	private long userId;

}
