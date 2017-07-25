/*
 Navicat Premium Data Transfer

 Source Server         : zb.jiang
 Source Server Type    : MySQL
 Source Server Version : 50636
 Source Host           : localhost
 Source Database       : simplebam

 Target Server Type    : MySQL
 Target Server Version : 50636
 File Encoding         : utf-8

 Date: 07/13/2017 17:00:57 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `sys_ picture`
-- ----------------------------


-- ----------------------------
--  Table structure for `sys_clients`
-- ----------------------------
DROP TABLE IF EXISTS `sys_clients`;
CREATE TABLE `sys_clients` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '名称',
  `picUrl` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `bindUrl` varchar(200) DEFAULT NULL COMMENT '关联地址',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
--  Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `logonId` varchar(50) DEFAULT NULL COMMENT '登录ID',
  `userName` varchar(100) DEFAULT NULL COMMENT '姓名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `level` int(1) DEFAULT NULL COMMENT '等级',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `lastIp` varchar(100) DEFAULT NULL COMMENT '登录IP',
  `lastTime` datetime DEFAULT NULL COMMENT '登录时间',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_user`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` (`id`, `logonId`, `userName`, `password`, `level`, `createTime`, `lastIp`, `lastTime`, `enabled`)
VALUES
  (1,'superadmin','superadmin','e10adc3949ba59abbe56e057f20f883e',0,'2017-07-11 15:48:39',NULL,NULL,NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_order`
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNum` varchar(20) DEFAULT NULL COMMENT '订单编号',
  `order_amount` double(20,0) DEFAULT '0' COMMENT '订单金额',
  `create_date` datetime DEFAULT NULL COMMENT '下单时间',
  `audit_status` int(3) DEFAULT '0' COMMENT '审核状态',
  `trans_user_name` varchar(255) DEFAULT NULL COMMENT '收货人',
  `trans_user_id` int(11) DEFAULT '0' COMMENT '收货人ID',
  `trans_user_id_num` varchar(255) DEFAULT NULL COMMENT '收货人身份证',
  `trans_user_phone` varchar(20) DEFAULT NULL COMMENT '收货人电话',
  `trans_user_address` varchar(255) DEFAULT NULL COMMENT '收货人地址',
  `trans_province` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '省',
  `trans_province_code` varchar(255) DEFAULT NULL COMMENT '省code',
  `trans_city` varchar(255) DEFAULT NULL COMMENT '市',
  `trans_city_code` varchar(255) DEFAULT NULL COMMENT '市code',
  `trans_area` varchar(255) DEFAULT NULL COMMENT '县/区',
  `trans_area_code` varchar(255) DEFAULT NULL COMMENT '县/区code',
  `trans_town` varchar(255) DEFAULT NULL COMMENT '镇/街道',
  `trans_town_code` varchar(255) DEFAULT NULL COMMENT '镇/街道code',
  `del_flag` int(3) DEFAULT '0' COMMENT '是否被删除默认0 ，1为删除',
  `payer_name` varchar(255) DEFAULT NULL COMMENT '支付人',
  `payer_id_num` varchar(255) DEFAULT NULL COMMENT '支付人身份证',
  `payer_phone` varchar(20) DEFAULT NULL COMMENT '支付人电话',
  `payer_amount` double(20,2) DEFAULT '0.00' COMMENT '支付金额',
  `trans_amount` double(20,2) DEFAULT '0.00' COMMENT '运费',
  `prd_amount` double(20,2) DEFAULT '0.00' COMMENT '商品金额',
  `tax_amount` double(20,2) DEFAULT '0.00' COMMENT '税款金额',
  `postal_code` varchar(10) DEFAULT NULL COMMENT '邮政编号',
  `delevery_order` varchar(30) DEFAULT NULL COMMENT '运单号',
  `customs_status` int(3) DEFAULT '0' COMMENT '申报海关状态:0未申报，1审核中，2通过，3驳回',
  `ngtc_status` int(3) DEFAULT '0' COMMENT '申报国检状态:0未申报，1审核中，2通过，3驳回',
  `payment_bg_status` int(3) DEFAULT '0' COMMENT '支付海关状态:0未申报，1审核中，2报关成功，3报关失败',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `all_amount` double(20,2) DEFAULT '0.00' COMMENT '总金额',
  `bg_status` int(3) DEFAULT '0' COMMENT '报关状态:0未报关，1报关成功，2，报关审核中，3报关失败，4报关处理中',
  `bgj_status` int(3) DEFAULT '0' COMMENT '报国检状态:0未申报，1成功，2初始化，3取消，4失败，5错误，6申报中',
  `logistics_status` int(3) DEFAULT '0' COMMENT '物流状态:0未申报，1审核中，2通过，3驳回',
  `tem_guanj_name` varchar(255) DEFAULT NULL COMMENT '关检名称',
  `tem_hg_name` varchar(255) DEFAULT NULL COMMENT '海关名称',
  `tem_hg_huizhi` varchar(255) DEFAULT NULL COMMENT '海关申报回执',
  `tem_guoj_name` varchar(255) DEFAULT NULL COMMENT '国检名称',
  `tem_guoj_huizhi` varchar(255) DEFAULT NULL COMMENT '国检申报回执',
  `tem_logitics_name` varchar(255) DEFAULT NULL COMMENT '物流名称',
  `tem_logitics_huizhi` varchar(255) DEFAULT NULL COMMENT '物流回执',
  `payment_gj_status` int(3) DEFAULT '0' COMMENT '支付国检状态:0未申报，1成功，2初始化，3取消，4失败，5错误，6申报中',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_order
-- ----------------------------
INSERT INTO `sys_order` VALUES ('1', '10000', '10', '2017-07-20 14:19:20', '0', '邹燕军', '1', '431333199903332455', '18613248859', '上海市浦东新区高行镇', '省', '省code', '市', '市code', '县', '县code', '镇', '镇code', '0', '邹燕军', '431333199903332455', '18613248859', '8.00', '2.00', '8.00', '0.00', '200000', '333333333333', '0', '0', '0', '2017-07-23 21:42:32', '0.00', '0', '0', '0', '家宝国际', '广州电子口岸', '[Code:1800;Desc:逻辑校验通过]', '', '入库成功', '心怡物流', '已成功接收运单号', '0');
INSERT INTO `sys_order` VALUES ('2', '20000', '20', '2017-07-20 14:19:20', '1', '朱琼兰', '1', '431222198801445264', '13086859493', '深圳盐田289号', '省', '省code', '市', '市code', '县', '县code', '镇', '镇code', '0', '朱琼兰', '431222198801445264', '13086859493', '8.00', '2.00', '8.00', '0.00', '200000', '4444444444444', '0', '0', '0', '2017-07-23 21:42:32', '0.00', '0', '0', '0', '家宝国际', '广州电子口岸', '[Code:1800;Desc:逻辑校验通过]', '', '入库成功', '心怡物流', '已成功接收运单号', '0');
commit;

DROP TABLE IF EXISTS `sys_amountUnit`;

CREATE TABLE `sys_amountUnit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `code` varchar(50) DEFAULT NULL COMMENT '代码',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_amountUnit` (`id`, `name`, `code`, `createTime`)
VALUES
  (1,'台1','0012','2017-07-20 16:47:11'),
  (2,'做','002','2017-07-20 16:48:35'),
  (3,'个','003','2017-07-20 16:48:42'),
  (4,'你','004','2017-07-20 16:48:47'),
  (5,'我','005','2017-07-20 16:48:52'),
  (6,'他','006','2017-07-20 16:48:56');

DROP TABLE IF EXISTS `sys_currencyUnit`;

CREATE TABLE `sys_currencyUnit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `code` varchar(50) DEFAULT NULL COMMENT '代码',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_currencyUnit` (`id`, `name`, `code`, `createTime`)
VALUES
  (1,'人民币','RMB','2017-07-20 17:18:24'),
  (2,'美元','MY','2017-07-20 17:18:32'),
  (3,'泰铢','ts','2017-07-20 17:18:39'),
  (5,'23','23','2017-07-20 17:18:45'),
  (6,'3','3','2017-07-20 17:18:48'),
  (7,'4','4','2017-07-20 17:18:51'),
  (8,'5','5','2017-07-20 17:18:53'),
  (9,'6','6','2017-07-20 17:18:57'),
  (12,'33','33','2017-07-20 17:19:07');

DROP TABLE IF EXISTS `sys_origin`;

CREATE TABLE `sys_origin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area` varchar(100) DEFAULT NULL COMMENT '国家/地区',
  `acronym` varchar(50) DEFAULT NULL COMMENT '缩写',
  `code` varchar(50) DEFAULT NULL COMMENT '代码',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_origin` (`id`, `area`, `acronym`, `code`, `createTime`)
VALUES
  (3,'中国','CN','001','2017-07-20 10:51:58'),
  (4,'美国','USA','002','2017-07-20 10:52:44'),
  (9,'2','23','34','2017-07-20 10:53:02'),
  (12,'2','23','34','2017-07-20 10:53:06'),
  (13,'2','23','34','2017-07-20 10:53:08'),
  (14,'2','23','34','2017-07-20 10:53:12'),
  (15,'2','3','1','2017-07-20 10:53:46');

DROP TABLE IF EXISTS `sys_product`;
CREATE TABLE sys_product (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '名称',
  `sku` varchar(200) DEFAULT NULL COMMENT 'sku',
  `originId` bigint(20) DEFAULT NULL COMMENT '产地ID',
  `amountUnitId` bigint(20) DEFAULT NULL COMMENT '单位ID',
  `maozhong` double(9,3) DEFAULT NULL COMMENT '毛重',
  `jingzhong` double(9,3) DEFAULT NULL COMMENT '净重',
  `brandName` varchar(200) DEFAULT NULL COMMENT '品牌名称',
  `barCode` varchar(100) DEFAULT NULL COMMENT '条形码',
  `hgbah` varchar(100) DEFAULT NULL COMMENT '海关备案号',
  `hgbm` varchar(200) DEFAULT NULL COMMENT '海关编码',
  `gjbah` varchar(200) DEFAULT NULL COMMENT '国检备案号',
  `gyscode` varchar(100) DEFAULT NULL COMMENT '供应商编码',
  `gysName` varchar(200) DEFAULT NULL COMMENT '供应商名称',
  `productGg` varchar(200) DEFAULT NULL COMMENT '商品规格',
  `price` double(8,2) DEFAULT NULL COMMENT '价格',
  `yhprice` double(8,2) DEFAULT NULL COMMENT '优惠价格',
  `productDesc` varchar(500) DEFAULT NULL COMMENT '描述',
  `state` int(2) DEFAULT NULL COMMENT '状态:0:未审核；1：已审核',
  `bgstate` int(2) DEFAULT NULL COMMENT '报关状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_product` (`id`, `name`, `sku`, `originId`, `amountUnitId`, `maozhong`, `jingzhong`, `brandName`, `barCode`, `hgbah`, `hgbm`, `gjbah`, `gyscode`, `gysName`, `productGg`, `price`, `yhprice`, `productDesc`, `state`, `bgstate`)
VALUES
  (1,'测试商品','SKU-werwersdfsfsre',3,3,0.500,0.450,'测试品牌','TX-wedqeq12313','hg91231313132','hg0123123asd','gj0123131313213','gys12313a','测试供应商','2134123阿斯达多',50.00,50.00,'11111111111111111',0,0),
  (4,'355841084156064','sku-1231313',4,5,0.800,0.700,'aqew','11312313','123123','111111','1231','222222','13123','11111111',33.00,NULL,'3333339999990000',0,0),
  (5,'1','11',9,2,2.000,22.000,'3','33','4','44','5','55','6','7',66.00,66.00,'77',1,0);

COMMIT;

DROP TABLE IF EXISTS `sys_platform`;

CREATE TABLE `sys_platform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `types` varchar(100) DEFAULT NULL COMMENT '类型',
  `isDefault` tinyint(1) DEFAULT NULL COMMENT '是否默认',
  `descInfo` varchar(500) DEFAULT NULL COMMENT '描述',
  `appName` varchar(100) DEFAULT NULL COMMENT 'app名称',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


SET FOREIGN_KEY_CHECKS=0;  
  
-- ----------------------------  
-- Table structure for region  
-- ----------------------------  
DROP TABLE IF EXISTS `region`;  
CREATE TABLE `region` (  
  `Id` int(11) NOT NULL,  
  `Name` varchar(40) default NULL,  
  `Pid` int(11) default NULL,  
  PRIMARY KEY  (`Id`),  
  KEY `FK_region_REFERENCE_region` (`Pid`),  
  CONSTRAINT `FK_region_REFERENCE_region` FOREIGN KEY (`Pid`) REFERENCES `region` (`Id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;  
  
-- ----------------------------  
-- Records of region  
-- ----------------------------  
INSERT INTO `region` VALUES ('0', '中国', '0');  
INSERT INTO `region` VALUES ('110000', '北京市', '0');  
INSERT INTO `region` VALUES ('110100', '东城区', '110000');  
INSERT INTO `region` VALUES ('110200', '西城区', '110000');  
INSERT INTO `region` VALUES ('110500', '朝阳区', '110000');  
INSERT INTO `region` VALUES ('110600', '丰台区', '110000');  
INSERT INTO `region` VALUES ('110700', '石景山区', '110000');  
INSERT INTO `region` VALUES ('110800', '海淀区', '110000');  
INSERT INTO `region` VALUES ('110900', '门头沟区', '110000');  
INSERT INTO `region` VALUES ('111100', '房山区', '110000');  
INSERT INTO `region` VALUES ('111200', '通州区', '110000');  
INSERT INTO `region` VALUES ('111300', '顺义区', '110000');  
INSERT INTO `region` VALUES ('111400', '昌平区', '110000');  
INSERT INTO `region` VALUES ('111500', '大兴区', '110000');  
INSERT INTO `region` VALUES ('111600', '怀柔区', '110000');  
INSERT INTO `region` VALUES ('111700', '平谷区', '110000');  
INSERT INTO `region` VALUES ('112800', '密云县', '110000');  
INSERT INTO `region` VALUES ('112900', '延庆县', '110000');  
INSERT INTO `region` VALUES ('120000', '天津市', '0');  
INSERT INTO `region` VALUES ('120100', '和平区', '120000');  
INSERT INTO `region` VALUES ('120200', '河东区', '120000');  
INSERT INTO `region` VALUES ('120300', '河西区', '120000');  
INSERT INTO `region` VALUES ('120400', '南开区', '120000');  
INSERT INTO `region` VALUES ('120500', '河北区', '120000');  
INSERT INTO `region` VALUES ('120600', '红桥区', '120000');  
INSERT INTO `region` VALUES ('120900', '滨海新区', '120000');  
INSERT INTO `region` VALUES ('121000', '东丽区', '120000');  
INSERT INTO `region` VALUES ('121100', '西青区', '120000');  
INSERT INTO `region` VALUES ('121200', '津南区', '120000');  
INSERT INTO `region` VALUES ('121300', '北辰区', '120000');  
INSERT INTO `region` VALUES ('121400', '武清区', '120000');  
INSERT INTO `region` VALUES ('121500', '宝坻区', '120000');  
INSERT INTO `region` VALUES ('122100', '宁河县', '120000');  
INSERT INTO `region` VALUES ('122300', '静海县', '120000');  
INSERT INTO `region` VALUES ('122500', '蓟县', '120000');  
INSERT INTO `region` VALUES ('130000', '河北省', '0');  
INSERT INTO `region` VALUES ('130100', '石家庄市', '130000');  
INSERT INTO `region` VALUES ('130101', '市辖区', '130100');  
INSERT INTO `region` VALUES ('130102', '长安区', '130101');  
INSERT INTO `region` VALUES ('130103', '桥东区', '130101');  
INSERT INTO `region` VALUES ('130104', '桥西区', '130101');  
INSERT INTO `region` VALUES ('130105', '新华区', '130101');  
INSERT INTO `region` VALUES ('130107', '井陉矿区', '130101');  
COMMIT;


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `sys_orderdetail`;
CREATE TABLE `sys_orderdetail` (
  `id` bigint(20) NOT NULL,
  `orderNum` bigint(20) DEFAULT NULL COMMENT '订单Id',
  `productId` bigint(20) DEFAULT NULL COMMENT '商品Id',
  `productName` varchar(200) DEFAULT NULL COMMENT '商品name',
  `amount` int(5) DEFAULT NULL COMMENT '数量',
  `prices` double(12,2) DEFAULT NULL COMMENT '价格',
  `totalMoney` double(12,2) DEFAULT NULL COMMENT '总价',
  `sku` varchar(200) DEFAULT NULL COMMENT 'sku',
  `status` int(3) DEFAULT NULL COMMENT '审核状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_orderdetail
-- ----------------------------
INSERT INTO `sys_orderdetail` VALUES ('1', '10000', '4', '355841084156064', '1', '33.00', '33.00', 'sku-1231313', '0');
INSERT INTO `sys_orderdetail` VALUES ('2', '20000', '4', '355841084156064', '1', '33.00', '33.00', 'sku-1231313', '0');
COMMIT;