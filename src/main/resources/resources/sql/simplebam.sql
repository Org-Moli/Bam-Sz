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
