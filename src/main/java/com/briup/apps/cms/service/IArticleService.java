package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.ArticleWithBLOBs;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.utils.CustomerException;

public interface IArticleService {

	List<ArticleWithBLOBs> findAll();
	List<ArticleExtend> cascadeFindAll();
	ArticleExtend findById(long id);
	void saveOrUpdate(ArticleWithBLOBs article) throws CustomerException;
	int deleteById(long id);
}
