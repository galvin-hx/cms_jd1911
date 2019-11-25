package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.extend.RoleExtend;
import com.briup.apps.cms.utils.CustomerException;

public interface IRoleService {

	List<Role> findAll();
	void saveOrUpdate(Role role) throws CustomerException;
	void deleteById(long id) throws CustomerException;
	void authorization(long roleId,List<Long> privilegeIds);
	List<RoleExtend> cascadePrivilegeFindAll();
}
