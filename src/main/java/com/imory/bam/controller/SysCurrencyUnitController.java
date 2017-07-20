package com.imory.bam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/20
 */
@Controller
@RequestMapping("/bam/sysCurrencyUnit")
public class SysCurrencyUnitController {

    @RequestMapping("/sysCurrencyUnitList")
    public String sysCurrencyUnitList()
    {
        return "/bam/sysCurrencyUnitList";
    }

}
