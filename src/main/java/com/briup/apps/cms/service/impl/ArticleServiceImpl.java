package com.briup.apps.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.ArticleWithBLOBs;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.dao.ArticleMapper;
import com.briup.apps.cms.dao.extend.ArticleExtendMapper;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.CustomerException;

@Service
public class ArticleServiceImpl implements IArticleService {

	@Resource
    private ArticleMapper articleMapper;
	@Resource
	private ArticleExtendMapper articleExtendMapper;
	
	@Override
	public List<ArticleWithBLOBs> findAll() {
		ArticleExample example = new ArticleExample();
		return articleMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrUpdate(ArticleWithBLOBs article) {
		if(article.getId()!=null) {
			articleMapper.updateByPrimaryKeySelective(article);
		}else {
			//标题不能重名
			ArticleExample example = new ArticleExample();
			example.createCriteria().andTitleEqualTo(article.getTitle());
			
			List<ArticleWithBLOBs> articles = articleMapper.selectByExampleWithBLOBs(example);
			if(articles.size()>0) {
				throw new CustomerException("标题不能重复");
			}
			//初始化
			article.setPublishTime(new Date().getTime());
			article.setStatus(ArticleExtend.STATUS_UNCHECK);
			article.setThumbUp(0l);
			article.setThumpDown(0l);
			articleMapper.insert(article);
		}
	}

	@Override
	public int deleteById(long id) {
		articleMapper.deleteByPrimaryKey(id);
		return 0;
	}

	@Override
	public List<ArticleExtend> cascadeFindAll() {
		return articleExtendMapper.selectAll();
	}

	@Override
	public ArticleExtend findById(long id) {
		return articleExtendMapper.selectById(id);
	}

}
