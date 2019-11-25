package com.briup.apps.cms.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.ArticleWithBLOBs;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/article")
public class ArticleController {

	@Autowired
    private IArticleService articleService;
	
	@ApiOperation(value = "查询所有文章")
	@GetMapping(value = "findAll")
    public Message findAll(){
		List<ArticleWithBLOBs> list = articleService.findAll();
        return MessageUtil.success(list);
    }
	
	@ApiOperation(value = "级联查询文章",notes = "级联所属栏目，作者")
	@GetMapping(value = "cascadeFindAll")
    public Message cascadeFindAll(){
		List<ArticleExtend> list = articleService.cascadeFindAll();
        return MessageUtil.success(list);
    }
	
	@ApiOperation(value = "通过id查询")
	@ApiImplicitParams(
			@ApiImplicitParam(name = "id",value = "主键",paramType = "query")
	)
	@GetMapping(value = "findById")
    public Message findById(long id){
		ArticleExtend articleExtend = articleService.findById(id);
        return MessageUtil.success(articleExtend);
    }
	
	@ApiOperation(value = "保存或更新文章信息",notes = "如果参数中包含id后端认为是更新操作，如果参数中不包含id认为是插入操作")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "编号",paramType = "form",required = false),
			@ApiImplicitParam(name = "title",value = "标题",paramType = "form",required = true),
			@ApiImplicitParam(name = "content",value = "内容",paramType = "form",required = true),
			@ApiImplicitParam(name = "source",value = "源内容",paramType = "form",required = false),
			@ApiImplicitParam(name = "categoryId",value = "所属栏目id",paramType = "form",required = true),
			@ApiImplicitParam(name = "authorId",value = "所属作者id",paramType = "form",required = false)
			
	})
	@PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(
    		Long id,
    		@NotNull String title,
    		@NotNull String content,
    		String source,
    		@NotNull long categoryId,
    		Long authorId){
        // 调用service,完成保存
		ArticleWithBLOBs article = new ArticleWithBLOBs();
		article.setId(id);
		article.setTitle(title);
		article.setContent(content);
		article.setSource(source);
		article.setCategoryId(categoryId);
		article.setAuthorId(authorId);
		articleService.saveOrUpdate(article);
        return MessageUtil.success("更新成功");
    }
	
	@PostMapping(value = "delete")
    public String deleteById(Integer id){
        // 调用service,完成保存
		articleService.deleteById(id);
        return "删除成功";
    }
	
}
