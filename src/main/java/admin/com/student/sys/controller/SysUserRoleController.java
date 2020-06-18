package admin.com.student.sys.controller;

import admin.com.student.common.core.controller.BaseController;
import admin.com.student.common.core.page.TableDataInfo;
import admin.com.student.sys.domain.SysUserRole;
import admin.com.student.sys.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户和角色关联Controller
 *
 * @author hecm
 * @date 2019-09-05
 */
@Controller
@RequestMapping("/system/role")
public class SysUserRoleController extends BaseController {

    @Autowired
    private ISysUserRoleService sysUserRoleService;


    /**
     * 查询用户和角色关联列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysUserRole sysUserRole) {
        startPage();
        List<SysUserRole> list = sysUserRoleService.selectSysUserRoleList(sysUserRole);
        return getDataTable(list);
    }

}
