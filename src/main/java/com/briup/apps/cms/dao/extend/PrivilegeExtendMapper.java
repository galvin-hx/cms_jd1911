package com.briup.apps.cms.dao.extend;

import java.util.List;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.vm.PrivilegeTree;

public interface PrivilegeExtendMapper {

	List<PrivilegeTree> selectAll();

    List<Privilege> selectByParentId(long id);

    List<Privilege> selectByRoleId(long id);
    
    List<Privilege> selectByUserId(long id);
}
