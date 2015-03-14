/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50532
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001

Date: 2015-03-11 18:19:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bbs`
-- ----------------------------
DROP TABLE IF EXISTS `bbs`;
CREATE TABLE `bbs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `content` text,
  `date` varchar(20) DEFAULT NULL,
  `access` int(11) DEFAULT NULL COMMENT '访问人数',
  `reply` int(11) DEFAULT NULL COMMENT '回复人数',
  `uid` int(11) DEFAULT NULL COMMENT '用户编号',
  `uname` varchar(20) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs
-- ----------------------------
INSERT INTO `bbs` VALUES ('1', 'helloworld', 'helloworld', '2015.03.10', '19', '4', '1', null, null);
INSERT INTO `bbs` VALUES ('2', 'testpost1', 'testpostcontent1', '2015.03.10', '0', '0', '1', null, null);

-- ----------------------------
-- Table structure for `group_info`
-- ----------------------------
DROP TABLE IF EXISTS `group_info`;
CREATE TABLE `group_info` (
  `id` int(11) NOT NULL,
  `sight` varchar(15) DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `haspeople` int(11) DEFAULT NULL,
  `maxpeople` int(11) DEFAULT NULL,
  `info` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_info
-- ----------------------------

-- ----------------------------
-- Table structure for `group_reserve`
-- ----------------------------
DROP TABLE IF EXISTS `group_reserve`;
CREATE TABLE `group_reserve` (
  `sight` varchar(15) DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `reservedpeople` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_reserve
-- ----------------------------

-- ----------------------------
-- Table structure for `hotel`
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `id` int(11) NOT NULL,
  `name` varchar(15) DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL,
  `room` char(5) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `reserved` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel
-- ----------------------------

-- ----------------------------
-- Table structure for `hotel_info`
-- ----------------------------
DROP TABLE IF EXISTS `hotel_info`;
CREATE TABLE `hotel_info` (
  `id` int(11) NOT NULL,
  `city` varchar(5) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `star` varchar(5) DEFAULT NULL,
  `info` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel_info
-- ----------------------------
INSERT INTO `hotel_info` VALUES ('1', '杭州', '如家快捷酒店', '3', '如家快捷酒店，致力于打造舒适安静的休息睡眠环境');

-- ----------------------------
-- Table structure for `hotel_reserve`
-- ----------------------------
DROP TABLE IF EXISTS `hotel_reserve`;
CREATE TABLE `hotel_reserve` (
  `name` varchar(15) DEFAULT NULL,
  `room` char(5) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `month` int(4) DEFAULT NULL,
  `day` int(4) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel_reserve
-- ----------------------------

-- ----------------------------
-- Table structure for `plane_info`
-- ----------------------------
DROP TABLE IF EXISTS `plane_info`;
CREATE TABLE `plane_info` (
  `id` int(11) NOT NULL,
  `number` char(10) DEFAULT NULL,
  `fromcity` varchar(10) DEFAULT NULL,
  `destiation` varchar(20) DEFAULT NULL,
  `fly_time` datetime DEFAULT NULL,
  `arrive_time` datetime DEFAULT NULL,
  `haspeople` int(11) DEFAULT NULL,
  `maxpeople` int(11) DEFAULT NULL,
  `fee` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plane_info
-- ----------------------------

-- ----------------------------
-- Table structure for `plane_reserve`
-- ----------------------------
DROP TABLE IF EXISTS `plane_reserve`;
CREATE TABLE `plane_reserve` (
  `id` int(11) DEFAULT NULL,
  `number` char(15) DEFAULT NULL,
  `fromcity` varchar(15) DEFAULT NULL,
  `destination` varchar(15) DEFAULT NULL,
  `fly_time` date DEFAULT NULL,
  `arrive_time` date DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `fly_type` varchar(4) DEFAULT NULL,
  `reservedpeople` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plane_reserve
-- ----------------------------

-- ----------------------------
-- Table structure for `reply`
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postId` int(11) NOT NULL COMMENT '帖子编号',
  `uid` int(11) DEFAULT NULL COMMENT '用户编号',
  `content` text,
  `date` date DEFAULT NULL,
  `rid` int(11) DEFAULT NULL COMMENT '楼层id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '1', '1', 'fasfddfdff', '2015-03-10', '1');
INSERT INTO `reply` VALUES ('2', '1', '1', 'hhahaha', '2015-03-11', '2');
INSERT INTO `reply` VALUES ('3', '1', '1', '54345634', '2015-03-11', '3');
INSERT INTO `reply` VALUES ('4', '1', '1', '9768677', '2015-03-11', '4');

-- ----------------------------
-- Table structure for `reserve_info`
-- ----------------------------
DROP TABLE IF EXISTS `reserve_info`;
CREATE TABLE `reserve_info` (
  `username` varchar(15) NOT NULL,
  `tname` varchar(15) DEFAULT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `plane_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reserve_info
-- ----------------------------

-- ----------------------------
-- Table structure for `sight_info`
-- ----------------------------
DROP TABLE IF EXISTS `sight_info`;
CREATE TABLE `sight_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL COMMENT '景点名称',
  `city` varchar(5) DEFAULT NULL COMMENT '景点所在城市',
  `ticket_cost` int(5) DEFAULT NULL COMMENT '门票',
  `discount` int(3) DEFAULT NULL COMMENT '折扣',
  `info` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sight_info
-- ----------------------------
INSERT INTO `sight_info` VALUES ('3', '九华山', '池州市', '100', '9', '九华山，[1-3]    位于安徽省池州市青阳县境内，西北接安庆市天柱山风景区，南接黄山风景区，是安徽省三大名山之一（黄山、九华山、天柱山），是上古学仙修道圣地之一。黄金旅游区的北部主入口、主景区。九华山风景区面积120平方公里，保护范围174平方公里。是首批国家重点风景名胜区，著名的游览避暑胜地，现为国家5A级旅游区、全国文明风景旅游区示范点，现与山西五台山、浙江普陀山、四川峨眉山并称为中国佛教四大名山，是“地狱未空誓不成佛，众生度尽方证菩提”的大愿地藏王菩萨道场，被誉为国际性佛教道场。\r\n九华山古称陵阳山、九子山，因有九峰形似莲花，因此而得名。于唐天宝年间（742（壬午年）～756）改名九华山。方圆100公里内有九十九峰，主峰十王峰海拔1342米，山体由花岗石组成，山形峭拔凌空，素有“东南第一山”之称，至今保留着乾隆御赐笔金匾“东南第一山”。');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `tname` varchar(15) DEFAULT NULL,
  `password` char(16) DEFAULT NULL,
  `telephone` char(15) DEFAULT NULL,
  `admin` bit(1) DEFAULT NULL,
  `email` char(25) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'windy', null, 'hqf123456', null, '', null);
INSERT INTO `user_info` VALUES ('2', null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('3', 'travelor1', '', '123456', '', null, null);
INSERT INTO `user_info` VALUES ('4', 'travelor2', '', 'hqf123456', '', null, null);
INSERT INTO `user_info` VALUES ('5', 'travelor3', '', '123456', '', null, null);
INSERT INTO `user_info` VALUES ('6', 'travelor5', '', '123', '', null, null);
INSERT INTO `user_info` VALUES ('7', 'travelor6', '', '123', '', null, null);
