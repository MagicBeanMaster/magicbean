/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.110_3306
Source Server Version : 50617
Source Host           : 192.168.0.110:3306
Source Database       : info

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-07-06 17:24:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_configuration`
-- ----------------------------
DROP TABLE IF EXISTS `t_configuration`;
CREATE TABLE `t_configuration` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置表id',
  `description` varchar(32) NOT NULL COMMENT '描述',
  `type` int(11) NOT NULL COMMENT '类型 - 枚举类',
  `sequence` int(11) DEFAULT '0' COMMENT '排序',
  `fatherid` int(11) DEFAULT '0' COMMENT '父配置id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `createpeople` int(11) DEFAULT '0' COMMENT '创建人',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `updatepeople` int(11) DEFAULT '0' COMMENT '更新人',
  `companyid` int(11) DEFAULT '0' COMMENT '公司id',
  `remark1` varchar(32) DEFAULT NULL COMMENT '保留字段1',
  `remark2` varchar(32) DEFAULT NULL COMMENT '保留字段2',
  `remark3` varchar(32) DEFAULT NULL COMMENT '保留字段3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_configuration
-- ----------------------------

INSERT INTO `t_configuration` VALUES ('45', '男', '6', '1', '0', '2016-08-05 17:41:20', '4', '2016-08-05 17:41:20', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('46', '女', '6', '2', '0', '2016-08-05 17:41:56', '4', '2016-08-05 17:41:56', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('47', '澳大利亚', '5', '1', '0', '2016-08-08 14:10:04', '4', '2016-08-08 14:10:04', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('48', '悉尼', '4', '1', '47', '2016-08-08 14:10:26', '4', '2016-08-08 14:10:26', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('49', '墨尔本', '4', '2', '47', '2016-08-08 14:10:36', '4', '2016-08-08 14:10:36', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('50', '布里斯班', '4', '3', '47', '2016-08-08 14:10:52', '4', '2016-08-08 14:10:52', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('51', '不限', '7', '1', '0', '2016-08-08 14:11:07', '4', '2016-08-08 14:11:07', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('52', '独栋别墅', '7', '2', '0', '2016-08-08 14:11:19', '4', '2016-08-08 14:11:19', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('53', '联排别墅', '7', '3', '0', '2016-08-08 14:11:34', '4', '2016-08-08 14:11:34', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('54', '精品公寓', '7', '4', '0', '2016-08-08 14:11:44', '4', '2016-08-08 14:11:44', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('55', '不限', '2', '1', '0', '2016-08-08 14:13:45', '4', '2016-08-08 14:13:45', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('56', '20万以内', '2', '2', '0', '2016-08-08 14:13:56', '4', '2016-08-08 14:13:56', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('57', '20万-25万', '2', '3', '0', '2016-08-08 14:14:11', '4', '2016-08-08 14:14:11', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('58', '25万-30万', '2', '4', '0', '2016-08-08 14:14:31', '4', '2016-08-08 14:14:31', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('59', '30万以上', '2', '5', '0', '2016-08-08 14:14:42', '4', '2016-08-08 14:14:42', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('60', '不限', '3', '1', '0', '2016-08-08 14:15:05', '4', '2016-08-08 14:15:05', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('61', '自住房', '3', '2', '0', '2016-08-08 14:15:16', '4', '2016-08-08 14:15:24', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('62', '学区房', '3', '4', '0', '2016-08-08 14:15:35', '4', '2016-08-08 14:15:54', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('63', '投资房', '3', '3', '0', '2016-08-08 14:15:36', '4', '2016-08-08 14:15:36', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('64', '海景房', '3', '5', '0', '2016-08-08 14:16:13', '4', '2016-08-08 14:16:13', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('65', 'IT及互联网', '1', '1', '0', '2016-08-08 14:16:40', '4', '2016-08-08 14:16:40', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('66', '房地产行业', '1', '2', '0', '2016-08-08 14:16:55', '4', '2016-08-08 14:16:55', '4', '0', null, null, null);
INSERT INTO `t_configuration` VALUES ('67', '金融行业', '1', '3', '0', '2016-08-08 14:17:06', '4', '2016-08-08 14:17:06', '4', '0', null, null, null);

-- ----------------------------
-- Table structure for `t_customer`
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户表id',
  `name` varchar(32) NOT NULL COMMENT '客户姓名',
  `sex` int(11) DEFAULT '0' COMMENT '性别 - 字典',
  `age` date DEFAULT NULL COMMENT '出生年月',
  `phone` varchar(64) NOT NULL COMMENT '手机号码',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `idcard` varchar(64) DEFAULT NULL COMMENT '身份证号',
  `industry` int(11) DEFAULT '0' COMMENT '行业',
  `province` int(11) DEFAULT '0' COMMENT '省',
  `city` int(11) DEFAULT '0' COMMENT '市',
  `datailaddress` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `message` varchar(255) DEFAULT NULL  COMMENT '留言',
  `origin` int(1) NOT NULL DEFAULT '0' COMMENT '客户来源：0系统 1官网',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '验证状态：0未验证 1验证',
  `state` int(1) NOT NULL DEFAULT '1' COMMENT '状态：0删除 1正常',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `level` int(11) DEFAULT '0' COMMENT '客户质量等级',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `createpeople` int(11) DEFAULT '0' COMMENT '创建人',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `updatepeople` int(11) DEFAULT '0' COMMENT '更新人',
  `companyid` int(11) DEFAULT '0' COMMENT '公司id',
  `remark1` varchar(32) DEFAULT NULL COMMENT '保留字段1',
  `remark2` varchar(32) DEFAULT NULL COMMENT '保留字段2',
  `remark3` varchar(32) DEFAULT NULL COMMENT '保留字段3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------

-- ----------------------------
-- Table structure for `t_demand`
-- ----------------------------
DROP TABLE IF EXISTS `t_demand`;
CREATE TABLE `t_demand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '需求表id',
  `country` int(11) DEFAULT '0' COMMENT '国家 - 字典',
  `city` int(11) DEFAULT '0' COMMENT '城市 - 字典',
  `premises` int(11) DEFAULT '0' COMMENT '意向楼盘 - 字典',
  `budget` int(11) DEFAULT '0' COMMENT '预算资金 - 字典',
  `purpose` int(11) DEFAULT '0' COMMENT '购房用途 - 字典',
  `wuye` int(11) DEFAULT '0' COMMENT '意向物业',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：1正常，0删除',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `customerid` int(11) DEFAULT '0' COMMENT '客户表id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `createpeople` int(11) DEFAULT '0' COMMENT '创建人',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `updatepeople` int(11) DEFAULT '0' COMMENT '更新人',
  `companyid` int(11) DEFAULT '0' COMMENT '公司id',
  `remark1` varchar(32) DEFAULT NULL COMMENT '保留字段1',
  `remark2` varchar(32) DEFAULT NULL COMMENT '保留字段2',
  `remark3` varchar(32) DEFAULT NULL COMMENT '保留字段3',
  PRIMARY KEY (`id`),
  KEY `客户id` (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_demand
-- ----------------------------

-- ----------------------------
-- Table structure for `t_employee`
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empcode` varchar(32) NOT NULL COMMENT '员工编号',
  `name` varchar(32) NOT NULL COMMENT '员工姓名',
  `age` date DEFAULT NULL COMMENT '出生日期',
  `sex` int(11) NOT NULL DEFAULT '0' COMMENT '性别',
  `phone` varchar(18) NOT NULL COMMENT '联系电话',
  `email` varchar(32) DEFAULT NULL COMMENT '电子邮箱',
  `job` varchar(32) NOT NULL DEFAULT '0' COMMENT '岗位',
  `status` int(1) DEFAULT '1' COMMENT '状态：0离职 1在职',
  `level` int(11) DEFAULT '0' COMMENT '员工等级',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `createpeople` int(11) DEFAULT '0' COMMENT '创建人',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `updatepeople` int(11) DEFAULT '0' COMMENT '更新人',
  `companyid` int(11) DEFAULT '0' COMMENT '公司id',
  `remark1` varchar(32) DEFAULT NULL COMMENT '保留字段1',
  `remark2` varchar(32) DEFAULT NULL COMMENT '保留字段2',
  `remark3` varchar(32) DEFAULT NULL COMMENT '保留字段3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employee
-- ----------------------------

-- ----------------------------
-- Table structure for `t_plat_account`
-- ----------------------------
DROP TABLE IF EXISTS `t_plat_account`;
CREATE TABLE `t_plat_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL COMMENT '账号',
  `pwd` varchar(36) NOT NULL COMMENT '密码',
  `employeeid` int(11) DEFAULT '0' COMMENT '员工id',
  `name` varchar(20) DEFAULT NULL,
  `type` int(11) NOT NULL DEFAULT '2' COMMENT '账号类型：1：业务模块，2,系统模块',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：1正常，0删除',
  `createtime` datetime NOT NULL,
  `companyid` int(11) DEFAULT '0' COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_plat_account
-- ----------------------------
-- 超级管理员  帐号:root  密码:jindingkf
INSERT INTO `t_plat_account` VALUES ('1', 'root', '92a33d7fef0934455457f8cff0d90bc6', '0', 'root', '2', '1', '2016-07-06 14:00:55', '0');

-- ----------------------------
-- Table structure for `t_plat_accountroles`
-- ----------------------------
DROP TABLE IF EXISTS `t_plat_accountroles`;
CREATE TABLE `t_plat_accountroles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountid` int(11) NOT NULL DEFAULT '0' COMMENT '帐号id',
  `roleid` int(11) NOT NULL DEFAULT '0' COMMENT '角色id',
  `companyid` int(11) DEFAULT '0' COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_plat_accountroles
-- ----------------------------

-- ----------------------------
-- Table structure for `t_plat_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_plat_resource`;
CREATE TABLE `t_plat_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentid` int(11) NOT NULL DEFAULT '0' COMMENT '父菜单',
  `menuname` varchar(30) NOT NULL COMMENT '菜单名',
  `path` varchar(200) DEFAULT NULL COMMENT '访问的路径',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '类型：0一级,5按钮',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态：0正常，-1删除',
  `ord` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `companyid` int(11) DEFAULT '0' COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_plat_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `t_plat_resourceroles`
-- ----------------------------
DROP TABLE IF EXISTS `t_plat_resourceroles`;
CREATE TABLE `t_plat_resourceroles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) NOT NULL DEFAULT '0' COMMENT '角色id',
  `resourceid` int(11) NOT NULL DEFAULT '0' COMMENT '资源id',
  `companyid` int(11) DEFAULT '0' COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_plat_resourceroles
-- ----------------------------

-- ----------------------------
-- Table structure for `t_plat_roles`
-- ----------------------------
DROP TABLE IF EXISTS `t_plat_roles`;
CREATE TABLE `t_plat_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolesname` varchar(20) NOT NULL COMMENT '角色名',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态：0正常，1删除',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `companyid` int(11) DEFAULT '0' COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_plat_roles
-- ----------------------------

-- ----------------------------
-- Table structure for `t_premises`
-- ----------------------------
DROP TABLE IF EXISTS `t_premises`;
CREATE TABLE `t_premises` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '楼盘名称',
  `country` int(11) NOT NULL DEFAULT '0' COMMENT '国家',
  `city` int(11) NOT NULL DEFAULT '0' COMMENT '城市',
  `datailaddress` varchar(255) NOT NULL COMMENT '详细地址',
  `summary` varchar(255) NOT NULL COMMENT '楼盘简介',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(11) DEFAULT '1' COMMENT '状态：1正常，0删除',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `createpeople` int(11) DEFAULT '0' COMMENT '创建人',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `updatepeople` int(11) DEFAULT '0' COMMENT '更新人',
  `companyid` int(11) DEFAULT '0' COMMENT '公司id',
  `remark1` varchar(32) DEFAULT NULL COMMENT '保留字段1',
  `remark2` varchar(32) DEFAULT NULL COMMENT '保留字段2',
  `remark3` varchar(32) DEFAULT NULL COMMENT '保留字段3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_premises
-- ----------------------------

-- ----------------------------
-- Table structure for `t_premises_image`
-- ----------------------------
DROP TABLE IF EXISTS `t_premises_image`;
CREATE TABLE `t_premises_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filepath` varchar(255) NOT NULL COMMENT '图片路径',
  `premisesid` int(11) DEFAULT '0' COMMENT '楼盘id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `createpeople` int(11) DEFAULT '0' COMMENT '创建人',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `updatepeople` int(11) DEFAULT '0' COMMENT '更新人',
  `companyid` int(11) DEFAULT '0' COMMENT '公司id',
  `remark1` varchar(32) DEFAULT NULL COMMENT '保留字段1',
  `remark2` varchar(32) DEFAULT NULL COMMENT '保留字段2',
  `remark3` varchar(32) DEFAULT NULL COMMENT '保留字段3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_premises_image
-- ----------------------------

-- ----------------------------
-- Table structure for `t_roomtype`
-- ----------------------------
DROP TABLE IF EXISTS `t_roomtype`;
CREATE TABLE `t_roomtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `premisesid` int(11) DEFAULT '0' COMMENT '楼盘id',
  `room` int(11) DEFAULT '0' COMMENT '室',
  `halls` int(11) DEFAULT '0' COMMENT '厅',
  `wei` int(11) DEFAULT '0' COMMENT '卫',
  `filepath` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `createpeople` int(11) DEFAULT '0' COMMENT '创建人',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `updatepeople` int(11) DEFAULT '0' COMMENT '更新人',
  `companyid` int(11) DEFAULT '0' COMMENT '公司id',
  `remark1` varchar(32) DEFAULT NULL COMMENT '保留字段1',
  `remark2` varchar(32) DEFAULT NULL COMMENT '保留字段2',
  `remark3` varchar(32) DEFAULT NULL COMMENT '保留字段3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_roomtype
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_login_logs`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_login_logs`;
CREATE TABLE `t_sys_login_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(20) NOT NULL COMMENT '账号',
  `ip` varchar(20) NOT NULL COMMENT 'ip地址',
  `sessId` varchar(36) NOT NULL COMMENT '登录SessionId',
  `intime` datetime NOT NULL COMMENT '登录时间',
  `outtime` datetime DEFAULT NULL COMMENT '退出时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_login_logs
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_operter_logs`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_operter_logs`;
CREATE TABLE `t_sys_operter_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(20) NOT NULL COMMENT '操作账号',
  `methodname` varchar(50) NOT NULL COMMENT '方法名称',
  `remark` varchar(200) NOT NULL COMMENT '备注',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `ip` varchar(20) DEFAULT NULL,
  `mac` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_operter_logs
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_sql`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_sql`;
CREATE TABLE `t_sys_sql` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `runsql` varchar(2000) DEFAULT NULL,
  `parameters` varchar(500) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `sqlruntime` int(11) DEFAULT NULL,
  `client` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_sql
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_version`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_version`;
CREATE TABLE `t_sys_version` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(5000) DEFAULT NULL,
  `likecontent` varchar(3000) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_version
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_error`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_error`;
CREATE TABLE `t_sys_error` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `errormess` text NOT NULL,
  `ip` varchar(20) NOT NULL COMMENT '系统ip',
  `createtime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_error
-- ----------------------------


-- ----------------------------
-- Table structure for `t_immigrant`
-- ----------------------------
DROP TABLE IF EXISTS `t_immigrant`;
CREATE TABLE `t_immigrant` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `score` varchar(11) DEFAULT '0' COMMENT '客户得分',
  `age` varchar(100) DEFAULT NULL COMMENT '您的年龄',
  `english` varchar(100) DEFAULT NULL COMMENT '英语能力',
  `education` varchar(100) DEFAULT NULL COMMENT '主申学历',
  `assets` varchar(100) DEFAULT NULL COMMENT '家庭资产',
  `business` varchar(100) DEFAULT NULL COMMENT '生意背景',
  `investment` varchar(100) DEFAULT NULL COMMENT '投资背景',
  `turnover` varchar(100) DEFAULT NULL COMMENT '公司营业额',
  `other` varchar(1000) DEFAULT NULL COMMENT '其他分数',
  `customerid` int(11) DEFAULT '0' COMMENT '客户表id',
  `status` int(11) DEFAULT '1' COMMENT '状态：1正常，0删除',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `createpeople` int(11) DEFAULT '0' COMMENT '创建人',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `updatepeople` int(11) DEFAULT '0' COMMENT '更新人',
  `companyid` int(11) DEFAULT '0' COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_immigrant
-- ----------------------------


-- ----------------------------
-- Table structure for `t_exhibition`
-- ----------------------------
DROP TABLE IF EXISTS `t_exhibition`;
CREATE TABLE `t_exhibition` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '展会表id',
  `name` varchar(32) DEFAULT NULL COMMENT '展会名称',
  `customerid` int(11) DEFAULT NULL COMMENT '客户id',
  `message` varchar(100) DEFAULT NULL COMMENT '客户留言',
  `companyid` int(11) DEFAULT NULL COMMENT '公司id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `createpeople` int(11) DEFAULT NULL COMMENT '创建人',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `updatepeople` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_exhibition
-- ----------------------------

