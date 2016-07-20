# 20170720
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `title` varchar(30) DEFAULT '' COMMENT '标题',
  `concent` text COMMENT '内容',
  `createtime` varchar(20) DEFAULT '' COMMENT '创建时间',
  `createman` varchar(20) DEFAULT '' COMMENT '创建人',
  `actflag` tinyint(4) DEFAULT '1' COMMENT '状态(0:禁用;1:启用)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告';