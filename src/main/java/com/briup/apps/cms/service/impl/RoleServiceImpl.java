package com.briup.apps.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.RoleExample;
import com.briup.apps.cms.bean.RolePrivilege;
import com.briup.apps.cms.bean.RolePrivilegeExample;
import com.briup.apps.cms.bean.extend.RoleExtend;
import com.briup.apps.cms.dao.RoleMapper;
import com.briup.apps.cms.dao.RolePrivilegeMapper;
import com.briup.apps.cms.dao.extend.RoleExtendMapper;
import com.briup.apps.cms.service.IRoleService;
import com.briup.apps.cms.utils.CustomerException;

@Service
public class RoleServiceImpl implements IRoleService {

	@Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleExtendMapper roleExtendMapper;
    @Resource
    private RolePrivilegeMapper rolePrivilegeMapper;
	
	@Override
	public List<Role> findAll() {
		RoleExample example = new RoleExample();
		return roleMapper.selectByExample(example);
	}

	@Override
	public void saveOrUpdate(Role role) {
		if(role.getId()!=null){
            roleMapper.updateByPrimaryKey(role);
        } else {
            roleMapper.insert(role);
        }
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		Role role = roleMapper.selectByPrimaryKey(id);
        if(role == null){
            throw new CustomerException("要删除的角色不存在");
        }
        roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void authorization(long roleId, List<Long> privilegeIds) {
		// 根据roleid查询出所有的权限
        RolePrivilegeExample example = new RolePrivilegeExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<RolePrivilege> list = rolePrivilegeMapper.selectByExample(example);
        // 将list转换为privilegeIDs的集合
        List<Long> old_privilegeIds = new ArrayList<>();
        for(RolePrivilege rp : list){
            old_privilegeIds.add(rp.getPrivilegeId());
        }
        // 依次判断privilegeIds 是否存在old_privilegeIds，如果不在则插入
        for(long privilegeId : privilegeIds){
            if (!old_privilegeIds.contains(privilegeId)) {
                RolePrivilege rp = new RolePrivilege();
                rp.setRoleId(roleId);
                rp.setPrivilegeId(privilegeId);
                rolePrivilegeMapper.insert(rp);
            }
        }
        // 依次判断 是否存在old_privilegeIds 是否存在privilegeIds，如果不存在删除
        for(long privilegeId: old_privilegeIds){
            if(!privilegeIds.contains(privilegeId)){
                // 根据privilegeId 从桥表中删除
                example.clear();
                example.createCriteria()
                        .andRoleIdEqualTo(roleId)
                        .andPrivilegeIdEqualTo(privilegeId);
                rolePrivilegeMapper.deleteByExample(example);
            }
        }
	}

	@Override
	public List<RoleExtend> cascadePrivilegeFindAll() {
		return roleExtendMapper.selectAll();
	}

}
