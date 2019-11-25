package com.briup.apps.cms.dao.extend;

import java.util.List;

import com.briup.apps.cms.bean.extend.UserExtend;

public interface UserExtendMapper {

	UserExtend selectById(long id);

    List<UserExtend> selectAll();
    
    UserExtend selectByName(String username);
}
