package com.imory.bam.controller;

import com.imory.bam.sysuser.bean.SysProductCk;
import com.imory.bam.sysuser.service.SysProductCkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/29
 */
@Controller
@RequestMapping("/bam/sysProductCk")
public class SysProductCkController {

    @Autowired
    private SysProductCkService sysProductCkService;

    @RequestMapping("/sysProductCkList")
    public String sysProductCkList()
    {
        return "/bam/sysProductCkList";
    }

    @RequestMapping("/addProductCk")
    public String addProductCk(Integer id, Model model)
    {
        if (id != null)
        {
            model.addAttribute("productCk", sysProductCkService.getById(id));
        } else
        {
            model.addAttribute("productCk", new SysProductCk());
        }
        return "/bam/addProductCk";
    }
}
