package com.briup.apps.cms.dao.extend;

import java.util.List;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.extend.RoleExtend;

public interface RoleExtendMapper {

	List<Role> selectByUserId(long id);

    List<RoleExtend> selectAll();
}
