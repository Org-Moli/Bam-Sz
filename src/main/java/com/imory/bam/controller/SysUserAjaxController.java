package com.imory.bam.controller;

import com.imory.bam.sysuser.bean.SysUser;
import com.imory.bam.sysuser.service.SysUserService;
import com.imory.bam.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/17
 */
@RestController
@RequestMapping("/bam/sysUserAjax")
public class SysUserAjaxController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 保存管理员
     *
     * @param logonId
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/saveSysUser")
    public Map<String, Object> saveSysUser(String logonId, String userName, String password)
    {
        Map<String, Object> resultMap = new HashMap<>();
        //密码MD5加密
        int count = sysUserService.insert(logonId, userName, MD5Util.MD5Encode(password, "UTF-8"), 1);
        if (count > 0)
        {
            resultMap.put("success", true);
        } else
        {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 重置密码
     */
    @RequestMapping("/resetPsd")
    public Map<String, Object> resetPsd(Integer id)
    {
        Map<String, Object> resultMap = new HashMap<>();
        //密码重置为123456
        sysUserService.resertPsd(id);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 根据ID查询管理员信息
     *
     * @param id
     */
    @RequestMapping("/findSysUserById")
    public SysUser findSysUserById(Integer id)
    {
        return sysUserService.findUserById(id);
    }

    /**
     * 管理员列表
     * @param startPos
     * @param maxRows
     * @return
     */
    @RequestMapping("/listSysUser")
    public List<SysUser> listSysUser(Integer startPos, Integer maxRows)
    {
        return sysUserService.listSysUser(startPos, maxRows);
    }
}
