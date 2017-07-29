package com.imory.bam.sysuser.bean;

import java.util.Date;

/**
 * 
 * @author hushun
 *
 */
public class SysRegion {

    private Integer id;                         
    private String name;
    private Integer pid;
    private String isParent;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getIsParent() {
		return isParent;
	}
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
    
    
}
