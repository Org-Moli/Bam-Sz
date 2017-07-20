package com.imory.bam.sysuser.service;

import com.imory.bam.sysuser.bean.SysOrigin;
import com.imory.bam.sysuser.dao.SysOriginMapper;
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
public class SysOriginService {

    @Autowired
    private SysOriginMapper sysOriginMapper;

    public List<SysOrigin> listSysOrigin(Integer startPos, Integer maxRows)
    {
        return sysOriginMapper.listSysOrigin(startPos, maxRows);
    }

    public int countSysOrigin()
    {
        return sysOriginMapper.countSysOrigin();
    }

    /**
     * 保存
     *
     * @param sysOrigin
     * @return
     */
    public int insert(SysOrigin sysOrigin)
    {
        return sysOriginMapper.insert(sysOrigin);
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public SysOrigin getById(Integer id)
    {
        return sysOriginMapper.getById(id);
    }

    /**
     * 更新
     *
     * @param sysOrigin
     * @return
     */
    public int updateById(SysOrigin sysOrigin)
    {
        return sysOriginMapper.updateById(sysOrigin);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(Integer id)
    {
        sysOriginMapper.deleteById(id);
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
        sysOriginMapper.deleteByIds(paramsMap);
    }
}
