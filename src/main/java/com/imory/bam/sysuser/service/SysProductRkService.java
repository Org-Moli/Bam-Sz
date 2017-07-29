package com.imory.bam.sysuser.service;

import com.imory.bam.sysuser.bean.SysProductRk;
import com.imory.bam.sysuser.dao.SysProductRkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
public class SysProductRkService {

    @Autowired
    private SysProductRkMapper sysProductRkMapper;

    public List<SysProductRk> listSysProductRk(Map<String, Object> paramsMap)
    {
        return sysProductRkMapper.listSysProductRk(paramsMap);
    }

    public int countSysProductRk(Map<String, Object> paramsMap)
    {
        return sysProductRkMapper.countSysProductRk(paramsMap);
    }

    /**
     * 保存
     *
     * @param sysProductRk
     * @return
     */
    public int insert(SysProductRk sysProductRk)
    {
        return sysProductRkMapper.insert(sysProductRk);
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public SysProductRk getById(Integer id)
    {
        return sysProductRkMapper.getById(id);
    }

    /**
     * 更新
     *
     * @param sysProductRk
     * @return
     */
    public int updateById(SysProductRk sysProductRk)
    {
        return sysProductRkMapper.updateById(sysProductRk);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(Integer id)
    {
        sysProductRkMapper.deleteById(id);
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
        sysProductRkMapper.deleteByIds(paramsMap);
    }
}
