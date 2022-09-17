package com.seafood.api.dto;

import java.io.Serializable;
import java.util.List;

import com.seafood.api.vo.LineItemVo;
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

	private List<LineItemVo> lineitems;

	private Double orderAmount;

	private Double orderTotal;

}
