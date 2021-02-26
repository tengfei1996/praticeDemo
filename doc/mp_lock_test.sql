/*
 Navicat Premium Data Transfer

 Source Server         : ningtf_sh_gov
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 192.168.250.54:3306
 Source Schema         : mp_lock_test

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 26/02/2021 09:57:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for od_busi_notelog
-- ----------------------------
DROP TABLE IF EXISTS `od_busi_notelog`;
CREATE TABLE `od_busi_notelog`  (
  `id` bigint(0) NOT NULL COMMENT '主键 主键标识',
  `note_type` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数据类别 留言类别',
  `relation_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联id 关联业务id，针对流程中的留言，关联流程配置主键',
  `note` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '留言内容 留言内容',
  `version` int(0) NULL DEFAULT 1,
  `user_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作人姓名 操作人姓名',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '操作时间 操作时间',
  `create_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '消息记录表 ' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of od_busi_notelog
-- ----------------------------
INSERT INTO `od_busi_notelog` VALUES (1340912587206258690, 'TEST', 'b1b0b8a8-eb02-4ca5-b8bb-6179440ab7f9', 'OptimisticLockerInnerInterceptor', 2, 'ning', '2020-12-30 19:00:57', '2020-12-21 14:50:48');
INSERT INTO `od_busi_notelog` VALUES (1340912587696992257, 'TEST', '442bbd74-034c-4e6e-b9d6-5382ee9d4340', 'OptimisticLockerInnerInterceptor', 1, 'ningtf1', '2020-12-21 14:50:49', '2020-12-21 14:50:49');
INSERT INTO `od_busi_notelog` VALUES (1340912587759906818, 'TEST', '1228135a-1b73-4081-8917-f4dbebcfb3b7', 'OptimisticLockerInnerInterceptor', 1, 'ningtf2', '2020-12-21 14:50:49', '2020-12-21 14:50:49');
INSERT INTO `od_busi_notelog` VALUES (1340912587759906819, 'TEST', '34cacfc7-2a3e-4ea0-9f09-a1ad1fc6592e', 'OptimisticLockerInnerInterceptor', 1, 'ningtf3', '2020-12-21 14:50:49', '2020-12-21 14:50:49');
INSERT INTO `od_busi_notelog` VALUES (1340912587835404289, 'TEST', '87120b8a-2f58-45f1-8c46-bf955ca59675', 'OptimisticLockerInnerInterceptor', 1, 'ningtf4', '2020-12-21 14:50:49', '2020-12-21 14:50:49');
INSERT INTO `od_busi_notelog` VALUES (1340912587894124546, 'TEST', '27da63fa-f9f8-441e-a12a-2071a247bdb2', 'OptimisticLockerInnerInterceptor', 1, 'ningtf5', '2020-12-21 14:50:49', '2020-12-21 14:50:49');
INSERT INTO `od_busi_notelog` VALUES (1340912588015759362, 'TEST', '96002f70-2c49-4a95-b02d-c59c06f856d9', 'OptimisticLockerInnerInterceptor', 1, 'ningtf6', '2020-12-21 14:50:49', '2020-12-21 14:50:49');
INSERT INTO `od_busi_notelog` VALUES (1340912588091256833, 'TEST', '304d5852-354b-4874-bca0-5d5004160075', 'OptimisticLockerInnerInterceptor', 1, 'ningtf7', '2020-12-21 14:50:49', '2020-12-21 14:50:49');
INSERT INTO `od_busi_notelog` VALUES (1340912588149977090, 'TEST', '35bb7826-2c59-439e-8731-8a9208ada334', 'OptimisticLockerInnerInterceptor', 1, 'ningtf8', '2020-12-21 14:50:49', '2020-12-21 14:50:49');
INSERT INTO `od_busi_notelog` VALUES (1340912588149977091, 'TEST', '41d020b8-0142-4290-bb29-34321906986a', 'OptimisticLockerInnerInterceptor', 1, 'ningtf9', '2020-12-21 14:50:49', '2020-12-21 14:50:49');

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user`  (
  `id` bigint(0) NOT NULL COMMENT '用户主键id',
  `user_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `describtion` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '描述',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '修改日期',
  `version` int(0) UNSIGNED NULL DEFAULT 1 COMMENT '版本/乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES (1358657922959630337, '123456', '123456', '这人很懒，什么都没留下。。。', '2021-02-08 14:04:26', '2021-02-08 14:04:26', 1);

SET FOREIGN_KEY_CHECKS = 1;
