package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.CommentExample;
import com.briup.apps.cms.dao.CommentMapper;
import com.briup.apps.cms.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService {

	@Resource
    private CommentMapper commentMapper;
	
	@Override
	public List<Comment> findAll() {
		CommentExample example = new CommentExample();
		return commentMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrUpdate(Comment comment) {
		commentMapper.insert(comment);
	}

	@Override
	public int deleteById(long id) {
		commentMapper.deleteByPrimaryKey(id);
		return 0;
	}

}
