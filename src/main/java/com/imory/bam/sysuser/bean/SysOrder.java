package com.imory.bam.sysuser.bean;

import java.util.Date;

/**
 * 
 * @author hushun
 *
 */
public class SysOrder {

    private Integer id;                         
    private String orderNum;                    //'订单编号' ,
    private Double order_amount;                //'订单金额' ,
    private Date create_date;                   //'下单时间' ,
    private int  audit_status;                  //'审核状态' ,
    private String trans_user_name;             //'收货人' ,
    private int trans_user_id;                  //'收货人ID' ,
    private String trans_user_id_num;           //'收货人身份证' ,
    private String trans_user_phone;            //'收货人电话' ,
    private String trans_user_address;          //'收货人地址' ,
    private String trans_province;              //'省' ,
    private String trans_province_code;         //'省code' ,
    private String trans_city;                  //'市' ,
    private String trans_city_code;             //'市code' ,
    private String trans_area;                  //'县/区' ,
    private String trans_area_code;             //'县/区code' ,
    private String trans_town;                  //'镇/街道' ,
    private String trans_town_code;             //'镇/街道code' ,
    private int  del_flag;                      //'是否被删除默认0 ，1为删除' ,
    private String payer_name;                  //'支付人' ,
    private String payer_id_num;                //'支付人身份证' ,
    private String payer_phone;                 //'支付人电话' ,
    private Double payer_amount;                //'支付金额' ,
    private Double trans_amount;                //'运费' ,
    private Double prd_amount;                  //'商品金额' ,
    private Double tax_amount;                  //'税款金额' ,
    private String postal_code;                 //'邮政编号' 
    private String delevery_order;              //运单号
    private Integer  customs_status;            //'申报海关状态:0未申报，1审核中，2通过，3驳回',
    private Integer  ngtc_status;               //'申报国检状态:0未申报，1审核中，2通过，3驳回'
    private Integer  payment_bg_status;         //'支付海关状态:0未申报，1审核中，2报关成功，3报关失败'
    private Date   update_time;                 //更新时间
    private Double all_amount;                  //总金额
    private int   bg_status;                    //'报关状态:0未报关，1报关成功，2，报关审核中，3报关失败，4报关处理中',
    private int   bgj_status;                   //'报国检状态:0未申报，1成功，2初始化，3取消，4失败，5错误，6申报中',
    private int   logistics_status;             //'物流状态:0未申报，1审核中，2通过，3驳回',
    private String tem_guanj_name;//'关检名称',
    private String tem_hg_name;   //'海关名称',
    private String tem_hg_huizhi;//'海关申报回执',
    private String tem_guoj_name;//'国检名称',
    private String tem_guoj_huizhi;//'国检申报回执',
    private String tem_logitics_name;//'物流名称',
    private String tem_logitics_huizhi;//'物流回执',
    private int  payment_gj_status;//'支付国检状态:0未申报，1成功，2初始化，3取消，4失败，5错误，6申报中',
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Double getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(Double order_amount) {
		this.order_amount = order_amount;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public int getAudit_status() {
		return audit_status;
	}
	public void setAudit_status(int audit_status) {
		this.audit_status = audit_status;
	}
	public String getTrans_user_name() {
		return trans_user_name;
	}
	public void setTrans_user_name(String trans_user_name) {
		this.trans_user_name = trans_user_name;
	}
	public int getTrans_user_id() {
		return trans_user_id;
	}
	public void setTrans_user_id(int trans_user_id) {
		this.trans_user_id = trans_user_id;
	}
	public String getTrans_user_id_num() {
		return trans_user_id_num;
	}
	public void setTrans_user_id_num(String trans_user_id_num) {
		this.trans_user_id_num = trans_user_id_num;
	}
	public String getTrans_user_phone() {
		return trans_user_phone;
	}
	public void setTrans_user_phone(String trans_user_phone) {
		this.trans_user_phone = trans_user_phone;
	}
	public String getTrans_user_address() {
		return trans_user_address;
	}
	public void setTrans_user_address(String trans_user_address) {
		this.trans_user_address = trans_user_address;
	}
	public String getTrans_province() {
		return trans_province;
	}
	public void setTrans_province(String trans_province) {
		this.trans_province = trans_province;
	}
	public String getTrans_province_code() {
		return trans_province_code;
	}
	public void setTrans_province_code(String trans_province_code) {
		this.trans_province_code = trans_province_code;
	}
	public String getTrans_city() {
		return trans_city;
	}
	public void setTrans_city(String trans_city) {
		this.trans_city = trans_city;
	}
	public String getTrans_city_code() {
		return trans_city_code;
	}
	public void setTrans_city_code(String trans_city_code) {
		this.trans_city_code = trans_city_code;
	}
	public String getTrans_area() {
		return trans_area;
	}
	public void setTrans_area(String trans_area) {
		this.trans_area = trans_area;
	}
	public String getTrans_area_code() {
		return trans_area_code;
	}
	public void setTrans_area_code(String trans_area_code) {
		this.trans_area_code = trans_area_code;
	}
	public String getTrans_town() {
		return trans_town;
	}
	public void setTrans_town(String trans_town) {
		this.trans_town = trans_town;
	}
	public String getTrans_town_code() {
		return trans_town_code;
	}
	public void setTrans_town_code(String trans_town_code) {
		this.trans_town_code = trans_town_code;
	}
	public int getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(int del_flag) {
		this.del_flag = del_flag;
	}
	public String getPayer_name() {
		return payer_name;
	}
	public void setPayer_name(String payer_name) {
		this.payer_name = payer_name;
	}
	public String getPayer_id_num() {
		return payer_id_num;
	}
	public void setPayer_id_num(String payer_id_num) {
		this.payer_id_num = payer_id_num;
	}
	public String getPayer_phone() {
		return payer_phone;
	}
	public void setPayer_phone(String payer_phone) {
		this.payer_phone = payer_phone;
	}
	public Double getPayer_amount() {
		return payer_amount;
	}
	public void setPayer_amount(Double payer_amount) {
		this.payer_amount = payer_amount;
	}
	public Double getTrans_amount() {
		return trans_amount;
	}
	public void setTrans_amount(Double trans_amount) {
		this.trans_amount = trans_amount;
	}
	public Double getPrd_amount() {
		return prd_amount;
	}
	public void setPrd_amount(Double prd_amount) {
		this.prd_amount = prd_amount;
	}
	public Double getTax_amount() {
		return tax_amount;
	}
	public void setTax_amount(Double tax_amount) {
		this.tax_amount = tax_amount;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getDelevery_order() {
		return delevery_order;
	}
	public void setDelevery_order(String delevery_order) {
		this.delevery_order = delevery_order;
	}
	public Integer getCustoms_status() {
		return customs_status;
	}
	public void setCustoms_status(Integer customs_status) {
		this.customs_status = customs_status;
	}
	public Integer getNgtc_status() {
		return ngtc_status;
	}
	public void setNgtc_status(Integer ngtc_status) {
		this.ngtc_status = ngtc_status;
	}
	public Integer getPayment_bg_status() {
		return payment_bg_status;
	}
	public void setPayment_bg_status(Integer payment_bg_status) {
		this.payment_bg_status = payment_bg_status;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	public Double getAll_amount() {
		return all_amount;
	}
	public void setAll_amount(Double all_amount) {
		this.all_amount = all_amount;
	}
	public int getBg_status() {
		return bg_status;
	}
	public void setBg_status(int bg_status) {
		this.bg_status = bg_status;
	}
	public int getBgj_status() {
		return bgj_status;
	}
	public void setBgj_status(int bgj_status) {
		this.bgj_status = bgj_status;
	}
	public int getLogistics_status() {
		return logistics_status;
	}
	public void setLogistics_status(int logistics_status) {
		this.logistics_status = logistics_status;
	}
	public String getTem_guanj_name() {
		return tem_guanj_name;
	}
	public void setTem_guanj_name(String tem_guanj_name) {
		this.tem_guanj_name = tem_guanj_name;
	}
	public String getTem_hg_name() {
		return tem_hg_name;
	}
	public void setTem_hg_name(String tem_hg_name) {
		this.tem_hg_name = tem_hg_name;
	}
	public String getTem_hg_huizhi() {
		return tem_hg_huizhi;
	}
	public void setTem_hg_huizhi(String tem_hg_huizhi) {
		this.tem_hg_huizhi = tem_hg_huizhi;
	}
	public String getTem_guoj_name() {
		return tem_guoj_name;
	}
	public void setTem_guoj_name(String tem_guoj_name) {
		this.tem_guoj_name = tem_guoj_name;
	}
	public String getTem_guoj_huizhi() {
		return tem_guoj_huizhi;
	}
	public void setTem_guoj_huizhi(String tem_guoj_huizhi) {
		this.tem_guoj_huizhi = tem_guoj_huizhi;
	}
	public String getTem_logitics_name() {
		return tem_logitics_name;
	}
	public void setTem_logitics_name(String tem_logitics_name) {
		this.tem_logitics_name = tem_logitics_name;
	}
	public String getTem_logitics_huizhi() {
		return tem_logitics_huizhi;
	}
	public void setTem_logitics_huizhi(String tem_logitics_huizhi) {
		this.tem_logitics_huizhi = tem_logitics_huizhi;
	}
	public int getPayment_gj_status() {
		return payment_gj_status;
	}
	public void setPayment_gj_status(int payment_gj_status) {
		this.payment_gj_status = payment_gj_status;
	}
    
    
}
