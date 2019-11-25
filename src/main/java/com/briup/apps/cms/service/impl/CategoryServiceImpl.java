package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.CategoryExample;
import com.briup.apps.cms.dao.CategoryMapper;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.utils.CustomerException;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Resource
    private CategoryMapper categoryMapper;
	
	@Override
	public List<Category> findAll() {
		CategoryExample example = new CategoryExample();
		return categoryMapper.selectByExample(example);
	}

	@Override
	public void saveOrUpdate(Category category) {
		if(category.getId() != null){
            categoryMapper.updateByPrimaryKey(category);
        } else {
            //判断是否重名
            CategoryExample example = new CategoryExample();
            example.createCriteria().andNameEqualTo(category.getName());
            List<Category> list = categoryMapper.selectByExample(example);
            if(list.size()>0){
                throw new CustomerException("该栏目已经存在");
            }
            categoryMapper.insert(category);
        }
	}

	@Override
	public void deleteById(long id) {
		Category category = categoryMapper.selectByPrimaryKey(id);
        if(category == null){
            throw new CustomerException("要删除的栏目不存在");
        }
        categoryMapper.deleteByPrimaryKey(id);
	}


	@Override
	public void batchDelete(long[] ids) throws CustomerException {
		for(long id : ids){
            this.deleteById(id);
        }
	}

}
