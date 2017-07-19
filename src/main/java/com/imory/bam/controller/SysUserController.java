package com.imory.bam.controller;

import com.imory.bam.sysuser.bean.SysUser;
import com.imory.bam.sysuser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/11
 */
@Controller
@RequestMapping("/bam/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("test")
    public SysUser test(Integer id)
    {
        return sysUserService.findUserById(id);
    }

}
