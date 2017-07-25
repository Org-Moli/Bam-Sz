package com.imory.bam.sysuser.service;

import com.imory.bam.sysuser.bean.SysRole;
import com.imory.bam.sysuser.dao.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * @Date 2017/7/20
 */
@Service
public class SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    public List<SysRole> listSysRole()
    {
        return sysRoleMapper.listSysRole();
    }

    public int countSysRole()
    {
        return sysRoleMapper.countSysRole();
    }

    /**
     * 保存
     *
     * @param sysRole
     * @return
     */
    public int insert(SysRole sysRole)
    {
        return sysRoleMapper.insert(sysRole);
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public SysRole getById(Integer id)
    {
        return sysRoleMapper.getById(id);
    }

    /**
     * 更新
     *
     * @param sysRole
     * @return
     */
    public int updateById(SysRole sysRole)
    {
        return sysRoleMapper.updateById(sysRole);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(Integer id)
    {
        sysRoleMapper.deleteById(id);
    }

    /**
     * 删除
     *
     * @param ids
     */
    public void deleteByIds(Integer[] ids)
    {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("ids", ids);
        sysRoleMapper.deleteByIds(paramsMap);
    }
}
