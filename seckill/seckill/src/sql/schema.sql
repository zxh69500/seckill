--数据库初始化脚本

--数据库创建

CREATE DATABASE seckill;

use seckill;

CREATE TABLE seckill (
`seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
`number` int NOT NULL COMMENT '库存数量',
`name` varchar(120) NOT NULL COMMENT '商品名称',
`start_time` timestamp NOT NULL COMMENT '秒杀开始时间',
`end_time` timestamp NOT NULL COMMENT '秒杀结束时间',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

insert into seckill (name,number ,start_time,end_time)
values ('1000秒杀iphone6',100,'2018-6-7 00:00:00','2018-6-8 00:00:00'),
('500秒杀iphone6s',100,'2018-6-7 00:00:00','2018-6-8 00:00:00'),
('300秒杀ipad',100,'2018-6-7 00:00:00','2018-6-8 00:00:00'),
('100秒杀小米6',100,'2018-6-7 00:00:00','2018-6-8 00:00:00');


--秒杀成功明细
--用户登录认证相关信息
 create table success_killed (
  `seckill_id` bigint NOT NULL COMMENT '秒杀商品id',
  `user_phone` bigint NOT NULL COMMENT '用户手机号',
  `state` tinyint NOT NULL DEFAULT -1 COMMENT '状态标示 -1：无效 0：成功 1已付款',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (seckill_id,user_phone),
  key idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';