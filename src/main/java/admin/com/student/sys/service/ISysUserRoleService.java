package admin.com.student.sys.service;

import admin.com.student.sys.domain.SysUserRole;

import java.util.List;

/**
 * 用户和角色关联Service接口
 *
 * @author hecm
 * @date 2019-09-05
 */
public interface ISysUserRoleService {

    /**
     * 查询用户和角色关联列表
     *
     * @param sysUserRole 用户和角色关联
     * @return 用户和角色关联集合
     */
    public List<SysUserRole> selectSysUserRoleList(SysUserRole sysUserRole);

}
