/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : lyqpro

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-07-10 17:47:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '账户名',
  `money` double(10,2) DEFAULT '0.00' COMMENT '余额',
  `createdatetime` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(200) DEFAULT '' COMMENT '备注',
  `type` tinyint(4) DEFAULT '0' COMMENT '类型(0:现金;1:银行卡;2:虚拟账户;3:信用卡)',
  `actflag` tinyint(4) DEFAULT '1' COMMENT '状态(0:禁用;1:启用)',
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户';

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('09386e44-bb37-48b4-8beb-f31413addd0d', '工商银行', '100.00', '2015-03-26 23:11:16', '454二', '1', '0', null);
INSERT INTO `account` VALUES ('15de00e7-504a-46c3-8d99-8dec0ea6be5e', '通天塔', '442.00', '2015-03-29 11:13:25', '通天塔', '2', '0', null);
INSERT INTO `account` VALUES ('5484d246-1e76-4d8f-bdb7-cf061631b1a1', '邮政银行', '500.00', '2015-03-26 23:10:38', '3432', '1', '0', null);
INSERT INTO `account` VALUES ('f64521a5-188d-4dd7-b893-d53d7e3a91e3', '招商银行', '10005.50', '2015-03-29 11:10:28', '2月11日初始', '1', '0', null);

-- ----------------------------
-- Table structure for daily
-- ----------------------------
DROP TABLE IF EXISTS `daily`;
CREATE TABLE `daily` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `accountid` varchar(36) NOT NULL COMMENT '账户名id',
  `money` double(10,2) DEFAULT '0.00' COMMENT '金额',
  `createdatetime` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(200) DEFAULT '' COMMENT '备注',
  `type` tinyint(4) DEFAULT '0' COMMENT '类型(0:收入;1:支出;)',
  `actflag` tinyint(4) DEFAULT '1' COMMENT '状态(0:禁用;1:启用)',
  PRIMARY KEY (`id`),
  KEY `accountid` (`accountid`),
  CONSTRAINT `accountid` FOREIGN KEY (`accountid`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收支录入';

-- ----------------------------
-- Records of daily
-- ----------------------------
INSERT INTO `daily` VALUES ('40565ce0-2bb6-4785-83d5-5315d1cc655e', '15de00e7-504a-46c3-8d99-8dec0ea6be5e', '665.00', '2016-01-28 19:44:43', '55', '0', '0');
INSERT INTO `daily` VALUES ('48a8aa15-cd55-4117-aaeb-75f53d4e82dc', '09386e44-bb37-48b4-8beb-f31413addd0d', '600.00', '2016-02-10 08:49:28', '孝敬长辈，年初二出门拜年，陆丰', '1', '1');
INSERT INTO `daily` VALUES ('67ea0544-e797-4c1f-aef6-412a075b5cb9', '5484d246-1e76-4d8f-bdb7-cf061631b1a1', '888.00', '2016-02-10 14:34:00', '45354', '1', '1');
INSERT INTO `daily` VALUES ('7bc22cc0-2cb3-4925-a68b-13a131cd3154', '5484d246-1e76-4d8f-bdb7-cf061631b1a1', '4.00', '2016-01-28 19:37:34', '44', '1', '1');
INSERT INTO `daily` VALUES ('89785f15-c146-4b27-82e9-d6700d8626a6', '5484d246-1e76-4d8f-bdb7-cf061631b1a1', '500.00', '2016-02-11 23:28:09', '改变账户金额第一笔收入', '0', '1');
INSERT INTO `daily` VALUES ('8ac7da2e-ac27-41ce-844b-12d355d4891f', '15de00e7-504a-46c3-8d99-8dec0ea6be5e', '44.00', '2016-01-28 19:43:26', '555', '0', '1');
INSERT INTO `daily` VALUES ('901c9472-9002-4068-bc81-60d8e4bb47ee', '5484d246-1e76-4d8f-bdb7-cf061631b1a1', '888.00', '2016-02-08 13:23:43', '春节第一天在家里', '0', '1');
INSERT INTO `daily` VALUES ('99d33fa1-4394-4626-87a9-2bf839f322c6', '5484d246-1e76-4d8f-bdb7-cf061631b1a1', '60.00', '2016-02-09 09:49:41', '32好77', '0', '1');
INSERT INTO `daily` VALUES ('c048ebe2-5152-4490-bb47-85b1c7c81b1a', 'f64521a5-188d-4dd7-b893-d53d7e3a91e3', '5.50', '2016-02-14 09:22:12', '红包收入', '0', '1');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` varchar(36) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `createdatetime` datetime DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `updatedatetime` datetime DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('24966de4-497a-482f-813b-ef94f2902194', '12', '2015-03-24 23:47:53', '李云强', '1', '2015-03-24 23:49:27', '5566');
INSERT INTO `employee` VALUES ('5853d45e-8958-4b08-a524-43b63352bd6b', '137', '2015-03-25 21:26:57', '乐檬K3', '0', '2015-03-29 11:03:59', '阿斯顿');
INSERT INTO `employee` VALUES ('b0382cde-31cc-4238-aee6-87d058126146', '411', '2015-03-25 21:42:51', 'u1', '1', '2015-05-19 06:09:09', '高i');

-- ----------------------------
-- Table structure for lyqaccount
-- ----------------------------
DROP TABLE IF EXISTS `lyqaccount`;
CREATE TABLE `lyqaccount` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '账户名',
  `money` double(10,2) DEFAULT '0.00' COMMENT '余额',
  `createdatetime` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(200) DEFAULT '' COMMENT '备注',
  `actflag` tinyint(4) DEFAULT '1' COMMENT '状态(0:禁用;1:启用)',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户';

-- ----------------------------
-- Records of lyqaccount
-- ----------------------------
INSERT INTO `lyqaccount` VALUES ('16e67d88-7112-412d-ae3c-ede2cc41bcd0', '百度云', '9.00', '2016-07-10 17:45:20', '百度云账号', '0', '');

-- ----------------------------
-- Table structure for syonline
-- ----------------------------
DROP TABLE IF EXISTS `syonline`;
CREATE TABLE `syonline` (
  `ID` varchar(36) NOT NULL,
  `CREATEDATETIME` datetime DEFAULT NULL,
  `IP` varchar(100) DEFAULT NULL,
  `LOGINNAME` varchar(100) DEFAULT NULL,
  `TYPE` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syonline
-- ----------------------------
INSERT INTO `syonline` VALUES ('008e275d-d0ed-4179-a31c-e2227a6e2f59', '2016-02-10 08:45:07', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('02693a85-d3ec-4f6c-8c81-a56686463c0d', '2015-12-05 09:41:39', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('04d999f4-00bd-477b-9fd8-6c5b4b5fd2a2', '2015-12-05 16:34:08', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('0593615f-0f6b-434a-a7b2-723f219748b3', '2016-02-01 17:48:30', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('07a6d4a6-28fb-4496-9454-5532f0fc266a', '2015-12-05 11:15:06', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('0800f381-4bb1-48ed-bb7b-9845bd71c8bb', '2015-12-04 12:46:26', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('087b221c-bedc-4e39-843a-7bcc9922d4bc', '2016-02-08 13:00:41', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('091e9220-b1d2-43bc-93f6-96a73f399091', '2015-03-29 11:03:34', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('094493b3-ed6e-4dbb-b567-3262e67c9ce9', '2016-02-26 13:56:03', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('0ccc006e-5443-4737-ad0d-53ebbe6ceea4', '2016-07-10 16:37:37', '本地', 'lyq', '1');
INSERT INTO `syonline` VALUES ('0ecb3fb2-4b47-4aaa-9d8c-3aa56d19ea3c', '2016-02-14 15:16:38', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('0fecc65e-764f-4b77-beb7-09be33d6b666', '2016-01-28 19:34:57', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('103f3f86-9e25-45ab-9ec4-c6fb1cd49dd7', '2015-03-24 23:37:41', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('10a5bca0-73a4-43ef-83f9-272e6c71f8e4', '2015-05-18 01:42:10', '127.0.0.1', '孙宇', '0');
INSERT INTO `syonline` VALUES ('117ae650-40e5-4b80-b991-2798501bbb69', '2016-02-09 09:44:31', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('13725187-efbf-4ab6-aeb1-57538dd251b3', '2016-07-10 16:25:47', '本地', 'lyq', '1');
INSERT INTO `syonline` VALUES ('1792880b-688f-4d4c-886e-73cbc850249c', '2015-03-26 21:19:15', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('1c4e450b-4f6c-4f31-bc7b-701f0cb23ede', '2015-12-05 09:20:52', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('1c9b8ca4-0b62-4335-aaa7-c22740e93e5c', '2015-03-26 21:23:56', '127.0.0.1', '孙宇', '0');
INSERT INTO `syonline` VALUES ('1d7f6568-fa49-4fb5-af88-911c77d3a95b', '2015-12-05 16:09:33', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('1d92f459-d860-4d29-9d25-072240a136f1', '2015-12-04 12:47:17', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('21bebd34-ec85-4369-8843-270c3421a781', '2016-02-12 11:03:58', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('21e83c47-d4cb-41ea-9eb2-745ee2bfeaca', '2016-02-13 00:48:15', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('22265e05-c940-41af-a61e-8763de664a39', '2016-02-11 23:26:39', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('2265d4d9-1506-452f-beb5-da6b4937c3d0', '2016-02-14 09:38:53', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('2395e4be-10c2-4cea-b31f-33b446672965', '2016-01-07 16:41:59', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('2692e92c-e152-421e-8a92-e84bbc68baaa', '2016-02-12 10:27:18', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('28444c6b-f939-4007-8d9d-948d26356b52', '2015-12-05 08:58:49', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('295d6fae-d531-412a-bb2e-0fe342cdb8ff', '2015-03-26 21:08:52', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('2b044b5d-e39d-4b2c-8644-bbf8fc921caf', '2015-03-26 21:08:03', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('2b39c474-0c4f-4733-89f5-f6858b4fa985', '2016-02-14 15:41:05', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('2ce40862-0cd0-4195-a3d6-3c15721cad36', '2015-03-24 23:37:39', '127.0.0.1', '孙宇', '0');
INSERT INTO `syonline` VALUES ('350decb7-047d-4920-841e-a8f1d27f0460', '2016-02-09 11:29:24', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('36e667f9-ce3f-4f09-83d6-659da7f56960', '2015-04-26 09:22:21', '127.0.0.1', '孙宇', '0');
INSERT INTO `syonline` VALUES ('375602de-53a4-4450-9393-b1a0f59970c6', '2016-02-11 08:47:43', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('3a097cde-d1fa-49e6-81ef-87adcdb9af02', '2016-07-10 17:15:13', '本地', 'lyq', '1');
INSERT INTO `syonline` VALUES ('3a10c380-bd4f-4fb2-9c98-faaf5234d36e', '2015-12-05 17:03:09', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('3b1315f2-ab42-4428-82b8-b6fd5a224ff8', '2015-12-05 16:35:34', '127.0.0.1', '孙宇', '0');
INSERT INTO `syonline` VALUES ('3b983148-54e9-42a0-b864-34abca510ca8', '2016-02-09 10:51:09', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('3b9986a7-782f-403e-b817-46242b1cbf2c', '2016-02-09 09:23:42', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('3bc29e92-7417-4e46-81d4-0b0a9caf6ec3', '2016-07-10 16:44:12', '本地', 'lyq', '0');
INSERT INTO `syonline` VALUES ('3ef3682e-3a0b-4827-a234-858a7b58647d', '2015-03-26 22:56:47', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('3f8c7986-1d62-4c64-967c-17b60d194778', '2016-01-27 19:05:55', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('4179f34d-5a7a-4455-871c-c756860af9d5', '2016-02-09 00:51:45', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('436204b1-30a4-4509-8f51-fe7204d8a34a', '2015-03-29 10:44:56', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('476c2116-a038-46a2-8ce3-a14fa9b3ac93', '2016-02-03 11:27:38', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('47a1384a-b6a0-440a-b2b9-2d8208a1071c', '2016-07-10 17:41:02', '本地', 'lyq', '0');
INSERT INTO `syonline` VALUES ('47be2c0d-824e-40e4-89b6-8695c45f633e', '2016-01-27 19:54:27', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('48da9dc9-172e-462a-94e6-13ef4b273b99', '2016-02-09 09:12:32', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('4953327e-815d-48c5-8ab0-100d6954e8cc', '2015-12-04 11:51:13', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('49827b3e-152a-451d-9e0e-e7a28c834a5c', '2015-03-29 11:31:59', '127.0.0.1', '孙宇', '0');
INSERT INTO `syonline` VALUES ('4a16f1a2-5f3e-40ab-a877-745959f98796', '2015-12-05 11:18:36', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('4b45742c-4e7b-448b-b9df-a48d4433a792', '2016-02-09 10:15:42', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('4c803d3b-e7e7-473c-aeed-413d2fa252ff', '2016-02-13 00:45:38', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('4c96caf9-7502-4bb9-99b3-7dc87a79b117', '2016-02-09 10:03:42', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('4e8e0b87-8c03-4339-9989-bf1a9e862aa6', '2016-07-10 16:55:51', '本地', 'lyq', '0');
INSERT INTO `syonline` VALUES ('527b57c5-be30-47f7-be67-3c9fcdf2886a', '2016-02-09 11:06:15', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('5316acf1-0d1e-4553-9ea8-42b383397351', '2015-12-05 16:09:30', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('54318cb6-b60c-42ce-abf3-69c53b711de8', '2016-02-11 10:47:34', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('544d5bc9-ac84-40a6-90bc-bda659d40e54', '2016-02-14 09:21:31', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('55984302-75f0-4a4a-844f-331ff77c4905', '2015-12-04 13:07:05', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('570b511d-89b9-4f95-a6ca-a9eb729ee013', '2016-01-27 19:06:36', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('576c85c3-a235-4af3-bb41-fefad8b6c7a0', '2016-02-13 00:45:41', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('5875f681-a70a-4d09-9aea-d9fb1c1742c0', '2016-02-09 09:44:41', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('58eea494-67f3-40ed-b52a-90b4a9c32a85', '2015-12-05 11:20:22', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('5900ee27-d9af-41b3-a2ef-32e8a0f70fe9', '2015-12-05 16:02:32', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('592d8ec2-9836-4d47-a0aa-a45f389297f9', '2016-02-09 00:54:05', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('5bcc2fe0-7b4f-4877-8157-5409faa85add', '2015-03-26 22:45:28', '127.0.0.1', '孙宇', '0');
INSERT INTO `syonline` VALUES ('5c7210cb-8706-4a09-8254-fc9ba84a8b2e', '2016-02-08 13:19:01', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('5f6ad592-8ce9-47c6-9527-a2a0ddf222ae', '2015-03-26 22:24:30', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('5fe02564-4f7d-49fb-963e-58cd19af7fa2', '2016-02-10 08:45:03', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('5fe97e24-7ab5-4bfd-9437-f2d82a815b30', '2016-02-09 09:09:12', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('62be697b-04f0-4a4f-ae71-c972f28b84bb', '2016-02-09 09:44:38', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('66867bbf-500d-40da-a8eb-d8333c95e0ef', '2015-12-04 12:46:18', '127.0.0.1', '孙宇', '0');
INSERT INTO `syonline` VALUES ('66e6a54c-8637-4299-ba40-a62bc5304d05', '2016-02-12 11:47:08', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('67906767-aeb5-469c-8776-0bb58ae2e126', '2015-12-05 16:45:41', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('6904721b-3e69-4b17-8510-ba6584d7fd38', '2015-12-05 11:29:39', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('6ba75418-e6dc-47c2-9861-033b567764a1', '2016-02-09 09:09:07', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('6e7155c7-38bc-4789-8b92-97ca46021066', '2015-11-24 15:12:42', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('6f68dd2c-3526-4ee5-a856-181b865f3c96', '2016-02-10 14:33:18', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('7071a10d-b2ae-4b76-b3fa-2b6836db8e14', '2016-07-10 16:44:14', '本地', 'lyq', '1');
INSERT INTO `syonline` VALUES ('7127a571-246c-44d2-bb11-512a80204a22', '2015-05-18 01:27:03', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('71806d62-c3ac-49fd-b641-b2d6da422c5e', '2016-02-10 09:21:07', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('71ddfe07-ce6a-4379-b339-263f62631b7b', '2015-12-05 11:08:21', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('739fca9c-5cc8-4ce6-91a4-057511e4682c', '2015-03-26 23:00:41', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('73d1085e-3d72-49ca-a281-7db7fc7c3d01', '2015-12-05 11:18:04', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('740fc69e-bb84-428a-aad6-837cf1787ab3', '2016-02-08 12:26:44', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('74bf91d7-101e-4d44-a032-286a23149447', '2015-12-04 12:41:02', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('74e684cf-5af4-4dbc-b2f9-2317c98c7245', '2015-12-05 16:05:04', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('74f5ff51-124c-404f-bbd0-fbe66d3c57ae', '2016-02-09 00:48:43', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('768c4487-ecd3-4be0-9843-d927c5a933da', '2016-07-10 16:55:53', '本地', 'lyq', '1');
INSERT INTO `syonline` VALUES ('78ebf845-26e3-4174-b168-d37f9ce45740', '2016-01-28 18:49:11', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('79e9e301-424e-44de-af69-f66099b70442', '2015-03-24 23:31:47', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('7d5c9490-bb68-4848-92e2-708cbc3361d3', '2016-01-27 19:06:23', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('7d938889-0d9a-4bd5-a418-621621a657e4', '2015-12-05 12:06:02', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('7f4bcacc-d3ad-4bc5-8092-2da36b394f1f', '2015-12-05 16:07:40', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('7fe2ebaf-33aa-47f8-a49e-c2a184c7eea2', '2016-02-11 10:10:03', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('7ff901af-5f18-4150-a9b9-6172503df699', '2015-12-04 12:46:23', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('80c09112-7b7d-4569-9e04-33bdac795519', '2016-01-28 18:46:59', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('8136b320-cb72-4616-b2eb-7a41a416ce19', '2016-02-14 14:55:37', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('813c2300-fe51-4e9b-af9b-87ff495e2e58', '2016-01-27 19:54:50', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('81b3faad-ceaf-4100-9c2b-aa303feeb933', '2015-12-05 15:57:28', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('820f1f4d-8efa-4a84-a6db-9d5dfeb30fc8', '2016-02-10 08:43:10', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('83d36ee4-a581-403e-8424-47bb029c3680', '2015-12-04 12:48:05', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('8aeff05c-678c-4b96-9e1e-3af2dbc99e36', '2015-03-26 23:10:00', '127.0.0.1', '孙宇', '0');
INSERT INTO `syonline` VALUES ('8b1c4b58-ccc7-4dbd-aa90-36670f0ef375', '2016-01-27 19:54:54', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('8b2a52f4-7f21-4929-ab9a-be5b653b9586', '2015-12-05 16:35:37', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('8d18358f-07a1-4769-a2dd-3ebe7c47fa18', '2016-02-09 09:24:10', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('8f2f0866-27b4-427f-aadb-d61190973c1b', '2016-07-10 17:08:30', '本地', 'lyq', '1');
INSERT INTO `syonline` VALUES ('9467d809-a387-4e44-b474-c7e8ac3d30b8', '2016-02-09 09:21:05', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('95af03bb-1a9b-477b-951d-da1a06dc4c16', '2015-03-26 23:10:02', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('95ba74dd-44e2-435c-a4d5-1b0b9e26c854', '2016-01-28 19:00:09', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('98143445-1341-4767-bb3d-86f8818e95d8', '2016-07-10 17:39:29', '本地', 'lyq', '1');
INSERT INTO `syonline` VALUES ('991b0671-cb88-417e-9d4b-3f8bc2826126', '2015-12-05 09:01:11', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('9a75d6c0-9666-48ae-9de8-d70ecb4b77ae', '2016-02-09 11:28:11', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('9aa7b33c-3cdc-4833-8568-75cc2ac74213', '2015-03-25 21:21:54', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('a4983d2e-0cf0-4529-b46e-e3d2fad99760', '2016-01-28 18:47:01', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('a56a5982-de76-4760-920c-46f2d67da76a', '2015-04-26 09:21:58', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('a6ba013c-b292-4838-889c-44a1d4eaeb7f', '2015-12-05 11:15:04', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('a8bfe042-3fe6-4269-ba31-518146b01dc7', '2016-02-11 23:11:03', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('aabd8e0d-9565-4056-8e9e-e1dec3400e2a', '2016-02-09 10:28:05', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('aec154a0-b4e6-4b8e-8c1f-ec327a0a0c29', '2016-02-14 14:50:00', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('b15449ac-1b80-485c-ab5c-e1ba5cacf8d9', '2016-01-27 19:07:55', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('b212c61b-3581-451b-a461-49c485fc5fdf', '2016-02-12 10:47:08', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('b420ebb8-01d1-4a75-a6b6-0a7eb8fe1735', '2016-02-12 12:07:48', '127.0.0.1', 'zxx', '0');
INSERT INTO `syonline` VALUES ('b4a9b682-1932-4596-af56-f112bbbac335', '2015-12-04 12:07:02', '127.0.0.1', '孙宇', '0');
INSERT INTO `syonline` VALUES ('b6a2293f-0a4c-4328-a29f-e7d9476883d7', '2016-02-10 09:22:58', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('b834f430-f3ed-4922-8ba0-3b8a3027715f', '2016-07-10 17:24:25', '本地', 'lyq', '1');
INSERT INTO `syonline` VALUES ('b909a13f-f327-4750-913b-8e118cf6a2b8', '2015-05-19 06:07:07', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('bb0324fc-dbd3-4ca2-ad83-60607a93e62d', '2016-02-09 00:46:17', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('c0819b3a-7114-4566-b968-50bd0a67b741', '2016-02-12 11:41:13', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('c0e1dd69-1f75-487c-9354-454d0c3e287f', '2016-02-09 11:17:22', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('c11340d6-e353-4b32-97c5-bbd3e0207e3d', '2015-12-05 16:35:21', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('c1c59a74-cbc8-4ff7-b6f1-32ec1f81bdc9', '2016-02-12 10:45:58', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('c24009cb-a0bf-49a3-8bd1-4855c8be43b0', '2016-01-27 19:06:28', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('c29bc27b-a499-470f-8f45-742d3936c600', '2016-02-01 18:04:52', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('c3450adb-4481-477e-acae-e7cf1b4259d0', '2016-07-10 17:12:39', '本地', 'lyq', '1');
INSERT INTO `syonline` VALUES ('c6150404-c3ab-493a-b83b-8f9daffea33e', '2015-12-05 10:04:51', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('c61f09dd-ad63-4854-bf32-37dcb9697775', '2016-01-28 20:29:28', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('c6f1a52a-e349-4e25-8310-d90bb1f9ed5b', '2015-12-05 09:01:13', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('cb2f9853-baca-4f31-ae3d-f12224b75bd3', '2016-02-10 09:47:53', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('cb580d79-c778-4b94-a405-b6e41dbc4f2e', '2016-02-03 12:07:27', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('cbbbfd48-5438-43d1-b3d6-45295acf0a2c', '2016-07-10 17:36:38', '本地', 'lyq', '1');
INSERT INTO `syonline` VALUES ('ce52f1a3-cde3-4fa2-9531-0b46ea26f5b8', '2016-02-09 10:33:25', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('cf683d4e-6cec-42b4-892e-9d9975f2792d', '2016-02-09 09:28:57', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('cf96b4dc-e850-4949-9a34-1cb7f23cb21c', '2016-01-28 19:41:35', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('cfd9cd9c-8713-43f7-ae2d-fa503a9068bb', '2016-02-09 09:46:33', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('cfdb3fdd-32f0-4f87-9682-3419f659544e', '2015-12-05 16:04:35', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('d03c4f8b-f575-4a68-bc69-b5926e4fbdee', '2015-12-05 16:04:33', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('d12f19ca-2e0e-47bf-81e9-c7ee866834b6', '2016-01-28 18:49:55', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('d1d87d49-739c-40e9-bbce-79f22bd57cb4', '2016-02-13 00:34:17', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('d5344f4a-e16c-4c63-9529-181682e724bb', '2015-12-05 11:10:41', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('d58271a7-19e6-41ab-ba87-405d907d54da', '2015-11-24 15:28:43', '127.0.0.1', '孙宇', '0');
INSERT INTO `syonline` VALUES ('d7aa47ac-e47c-4a5e-97ff-54b0db050db6', '2016-07-10 16:58:39', '本地', 'lyq', '1');
INSERT INTO `syonline` VALUES ('d7e5339d-c479-4c2c-a5eb-e8f93c58953f', '2016-07-10 17:30:06', '本地', 'lyq', '1');
INSERT INTO `syonline` VALUES ('d9cf33da-2469-4b93-b1ca-1b20c0c23018', '2016-02-01 18:04:50', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('da553444-ddf0-4e18-8b95-080076212838', '2016-02-08 13:04:35', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('da8a00a2-4a31-4aed-a333-3a54599f94a1', '2016-01-27 19:23:36', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('dc905bef-774a-41d4-a487-1303cd209086', '2016-02-12 11:47:13', '127.0.0.1', 'zxx', '1');
INSERT INTO `syonline` VALUES ('dce78517-9763-469c-9aed-70803f24c2b7', '2016-02-08 13:00:45', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('de076462-f829-44d8-b3f3-629b96ee411b', '2015-12-05 16:02:34', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('e00243d0-8832-4c8f-b63b-a7b5ccb4b648', '2016-02-01 18:04:47', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('e054f281-1e71-4f1f-a458-b28f5d38badf', '2015-12-05 16:35:27', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('e1069e19-2f49-4d34-91e7-e7e33935bf30', '2015-12-05 16:45:43', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('e60d4590-b7cf-47b5-b6b6-84bc4b98beea', '2015-03-26 22:45:29', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('e8fe4fdf-25e5-4535-ae74-9f28f590b6d1', '2016-01-28 18:40:19', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('e94f85a9-7db3-4036-a2b1-17db4cf7b496', '2016-02-01 17:50:27', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('ea2ed14a-3c31-41fa-9b03-e175229d629b', '2015-12-05 11:18:34', '127.0.0.1', '孙宇', '0');
INSERT INTO `syonline` VALUES ('eba1e250-8b61-4c4e-9d6c-8243a94831b8', '2015-12-04 12:44:23', '127.0.0.1', '孙宇', '0');
INSERT INTO `syonline` VALUES ('ec453703-517d-4700-b347-4e86128d80f0', '2015-12-05 10:20:48', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('ec7c30fb-4c62-463b-80f8-8f681c8a9038', '2016-01-28 20:16:33', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('ecacad49-2cb7-4fc5-b7e1-5543ba9eaf43', '2015-12-05 11:20:25', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('ecf1bdd7-da6c-4670-b190-c520707a58e2', '2015-12-05 16:35:13', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('ee02e474-67b7-4002-bd02-348cf7f26b90', '2015-03-24 23:44:10', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('ef487196-88c2-4368-8fc6-05dfb7b3c3ee', '2016-02-10 09:37:52', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('efc9db04-e510-4633-8c62-b9061878a367', '2015-03-24 23:38:44', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('f0560df0-4729-439d-89da-3e959d769441', '2016-01-27 19:54:39', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('f1575fad-ff36-404f-925d-4cebd15cd69a', '2016-02-11 22:50:19', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('f35b033c-f4f3-44af-ac0b-83f9d212b8a2', '2015-12-04 12:46:16', '127.0.0.1', '孙宇', '1');
INSERT INTO `syonline` VALUES ('f3c6a4e6-2861-47f1-8357-acd53a25dd8f', '2015-12-05 11:24:00', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('f4ae31ec-73a8-4c0e-ab32-bef7cb29d7c4', '2015-12-05 11:29:36', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('f6979bcf-7beb-45a2-a378-4a302bfa21ee', '2016-02-09 00:04:49', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('f6d41ba2-ae10-4010-8326-2b766693ad8f', '2016-01-28 18:57:23', '127.0.0.1', 'lyq', '1');
INSERT INTO `syonline` VALUES ('f7471fc8-33c1-41d9-873b-4a6d1df7830f', '2015-12-04 12:47:49', '127.0.0.1', '孙宇', '0');
INSERT INTO `syonline` VALUES ('fc939147-7431-41b0-8567-2189b0a133d1', '2016-07-10 17:43:47', '本地', 'lyq', '1');
INSERT INTO `syonline` VALUES ('fcab9ec2-a20b-49a1-a920-b41dbeb3505c', '2015-12-05 11:17:58', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('fd348bbb-5105-4ea3-98e2-02c762d2357a', '2016-02-09 00:01:21', '127.0.0.1', 'lyq', '0');
INSERT INTO `syonline` VALUES ('ff52eaf3-77ab-4814-b33a-03d2d64980d1', '2016-02-08 13:13:50', '127.0.0.1', 'lyq', '1');

-- ----------------------------
-- Table structure for syorganization
-- ----------------------------
DROP TABLE IF EXISTS `syorganization`;
CREATE TABLE `syorganization` (
  `ID` varchar(36) NOT NULL,
  `ADDRESS` varchar(200) DEFAULT NULL,
  `CODE` varchar(200) DEFAULT NULL,
  `CREATEDATETIME` datetime DEFAULT NULL,
  `ICONCLS` varchar(100) DEFAULT NULL,
  `NAME` varchar(200) DEFAULT NULL,
  `SEQ` int(11) DEFAULT NULL,
  `UPDATEDATETIME` datetime DEFAULT NULL,
  `SYORGANIZATION_ID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_acf7qlb04quthktalwx8c7q69` (`SYORGANIZATION_ID`),
  CONSTRAINT `FK_acf7qlb04quthktalwx8c7q69` FOREIGN KEY (`SYORGANIZATION_ID`) REFERENCES `syorganization` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syorganization
-- ----------------------------
INSERT INTO `syorganization` VALUES ('0', '机构地址', null, '2015-03-24 23:19:44', 'ext-icon-brick', '一级机构', '0', '2015-12-05 11:50:17', null);
INSERT INTO `syorganization` VALUES ('fa6f6408-cb17-44c0-872f-45912ce51685', '海丰梅陇', 'XX', '2016-01-28 20:02:23', 'ext-icon-bullet_blue', '小学', '100', '2016-01-28 20:02:23', '0');

-- ----------------------------
-- Table structure for syorganization_syresource
-- ----------------------------
DROP TABLE IF EXISTS `syorganization_syresource`;
CREATE TABLE `syorganization_syresource` (
  `SYRESOURCE_ID` varchar(36) NOT NULL,
  `SYORGANIZATION_ID` varchar(36) NOT NULL,
  PRIMARY KEY (`SYORGANIZATION_ID`,`SYRESOURCE_ID`),
  KEY `FK_acpjp8a7fjo0cnn02eb0ia6uf` (`SYORGANIZATION_ID`),
  KEY `FK_m4mfglk7odi78d8pk9pif44vc` (`SYRESOURCE_ID`),
  CONSTRAINT `FK_acpjp8a7fjo0cnn02eb0ia6uf` FOREIGN KEY (`SYORGANIZATION_ID`) REFERENCES `syorganization` (`ID`),
  CONSTRAINT `FK_m4mfglk7odi78d8pk9pif44vc` FOREIGN KEY (`SYRESOURCE_ID`) REFERENCES `syresource` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syorganization_syresource
-- ----------------------------
INSERT INTO `syorganization_syresource` VALUES ('jgck', '0');
INSERT INTO `syorganization_syresource` VALUES ('jggl', '0');
INSERT INTO `syorganization_syresource` VALUES ('jglb', '0');
INSERT INTO `syorganization_syresource` VALUES ('jsck', '0');
INSERT INTO `syorganization_syresource` VALUES ('jsgl', '0');
INSERT INTO `syorganization_syresource` VALUES ('jslb', '0');
INSERT INTO `syorganization_syresource` VALUES ('xtgl', '0');
INSERT INTO `syorganization_syresource` VALUES ('yhck', '0');
INSERT INTO `syorganization_syresource` VALUES ('yhgl', '0');
INSERT INTO `syorganization_syresource` VALUES ('yhlb', '0');
INSERT INTO `syorganization_syresource` VALUES ('zyck', '0');
INSERT INTO `syorganization_syresource` VALUES ('zygl', '0');
INSERT INTO `syorganization_syresource` VALUES ('zylb', '0');

-- ----------------------------
-- Table structure for syresource
-- ----------------------------
DROP TABLE IF EXISTS `syresource`;
CREATE TABLE `syresource` (
  `ID` varchar(36) NOT NULL,
  `CREATEDATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `DESCRIPTION` varchar(200) DEFAULT NULL COMMENT '注释',
  `ICONCLS` varchar(100) DEFAULT NULL COMMENT '图标',
  `NAME` varchar(100) NOT NULL COMMENT '名称',
  `SEQ` int(11) DEFAULT NULL COMMENT '排序',
  `TARGET` varchar(100) DEFAULT NULL COMMENT '目标',
  `UPDATEDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `URL` varchar(200) DEFAULT NULL COMMENT '地址',
  `SYRESOURCE_ID` varchar(36) DEFAULT NULL COMMENT '资源id',
  `SYRESOURCETYPE_ID` varchar(36) DEFAULT NULL COMMENT '资源类型',
  PRIMARY KEY (`ID`),
  KEY `FK_n8kk2inhw4y4gax3nra2etfup` (`SYRESOURCE_ID`),
  KEY `FK_93qfpiiuk3rwb32gc5mcmmlgh` (`SYRESOURCETYPE_ID`),
  CONSTRAINT `FK_93qfpiiuk3rwb32gc5mcmmlgh` FOREIGN KEY (`SYRESOURCETYPE_ID`) REFERENCES `syresourcetype` (`ID`),
  CONSTRAINT `FK_n8kk2inhw4y4gax3nra2etfup` FOREIGN KEY (`SYRESOURCE_ID`) REFERENCES `syresource` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syresource
-- ----------------------------
INSERT INTO `syresource` VALUES ('0f59e61e-10a4-4f0d-964e-01cd91b2db09', '2016-07-10 16:47:39', '账号信息', 'ext-icon-key', '账号管理', '100', null, '2016-07-10 16:47:39', '/securityJsp/passkeeper/lyqAccount/lyqaccount.jsp', 'd48b4c67-7bde-4ee8-bdb8-826cbd2ffa64', '0');
INSERT INTO `syresource` VALUES ('22ba0221-0ed6-46d7-822b-c64cc60b8c5c', '2015-03-26 23:06:49', '添加账户', 'ext-icon-bullet_wrench', '添加账户', '102', null, '2015-03-26 23:06:49', '/account/account!save', '27117480-3cce-4ea8-b250-dd5afff425f9', '1');
INSERT INTO `syresource` VALUES ('27117480-3cce-4ea8-b250-dd5afff425f9', '2015-03-26 22:42:23', '账户管理', 'ext-icon-money', '账户管理', '100', null, '2015-03-26 22:43:05', '/securityJsp/account/account.jsp', 'ce0622dc-ec8f-4128-beae-b465f6b05b98', '0');
INSERT INTO `syresource` VALUES ('347c1b44-dde2-4107-b6b4-6c85cfac27ac', '2015-03-26 23:07:50', '编辑账户', 'ext-icon-bullet_wrench', '编辑账户', '103', null, '2015-03-26 23:07:50', '/account/account!update', '27117480-3cce-4ea8-b250-dd5afff425f9', '1');
INSERT INTO `syresource` VALUES ('5de86236-d8ed-4428-97dd-7bb0890f5381', '2015-12-05 09:50:29', '查看收支录入列表权限', 'ext-icon-cog', '收支列表', '100', null, '2015-12-05 16:44:53', '/account/daily/daily!grid', 'cb8f74c0-362c-4547-b007-2f91605242e9', '1');
INSERT INTO `syresource` VALUES ('694c7c45-5516-4da4-8da8-fd911a1a1685', '2015-03-23 23:15:11', '删除员工', 'ext-icon-bullet_wrench', '删除员工', '104', null, '2015-03-23 23:15:11', '/oa/employee!delete', '892258ed-27e3-4a5e-93ea-c82525884810', '1');
INSERT INTO `syresource` VALUES ('7acb96ef-9108-421e-a8c0-19936aaa8ba1', '2015-03-23 23:15:52', '查看员工', 'ext-icon-bullet_wrench', '查看员工', '105', null, '2015-03-23 23:16:03', '/oa/employee!getById', '892258ed-27e3-4a5e-93ea-c82525884810', '1');
INSERT INTO `syresource` VALUES ('7de7def6-7d80-43bd-819a-3cdb25553cf4', '2015-03-26 23:09:34', '查看账户', 'ext-icon-bullet_wrench', '查看账户', '105', null, '2015-03-26 23:09:34', '/account/account!getById', '27117480-3cce-4ea8-b250-dd5afff425f9', '1');
INSERT INTO `syresource` VALUES ('892258ed-27e3-4a5e-93ea-c82525884810', '2015-03-23 22:58:48', '员工列表', 'ext-icon-user', '员工管理', '100', null, '2015-03-23 23:02:23', '/securityJsp/oa/employee.jsp', 'xtgl', '0');
INSERT INTO `syresource` VALUES ('913f3e16-24d4-4a12-bec1-5221df8d5ba4', '2015-03-23 23:01:57', '编辑员工', 'ext-icon-bullet_wrench', '编辑员工', '103', null, '2015-03-23 23:14:23', '/oa/employee!update', '892258ed-27e3-4a5e-93ea-c82525884810', '1');
INSERT INTO `syresource` VALUES ('91fac94e-519e-4acb-aba4-56640d92d802', '2015-12-05 10:00:48', '删除收支', 'ext-icon-cog', '删除收支', '103', null, '2015-12-05 16:45:37', '/account/daily/daily!delete', 'cb8f74c0-362c-4547-b007-2f91605242e9', '1');
INSERT INTO `syresource` VALUES ('9349eab9-cd3a-444a-9d7a-796a11fa8123', '2015-12-05 09:59:57', '编辑收支', 'ext-icon-cog', '编辑收支', '102', null, '2015-12-05 16:45:16', '/account/daily/daily!update', 'cb8f74c0-362c-4547-b007-2f91605242e9', '1');
INSERT INTO `syresource` VALUES ('actionConfigBrowser', '2015-03-24 23:19:44', 'Action映射情况监控', 'ext-icon-monitor_lightning', 'Action映射监控', '3', '', '2015-03-24 23:19:44', '/config-browser/showConstants.sy', 'xtjk', '0');
INSERT INTO `syresource` VALUES ('appDemo', '2015-03-24 23:19:44', '桌面演示demo', 'ext-icon-award_star_gold_1', '桌面Demo', '4', '_blank', '2015-03-24 23:19:44', 'http://app.btboys.com', 'demo', '0');
INSERT INTO `syresource` VALUES ('c6141369-36d9-4608-83dd-4566a2a194fd', '2015-12-05 10:01:45', '查看收支', 'ext-icon-cog', '查看收支', '104', null, '2015-12-05 16:45:25', '/account/daily/daily!getById', 'cb8f74c0-362c-4547-b007-2f91605242e9', '1');
INSERT INTO `syresource` VALUES ('cb67da07-b11e-4575-b7f1-cad245686bca', '2015-03-23 23:05:01', '添加员工', 'ext-icon-bullet_wrench', '添加员工', '102', null, '2015-03-23 23:05:01', '/oa/employee!save', '892258ed-27e3-4a5e-93ea-c82525884810', '1');
INSERT INTO `syresource` VALUES ('cb8f74c0-362c-4547-b007-2f91605242e9', '2015-12-05 09:46:47', '资金流水', 'ext-icon-anchor', '收支录入', '101', null, '2015-12-05 09:47:01', '/securityJsp/account/daily/daily.jsp', 'ce0622dc-ec8f-4128-beae-b465f6b05b98', '0');
INSERT INTO `syresource` VALUES ('ce0622dc-ec8f-4128-beae-b465f6b05b98', '2015-03-26 22:39:53', '现金日记账', 'ext-icon-money', '现金日记账', '1', null, '2015-05-19 06:30:18', null, null, '0');
INSERT INTO `syresource` VALUES ('cxfDemo', '2015-03-24 23:19:44', 'Apache CXF DEMO', 'ext-icon-world', 'ApacheCXF示例', '0', 'CXFDemo', '2015-03-24 23:19:44', '/ws', 'demo', '0');
INSERT INTO `syresource` VALUES ('d1a379d6-b877-4730-8bbc-aae927ec5727', '2015-03-23 23:00:30', '用户列表', 'ext-icon-bullet_wrench', '员工列表', '101', null, '2015-03-23 23:00:30', '/oa/employee!grid', '892258ed-27e3-4a5e-93ea-c82525884810', '1');
INSERT INTO `syresource` VALUES ('d48b4c67-7bde-4ee8-bdb8-826cbd2ffa64', '2016-07-10 16:39:44', '账号管家', 'ext-icon-book_key', '账号管家', '2', null, '2016-07-10 16:39:44', null, null, '0');
INSERT INTO `syresource` VALUES ('da72cff2-de02-4209-8c06-79c1a0bbdcc3', '2015-12-05 09:59:02', '添加收支', 'ext-icon-cog', '添加收支', '101', null, '2015-12-05 16:45:04', '/account/daily/daily!save', 'cb8f74c0-362c-4547-b007-2f91605242e9', '1');
INSERT INTO `syresource` VALUES ('demo', '2015-03-24 23:19:44', 'EasyUI还能做到更多，只有你想不到，没有做不到！', 'ext-icon-asterisk_orange', '其他示例', '202', '', '2015-03-24 23:19:44', '/welcome.jsp', null, '0');
INSERT INTO `syresource` VALUES ('druid', '2015-03-24 23:19:44', '监控数据源', 'ext-icon-monitor_link', '数据源监控', '2', '', '2015-03-24 23:19:44', '/druid', 'xtjk', '0');
INSERT INTO `syresource` VALUES ('e6646241-3a63-4fb0-a900-46ba1def5f01', '2015-03-26 23:08:42', '删除账户', 'ext-icon-bullet_wrench', '删除账户', '104', null, '2015-03-26 23:08:42', '/account/account!delete', '27117480-3cce-4ea8-b250-dd5afff425f9', '1');
INSERT INTO `syresource` VALUES ('easyuiAPI', '2015-03-24 23:19:44', 'EasyUI官方API', 'ext-icon-medal_bronze_2', 'EasyUI官方API', '6', '', '2015-03-24 23:19:44', 'http://jeasyui.com/documentation/index.php', 'demo', '0');
INSERT INTO `syresource` VALUES ('easyuiDemo', '2015-03-24 23:19:44', 'EasyUI官方Demo', 'ext-icon-medal_bronze_1', 'EasyUI官方Demo', '5', '', '2015-03-24 23:19:44', 'http://jeasyui.com/demo/main/index.php', 'demo', '0');
INSERT INTO `syresource` VALUES ('easyuiDownload', '2015-03-24 23:19:44', 'EasyUI官方下载', 'ext-icon-medal_gold_1', 'EasyUI官方下载', '8', '', '2015-03-24 23:19:44', 'http://jeasyui.com/download/index.php', 'demo', '0');
INSERT INTO `syresource` VALUES ('easyuiExtension', '2015-03-24 23:19:44', 'EasyUI其他扩展', 'ext-icon-medal_gold_2', 'EasyUI其他扩展', '9', '', '2015-03-24 23:19:44', 'http://jeasyui.com/extension/index.php', 'demo', '0');
INSERT INTO `syresource` VALUES ('easyuiForum', '2015-03-24 23:19:44', 'EasyUI官方论坛', 'ext-icon-medal_gold_3', 'EasyUI官方论坛', '10', '', '2015-03-24 23:19:44', 'http://www.jeasyui.com/forum/index.php', 'demo', '0');
INSERT INTO `syresource` VALUES ('easyuiTutorial', '2015-03-24 23:19:44', 'EasyUI辅导', 'ext-icon-medal_bronze_3', 'EasyUI进阶DEMO', '7', '', '2015-03-24 23:19:44', 'http://jeasyui.com/tutorial/index.php', 'demo', '0');
INSERT INTO `syresource` VALUES ('edd68e9e-0080-44e6-a093-5fe228dcf168', '2016-02-12 11:43:51', '按账户来统计流水的收入和支出小计', 'ext-icon-creditcards', '账户流水统计表', '105', null, '2016-02-12 11:43:51', '/securityJsp/account/report/accountTotal.jsp', 'ce0622dc-ec8f-4128-beae-b465f6b05b98', '0');
INSERT INTO `syresource` VALUES ('fab2843e-1b18-4e93-b232-9b19efe9d8ed', '2015-03-26 22:44:57', '账户列表', 'ext-icon-bullet_wrench', '账户列表', '101', null, '2015-03-26 22:44:57', '/account/account!grid', '27117480-3cce-4ea8-b250-dd5afff425f9', '1');
INSERT INTO `syresource` VALUES ('jgbj', '2015-03-24 23:19:43', '编辑机构', 'ext-icon-bullet_wrench', '编辑机构', '2', '', '2015-03-24 23:19:43', '/base/syorganization!update', 'jggl', '1');
INSERT INTO `syresource` VALUES ('jgck', '2015-03-24 23:19:43', '查看机构', 'ext-icon-bullet_wrench', '查看机构', '4', '', '2015-03-24 23:19:43', '/base/syorganization!getById', 'jggl', '1');
INSERT INTO `syresource` VALUES ('jggl', '2015-03-24 23:19:43', '管理系统中用户的机构', 'ext-icon-group_link', '机构管理', '3', '', '2015-03-24 23:19:43', '/securityJsp/base/Syorganization.jsp', 'xtgl', '0');
INSERT INTO `syresource` VALUES ('jglb', '2015-03-24 23:19:43', '查询机构列表', 'ext-icon-bullet_wrench', '机构列表', '0', '', '2015-03-24 23:19:43', '/base/syorganization!treeGrid', 'jggl', '1');
INSERT INTO `syresource` VALUES ('jgsc', '2015-03-24 23:19:43', '删除机构', 'ext-icon-bullet_wrench', '删除机构', '3', '', '2015-03-24 23:19:43', '/base/syorganization!delete', 'jggl', '1');
INSERT INTO `syresource` VALUES ('jgsq', '2015-03-24 23:19:43', '机构授权', 'ext-icon-bullet_wrench', '机构授权', '5', '', '2015-03-24 23:19:43', '/base/syorganization!grant', 'jggl', '1');
INSERT INTO `syresource` VALUES ('jgtj', '2015-03-24 23:19:43', '添加机构', 'ext-icon-bullet_wrench', '添加机构', '1', '', '2015-03-24 23:19:43', '/base/syorganization!save', 'jggl', '1');
INSERT INTO `syresource` VALUES ('jsbj', '2015-03-24 23:19:43', '编辑角色', 'ext-icon-bullet_wrench', '编辑角色', '2', '', '2015-03-24 23:19:43', '/base/syrole!update', 'jsgl', '1');
INSERT INTO `syresource` VALUES ('jsck', '2015-03-24 23:19:43', '查看角色', 'ext-icon-bullet_wrench', '查看角色', '4', '', '2015-03-24 23:19:43', '/base/syrole!getById', 'jsgl', '1');
INSERT INTO `syresource` VALUES ('jsgl', '2015-03-24 23:19:43', '管理系统中用户的角色', 'ext-icon-tux', '角色管理', '2', '', '2015-03-24 23:19:43', '/securityJsp/base/Syrole.jsp', 'xtgl', '0');
INSERT INTO `syresource` VALUES ('jslb', '2015-03-24 23:19:43', '查询角色列表', 'ext-icon-bullet_wrench', '角色列表', '0', '', '2015-03-24 23:19:43', '/base/syrole!grid', 'jsgl', '1');
INSERT INTO `syresource` VALUES ('jssc', '2015-03-24 23:19:43', '删除角色', 'ext-icon-bullet_wrench', '删除角色', '3', '', '2015-03-24 23:19:43', '/base/syrole!delete', 'jsgl', '1');
INSERT INTO `syresource` VALUES ('jssq', '2015-03-24 23:19:43', '角色授权', 'ext-icon-bullet_wrench', '角色授权', '5', '', '2015-03-24 23:19:43', '/base/syrole!grant', 'jsgl', '1');
INSERT INTO `syresource` VALUES ('jstj', '2015-03-24 23:19:43', '添加角色', 'ext-icon-bullet_wrench', '添加角色', '1', '', '2015-03-24 23:19:43', '/base/syrole!save', 'jsgl', '1');
INSERT INTO `syresource` VALUES ('lyDemo', '2015-03-24 23:19:44', '针对EasyUI二次开发的DEMO', 'ext-icon-award_star_bronze_1', '流云的Demo', '1', '_blank', '2015-03-24 23:19:44', 'http://jqext.sinaapp.com', 'demo', '0');
INSERT INTO `syresource` VALUES ('monitoring', '2015-03-24 23:19:44', '监控项目', 'ext-icon-monitor_error', '项目监控', '1', '', '2015-03-24 23:19:44', '/monitoring', 'xtjk', '0');
INSERT INTO `syresource` VALUES ('online', '2015-03-24 23:19:44', '监控用户登录、注销', 'ext-icon-chart_line', '用户登录历史监控', '4', '', '2015-03-24 23:19:44', '/securityJsp/base/Syonline.jsp', 'xtjk', '0');
INSERT INTO `syresource` VALUES ('onlineGrid', '2015-03-24 23:19:44', '用户登录、注销历史记录列表', 'ext-icon-bullet_wrench', '用户登录历史列表', '0', '', '2015-03-24 23:19:44', '/base/syonline!grid', 'online', '1');
INSERT INTO `syresource` VALUES ('phpDemo', '2015-03-24 23:19:44', '夏悸的php demo', 'ext-icon-award_star_bronze_3', 'phpDemo', '3', '_blank', '2015-03-24 23:19:44', 'http://php-easyui-demo.jeasyuicn.com', 'demo', '0');
INSERT INTO `syresource` VALUES ('syproDemo', '2015-03-24 23:19:44', 'SpringMvc+Spring3+Hibernate4+Maven', 'ext-icon-award_star_bronze_2', 'SyProDemo', '2', '_blank', '2015-03-24 23:19:44', 'http://sypro.jeasyuicn.com', 'demo', '0');
INSERT INTO `syresource` VALUES ('userCreateDatetimeChart', '2015-03-24 23:19:44', '用户注册时间分布报表', 'ext-icon-chart_bar', '注册时间分布', '1', '', '2015-03-24 23:19:44', '/securityJsp/base/chart/userCreateDatetimeChart.jsp', 'xtbb', '0');
INSERT INTO `syresource` VALUES ('userRoleChart', '2015-03-24 23:19:44', '用户角色分布', 'ext-icon-chart_pie', '用户角色分布', '2', '', '2015-03-24 23:19:44', '/securityJsp/base/chart/userRoleChart.jsp', 'xtbb', '0');
INSERT INTO `syresource` VALUES ('xtbb', '2015-03-24 23:19:44', '查看系统相关报表图标', 'ext-icon-chart_curve', '系统报表', '201', '', '2015-03-24 23:19:44', '/welcome.jsp', null, '0');
INSERT INTO `syresource` VALUES ('xtgl', '2015-03-24 23:19:43', '管理系统的资源、角色、机构、用户等信息', 'ext-icon-application_view_tile', '系统管理', '0', '', '2015-03-24 23:19:43', '/welcome.jsp', null, '0');
INSERT INTO `syresource` VALUES ('xtjk', '2015-03-24 23:19:44', '监控系统运行情况等信息', 'ext-icon-monitor', '系统监控', '200', '', '2015-03-24 23:19:44', '/welcome.jsp', null, '0');
INSERT INTO `syresource` VALUES ('yhbj', '2015-03-24 23:19:44', '编辑用户', 'ext-icon-bullet_wrench', '编辑用户', '2', '', '2015-03-24 23:19:44', '/base/syuser!update', 'yhgl', '1');
INSERT INTO `syresource` VALUES ('yhck', '2015-03-24 23:19:44', '查看用户', 'ext-icon-bullet_wrench', '查看用户', '4', '', '2015-03-24 23:19:44', '/base/syuser!getById', 'yhgl', '1');
INSERT INTO `syresource` VALUES ('yhgl', '2015-03-24 23:19:43', '管理系统中用户的用户', 'ext-icon-user_suit', '用户管理', '4', '', '2015-03-24 23:19:43', '/securityJsp/base/Syuser.jsp', 'xtgl', '0');
INSERT INTO `syresource` VALUES ('yhjg', '2015-03-24 23:19:44', '编辑用户机构', 'ext-icon-bullet_wrench', '用户机构', '6', '', '2015-03-24 23:19:44', '/base/syuser!grantOrganization', 'yhgl', '1');
INSERT INTO `syresource` VALUES ('yhjs', '2015-03-24 23:19:44', '编辑用户角色', 'ext-icon-bullet_wrench', '用户角色', '5', '', '2015-03-24 23:19:44', '/base/syuser!grantRole', 'yhgl', '1');
INSERT INTO `syresource` VALUES ('yhlb', '2015-03-24 23:19:43', '查询用户列表', 'ext-icon-bullet_wrench', '用户列表', '0', '', '2015-03-24 23:19:43', '/base/syuser!grid', 'yhgl', '1');
INSERT INTO `syresource` VALUES ('yhsc', '2015-03-24 23:19:44', '删除用户', 'ext-icon-bullet_wrench', '删除用户', '3', '', '2015-03-24 23:19:44', '/base/syuser!delete', 'yhgl', '1');
INSERT INTO `syresource` VALUES ('yhtj', '2015-03-24 23:19:43', '添加用户', 'ext-icon-bullet_wrench', '添加用户', '1', '', '2015-03-24 23:19:43', '/base/syuser!save', 'yhgl', '1');
INSERT INTO `syresource` VALUES ('zhbj', '2016-07-10 16:59:21', '编辑账号', 'ext-icon-bullet_wrench', '编辑账号', '103', null, '2016-07-10 16:59:21', '/passkeeper/lyqaccount!update', '0f59e61e-10a4-4f0d-964e-01cd91b2db09', '1');
INSERT INTO `syresource` VALUES ('zhck', '2016-07-10 16:59:21', '查看账号', 'ext-icon-bullet_wrench', '查看账号', '105', null, '2016-07-10 16:59:21', '/passkeeper/lyqaccount!getById', '0f59e61e-10a4-4f0d-964e-01cd91b2db09', '1');
INSERT INTO `syresource` VALUES ('zhlb', '2016-07-10 16:59:21', '账号列表', 'ext-icon-bullet_wrench', '账号列表', '101', null, '2016-07-10 16:59:21', '/passkeeper/lyqaccount!grid', '0f59e61e-10a4-4f0d-964e-01cd91b2db09', '1');
INSERT INTO `syresource` VALUES ('zhsc', '2016-07-10 16:59:21', '删除账号', 'ext-icon-bullet_wrench', '删除账号', '104', null, '2016-07-10 16:59:21', '/passkeeper/lyqaccount!delete', '0f59e61e-10a4-4f0d-964e-01cd91b2db09', '1');
INSERT INTO `syresource` VALUES ('zhtj', '2016-07-10 16:59:21', '添加账号', 'ext-icon-bullet_wrench', '添加账号', '102', null, '2016-07-10 16:59:21', '/passkeeper/lyqaccount!save', '0f59e61e-10a4-4f0d-964e-01cd91b2db09', '1');
INSERT INTO `syresource` VALUES ('zybj', '2015-03-24 23:19:43', '编辑资源', 'ext-icon-bullet_wrench', '编辑资源', '2', '', '2015-03-24 23:19:43', '/base/syresource!update', 'zygl', '1');
INSERT INTO `syresource` VALUES ('zyck', '2015-03-24 23:19:43', '查看资源', 'ext-icon-bullet_wrench', '查看资源', '4', '', '2015-03-24 23:19:43', '/base/syresource!getById', 'zygl', '1');
INSERT INTO `syresource` VALUES ('zygl', '2015-03-24 23:19:43', '管理系统的资源', 'ext-icon-newspaper_link', '资源管理', '1', '', '2015-03-24 23:19:43', '/securityJsp/base/Syresource.jsp', 'xtgl', '0');
INSERT INTO `syresource` VALUES ('zylb', '2015-03-24 23:19:43', '查询资源', 'ext-icon-bullet_wrench', '资源列表', '0', '', '2015-03-24 23:19:43', '/base/syresource!treeGrid', 'zygl', '1');
INSERT INTO `syresource` VALUES ('zysc', '2015-03-24 23:19:43', '删除资源', 'ext-icon-bullet_wrench', '删除资源', '3', '', '2015-03-24 23:19:43', '/base/syresource!delete', 'zygl', '1');
INSERT INTO `syresource` VALUES ('zytj', '2015-03-24 23:19:43', '添加资源', 'ext-icon-bullet_wrench', '添加资源', '1', '', '2015-03-24 23:19:43', '/base/syresource!save', 'zygl', '1');

-- ----------------------------
-- Table structure for syresourcetype
-- ----------------------------
DROP TABLE IF EXISTS `syresourcetype`;
CREATE TABLE `syresourcetype` (
  `ID` varchar(36) NOT NULL,
  `CREATEDATETIME` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  `NAME` varchar(100) NOT NULL,
  `UPDATEDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syresourcetype
-- ----------------------------
INSERT INTO `syresourcetype` VALUES ('0', '2015-03-24 23:19:43', '菜单类型会显示在系统首页左侧菜单中', '菜单', '2015-03-24 23:19:43');
INSERT INTO `syresourcetype` VALUES ('1', '2015-03-24 23:19:43', '功能类型不会显示在系统首页左侧菜单中', '功能', '2015-03-24 23:19:43');

-- ----------------------------
-- Table structure for syrole
-- ----------------------------
DROP TABLE IF EXISTS `syrole`;
CREATE TABLE `syrole` (
  `ID` varchar(36) NOT NULL,
  `CREATEDATETIME` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  `ICONCLS` varchar(100) DEFAULT NULL,
  `NAME` varchar(100) NOT NULL,
  `SEQ` int(11) DEFAULT NULL,
  `UPDATEDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syrole
-- ----------------------------
INSERT INTO `syrole` VALUES ('0', '2015-03-24 23:19:44', '拥有系统所有权限', null, '超管', '0', '2015-03-24 23:19:44');
INSERT INTO `syrole` VALUES ('1', '2015-03-24 23:19:44', '只有查看权限', null, 'Guest', '1', '2015-03-24 23:19:44');
INSERT INTO `syrole` VALUES ('2', '2015-03-24 23:19:44', '只有资源管理权限', null, 'admin1', '2', '2015-03-24 23:19:44');
INSERT INTO `syrole` VALUES ('3', '2015-03-24 23:19:44', '只有角色管理权限', null, 'admin2', '3', '2015-03-24 23:19:44');
INSERT INTO `syrole` VALUES ('4', '2015-03-24 23:19:44', '只有机构管理权限', null, 'admin3', '4', '2015-05-19 06:07:24');
INSERT INTO `syrole` VALUES ('5', '2015-03-24 23:19:44', '只有用户管理权限', null, 'admin4', '5', '2015-03-24 23:19:44');
INSERT INTO `syrole` VALUES ('6', '2015-03-24 23:19:44', '只有系统监控权限', null, 'admin5', '6', '2015-03-24 23:19:44');
INSERT INTO `syrole` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', '2016-02-12 11:45:51', '管理员1', null, '管理员', '100', '2016-02-12 11:45:51');

-- ----------------------------
-- Table structure for syrole_syresource
-- ----------------------------
DROP TABLE IF EXISTS `syrole_syresource`;
CREATE TABLE `syrole_syresource` (
  `SYROLE_ID` varchar(36) NOT NULL,
  `SYRESOURCE_ID` varchar(36) NOT NULL,
  PRIMARY KEY (`SYRESOURCE_ID`,`SYROLE_ID`),
  KEY `FK_kkrartsovl2frhfvriqdi7jwl` (`SYRESOURCE_ID`),
  KEY `FK_r139h669pg4ts6mbvn3ip5472` (`SYROLE_ID`),
  CONSTRAINT `FK_kkrartsovl2frhfvriqdi7jwl` FOREIGN KEY (`SYRESOURCE_ID`) REFERENCES `syresource` (`ID`),
  CONSTRAINT `FK_r139h669pg4ts6mbvn3ip5472` FOREIGN KEY (`SYROLE_ID`) REFERENCES `syrole` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syrole_syresource
-- ----------------------------
INSERT INTO `syrole_syresource` VALUES ('0', '0f59e61e-10a4-4f0d-964e-01cd91b2db09');
INSERT INTO `syrole_syresource` VALUES ('0', '22ba0221-0ed6-46d7-822b-c64cc60b8c5c');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', '22ba0221-0ed6-46d7-822b-c64cc60b8c5c');
INSERT INTO `syrole_syresource` VALUES ('0', '27117480-3cce-4ea8-b250-dd5afff425f9');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', '27117480-3cce-4ea8-b250-dd5afff425f9');
INSERT INTO `syrole_syresource` VALUES ('0', '347c1b44-dde2-4107-b6b4-6c85cfac27ac');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', '347c1b44-dde2-4107-b6b4-6c85cfac27ac');
INSERT INTO `syrole_syresource` VALUES ('0', '5de86236-d8ed-4428-97dd-7bb0890f5381');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', '5de86236-d8ed-4428-97dd-7bb0890f5381');
INSERT INTO `syrole_syresource` VALUES ('0', '694c7c45-5516-4da4-8da8-fd911a1a1685');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', '694c7c45-5516-4da4-8da8-fd911a1a1685');
INSERT INTO `syrole_syresource` VALUES ('0', '7acb96ef-9108-421e-a8c0-19936aaa8ba1');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', '7acb96ef-9108-421e-a8c0-19936aaa8ba1');
INSERT INTO `syrole_syresource` VALUES ('0', '7de7def6-7d80-43bd-819a-3cdb25553cf4');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', '7de7def6-7d80-43bd-819a-3cdb25553cf4');
INSERT INTO `syrole_syresource` VALUES ('0', '892258ed-27e3-4a5e-93ea-c82525884810');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', '892258ed-27e3-4a5e-93ea-c82525884810');
INSERT INTO `syrole_syresource` VALUES ('0', '913f3e16-24d4-4a12-bec1-5221df8d5ba4');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', '913f3e16-24d4-4a12-bec1-5221df8d5ba4');
INSERT INTO `syrole_syresource` VALUES ('0', '91fac94e-519e-4acb-aba4-56640d92d802');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', '91fac94e-519e-4acb-aba4-56640d92d802');
INSERT INTO `syrole_syresource` VALUES ('0', '9349eab9-cd3a-444a-9d7a-796a11fa8123');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', '9349eab9-cd3a-444a-9d7a-796a11fa8123');
INSERT INTO `syrole_syresource` VALUES ('0', 'actionConfigBrowser');
INSERT INTO `syrole_syresource` VALUES ('6', 'actionConfigBrowser');
INSERT INTO `syrole_syresource` VALUES ('0', 'appDemo');
INSERT INTO `syrole_syresource` VALUES ('1', 'appDemo');
INSERT INTO `syrole_syresource` VALUES ('0', 'c6141369-36d9-4608-83dd-4566a2a194fd');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'c6141369-36d9-4608-83dd-4566a2a194fd');
INSERT INTO `syrole_syresource` VALUES ('0', 'cb67da07-b11e-4575-b7f1-cad245686bca');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'cb67da07-b11e-4575-b7f1-cad245686bca');
INSERT INTO `syrole_syresource` VALUES ('0', 'cb8f74c0-362c-4547-b007-2f91605242e9');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'cb8f74c0-362c-4547-b007-2f91605242e9');
INSERT INTO `syrole_syresource` VALUES ('0', 'ce0622dc-ec8f-4128-beae-b465f6b05b98');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'ce0622dc-ec8f-4128-beae-b465f6b05b98');
INSERT INTO `syrole_syresource` VALUES ('0', 'cxfDemo');
INSERT INTO `syrole_syresource` VALUES ('0', 'd1a379d6-b877-4730-8bbc-aae927ec5727');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'd1a379d6-b877-4730-8bbc-aae927ec5727');
INSERT INTO `syrole_syresource` VALUES ('0', 'd48b4c67-7bde-4ee8-bdb8-826cbd2ffa64');
INSERT INTO `syrole_syresource` VALUES ('0', 'da72cff2-de02-4209-8c06-79c1a0bbdcc3');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'da72cff2-de02-4209-8c06-79c1a0bbdcc3');
INSERT INTO `syrole_syresource` VALUES ('0', 'demo');
INSERT INTO `syrole_syresource` VALUES ('1', 'demo');
INSERT INTO `syrole_syresource` VALUES ('0', 'druid');
INSERT INTO `syrole_syresource` VALUES ('6', 'druid');
INSERT INTO `syrole_syresource` VALUES ('0', 'e6646241-3a63-4fb0-a900-46ba1def5f01');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'e6646241-3a63-4fb0-a900-46ba1def5f01');
INSERT INTO `syrole_syresource` VALUES ('0', 'easyuiAPI');
INSERT INTO `syrole_syresource` VALUES ('1', 'easyuiAPI');
INSERT INTO `syrole_syresource` VALUES ('0', 'easyuiDemo');
INSERT INTO `syrole_syresource` VALUES ('1', 'easyuiDemo');
INSERT INTO `syrole_syresource` VALUES ('0', 'easyuiDownload');
INSERT INTO `syrole_syresource` VALUES ('1', 'easyuiDownload');
INSERT INTO `syrole_syresource` VALUES ('0', 'easyuiExtension');
INSERT INTO `syrole_syresource` VALUES ('1', 'easyuiExtension');
INSERT INTO `syrole_syresource` VALUES ('0', 'easyuiForum');
INSERT INTO `syrole_syresource` VALUES ('1', 'easyuiForum');
INSERT INTO `syrole_syresource` VALUES ('0', 'easyuiTutorial');
INSERT INTO `syrole_syresource` VALUES ('1', 'easyuiTutorial');
INSERT INTO `syrole_syresource` VALUES ('0', 'edd68e9e-0080-44e6-a093-5fe228dcf168');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'edd68e9e-0080-44e6-a093-5fe228dcf168');
INSERT INTO `syrole_syresource` VALUES ('0', 'fab2843e-1b18-4e93-b232-9b19efe9d8ed');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'fab2843e-1b18-4e93-b232-9b19efe9d8ed');
INSERT INTO `syrole_syresource` VALUES ('0', 'jgbj');
INSERT INTO `syrole_syresource` VALUES ('4', 'jgbj');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'jgbj');
INSERT INTO `syrole_syresource` VALUES ('0', 'jgck');
INSERT INTO `syrole_syresource` VALUES ('1', 'jgck');
INSERT INTO `syrole_syresource` VALUES ('4', 'jgck');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'jgck');
INSERT INTO `syrole_syresource` VALUES ('0', 'jggl');
INSERT INTO `syrole_syresource` VALUES ('1', 'jggl');
INSERT INTO `syrole_syresource` VALUES ('4', 'jggl');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'jggl');
INSERT INTO `syrole_syresource` VALUES ('0', 'jglb');
INSERT INTO `syrole_syresource` VALUES ('1', 'jglb');
INSERT INTO `syrole_syresource` VALUES ('4', 'jglb');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'jglb');
INSERT INTO `syrole_syresource` VALUES ('0', 'jgsc');
INSERT INTO `syrole_syresource` VALUES ('4', 'jgsc');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'jgsc');
INSERT INTO `syrole_syresource` VALUES ('0', 'jgsq');
INSERT INTO `syrole_syresource` VALUES ('4', 'jgsq');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'jgsq');
INSERT INTO `syrole_syresource` VALUES ('0', 'jgtj');
INSERT INTO `syrole_syresource` VALUES ('4', 'jgtj');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'jgtj');
INSERT INTO `syrole_syresource` VALUES ('0', 'jsbj');
INSERT INTO `syrole_syresource` VALUES ('3', 'jsbj');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'jsbj');
INSERT INTO `syrole_syresource` VALUES ('0', 'jsck');
INSERT INTO `syrole_syresource` VALUES ('1', 'jsck');
INSERT INTO `syrole_syresource` VALUES ('3', 'jsck');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'jsck');
INSERT INTO `syrole_syresource` VALUES ('0', 'jsgl');
INSERT INTO `syrole_syresource` VALUES ('1', 'jsgl');
INSERT INTO `syrole_syresource` VALUES ('3', 'jsgl');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'jsgl');
INSERT INTO `syrole_syresource` VALUES ('0', 'jslb');
INSERT INTO `syrole_syresource` VALUES ('1', 'jslb');
INSERT INTO `syrole_syresource` VALUES ('3', 'jslb');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'jslb');
INSERT INTO `syrole_syresource` VALUES ('0', 'jssc');
INSERT INTO `syrole_syresource` VALUES ('3', 'jssc');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'jssc');
INSERT INTO `syrole_syresource` VALUES ('0', 'jssq');
INSERT INTO `syrole_syresource` VALUES ('3', 'jssq');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'jssq');
INSERT INTO `syrole_syresource` VALUES ('0', 'jstj');
INSERT INTO `syrole_syresource` VALUES ('3', 'jstj');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'jstj');
INSERT INTO `syrole_syresource` VALUES ('0', 'lyDemo');
INSERT INTO `syrole_syresource` VALUES ('1', 'lyDemo');
INSERT INTO `syrole_syresource` VALUES ('0', 'monitoring');
INSERT INTO `syrole_syresource` VALUES ('6', 'monitoring');
INSERT INTO `syrole_syresource` VALUES ('0', 'online');
INSERT INTO `syrole_syresource` VALUES ('6', 'online');
INSERT INTO `syrole_syresource` VALUES ('0', 'onlineGrid');
INSERT INTO `syrole_syresource` VALUES ('6', 'onlineGrid');
INSERT INTO `syrole_syresource` VALUES ('0', 'phpDemo');
INSERT INTO `syrole_syresource` VALUES ('1', 'phpDemo');
INSERT INTO `syrole_syresource` VALUES ('0', 'syproDemo');
INSERT INTO `syrole_syresource` VALUES ('1', 'syproDemo');
INSERT INTO `syrole_syresource` VALUES ('0', 'userCreateDatetimeChart');
INSERT INTO `syrole_syresource` VALUES ('0', 'userRoleChart');
INSERT INTO `syrole_syresource` VALUES ('0', 'xtbb');
INSERT INTO `syrole_syresource` VALUES ('0', 'xtgl');
INSERT INTO `syrole_syresource` VALUES ('1', 'xtgl');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'xtgl');
INSERT INTO `syrole_syresource` VALUES ('0', 'xtjk');
INSERT INTO `syrole_syresource` VALUES ('6', 'xtjk');
INSERT INTO `syrole_syresource` VALUES ('0', 'yhbj');
INSERT INTO `syrole_syresource` VALUES ('5', 'yhbj');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'yhbj');
INSERT INTO `syrole_syresource` VALUES ('0', 'yhck');
INSERT INTO `syrole_syresource` VALUES ('1', 'yhck');
INSERT INTO `syrole_syresource` VALUES ('5', 'yhck');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'yhck');
INSERT INTO `syrole_syresource` VALUES ('0', 'yhgl');
INSERT INTO `syrole_syresource` VALUES ('1', 'yhgl');
INSERT INTO `syrole_syresource` VALUES ('5', 'yhgl');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'yhgl');
INSERT INTO `syrole_syresource` VALUES ('0', 'yhjg');
INSERT INTO `syrole_syresource` VALUES ('5', 'yhjg');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'yhjg');
INSERT INTO `syrole_syresource` VALUES ('0', 'yhjs');
INSERT INTO `syrole_syresource` VALUES ('5', 'yhjs');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'yhjs');
INSERT INTO `syrole_syresource` VALUES ('0', 'yhlb');
INSERT INTO `syrole_syresource` VALUES ('1', 'yhlb');
INSERT INTO `syrole_syresource` VALUES ('5', 'yhlb');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'yhlb');
INSERT INTO `syrole_syresource` VALUES ('0', 'yhsc');
INSERT INTO `syrole_syresource` VALUES ('5', 'yhsc');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'yhsc');
INSERT INTO `syrole_syresource` VALUES ('0', 'yhtj');
INSERT INTO `syrole_syresource` VALUES ('5', 'yhtj');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'yhtj');
INSERT INTO `syrole_syresource` VALUES ('0', 'zhbj');
INSERT INTO `syrole_syresource` VALUES ('0', 'zhck');
INSERT INTO `syrole_syresource` VALUES ('0', 'zhlb');
INSERT INTO `syrole_syresource` VALUES ('0', 'zhsc');
INSERT INTO `syrole_syresource` VALUES ('0', 'zhtj');
INSERT INTO `syrole_syresource` VALUES ('0', 'zybj');
INSERT INTO `syrole_syresource` VALUES ('2', 'zybj');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'zybj');
INSERT INTO `syrole_syresource` VALUES ('0', 'zyck');
INSERT INTO `syrole_syresource` VALUES ('1', 'zyck');
INSERT INTO `syrole_syresource` VALUES ('2', 'zyck');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'zyck');
INSERT INTO `syrole_syresource` VALUES ('0', 'zygl');
INSERT INTO `syrole_syresource` VALUES ('1', 'zygl');
INSERT INTO `syrole_syresource` VALUES ('2', 'zygl');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'zygl');
INSERT INTO `syrole_syresource` VALUES ('0', 'zylb');
INSERT INTO `syrole_syresource` VALUES ('1', 'zylb');
INSERT INTO `syrole_syresource` VALUES ('2', 'zylb');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'zylb');
INSERT INTO `syrole_syresource` VALUES ('0', 'zysc');
INSERT INTO `syrole_syresource` VALUES ('2', 'zysc');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'zysc');
INSERT INTO `syrole_syresource` VALUES ('0', 'zytj');
INSERT INTO `syrole_syresource` VALUES ('2', 'zytj');
INSERT INTO `syrole_syresource` VALUES ('7894e81f-4c82-4960-a8ec-f71dc6959f99', 'zytj');

-- ----------------------------
-- Table structure for syuser
-- ----------------------------
DROP TABLE IF EXISTS `syuser`;
CREATE TABLE `syuser` (
  `ID` varchar(36) NOT NULL,
  `AGE` int(11) DEFAULT NULL,
  `CREATEDATETIME` datetime DEFAULT NULL,
  `LOGINNAME` varchar(100) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `PHOTO` varchar(200) DEFAULT NULL,
  `PWD` varchar(100) DEFAULT NULL,
  `SEX` varchar(1) DEFAULT NULL,
  `UPDATEDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syuser
-- ----------------------------
INSERT INTO `syuser` VALUES ('0', '30', '2015-03-24 23:19:44', '孙宇', '孙宇', null, 'e10adc3949ba59abbe56e057f20f883e', '1', '2015-03-24 23:19:44');
INSERT INTO `syuser` VALUES ('1', '30', '2015-03-24 23:19:44', 'guest', 'guest', null, 'e10adc3949ba59abbe56e057f20f883e', '1', '2015-03-24 23:19:44');
INSERT INTO `syuser` VALUES ('2', '30', '2015-03-24 23:19:45', 'admin1', 'admin1', null, 'e10adc3949ba59abbe56e057f20f883e', '0', '2015-03-24 23:19:45');
INSERT INTO `syuser` VALUES ('3', '30', '2015-03-24 23:19:45', 'admin2', 'admin2', null, 'e10adc3949ba59abbe56e057f20f883e', '0', '2015-03-24 23:19:45');
INSERT INTO `syuser` VALUES ('4', '30', '2015-03-24 23:19:45', 'admin3', 'admin3', null, 'e10adc3949ba59abbe56e057f20f883e', '0', '2015-03-24 23:19:45');
INSERT INTO `syuser` VALUES ('5', '30', '2015-03-24 23:19:45', 'admin4', 'admin4', null, 'e10adc3949ba59abbe56e057f20f883e', '0', '2015-03-24 23:19:45');
INSERT INTO `syuser` VALUES ('6', '30', '2015-03-24 23:19:45', 'admin5', 'admin5', null, 'e10adc3949ba59abbe56e057f20f883e', '0', '2015-03-24 23:19:45');
INSERT INTO `syuser` VALUES ('7', '30', '2015-12-08 13:39:20', 'lyq', '管理员', null, 'e10adc3949ba59abbe56e057f20f883e', '0', '2015-12-08 13:39:20');
INSERT INTO `syuser` VALUES ('8d760bcf-89dc-4d7b-80db-ff7c165fc1bc', null, '2016-02-12 11:46:37', 'zxx', 'zxx', null, 'e10adc3949ba59abbe56e057f20f883e', '0', '2016-02-12 11:46:37');

-- ----------------------------
-- Table structure for syuser_syorganization
-- ----------------------------
DROP TABLE IF EXISTS `syuser_syorganization`;
CREATE TABLE `syuser_syorganization` (
  `SYUSER_ID` varchar(36) NOT NULL,
  `SYORGANIZATION_ID` varchar(36) NOT NULL,
  PRIMARY KEY (`SYORGANIZATION_ID`,`SYUSER_ID`),
  KEY `FK_14ewqc5wtscac0dd5rswrm5j2` (`SYORGANIZATION_ID`),
  KEY `FK_63bdmtxwlk259id13rp4iryy` (`SYUSER_ID`),
  CONSTRAINT `FK_14ewqc5wtscac0dd5rswrm5j2` FOREIGN KEY (`SYORGANIZATION_ID`) REFERENCES `syorganization` (`ID`),
  CONSTRAINT `FK_63bdmtxwlk259id13rp4iryy` FOREIGN KEY (`SYUSER_ID`) REFERENCES `syuser` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syuser_syorganization
-- ----------------------------
INSERT INTO `syuser_syorganization` VALUES ('0', '0');
INSERT INTO `syuser_syorganization` VALUES ('1', '0');
INSERT INTO `syuser_syorganization` VALUES ('7', 'fa6f6408-cb17-44c0-872f-45912ce51685');
INSERT INTO `syuser_syorganization` VALUES ('8d760bcf-89dc-4d7b-80db-ff7c165fc1bc', 'fa6f6408-cb17-44c0-872f-45912ce51685');

-- ----------------------------
-- Table structure for syuser_syrole
-- ----------------------------
DROP TABLE IF EXISTS `syuser_syrole`;
CREATE TABLE `syuser_syrole` (
  `SYUSER_ID` varchar(36) NOT NULL,
  `SYROLE_ID` varchar(36) NOT NULL,
  PRIMARY KEY (`SYROLE_ID`,`SYUSER_ID`),
  KEY `FK_j7iwtgslc2esrjx0ptieleoko` (`SYROLE_ID`),
  KEY `FK_1pi4p5h4y5ghbs5f4gdlgn620` (`SYUSER_ID`),
  CONSTRAINT `FK_1pi4p5h4y5ghbs5f4gdlgn620` FOREIGN KEY (`SYUSER_ID`) REFERENCES `syuser` (`ID`),
  CONSTRAINT `FK_j7iwtgslc2esrjx0ptieleoko` FOREIGN KEY (`SYROLE_ID`) REFERENCES `syrole` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syuser_syrole
-- ----------------------------
INSERT INTO `syuser_syrole` VALUES ('0', '0');
INSERT INTO `syuser_syrole` VALUES ('7', '0');
INSERT INTO `syuser_syrole` VALUES ('0', '1');
INSERT INTO `syuser_syrole` VALUES ('1', '1');
INSERT INTO `syuser_syrole` VALUES ('0', '2');
INSERT INTO `syuser_syrole` VALUES ('2', '2');
INSERT INTO `syuser_syrole` VALUES ('0', '3');
INSERT INTO `syuser_syrole` VALUES ('3', '3');
INSERT INTO `syuser_syrole` VALUES ('0', '4');
INSERT INTO `syuser_syrole` VALUES ('4', '4');
INSERT INTO `syuser_syrole` VALUES ('0', '5');
INSERT INTO `syuser_syrole` VALUES ('5', '5');
INSERT INTO `syuser_syrole` VALUES ('0', '6');
INSERT INTO `syuser_syrole` VALUES ('6', '6');
INSERT INTO `syuser_syrole` VALUES ('7', '7894e81f-4c82-4960-a8ec-f71dc6959f99');
INSERT INTO `syuser_syrole` VALUES ('8d760bcf-89dc-4d7b-80db-ff7c165fc1bc', '7894e81f-4c82-4960-a8ec-f71dc6959f99');
