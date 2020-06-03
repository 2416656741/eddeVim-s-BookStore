/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 03/06/2020 20:26:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `img_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_book
-- ----------------------------
BEGIN;
INSERT INTO `t_book` VALUES (1, 'java 从入门到放弃', 80.00, '国哥', 9999, 9, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (2, '数据结构与算法', 78.50, '严敏君', 6, 13, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (5, 'C++编程思想', 45.50, '刚哥', 20, 89, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (6, '蛋炒饭', 9.90, '周星星', 15, 50, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (7, '赌神', 66.50, '龙伍', 125, 535, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (8, 'Java 编程思想', 99.50, '阳哥', 47, 36, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (9, 'JavaScript 从入门到精通', 9.90, 'js', 85, 95, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (10, 'cocos2d-x 游戏编程入门', 49.00, '国哥', 52, 62, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (11, 'C 语言程序设计', 28.00, '谭浩强', 52, 74, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (12, 'Lua 语言程序设计', 51.50, '雷丰阳', 48, 82, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (13, '西游记', 12.00, '罗贯中', 19, 9999, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (14, '水浒传', 33.05, '华仔', 22, 88, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (15, '操作系统原理', 133.05, '刘优', 122, 188, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (16, '数据结构 java 版', 173.15, '封大神', 21, 81, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (17, 'UNIX 高级环境编程', 99.15, '乐天', 210, 810, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (18, 'javaScript 高级编程', 69.15, '国哥', 210, 810, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (19, '大话设计模式', 89.15, '国哥', 20, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (20, '人月神话', 88.15, '刚哥', 20, 80, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (21, '算法5', 66.00, 'EddieVim', 999, 0, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (51, '密码', 20.00, 'Vim', 200, 300, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (56, '相对论', 50.00, '爱因斯坦', 500, 200, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (73, 'test', 20.00, '爱因斯坦', 500, 0, 'static/img/default.jpg');
COMMIT;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` varchar(50) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `total_price` decimal(11,2) DEFAULT NULL,
  `order_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `PASSWORD` varchar(32) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'admin', 'admin', 'admin@qq.com');
INSERT INTO `t_user` VALUES (2, 'dijkstra', '666666', 'dj@qq.com');
INSERT INTO `t_user` VALUES (5, 'eddieVim', '1234qwer', '123@qq.com');
INSERT INTO `t_user` VALUES (6, 'rubyonly', '123456', '123@qq.com');
INSERT INTO `t_user` VALUES (7, '15980897506', '1234qwer', '1548033119@qq.com');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
