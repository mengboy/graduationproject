
/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost
 Source Database       : bootdo

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : utf-8

 Date: 04/21/2018 17:51:08 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `meeting_people`
-- ----------------------------
DROP TABLE IF EXISTS `meeting_people`;
CREATE TABLE `meeting_people` (
  `mp_id` int(11) NOT NULL AUTO_INCREMENT,
  `truename` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '姓名',
  `telephone` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '联系电话',
  `company` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '公司单位',
  `position` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '职位描述',
  `registertime` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '提交时间',
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '电子邮箱',
  `remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '留言备注',
  `is_del` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '是否删除, 0表示未删除，1表示已删除',
  `m_id` int(20) NOT NULL,
  PRIMARY KEY (`mp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
--  Records of `sys_menu`
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES ('1', '0', '基础管理', '', '', '0', 'fa fa-bars', '0', '2017-08-09 22:49:47', null), ('2', '3', '系统菜单', 'sys/menu/', 'sys:menu:menu', '1', 'fa fa-th-list', '2', '2017-08-09 22:55:15', null), ('3', '0', '系统管理', null, null, '0', 'fa fa-desktop', '1', '2017-08-09 23:06:55', '2017-08-14 14:13:43'), ('6', '3', '用户管理', 'sys/user/', 'sys:user:user', '1', 'fa fa-user', '0', '2017-08-10 14:12:11', null), ('7', '3', '角色管理', 'sys/role', 'sys:role:role', '1', 'fa fa-paw', '1', '2017-08-10 14:13:19', null), ('12', '6', '新增', '', 'sys:user:add', '2', '', '0', '2017-08-14 10:51:35', null), ('13', '6', '编辑', '', 'sys:user:edit', '2', '', '0', '2017-08-14 10:52:06', null), ('14', '6', '删除', null, 'sys:user:remove', '2', null, '0', '2017-08-14 10:52:24', null), ('15', '7', '新增', '', 'sys:role:add', '2', '', '0', '2017-08-14 10:56:37', null), ('20', '2', '新增', '', 'sys:menu:add', '2', '', '0', '2017-08-14 10:59:32', null), ('21', '2', '编辑', '', 'sys:menu:edit', '2', '', '0', '2017-08-14 10:59:56', null), ('22', '2', '删除', '', 'sys:menu:remove', '2', '', '0', '2017-08-14 11:00:26', null), ('24', '6', '批量删除', '', 'sys:user:batchRemove', '2', '', '0', '2017-08-14 17:27:18', null), ('25', '6', '停用', null, 'sys:user:disable', '2', null, '0', '2017-08-14 17:27:43', null), ('26', '6', '重置密码', '', 'sys:user:resetPwd', '2', '', '0', '2017-08-14 17:28:34', null), ('27', '1', '系统日志', 'common/log', 'common:log', '1', 'fa fa-warning', '2', '2017-08-14 22:11:53', null), ('28', '27', '刷新', null, 'sys:log:list', '2', null, '0', '2017-08-14 22:30:22', null), ('29', '27', '删除', null, 'sys:log:remove', '2', null, '0', '2017-08-14 22:30:43', null), ('30', '27', '清空', null, 'sys:log:clear', '2', null, '0', '2017-08-14 22:31:02', null), ('48', '1', '代码生成', 'common/generator', 'common:generator', '1', 'fa fa-code', null, null, null), ('49', '0', '内容管理', '', '', '0', 'fa fa-rss', null, null, null), ('50', '49', '动态消息', 'content/bContent', 'content:bContent:bContent', '1', 'fa fa-file-image-o', null, null, null), ('51', '50', '新增', '', 'content:bContent:add', '2', '', null, null, null), ('55', '7', '编辑', '', 'sys:role:edit', '2', '', null, null, null), ('56', '7', '删除', '', 'sys:role:remove', '2', null, null, null, null), ('57', '1', '运行监控', '/druid/index.html', '', '1', 'fa fa-caret-square-o-right', null, null, null), ('58', '50', '编辑', '', 'content:bContent:edit', '2', null, null, null, null), ('59', '50', '删除', '', 'content:bContent:remove', '2', null, null, null, null), ('60', '50', '批量删除', '', 'content:bContent:batchRemove', '2', null, null, null, null), ('61', '2', '批量删除', '', 'sys:menu:batchRemove', '2', null, null, null, null), ('62', '7', '批量删除', '', 'sys:role:batchRemove', '2', null, null, null, null), ('64', '0', '分类管理', '', '', '0', 'fa fa-tags', null, null, null), ('65', '64', '动态消息', '/content/news', 'content:news:news', '1', null, null, null, null), ('66', '65', '添加', '/content/news/add', 'content:news:add', '2', '', null, null, null), ('67', '65', '删除', '/content/news/remove', 'content:news:remove', '2', null, null, null, null), ('81', '65', '编辑', '/content/news/edit', 'content:news:edit', '2', null, null, null, null), ('82', '65', '批量删除', '/content/news/batchRemove', 'content:news:batchRemove', '2', '', null, null, null), ('92', '49', '研究方向', '/direction/content', 'content:direction:direction', '1', '', null, null, null), ('93', '92', '示范项目', '/direction/showProject', 'content:direction:showproject', '2', '', null, null, null), ('94', '92', '案例分析', '/content/direction/caseAnalysis', 'content:direction:caseanalysis', '2', '', null, null, null), ('95', '92', '交流空间', '/content/direction/discussSpace', 'content:direction:discussSpace', '2', '', null, null, null), ('96', '92', '添加', '/content/direction/contentAdd', 'content:direction:add', '2', '', null, null, null), ('97', '92', '删除', '/content/direction/contentRemove', 'content:direction:remove', '2', '', null, null, null), ('98', '92', '批量删除', '/content/direction/contentBatchRemove', 'content:direction:batchRemove', '2', '', null, null, null), ('99', '49', '解决方案', '/content/solution', 'content:solution:solution', '1', '', null, null, null), ('100', '99', '添加', '', 'content:solution:add', '2', null, null, null, null), ('101', '99', '方案种类', '', 'content:solution:solution', '2', null, null, null, null), ('103', '99', '解决方案', '', 'content:solution:solution', '2', '', null, null, null), ('104', '99', '删除', '', 'content:solution:remove', '2', null, null, null, null), ('105', '49', '研究团队', '/content/team', 'content:team:team', '1', null, null, null, null), ('106', '105', '添加', '/content/team/add', 'content:team:add', '2', null, null, null, null), ('107', '105', '团队代表', '/content/team/representative', 'content:team:team', '2', null, null, null, null), ('108', '105', '删除', '/content/team/remove', 'content:team:remove', '2', null, null, null, null), ('109', '105', '批量删除', '/content/team/batchRemove', 'content:team:batchRemove', '2', '', null, null, null), ('110', '49', '资料下载', '/content/dataDownload', 'content:data:data', '1', null, null, null, null), ('111', '110', '添加', '/content/data/add', 'content:data:add', '2', null, null, null, null), ('112', '110', '删除', '/content/data/remove', 'content:data:remove', '2', null, null, null, null), ('113', '110', '批量删除', '/content/data/batchRemove', 'content:data:batchRemove', '2', null, null, null, null), ('114', '92', '编辑', '', 'content:direction:edit', '2', null, null, null, null), ('115', '49', '人才招聘', '/content/recruitment', 'content:recruitment:recruitment', '1', null, null, null, null), ('116', '115', '招聘种类', '/content/recruitment/type', 'content:recruitment:type', '2', null, null, null, null), ('117', '115', '招聘职位', '/content/recruitment/position', 'content:recruitment:position', '2', null, null, null, null), ('118', '115', '添加', '', 'content:recruitment:add', '2', '', null, null, null), ('119', '115', '删除', '', 'content:recruitment:remove', '2', null, null, null, null), ('120', '115', '批量删除', '', 'content:recruitment:batchRemove', '2', null, null, null, null), ('121', '115', '编辑', '', 'content:recruitment:edit', '2', null, null, null, null), ('122', '49', '会议管理', '/content/signature', 'content:signature:signature', '1', '', null, null, null), ('123', '122', '添加', '', 'content:signature:add', '2', '', null, null, null), ('124', '122', '删除', '', 'content:signature:remove', '2', null, null, null, null), ('125', '122', '编辑', '', 'content:signature:edit', '2', null, null, null, null), ('126', '122', '批量删除', '', 'content:signature:batchRemove', '2', null, null, null, null), ('127', '49', '证书管理', '/content/certificate', 'content:certificate:certificate', '1', '', null, null, null), ('128', '127', '添加', '', 'content:certificate:add', '2', null, null, null, null), ('129', '127', '删除', '', 'content:certificate:remove', '2', null, null, null, null), ('130', '127', '编辑', '', 'content:certificate:edit', '2', null, null, null, null), ('131', '127', '批量删除', '', 'content:certificate:batchRemove', '2', null, null, null, null), ('132', '50', '消息分类', '', 'content:news:type', '2', null, null, null, null), ('133', '50', '动态消息', '', 'content:news:news', '2', null, null, null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
