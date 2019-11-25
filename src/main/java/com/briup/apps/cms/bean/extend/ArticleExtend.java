package com.briup.apps.cms.bean.extend;

import java.util.List;

import com.briup.apps.cms.bean.ArticleWithBLOBs;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.User;

public class ArticleExtend extends ArticleWithBLOBs {
	
	public static final String STATUS_UNCHECK = "未审核";
	public static final String STATUS_CHECK_PASS = "审核通过";
	public static final String STATUS_CHECK_NOPASS = "审核未通过";
	private Category category;
	private User user;
	private List<Comment> comments;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
