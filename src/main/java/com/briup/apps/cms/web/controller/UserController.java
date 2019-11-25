package com.briup.apps.cms.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.service.IUserService;
import com.briup.apps.cms.utils.JwtTokenUtil;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.UserRoleVM;
import com.briup.apps.cms.vm.UserVM;

import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private IUserService userService;
	
	@PostMapping("login")
	public Message login(@RequestBody UserVM userVM) {
		// 1. 认证用户的用户名和密码
        User user = userService.login(userVM);
        // 2. 如果登录成功产生token,将token缓存起来，返回
        String token = JwtTokenUtil.createJWT(user.getId(), user.getUsername());
        // 3. 如果登录失败
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return MessageUtil.success(map);
//		UserExtend userExtend = userService.findByName(userVM.getUsername());
//		if(userExtend == null) {
//			return MessageUtil.error("用户名不存在");
//		}
//		if(userVM.getUsername().equals(userExtend.getUsername())&&
//				userVM.getPassword().equals(userExtend.getPassword())) {
//			Map<String,String> map = new HashMap<>();
//	        map.put("token",userVM.getUsername()+"-token");
//	        return MessageUtil.success(map);
//		}
//		return MessageUtil.error("用户名或密码错误");
	}
	
	@ApiOperation(value = "通过token获取用户的基本信息")
    @GetMapping("info")
    public Message info(String token){
		// 1. 通过token获取用户信息  {id,use,gender,roles:[]}
        long id = Long.parseLong(JwtTokenUtil.getUserId(token,JwtTokenUtil.base64Secret));
        UserExtend userExtend = userService.findById(id);
        return MessageUtil.success(userExtend);
//		String s = token.substring(0,token.length()-6);
//      UserExtend userExtend = userService.findByName(s);
//      return MessageUtil.success(userExtend);
    }
	
	@PostMapping("logout")
    public Message logout(){
        // 1. 登录， token从缓存中移除掉
        return MessageUtil.success("退出成功");
    }
	
	@ApiOperation(value = "查询所有")
    @GetMapping(value = "findAll")
    public Message findAll(){
        List<User> list = userService.findAll();
        return MessageUtil.success(list);
    }
	
	@ApiOperation(value = "查询所有",notes = "级联用户角色")
    @GetMapping(value = "cascadeRoleFindAll")
    public Message cascadeRoleFindAll(){
        List<UserExtend> list = userService.cascadeRoleFindAll();
        return MessageUtil.success(list);
    }
	
	@ApiOperation(value = "保存或更新")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(User user){
        userService.saveOrUpdate(user);
        return MessageUtil.success("更新成功");
    }
	
	@ApiOperation(value = "设置权限")
    @PostMapping(value = "setRoles")
    public Message setRoles(UserRoleVM userRoleVM){
        userService.setRoles(userRoleVM.getId(),userRoleVM.getRoles());
        return MessageUtil.success("设置成功");
    }

	@ApiOperation(value = "通过id删除")
    @GetMapping(value = "deleteById")
    public Message deleteById(long id){
        userService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
}
