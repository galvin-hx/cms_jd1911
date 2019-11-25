package com.briup.apps.cms.dao.extend;

import java.util.List;

import com.briup.apps.cms.bean.Comment;

public interface CommentExtendMapper {

	List<Comment> selectByArticleId(long article_id);
}
