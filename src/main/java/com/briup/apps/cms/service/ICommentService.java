package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Comment;

public interface ICommentService {

	List<Comment> findAll();
	void saveOrUpdate(Comment comment);
	int deleteById(long id);
}
