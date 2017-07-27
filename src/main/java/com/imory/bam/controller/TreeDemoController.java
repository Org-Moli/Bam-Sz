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
 * @Date 2017/7/26
 */
@Controller
@RequestMapping("/tree")
public class TreeDemoController {

    @RequestMapping("/index")
    public String tree()
    {
        return "tree";
    }
    
    @RequestMapping("/ztreeIndex")
    public String ztreeIndex()
    {
        return "ztree";
    }
}
