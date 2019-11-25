package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.UserVM;

public interface IUserService {

	UserExtend findById(long id);
	List<User> findAll();
	List<UserExtend> cascadeRoleFindAll();
	void saveOrUpdate(User user) throws CustomerException;
	void changeStatus(long id,String status) throws CustomerException;
	void deleteById(long id) throws CustomerException;
	void setRoles(long id, List<Long> roles);
	UserExtend findByName(String username);
	User login(UserVM userVM) throws CustomerException;
}
