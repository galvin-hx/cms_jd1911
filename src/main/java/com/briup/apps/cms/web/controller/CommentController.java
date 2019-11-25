package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.service.ICommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
    private ICommentService commentService;
	
	@GetMapping(value = "findAll")
    public List<Comment> findAll(){
        return commentService.findAll();
    }
	
	@PostMapping(value = "saveOrUpdate")
    public String saveOrUpdate(Comment comment){
        // 调用service,完成保存
		commentService.saveOrUpdate(comment);
        return "保存成功";
    }
	
	@PostMapping(value = "delete")
    public String deleteById(long id){
        // 调用service,完成保存
		commentService.deleteById(id);
        return "删除成功";
    }
	
}
