package com.imory.bam.sysuser.service;

import com.imory.bam.sysuser.bean.SysUser;
import com.imory.bam.sysuser.dao.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/11
 */
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 根据Id查用户
     *
     * @param id
     * @return
     */
    public SysUser findUserById(Integer id)
    {
        return sysUserMapper.findUserById(id);
    }

    /**
     * 新增管理员
     *
     * @param logonId
     * @param userName
     * @param password
     * @param level
     * @return
     */
    public int insert(String logonId, String userName, String password, Integer level)
    {
        return sysUserMapper.insert(logonId, userName, password, level);
    }

    /**
     * 重置密码
     */
    public void resertPsd(Integer id)
    {
        sysUserMapper.resertPsd(id);
    }

    /**
     * 用户列表
     *
     * @param startPos
     * @param maxRows
     * @return
     */
    public List<SysUser> listSysUser(Integer startPos, Integer maxRows)
    {
        return sysUserMapper.listSysUser(startPos, maxRows);
    }

    /**
     * 登录
     *
     * @param logonId
     * @param password
     * @return
     */
    public SysUser userLogon(String logonId, String password)
    {
        return sysUserMapper.userLogon(logonId, password);
    }

    /**
     * 查询
     *
     * @param logonId
     * @return
     */
    public SysUser findSysUserByLogonId(String logonId)
    {
        return sysUserMapper.findSysUserByLogonId(logonId);
    }
}
