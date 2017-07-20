package com.imory.bam.sysuser.service;

import com.imory.bam.sysuser.bean.SysCurrencyUnit;
import com.imory.bam.sysuser.dao.SysCurrencyUnitMapper;
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
public class SysCurrencyUnitService {

    @Autowired
    private SysCurrencyUnitMapper sysCurrencyUnitMapper;

    public List<SysCurrencyUnit> listSysCurrencyUnit(Integer startPos, Integer maxRows, String qryVal)
    {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("startPos", startPos);
        paramsMap.put("maxRows", maxRows);
        paramsMap.put("qryVal", qryVal);
        return sysCurrencyUnitMapper.listSysCurrencyUnit(paramsMap);
    }

    public int countSysCurrencyUnit(String qryVal)
    {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("qryVal", qryVal);
        return sysCurrencyUnitMapper.countSysCurrencyUnit(paramsMap);
    }

    /**
     * 保存
     *
     * @param sysAmountUnit
     * @return
     */
    public int insert(SysCurrencyUnit sysAmountUnit)
    {
        return sysCurrencyUnitMapper.insert(sysAmountUnit);
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public SysCurrencyUnit getById(Integer id)
    {
        return sysCurrencyUnitMapper.getById(id);
    }

    /**
     * 更新
     *
     * @param sysOrigin
     * @return
     */
    public int updateById(SysCurrencyUnit sysOrigin)
    {
        return sysCurrencyUnitMapper.updateById(sysOrigin);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(Integer id)
    {
        sysCurrencyUnitMapper.deleteById(id);
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
        sysCurrencyUnitMapper.deleteByIds(paramsMap);
    }
}
