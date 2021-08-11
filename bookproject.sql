/*
Navicat MySQL Data Transfer

Source Server         : 192.168.2.16-mysql
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : bookproject

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2021-08-11 16:58:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('19', 'A_0001', '谢嘉柱', '123456');
INSERT INTO `admin` VALUES ('20', 'A_0002', '汤哲', '123456');
INSERT INTO `admin` VALUES ('21', 'A_0003', '家乐乐', '123456');
INSERT INTO `admin` VALUES ('22', 'A_0004', '杨建勋', '123456');
INSERT INTO `admin` VALUES ('23', 'A_0005', '庞钧耀', '123456');
INSERT INTO `admin` VALUES ('24', 'A_0006', '黄楚荣', '123456');
INSERT INTO `admin` VALUES ('25', 'A_0007', '观然锋', '123456');
INSERT INTO `admin` VALUES ('26', 'A_0008', '王佳泓', '123456');
INSERT INTO `admin` VALUES ('27', 'A_0009', '陈境聪', '123456');
INSERT INTO `admin` VALUES ('28', 'A_0010', '我是大帅比', '123456');
INSERT INTO `admin` VALUES ('29', 'admin_00078', '谢嘉柱1', '123456');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `sales` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('12', 'B_0001', '红楼梦', '曹雪芹', '60', '8', '460');
INSERT INTO `book` VALUES ('13', 'B_0002', '西游记', '吴承恩', '60', '6', '246');
INSERT INTO `book` VALUES ('14', 'B_0003', '三国演义', '罗贯中', '60', '8', '273');
INSERT INTO `book` VALUES ('15', 'B_0004', '水浒传', '施耐庵', '60', '4', '100');
INSERT INTO `book` VALUES ('16', 'B_0005', '人间失格', '太宰治', '60', '3', '98');
INSERT INTO `book` VALUES ('17', 'B_0006', 'java面向对象编程', '孙卫琴', '60', '1', '101');
INSERT INTO `book` VALUES ('18', 'B_0007', '活着', '余华', '60', '0', '103');
INSERT INTO `book` VALUES ('19', 'B_0008', 'python基础案例教程', '黑马程序员', '60', '100', '101');
INSERT INTO `book` VALUES ('20', 'B_0011', '软件工程导论', '清华大学出版社', '60', '100', '0');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` varchar(255) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `price` float NOT NULL,
  `status` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('35', '1624286440290T_0001', '2021-06-21 00:00:00', '120', '1', 'T_0001');
INSERT INTO `order` VALUES ('36', '1624286588773T_0001', '2021-06-21 00:00:00', '60', '1', 'T_0001');
INSERT INTO `order` VALUES ('37', '1624345311581T_0001', '2021-07-04 15:18:13', '240', '1', 'T_0001');
INSERT INTO `order` VALUES ('38', '1624345336276T_0001', '2021-06-22 15:14:22', '0', '1', 'T_0001');
INSERT INTO `order` VALUES ('39', '1624346075036T_0001', '2021-07-04 15:18:14', '180', '1', 'T_0001');
INSERT INTO `order` VALUES ('40', '1624455223180T_0001', '2021-06-23 21:34:07', '1260', '1', 'T_0001');
INSERT INTO `order` VALUES ('41', '1625124027987T_0001', '2021-07-04 15:18:15', '240', '1', 'T_0001');
INSERT INTO `order` VALUES ('42', '1625124437950T_0001', '2021-07-04 15:18:15', '180', '1', 'T_0001');
INSERT INTO `order` VALUES ('43', '1625382673416T_0001', '2021-07-04 15:18:16', '1680', '1', 'T_0001');
INSERT INTO `order` VALUES ('44', '1625383185886T_0001', '2021-07-04 15:23:39', '120', '1', 'T_0001');
INSERT INTO `order` VALUES ('45', '1625383238158T_0001', '2021-07-04 15:23:40', '36000', '1', 'T_0001');
INSERT INTO `order` VALUES ('46', '1625383457206T_0001', '2021-07-04 15:24:44', '12000', '1', 'T_0001');
INSERT INTO `order` VALUES ('47', '1625383529663T_0001', '2021-07-04 15:34:29', '12000', '1', 'T_0001');
INSERT INTO `order` VALUES ('48', '1625383562340T_0001', '2021-07-04 15:34:30', '12000', '1', 'T_0001');
INSERT INTO `order` VALUES ('49', '1625383582776T_0001', '2021-07-04 15:34:31', '12000', '1', 'T_0001');

-- ----------------------------
-- Table structure for `orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` varchar(255) NOT NULL,
  `bid` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `count` int(11) NOT NULL,
  `totalPrice` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('42', '1624286440290T_0001', 'B_0003', '三国演义', '罗贯中', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('43', '1624286440290T_0001', 'B_0001', '红楼梦', '曹雪芹', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('44', '1624286588773T_0001', 'B_0001', '红楼梦', '曹雪芹', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('45', '1624345311581T_0001', 'B_0001', '红楼梦', '曹雪芹', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('46', '1624345311581T_0001', 'B_0002', '西游记', '吴承恩', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('47', '1624345311581T_0001', 'B_0003', '三国演义', '罗贯中', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('48', '1624345311581T_0001', 'B_0004', '水浒传', '施耐庵', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('49', '1624346075036T_0001', 'B_0003', '三国演义', '罗贯中', '60', '2', '120');
INSERT INTO `orderitem` VALUES ('50', '1624346075036T_0001', 'B_0002', '西游记', '吴承恩', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('51', '1624455223180T_0001', 'B_0001', '红楼梦', '曹雪芹', '60', '10', '600');
INSERT INTO `orderitem` VALUES ('52', '1624455223180T_0001', 'B_0002', '西游记', '吴承恩', '60', '10', '600');
INSERT INTO `orderitem` VALUES ('53', '1624455223180T_0001', 'B_0003', '三国演义', '罗贯中', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('54', '1625124027987T_0001', 'B_0001', '红楼梦', '曹雪芹', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('55', '1625124027987T_0001', 'B_0002', '西游记', '吴承恩', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('56', '1625124027987T_0001', 'B_0003', '三国演义', '罗贯中', '60', '2', '120');
INSERT INTO `orderitem` VALUES ('57', '1625124437950T_0001', 'B_0001', '红楼梦', '曹雪芹', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('58', '1625124437950T_0001', 'B_0002', '西游记', '吴承恩', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('59', '1625124437950T_0001', 'B_0003', '三国演义', '罗贯中', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('60', '1625382673416T_0001', 'B_0001', '红楼梦', '曹雪芹', '60', '25', '1500');
INSERT INTO `orderitem` VALUES ('61', '1625382673416T_0001', 'B_0002', '西游记', '吴承恩', '60', '2', '120');
INSERT INTO `orderitem` VALUES ('62', '1625382673416T_0001', 'B_0003', '三国演义', '罗贯中', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('63', '1625383185886T_0001', 'B_0001', '红楼梦', '曹雪芹', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('64', '1625383185886T_0001', 'B_0002', '西游记', '吴承恩', '60', '1', '60');
INSERT INTO `orderitem` VALUES ('65', '1625383238158T_0001', 'B_0005', '人间失格', '太宰治', '60', '200', '12000');
INSERT INTO `orderitem` VALUES ('66', '1625383238158T_0001', 'B_0004', '水浒传', '施耐庵', '60', '200', '12000');
INSERT INTO `orderitem` VALUES ('67', '1625383238158T_0001', 'B_0003', '三国演义', '罗贯中', '60', '200', '12000');
INSERT INTO `orderitem` VALUES ('68', '1625383457206T_0001', 'B_0005', '人间失格', '太宰治', '60', '200', '12000');
INSERT INTO `orderitem` VALUES ('69', '1625383529663T_0001', 'B_0005', '人间失格', '太宰治', '60', '200', '12000');
INSERT INTO `orderitem` VALUES ('70', '1625383562340T_0001', 'B_0005', '人间失格', '太宰治', '60', '200', '12000');
INSERT INTO `orderitem` VALUES ('71', '1625383582776T_0001', 'B_0004', '水浒传', '施耐庵', '60', '200', '12000');

-- ----------------------------
-- Table structure for `purchaser`
-- ----------------------------
DROP TABLE IF EXISTS `purchaser`;
CREATE TABLE `purchaser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `job` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchaser
-- ----------------------------
INSERT INTO `purchaser` VALUES ('2', 'P_0001', '谢嘉柱', '123456', '科长', '15712345678');

-- ----------------------------
-- Table structure for `store`
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` varchar(255) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('13', '1624288550114admin_0001', '2021-06-21 00:00:00', '1');
INSERT INTO `store` VALUES ('14', '1624290566510A_0001', '2021-06-21 00:00:00', '1');
INSERT INTO `store` VALUES ('15', '1624291067522A_0001', '2021-06-21 00:00:00', '1');
INSERT INTO `store` VALUES ('16', '1624325909025A_0001', '2021-06-22 00:00:00', '1');
INSERT INTO `store` VALUES ('17', '1624326903694A_0001', '2021-07-04 15:17:40', '1');
INSERT INTO `store` VALUES ('18', '1624330881080A_0001', '2021-07-04 15:17:43', '1');
INSERT INTO `store` VALUES ('19', '1624331702656A_0001', '2021-07-04 15:16:56', '1');
INSERT INTO `store` VALUES ('20', '1624332156904A_0001', '2021-07-04 15:15:39', '1');
INSERT INTO `store` VALUES ('21', '1624341305167A_0001', '2021-07-04 15:15:36', '1');
INSERT INTO `store` VALUES ('22', '1624449499030A_0001', '2021-07-04 15:15:30', '1');
INSERT INTO `store` VALUES ('23', '1624455124574A_0001', '2021-06-23 21:32:43', '1');
INSERT INTO `store` VALUES ('24', '1625124399466A_0001', '2021-07-01 15:28:17', '1');
INSERT INTO `store` VALUES ('25', '1625384221923A_0001', '2021-07-04 15:37:24', '1');
INSERT INTO `store` VALUES ('26', '1625384319048A_0001', '2021-07-04 15:38:39', '0');

-- ----------------------------
-- Table structure for `storeitem`
-- ----------------------------
DROP TABLE IF EXISTS `storeitem`;
CREATE TABLE `storeitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` varchar(255) NOT NULL,
  `bid` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of storeitem
-- ----------------------------
INSERT INTO `storeitem` VALUES ('27', '1624288550114admin_0001', 'B_0004', '水浒传', '施耐庵', '144');
INSERT INTO `storeitem` VALUES ('28', '1624288550114admin_0001', 'B_0001', '红楼梦', '曹雪芹', '122');
INSERT INTO `storeitem` VALUES ('29', '1624288550114admin_0001', 'B_0005', '人间失格', '太宰治', '142');
INSERT INTO `storeitem` VALUES ('30', '1624288550114admin_0001', 'B_0006', 'java面向对象编程', '孙卫琴', '11');
INSERT INTO `storeitem` VALUES ('31', '1624288550114admin_0001', 'B_0003', '三国演义', '罗贯中', '11');
INSERT INTO `storeitem` VALUES ('32', '1624290566510A_0001', 'B_0001', '红楼梦', '曹雪芹', '100');
INSERT INTO `storeitem` VALUES ('33', '1624290566510A_0001', 'B_0003', '三国演义', '罗贯中', '124');
INSERT INTO `storeitem` VALUES ('34', '1624290566510A_0001', 'B_0002', '西游记', '吴承恩', '56');
INSERT INTO `storeitem` VALUES ('35', '1624291067522A_0001', 'B_0001', '红楼梦', '曹雪芹', '121');
INSERT INTO `storeitem` VALUES ('36', '1624291067522A_0001', 'B_0002', '西游记', '吴承恩', '35');
INSERT INTO `storeitem` VALUES ('37', '1624291067522A_0001', 'B_0003', '三国演义', '罗贯中', '43');
INSERT INTO `storeitem` VALUES ('38', '1624325909025A_0001', 'B_0001', '红楼梦', '曹雪芹', '1');
INSERT INTO `storeitem` VALUES ('39', '1624326903694A_0001', 'B_0001', '红楼梦', '曹雪芹', '1');
INSERT INTO `storeitem` VALUES ('40', '1624330881080A_0001', 'B_0006', 'java面向对象编程', '孙卫琴', '1');
INSERT INTO `storeitem` VALUES ('41', '1624330881080A_0001', 'B_0005', '人间失格', '太宰治', '1');
INSERT INTO `storeitem` VALUES ('42', '1624330881080A_0001', 'B_0004', '水浒传', '施耐庵', '1');
INSERT INTO `storeitem` VALUES ('43', '1624331702656A_0001', 'B_0001', '红楼梦', '曹雪芹', '143');
INSERT INTO `storeitem` VALUES ('44', '1624331702656A_0001', 'B_0002', '西游记', '吴承恩', '13');
INSERT INTO `storeitem` VALUES ('45', '1624331702656A_0001', 'B_0003', '三国演义', '罗贯中', '134');
INSERT INTO `storeitem` VALUES ('46', '1624331702656A_0001', 'B_0004', '水浒传', '施耐庵', '1');
INSERT INTO `storeitem` VALUES ('47', '1624332156904A_0001', 'B_0002', '西游记', '吴承恩', '1');
INSERT INTO `storeitem` VALUES ('48', '1624332156904A_0001', 'B_0003', '三国演义', '罗贯中', '2');
INSERT INTO `storeitem` VALUES ('49', '1624341305167A_0001', 'B_0001', '红楼梦', '曹雪芹', '1');
INSERT INTO `storeitem` VALUES ('50', '1624341305167A_0001', 'B_0002', '西游记', '吴承恩', '1');
INSERT INTO `storeitem` VALUES ('51', '1624449499030A_0001', 'B_0001', '红楼梦', '曹雪芹', '1');
INSERT INTO `storeitem` VALUES ('52', '1624449499030A_0001', 'B_0002', '西游记', '吴承恩', '1');
INSERT INTO `storeitem` VALUES ('53', '1624449499030A_0001', 'B_0003', '三国演义', '罗贯中', '1');
INSERT INTO `storeitem` VALUES ('54', '1624449499030A_0001', 'B_0007', '活着', '余华', '2');
INSERT INTO `storeitem` VALUES ('55', '1624449499030A_0001', 'B_0008', 'python基础案例教程', '黑马程序员', '1');
INSERT INTO `storeitem` VALUES ('56', '1624455124574A_0001', 'B_0008', 'python基础案例教程', '黑马程序员', '100');
INSERT INTO `storeitem` VALUES ('57', '1625124399466A_0001', 'B_0001', '红楼梦', '曹雪芹', '100');
INSERT INTO `storeitem` VALUES ('58', '1625124399466A_0001', 'B_0002', '西游记', '吴承恩', '100');
INSERT INTO `storeitem` VALUES ('59', '1625124399466A_0001', 'B_0007', '活着', '余华', '1');
INSERT INTO `storeitem` VALUES ('60', '1625384221923A_0001', 'B_0004', '水浒传', '施耐庵', '2');
INSERT INTO `storeitem` VALUES ('61', '1625384221923A_0001', 'B_0006', 'java面向对象编程', '孙卫琴', '1');
INSERT INTO `storeitem` VALUES ('62', '1625384221923A_0001', 'B_0003', '三国演义', '罗贯中', '1');
INSERT INTO `storeitem` VALUES ('63', '1625384221923A_0001', 'B_0002', '西游记', '吴承恩', '1');
INSERT INTO `storeitem` VALUES ('64', '1625384319048A_0001', 'B_0001', '红楼梦', '曹雪芹', '1');
INSERT INTO `storeitem` VALUES ('65', '1625384319048A_0001', 'B_0002', '西游记', '吴承恩', '1');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `job` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2', 'S_0001', '谢嘉柱', '123456', '班长', '15712345678');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `job` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('2', 'T_0001', '上山打老虎', '123456', '班主任', '15712345678');
INSERT INTO `teacher` VALUES ('5', 'T_0003', '汤哲', '123456', '班主任', '15712345678');
INSERT INTO `teacher` VALUES ('6', 'T_0004', '庞钧耀', '123456', '班主任', '15712345678');
INSERT INTO `teacher` VALUES ('7', 'T_0005', '家乐乐', '123456', '班主任', '15712345678');
INSERT INTO `teacher` VALUES ('8', 'T_0002', '谢嘉柱', '123456', '班主任', '15712345678');
INSERT INTO `teacher` VALUES ('9', 'T_0006', '黄楚荣', '123456', '班主任', '15712345678');
