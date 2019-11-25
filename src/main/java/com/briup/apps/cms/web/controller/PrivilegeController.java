package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.service.IPrivilegeService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.PrivilegeTree;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/privilege")
public class PrivilegeController {

	@Autowired
    private IPrivilegeService privilegeSevice;
	
	@ApiOperation(value = "查询所有")
	@GetMapping(value = "findAll")
    public Message findAll(){
		List<Privilege> list = privilegeSevice.findAll();
        return MessageUtil.success(list);
    }
	
	@ApiOperation(value = "通过parentId查询")
	@GetMapping(value = "findByParentId")
	public Message findByParentId(Long id) {
		List<Privilege> list = privilegeSevice.findByParentId(id);
		return MessageUtil.success(list);
	}
	
	@ApiOperation(value = "保存或更新")
	@PostMapping(value = "saveOrUpdate")
	public Message saveOrUpdate(Privilege privilege) {
		privilegeSevice.saveOrUpdate(privilege);
		return MessageUtil.success("更新成功");
	}
	
	@ApiOperation(value = "查询树")
	@GetMapping(value = "findPrivilegeTree")
	public Message findPrivilegeTree() {
		List<PrivilegeTree> list = privilegeSevice.findPrivilegeTree();
		return MessageUtil.success(list);
	}
}
