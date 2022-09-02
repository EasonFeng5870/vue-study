package com.seafood.api.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seafood.api.entity.Category;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Repository;

/**
 *
 * @author eason
 * @date 2022/08/27
 **/
@Repository
public interface CategoryMapper extends BaseMapper<Category> {

	@Select("select * from category where catalog_id=#{catalogId}")
	public List<Category> selectAllProductCategoriesByCatalogId(long catalogId);
}
