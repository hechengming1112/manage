package admin.com.student.sys.service.impl;

import java.util.List;

import admin.com.student.common.core.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import admin.com.student.sys.mapper.SysUserRoleMapper;
import admin.com.student.sys.domain.SysUserRole;
import admin.com.student.sys.service.ISysUserRoleService;

/**
 * 用户和角色关联Service业务层处理
 *
 * @author hecm
 * @date 2019-09-05
 */
@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;


    /**
     * 查询用户和角色关联列表
     *
     * @param sysUserRole 用户和角色关联
     * @return 用户和角色关联
     */
    @Override
    public List<SysUserRole> selectSysUserRoleList(SysUserRole sysUserRole) {
        return sysUserRoleMapper.selectSysUserRoleList(sysUserRole);
    }

}
