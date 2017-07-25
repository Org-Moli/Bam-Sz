package com.imory.bam.sysuser.service;

import com.imory.bam.sysuser.bean.SysPlatform;
import com.imory.bam.sysuser.dao.SysPlatformMapper;
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
public class SysPlatformService {

    @Autowired
    private SysPlatformMapper sysPlatformMapper;

    public List<SysPlatform> listSysPlatform()
    {
        return sysPlatformMapper.listSysPlatform();
    }

    public int countSysPlatform()
    {
        return sysPlatformMapper.countSysPlatform();
    }

    /**
     * 保存
     *
     * @param sysPlatform
     * @return
     */
    public int insert(SysPlatform sysPlatform)
    {
        return sysPlatformMapper.insert(sysPlatform);
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public SysPlatform getById(Integer id)
    {
        return sysPlatformMapper.getById(id);
    }

    /**
     * 更新
     *
     * @param sysPlatform
     * @return
     */
    public int updateById(SysPlatform sysPlatform)
    {
        return sysPlatformMapper.updateById(sysPlatform);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(Integer id)
    {
        sysPlatformMapper.deleteById(id);
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
        sysPlatformMapper.deleteByIds(paramsMap);
    }
}
