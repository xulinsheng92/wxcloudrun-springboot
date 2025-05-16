CREATE TABLE `cart` (
  `cart_id` int(11) NOT NULL COMMENT '购物车唯一标识',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID（外键关联users）',
  `dish_id` int(11) DEFAULT NULL COMMENT '菜品ID（外键关联dishes）',
  `quantity` int(11) DEFAULT NULL COMMENT '菜品数量',
  `created_at` decimal(10,0) DEFAULT NULL COMMENT '添加到购物车的时间',
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车表'

CREATE TABLE `dishes` (
  `dish_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜品唯一标识',
  `dish_name` varchar(100) DEFAULT '' COMMENT '菜品名称',
  `dish_image_url` varchar(255) DEFAULT '' COMMENT '菜品图片URL',
  `description` text COMMENT '菜品描述',
  `price` decimal(10,2) DEFAULT NULL COMMENT '菜品价格',
  `is_available` tinyint(1) DEFAULT NULL COMMENT '是否可点（0不可点，1可点）',
  PRIMARY KEY (`dish_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜品表'

CREATE TABLE `order_details` (
  `order_detail_id` int(11) NOT NULL COMMENT '订单详情唯一标识',
  `order_id` int(11) DEFAULT NULL COMMENT '订单ID（外键关联orders）',
  `dish_id` int(11) DEFAULT NULL COMMENT '菜品ID（外键关联dishes）',
  `quantity` int(11) DEFAULT NULL COMMENT '菜品数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '菜品单价',
  PRIMARY KEY (`order_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表'

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL COMMENT '订单唯一标识',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID（外键关联users）',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '订单总金额',
  `order_status` varchar(20) DEFAULT '' COMMENT '订单状态（如“待付款”、“待出菜”、“已完成”）',
  `created_at` datetime DEFAULT NULL COMMENT '下单时间',
  `updated_at` datetime DEFAULT NULL COMMENT '订单状态更新时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户下单的订单信息'

CREATE TABLE `reviews` (
  `review_id` int(11) NOT NULL COMMENT '评价唯一标识',
  `order_detail_id` int(11) DEFAULT NULL COMMENT '订单详情ID（外键关联order_details）',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID（外键关联users）',
  `rating` int(11) DEFAULT NULL COMMENT '评分（1-5）',
  `comment` text COMMENT '评价内容',
  `created_at` datetime DEFAULT NULL COMMENT '评价时间',
  PRIMARY KEY (`review_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评价表'

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL COMMENT '用户唯一标识',
  `nickname` varchar(50) DEFAULT '' COMMENT '用户昵称',
  `phone` varchar(20) DEFAULT '' COMMENT '用户手机号',
  `wx_openid` varchar(50) DEFAULT '' COMMENT '微信用户唯一标识',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表'