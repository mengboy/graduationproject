SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- 新加的库
-- ----------------------------
--  Table structure for `meeting`
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `meeting` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '会议名称',
  `meetingtime` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '会议时间',
  `meetingaddr` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '会议地点',
  `remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '留言备注',
  `is_del` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '是否删除, 0表示未删除，1表示已删除',
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=latin1;

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
  PRIMARY KEY (`mp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=latin1;



-- ----------------------------
--  Table structure for `certificate`
-- ----------------------------
DROP TABLE IF EXISTS `certificate`;
CREATE TABLE `certificate` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '姓名',
  `sex` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '性别',
  `idcard` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '身份证号码',
  `number` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '证书编号',
  `organization` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '单位组织',
  `ctype` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '证书类型',
  `signdate` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '签发日期',
  `headpic` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '证件照片',
  `begindate` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '培训的开始日期',
  `enddate` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '培训的j结束日期',
  `validtime` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '有效时间',
  `email` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '联系邮箱',
  `telphone` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '联系电话号码',
  `is_del` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '是否删除',
  `remark` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `certificate`
-- ----------------------------
BEGIN;
INSERT INTO `certificate` VALUES ('1', 'zhang', '男', '511', '2018', '西南交通大学', '不动产登记', '2018-03-05', null, '2018-04-02', '2018-04-04', '2022-01-01', '123@qq.com', '13888888888', '0', '可以了'), ('2', 'liu', '女', '512', '2017', '四川大学', '两区', '2018年03月16日', null, '2018-04-02', '2018年04月02', null, null, null, '0', null), ('3', 'skjdbcj', 'ksjdabc', '4932589475894', '32i ri o', 'efnj', 'kjesnjfk', '2018-03-16', '/img/blog/60b060fd82964c29b401ca391fa2a1d2.png', '2018-03-15', '2018-03-20', '2018-03-01', 'jkdnvjkfn,89429u483', '', '0', 'davcdiovio'), ('4', 'dsakjbvkj', 'dsajvb', 'dsajv', 'dsalkvb', 'dsalknv', 'dsaklnv', '2018-03-02', '', '2018-03-08', '2018-03-04', '2018-03-05', 'dsajkbv,sajbcj', null, '1', 'dsakjbv');
COMMIT;


-- ----------------------------
--  Table structure for `about`
-- ----------------------------
DROP TABLE IF EXISTS `about`;
CREATE TABLE `about` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `desrc` text COMMENT '描述',
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `zip_code` varchar(6) DEFAULT NULL,
  `work_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `about`
-- ----------------------------
BEGIN;
INSERT INTO `about` VALUES ('1', '西南交通大学中国土地信息大数据研究院是西南交通大学下设的二级科学研究机构，以科学技术发展研究院为主管部门，由信息科学与技术学院、电气工程学院、地球科学与环境工程学院联合共建。\r\n研究院依托西南交通大学雄厚的人才资源和科研实力，整合计算机科学与技术、信息与通信工程、控制科学与工程、测绘科学与技术、地质资源与地质工程、电气工程等学科优势，以土地信息大数据为研究对象，以促进土地信息的智慧化为根本目标，致力于大数据、云计算、物联网、人工智能等领域的科学研究、人才培养、技术创新和社会服务。', '四川省成都市金牛区二环路北一段111号/成都市犀安路999号', '027-66367729', '610031', 'AM 9:00-PM 6:00');
COMMIT;


-- ----------------------------
--  Table structure for `job_type`
-- ----------------------------
DROP TABLE IF EXISTS `job_type`;
CREATE TABLE `job_type` (
  `jt_id` int(20) NOT NULL AUTO_INCREMENT,
  `jt_name` varchar(20) NOT NULL,
  `jt_desc` text,
  PRIMARY KEY (`jt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `job_type`
-- ----------------------------
BEGIN;
INSERT INTO `job_type` VALUES ('1', '社会招聘', '西南交通大学中国土地信息大数据研究院是2015年提出并更名，2016年10月9日，学校第十四届党委会第46次常委（扩大）会议审议并通过成立。决议确定：研究院以科学技术发展研究院为主管部门，由信息科学与技术学院、电气学院、地理科学与环境工程学院联合共建。2016年10月27日，学校发布西交校人【2016】120号“西南交通大学关于成立‘西南交通大学中国土地信息大数据研究院’等三个机构的通知”的文件，研究院正式成立。2016年12月26日，学校发布西交校[2016]82号“西南交通大学关于启用‘四川省社会科学重点研究基地现代设计与文化研究中心’等单位印章的通知”的文件，研究院正式对外开展科研项目的合作。2017年3月27日，学校在九里校区创新大厦为研究院分配了科研场地，支持研究院的科学研究工作，为“西南交通大学 四川省农业厅战略合作协议”中共建“四川省农村土地大数据中心”和“西南交通大学 四川省国土资源厅战略合作协议”中共建“四川省国土资源大数据中心”提供场地保障。为落实校厅农业大数据、农业信息科学、农业技术、农业精准化等方面提供了保障。'), ('3', '实习生招聘', '目前暂时没有实习生招聘计划，谢谢关注！');
COMMIT;


-- ----------------------------
--  Table structure for `position`
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `p_id` int(20) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(20) NOT NULL,
  `jt_id` int(20) DEFAULT NULL,
  `p_desc` text,
  `p_work_place` varchar(20) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `position`
-- ----------------------------
BEGIN;
INSERT INTO `position` VALUES ('1', 'Java 系统架构师', '1', '岗位职责：\r\n\r\n1. 负责海量用户、高并发、分布式系统的设计和开发\r\n\r\n2. 参与系统的需求分析，撰写技术文档\r\n\r\n3. 参与基础服务、中间件的开发\r\n\r\n4. 发现并解决系统存在的问题\r\n\r\n岗位要求：\r\n\r\n1、本科及以上学历，3-5年Java服务器工作经验;\r\n\r\n2、编程基础扎实，具备良好的代码编写习惯和结构组织能力；\r\n\r\n3、精通Java语言，深刻理解面向对象思想，熟悉常用项目构建工具，具备大规模高并发访问的Web应用开发经验；\r\n\r\n4、熟悉常用数据库(MySQL等)的原理和使用，对SQL优化有丰富的经验；\r\n\r\n5、熟悉分布式系统的设计和应用，熟悉分布式、缓存、消息、负载均衡等机制和实现；\r\n\r\n6、掌握Linux 操作系统，熟悉shell的使用。', '成都', '2018-03-18'), ('2', 'Java 开发工程师', '1', '岗位职责：\r\n\r\n1. 负责海量用户、高并发、分布式系统的设计和开发\r\n\r\n2. 参与系统的需求分析，撰写技术文档\r\n\r\n3. 参与基础服务、中间件的开发\r\n\r\n4. 发现并解决系统存在的问题\r\n\r\n岗位要求：\r\n\r\n1、本科及以上学历，3-5年Java服务器工作经验;\r\n\r\n2、编程基础扎实，具备良好的代码编写习惯和结构组织能力；\r\n\r\n3、精通Java语言，深刻理解面向对象思想，熟悉常用项目构建工具，具备大规模高并发访问的Web应用开发经验；\r\n\r\n4、熟悉常用数据库(MySQL等)的原理和使用，对SQL优化有丰富的经验；\r\n\r\n5、熟悉分布式系统的设计和应用，熟悉分布式、缓存、消息、负载均衡等机制和实现；\r\n\r\n6、掌握Linux 操作系统，熟悉shell的使用。', '成都', '2018-03-18'), ('4', '嵌入式软件开发', '1', '任职资格：\r\n\r\n1. 本科及以上学历，计算机等相关专业\r\n\r\n2. 精通C/C++语言，熟练使用python，shell至少一种脚本语言\r\n\r\n3. 具有良好的计算机体系结构基础，熟悉ARM或DSP体系结构\r\n\r\n4. 熟悉视频/图像的基本处理方法，有图像处理开发经验者优先\r\n\r\n5. 有性能优化，算法优化开发经验者优先\r\n\r\n6. 认真负责，有很好的团队精神，善与人沟通，有一定的协调推动能力', '成都', '2018-03-18');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;