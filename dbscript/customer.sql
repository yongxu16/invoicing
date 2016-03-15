DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '客户名称',
  `contact` varchar(255) NOT NULL COMMENT '联系人',
  `telephone` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `customer` VALUES ('08bbb93063f74b96b95a25f2a3ba96d4', 'customer1', 'hanyx', '18604230000', 'yongxu16@163.com', NULL);
INSERT INTO `customer` VALUES ('884d1c0fafed473d8eb581cab6fe5cce', 'customer2', 'suny', '18678230000', 'suny@163.com', NULL);