package com.imory.bam.sysuser.service;

import com.imory.bam.sysuser.bean.SysAmountUnit;
import com.imory.bam.sysuser.dao.SysAmountUnitMapper;
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
public class SysAmountUnitService {

    @Autowired
    private SysAmountUnitMapper sysAmountUnitMapper;

    public List<SysAmountUnit> listSysAmountUnit(Integer startPos, Integer maxRows, String qryVal)
    {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("startPos", startPos);
        paramsMap.put("maxRows", maxRows);
        paramsMap.put("qryVal", qryVal);
        return sysAmountUnitMapper.listSysAmountUnit(paramsMap);
    }

    public int countSysAmountUnit(String qryVal)
    {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("qryVal", qryVal);
        return sysAmountUnitMapper.countSysAmountUnit(paramsMap);
    }

    /**
     * 保存
     *
     * @param sysAmountUnit
     * @return
     */
    public int insert(SysAmountUnit sysAmountUnit)
    {
        return sysAmountUnitMapper.insert(sysAmountUnit);
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public SysAmountUnit getById(Integer id)
    {
        return sysAmountUnitMapper.getById(id);
    }

    /**
     * 更新
     *
     * @param sysOrigin
     * @return
     */
    public int updateById(SysAmountUnit sysOrigin)
    {
        return sysAmountUnitMapper.updateById(sysOrigin);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(Integer id)
    {
        sysAmountUnitMapper.deleteById(id);
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
        sysAmountUnitMapper.deleteByIds(paramsMap);
    }
}
