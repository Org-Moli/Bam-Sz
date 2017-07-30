/*
 Navicat Premium Data Transfer

 Source Server         : JR_BAM
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : 120.27.208.81
 Source Database       : simplebam

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : utf-8

 Date: 07/30/2017 10:32:39 AM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `log_icecoldmonitor`
-- ----------------------------
DROP TABLE IF EXISTS `log_icecoldmonitor`;
CREATE TABLE `log_icecoldmonitor` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '优先级',
  `category` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '类目',
  `thread` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '进程',
  `time` varchar(30) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '时间',
  `location` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '位置',
  `note` text COLLATE utf8_bin COMMENT '日志信息',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `region`
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `Id` int(11) NOT NULL,
  `Name` varchar(40) DEFAULT NULL,
  `Pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_region_REFERENCE_region` (`Pid`),
  CONSTRAINT `FK_region_REFERENCE_region` FOREIGN KEY (`Pid`) REFERENCES `region` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `region`
-- ----------------------------
BEGIN;
INSERT INTO `region` VALUES ('0', '中国', '0'), ('110000', '北京市', '0'), ('110100', '东城区', '110000'), ('110200', '西城区', '110000'), ('110500', '朝阳区', '110000'), ('110600', '丰台区', '110000'), ('110700', '石景山区', '110000'), ('110800', '海淀区', '110000'), ('110900', '门头沟区', '110000'), ('111100', '房山区', '110000'), ('111200', '通州区', '110000'), ('111300', '顺义区', '110000'), ('111400', '昌平区', '110000'), ('111500', '大兴区', '110000'), ('111600', '怀柔区', '110000'), ('111700', '平谷区', '110000'), ('112800', '密云县', '110000'), ('112900', '延庆县', '110000'), ('120000', '天津市', '0'), ('120100', '和平区', '120000'), ('120200', '河东区', '120000'), ('120300', '河西区', '120000'), ('120400', '南开区', '120000'), ('120500', '河北区', '120000'), ('120600', '红桥区', '120000'), ('120900', '滨海新区', '120000'), ('121000', '东丽区', '120000'), ('121100', '西青区', '120000'), ('121200', '津南区', '120000'), ('121300', '北辰区', '120000'), ('121400', '武清区', '120000'), ('121500', '宝坻区', '120000'), ('122100', '宁河县', '120000'), ('122300', '静海县', '120000'), ('122500', '蓟县', '120000'), ('130000', '河北省', '0'), ('130100', '石家庄市', '130000'), ('130101', '市辖区', '130100'), ('130102', '长安区', '130101'), ('130103', '桥东区', '130101'), ('130104', '桥西区', '130101'), ('130105', '新华区', '130101'), ('130107', '井陉矿区', '130101');
COMMIT;

-- ----------------------------
--  Table structure for `sys_about`
-- ----------------------------
DROP TABLE IF EXISTS `sys_about`;
CREATE TABLE `sys_about` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `sys_amountUnit`
-- ----------------------------
DROP TABLE IF EXISTS `sys_amountUnit`;
CREATE TABLE `sys_amountUnit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `code` varchar(50) DEFAULT NULL COMMENT '代码',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_amountUnit`
-- ----------------------------
BEGIN;
INSERT INTO `sys_amountUnit` VALUES ('8', '吨', 'dun', '2017-07-26 11:19:50'), ('9', '法规的法规', '法规的法规', '2017-07-26 14:10:33'), ('10', '米', '111', '2017-07-26 14:41:46');
COMMIT;

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
--  Table structure for `sys_contacts`
-- ----------------------------
DROP TABLE IF EXISTS `sys_contacts`;
CREATE TABLE `sys_contacts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `title` varchar(100) DEFAULT NULL COMMENT '主题',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `sys_currencyUnit`
-- ----------------------------
DROP TABLE IF EXISTS `sys_currencyUnit`;
CREATE TABLE `sys_currencyUnit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `code` varchar(50) DEFAULT NULL COMMENT '代码',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_currencyUnit`
-- ----------------------------
BEGIN;
INSERT INTO `sys_currencyUnit` VALUES ('1', '人民币', 'RMB', '2017-07-20 17:18:24'), ('3', '泰铢', 'ts', '2017-07-20 17:18:39'), ('13', '美元', 'Dollar', '2017-07-25 21:28:13'), ('14', '日元', 'RY', '2017-07-26 11:20:01');
COMMIT;

-- ----------------------------
--  Table structure for `sys_db`
-- ----------------------------
DROP TABLE IF EXISTS `sys_db`;
CREATE TABLE `sys_db` (
  `id` bigint(20) NOT NULL,
  `dbLink` varchar(200) DEFAULT NULL COMMENT '数据库地址',
  `dbName` varchar(100) DEFAULT NULL COMMENT '数据库名称',
  `dbUserName` varchar(100) DEFAULT NULL COMMENT '用户名',
  `dbPassword` varchar(100) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `sys_kcManage`
-- ----------------------------
DROP TABLE IF EXISTS `sys_kcManage`;
CREATE TABLE `sys_kcManage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productId` varchar(50) DEFAULT NULL COMMENT '商品编码',
  `ckName` varchar(100) DEFAULT NULL,
  `rkTotal` int(10) DEFAULT '0' COMMENT '总入库数量',
  `ckTotal` int(10) DEFAULT '0' COMMENT '总出库数量',
  `syNums` int(10) DEFAULT '0' COMMENT '剩余数量',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `sys_kcManage`
-- ----------------------------
BEGIN;
INSERT INTO `sys_kcManage` VALUES ('6', '4', '仓库1', '12', '10', '2', '2017-07-30 10:11:58'), ('7', '10', '仓库1', '22', '0', '22', '2017-07-30 10:16:18');
COMMIT;

-- ----------------------------
--  Table structure for `sys_news`
-- ----------------------------
DROP TABLE IF EXISTS `sys_news`;
CREATE TABLE `sys_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `picUrl` varchar(200) DEFAULT NULL COMMENT '封面图片',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `content` varchar(2000) DEFAULT NULL COMMENT '内容',
  `source` varchar(50) DEFAULT NULL COMMENT '来源',
  `newsDate` datetime DEFAULT NULL COMMENT '新闻日期',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `sys_order`
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNum` varchar(100) DEFAULT NULL COMMENT '订单编号',
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
--  Records of `sys_order`
-- ----------------------------
BEGIN;
INSERT INTO `sys_order` VALUES ('1', 'NC1161011112543800001', '10', '2017-07-20 14:19:20', '1', '杨晓', '1', '450521197810010046', '13709745077', '青海省-西宁市-城西区-南气象巷2号精益广告公司', '省', '省code', '市', '市code', '县', '县code', '镇', '镇code', '0', '杨晓', '450521197810010046', '13709745077', '8.00', '2.00', '8.00', '0.00', '200000', '1120930179996', '0', '0', '0', '2017-07-23 21:42:32', '0.00', '0', '0', '0', '家宝国际', '广州电子口岸', '[Code:1800;Desc:逻辑校验通过]', '', '入库成功', '心怡物流', '已成功接收运单号', '0'), ('2', 'TZ20170511077723972', '20', '2017-07-20 14:19:20', '0', '朱琼兰', '1', '431023198208021540', '18670273373', '湖南省-郴州市-北湖区-国庆北路11号', '省', '省code', '市', '市code', '县', '县code', '镇', '镇code', '0', '爱妃支付人', '431023198208021540', '18600000000', '8.00', '2.00', '8.00', '0.00', '200000', '4444444444444', '0', '0', '0', '2017-07-23 21:42:32', '0.00', '0', '0', '0', '家宝国际', '广州电子口岸', '[Code:1800;Desc:逻辑校验通过]', '', '入库成功', '心怡物流', '已成功接收运单号', '0');
COMMIT;

-- ----------------------------
--  Table structure for `sys_orderDetail`
-- ----------------------------
DROP TABLE IF EXISTS `sys_orderDetail`;
CREATE TABLE `sys_orderDetail` (
  `id` bigint(20) NOT NULL,
  `orderId` bigint(20) DEFAULT NULL COMMENT '订单Id',
  `productId` bigint(20) DEFAULT NULL COMMENT '商品Id',
  `amount` int(5) DEFAULT NULL COMMENT '数量',
  `prices` double(12,2) DEFAULT NULL COMMENT '价格',
  `totalMoney` double(12,2) DEFAULT NULL COMMENT '总价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `sys_orderdetail`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `sys_orderdetail`
-- ----------------------------
BEGIN;
INSERT INTO `sys_orderdetail` VALUES ('1', '10000', '4', '355841084156064', '1', '33.00', '33.00', 'sku-1231313', '0'), ('2', '20000', '4', '355841084156064', '1', '33.00', '33.00', 'sku-1231313', '0');
COMMIT;

-- ----------------------------
--  Table structure for `sys_origin`
-- ----------------------------
DROP TABLE IF EXISTS `sys_origin`;
CREATE TABLE `sys_origin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area` varchar(100) DEFAULT NULL COMMENT '国家/地区',
  `acronym` varchar(50) DEFAULT NULL COMMENT '缩写',
  `code` varchar(50) DEFAULT NULL COMMENT '代码',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_origin`
-- ----------------------------
BEGIN;
INSERT INTO `sys_origin` VALUES ('3', '中国', 'CN', '001', '2017-07-20 10:51:58'), ('4', '美国', 'USA', '002', '2017-07-20 10:52:44'), ('17', '泰国', 'TG', 'eqw', '2017-07-26 11:14:32');
COMMIT;

-- ----------------------------
--  Table structure for `sys_picture`
-- ----------------------------
DROP TABLE IF EXISTS `sys_picture`;
CREATE TABLE `sys_picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `srcUrl` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `name` varchar(200) DEFAULT NULL COMMENT '图片名称',
  `clickUrl` varchar(200) DEFAULT NULL COMMENT '图片导向地址',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `sys_platform`
-- ----------------------------
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

-- ----------------------------
--  Table structure for `sys_product`
-- ----------------------------
DROP TABLE IF EXISTS `sys_product`;
CREATE TABLE `sys_product` (
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
  `productNo` varchar(50) DEFAULT NULL,
  `rkTotal` int(10) DEFAULT NULL,
  `ckTotal` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_product`
-- ----------------------------
BEGIN;
INSERT INTO `sys_product` VALUES ('4', '矿泉水', 'sku-1231313', '4', '8', '0.800', '0.700', 'aqew', '11312313', '123123', '111111', '1231', '222222', '13123', '11111111', '33.00', null, '3333339999990000', null, null, 'KQS001', null, null), ('10', '人人', 'EF_34134254', '4', '8', '12.000', '12.000', '非官方', '46434214123', '2123123', '675t3241', '4534532534', '123', '我', '21', '10.00', '10.00', '', '1', '0', '312313', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_productCk`
-- ----------------------------
DROP TABLE IF EXISTS `sys_productCk`;
CREATE TABLE `sys_productCk` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productNo` varchar(50) DEFAULT NULL COMMENT '商品编码',
  `productName` varchar(100) DEFAULT NULL COMMENT '货物名称',
  `sku` varchar(100) DEFAULT NULL,
  `ckName` varchar(100) DEFAULT NULL COMMENT '仓库',
  `khName` varchar(100) DEFAULT NULL COMMENT '客户名称',
  `khCkNo` varchar(100) DEFAULT NULL COMMENT '客户出库订单号',
  `ckDate` date DEFAULT NULL COMMENT '出库时间',
  `ckOperator` varchar(100) DEFAULT NULL COMMENT '出库操作员',
  `ckNumbers` int(10) DEFAULT NULL COMMENT '出库数量',
  `createTime` datetime DEFAULT NULL,
  `productId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `sys_productCk`
-- ----------------------------
BEGIN;
INSERT INTO `sys_productCk` VALUES ('6', 'KQS001', '矿泉水', 'sku-1231313', '仓库1', '客户1', '12312312', '2017-07-31', '李', '10', '2017-07-30 10:14:07', '4');
COMMIT;

-- ----------------------------
--  Table structure for `sys_productRk`
-- ----------------------------
DROP TABLE IF EXISTS `sys_productRk`;
CREATE TABLE `sys_productRk` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productNo` varchar(50) DEFAULT NULL COMMENT '商品编码',
  `productName` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `sku` varchar(100) DEFAULT NULL,
  `ckName` varchar(100) DEFAULT NULL COMMENT '仓库名称',
  `khName` varchar(100) DEFAULT NULL COMMENT '客户名称',
  `khRkNo` varchar(100) DEFAULT NULL COMMENT '客户入库单号',
  `rkDate` date DEFAULT NULL COMMENT '入库时间',
  `rkOperator` varchar(100) DEFAULT NULL COMMENT '入库操作员',
  `rkNumbers` int(10) DEFAULT NULL COMMENT '入库数量',
  `createTime` datetime DEFAULT NULL,
  `productId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `sys_productRk`
-- ----------------------------
BEGIN;
INSERT INTO `sys_productRk` VALUES ('12', 'KQS001', '矿泉水', 'sku-1231313', '仓库1', '客户1', '2311313', '2017-07-26', '李', '12', '2017-07-30 10:11:58', '4'), ('13', '312313', '人人', 'EF_34134254', '仓库1', '客户1', '98867453', '2017-07-30', 'wang', '22', '2017-07-30 10:16:18', '10');
COMMIT;

-- ----------------------------
--  Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `sys_role`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('4', '操作员', '1');
COMMIT;

-- ----------------------------
--  Table structure for `sys_services`
-- ----------------------------
DROP TABLE IF EXISTS `sys_services`;
CREATE TABLE `sys_services` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `desc` varchar(500) DEFAULT NULL COMMENT '描述',
  `icon` varchar(100) DEFAULT NULL COMMENT '标记',
  `url` varchar(200) DEFAULT NULL COMMENT '链接(预留)',
  `num` int(2) DEFAULT NULL COMMENT '排序(预留)',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '是否启用',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `sys_services`
-- ----------------------------
BEGIN;
INSERT INTO `sys_services` VALUES ('1', 'Performance Increase', 'Enabling companies to grow revenue, improve margins and reposition quickly.', 'service-icon-performance', null, '1', null, '2017-07-14 16:26:43'), ('2', 'Customer Marketing', 'In-depth customer insights combined with economic and operational fundamentals.', 'service-icon-customer', null, '2', null, '2017-07-14 16:27:10'), ('3', 'Innovative Technology', 'Realizing the full potential of IT resources, investments and assets.', 'service-icon-it', null, '3', null, '2017-07-14 16:27:37'), ('4', 'Full Transformation', 'A cross-functional effort to alter the financial, operational and strategic trajectory of a business.', 'service-icon-transformation', null, '4', null, '2017-07-14 16:28:10'), ('5', 'Strategy', 'Tailored solutions that deliver results and achieve sustained growth', 'service-item-heading service-icon service-icon-strategy', null, '5', null, '2017-07-14 16:28:45'), ('6', 'Private Equity', 'Advising investors across the entire investment life cycle.', 'service-icon-digital', null, '6', null, '2017-07-14 16:29:14'), ('7', 'Digital', 'Deliver on core strategy, delight customers and operate smarter and faster.', 'service-icon-digital', null, '7', null, '2017-07-14 16:29:33'), ('8', 'Results Delivery', 'Predicting, measuring and managing risk associated with change management.', 'service-icon-delivery', null, '8', null, '2017-07-14 16:29:37');
COMMIT;

-- ----------------------------
--  Table structure for `sys_teams`
-- ----------------------------
DROP TABLE IF EXISTS `sys_teams`;
CREATE TABLE `sys_teams` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '姓名',
  `enName` varchar(200) DEFAULT NULL COMMENT '英文名称',
  `title` varchar(200) DEFAULT NULL COMMENT '职位',
  `picUrl` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_user`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', 'superadmin', 'superadmin', 'e10adc3949ba59abbe56e057f20f883e', '0', '2017-07-11 15:48:39', null, null, null), ('2', 'admin', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '1', '2017-07-25 21:43:28', null, null, '1'), ('3', '123', '123', '202cb962ac59075b964b07152d234b70', '1', '2017-07-26 11:17:28', null, null, '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
