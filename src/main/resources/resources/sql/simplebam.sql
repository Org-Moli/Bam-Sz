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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_user`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', 'superadmin', 'superadmin', '123456', '0', '2017-07-11 15:48:39');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Sys_origin`
-- ----------------------------
DROP TABLE IF EXISTS `Sys_origin`;
CREATE TABLE `Sys_origin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area` varchar(100) DEFAULT NULL COMMENT '国家/地区',
  `acronym` varchar(50) DEFAULT NULL COMMENT '缩写',
  `code` varchar(50) DEFAULT NULL COMMENT '代码',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `Sys_origin`
-- ----------------------------
BEGIN;
INSERT INTO `Sys_origin` VALUES ('3', '中国', 'CN', '001', '2017-07-20 10:51:58'), ('4', '1', '2', '3', '2017-07-20 10:52:44'), ('5', '2', '23', '34', '2017-07-20 10:52:50'), ('6', '2', '23', '34', '2017-07-20 10:52:57'), ('7', '2', '23', '34', '2017-07-20 10:52:59'), ('8', '2', '23', '34', '2017-07-20 10:53:00'), ('9', '2', '23', '34', '2017-07-20 10:53:02'), ('10', '2', '23', '34', '2017-07-20 10:53:03'), ('11', '2', '23', '34', '2017-07-20 10:53:05'), ('12', '2', '23', '34', '2017-07-20 10:53:06'), ('13', '2', '23', '34', '2017-07-20 10:53:08'), ('14', '2', '23', '34', '2017-07-20 10:53:12'), ('15', '2', '3', '1', '2017-07-20 10:53:46');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;



SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNum` varchar(20) DEFAULT NULL COMMENT '订单编号',
  `order_amount` double(20,0) DEFAULT '0' COMMENT '订单金额',
  `create_date` datetime DEFAULT NULL COMMENT '下单时间',
  `audit_status` int(3) DEFAULT '0' COMMENT '审核状态',
  `trans_user_name` varchar(255) DEFAULT NULL COMMENT '收货人',
  `trans_user_id` int(11) DEFAULT NULL COMMENT '收货人ID',
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `sys_order` VALUES ('1', '10000', '10', '2017-07-20 14:19:20', '0', '小蒋', '1', '431333199903332455', '18620000000', '小蒋地址', '省', '省code', '市', '市code', '县', '县code', '镇', '镇code', '0', '小蒋支付人', 'zf4312222152415456', '18600000000', '8.00', '2.00', '8.00', '0.00', '200000');

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

DROP TABLE IF EXISTS `Sys_origin`;

CREATE TABLE `Sys_origin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area` varchar(100) DEFAULT NULL COMMENT '国家/地区',
  `acronym` varchar(50) DEFAULT NULL COMMENT '缩写',
  `code` varchar(50) DEFAULT NULL COMMENT '代码',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `Sys_origin` (`id`, `area`, `acronym`, `code`, `createTime`)
VALUES
  (3,'中国','CN','001','2017-07-20 10:51:58'),
  (4,'美国','USA','002','2017-07-20 10:52:44'),
  (9,'2','23','34','2017-07-20 10:53:02'),
  (12,'2','23','34','2017-07-20 10:53:06'),
  (13,'2','23','34','2017-07-20 10:53:08'),
  (14,'2','23','34','2017-07-20 10:53:12'),
  (15,'2','3','1','2017-07-20 10:53:46');
COMMIT;