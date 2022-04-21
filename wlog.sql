/*
 Navicat Premium Data Transfer

 Source Server         : Aliyun
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : 8.136.191.185:3306
 Source Schema         : wlog

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 21/04/2022 14:55:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basic
-- ----------------------------
DROP TABLE IF EXISTS `basic`;
CREATE TABLE `basic` (
  `last_operator` bigint NOT NULL COMMENT '最后操作人',
  `founder` bigint NOT NULL COMMENT '创建人',
  `change_time` datetime NOT NULL COMMENT '最后操作时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `id` bigint NOT NULL COMMENT '唯一标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of basic
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `last_operator` bigint NOT NULL COMMENT '最后操作人',
  `founder` bigint NOT NULL COMMENT '创建人',
  `change_time` datetime NOT NULL COMMENT '最后操作时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `id` bigint NOT NULL COMMENT '唯一标识',
  `username` varchar(30) DEFAULT NULL COMMENT '用户名',
  `password` varchar(60) DEFAULT NULL COMMENT '密码',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `gender` int DEFAULT NULL COMMENT '性别 0:女 1:男',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` VALUES (12345678, 12345678, '2022-04-19 15:54:18', '2022-04-19 15:54:19', 12345678, 'Baozoulolw', 'w123456789', '1999-03-13 15:54:39', 'Shiki', 1, '12138', '2380758345@qq.com');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
