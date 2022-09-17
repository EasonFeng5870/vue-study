package com.seafood.api.vo;

import java.util.List;

import com.seafood.api.entity.Address;
import lombok.Data;
import net.sf.jsqlparser.statement.select.Pivot;

/**
 *
 * @author eason
 * @date 2022/09/10
 **/
@Data
public class OrderVo {

	private long id;

	private List<LineItemVo> lineItemVos;

	private Address shippingAddress;

	private String payInfo;

	private String reason;

	private int reasonCode;

}
