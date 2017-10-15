#创建数据库
DROP database IF exists wehelpsrc;
create database wehelpsrc;
use wehelpsrc;
#创建相关表格

##信息类型表
DROP TABLE IF EXISTS `t_message_type`;
CREATE TABLE `t_message_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识且自增',
  `name` varchar(20) NOT NULL COMMENT '类型名称',
  `description` varchar(255) NOT NULL COMMENT '描述',
  `available` char(1) DEFAULT NULL COMMENT '是否可用0否1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT '信息类型';

##用户表
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `user_name` varchar(255) NOT NULL unique COMMENT '用户名（用户账号）唯一',
  `password` varchar(64) NOT NULL COMMENT '账号密码',
  `salt` varchar(32) DEFAULT NULL COMMENT '盐',
  `locked` char(1) DEFAULT NULL COMMENT '是否锁定0否，1是',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `sex` char(1) DEFAULT '0' COMMENT '性别 男：0 女：1',
  `age` int(3) DEFAULT '0'COMMENT '年龄',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `email`  varchar(255) DEFAULT NULL COMMENT '邮箱',
  `address`  varchar(255) DEFAULT NULL COMMENT '地址',
  `register_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '注册日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT '用户';

##信息表
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识且自增',
  `user_id` int(11) NOT NULL COMMENT '消息创建者',
  `type_id` int(11) NOT NULL COMMENT '消息类型',
  `content` varchar(1200) NOT NULL COMMENT '消息内容',
  `contacts` varchar(30) NOT NULL COMMENT '联系信息',
  `locale` varchar(100) COMMENT '约定地点',
  `longitude` FLOAT COMMENT '经度',
  `latitude` FLOAT COMMENT '纬度',
  `create_date` TIMESTAMP(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `published_date` TIMESTAMP(3) COMMENT '发布时间',
  foreign key(user_id) references t_user(id),
  foreign key(type_id) references t_message_type(id),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT '消息';

##角色表
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `name` varchar(20) NOT NULL COMMENT '角色名称',
  `available` char(1) DEFAULT NULL COMMENT '是否可用0否1是',
  `create_date` TIMESTAMP(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_date` TIMESTAMP(3) COMMENT '更新时间',
  `description` varchar(255) DEFAULT NULL COMMENT '描述、介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT '角色';

##权限表
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `role_id` int(11) COMMENT '所属角色',
  `token` varchar(100) NOT NULL COMMENT '未使用',
  `url` varchar(255) NOT NULL COMMENT 'url链接',
  `available` char(1) DEFAULT NULL COMMENT '是否可用0否1是',
  `description` varchar(255) DEFAULT NULL COMMENT '描述介绍',
  foreign key(role_id) references t_role(id),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT '权限';

##用户角色信息表
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `user_id` int(11) COMMENT '拥有角色的用户',
  `role_id` int(11) COMMENT '所属用户的角色',
  `available` char(1) DEFAULT NULL COMMENT '是否可用0否1是',
  `create_date` TIMESTAMP(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '授权时间',
  `update_date` TIMESTAMP(3) COMMENT '更新时间',
  foreign key(user_id) references t_user(id),
  foreign key(role_id) references t_role(id),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT '用户拥有的角色';


#插入测试数据
insert into t_user(user_name, password, locked, nick_name, sex, age, phone, email, address)
values('naying', '000000', 0, '那英', 2, 18, '13888888888', 'meigui@qq.com', '华盛顿');
insert into t_user(user_name, password, locked, nick_name, sex, age, phone, email, address)
values('wangfeng', '000000', 0, '汪峰', 1, 20, '13999999999', 'jiege@qq.com', '伦敦');
insert into t_user(user_name, password, locked, nick_name, sex, age, phone, email, address)
values('zhangjie', '000000', 0, '张杰', 1, 20, '13333333333', 'zhangsan@qq.com', '北京');
insert into t_user(user_name, password, locked, nick_name, sex, age, phone, email, address)
values('huazai', '000000', 0, '华仔', 1, 19, '13666666666', 'lisi@qq.com', '香港');

update t_user set password='MDZhNTE0NThhNjQ4OTgwYjE1ZGM3NDZjODIyMDcwMzQ=', salt='7845233539713e375677264f30736133' where id = 1;
update t_user set password='MTI4NWQ0ZWU2YTk1MTRjMzVhNzI5NmE5MzliNTFjOTU=', salt='2830727a3857514f2f5e2c263a6a6d3d' where id = 2;
update t_user set password='MWVjYzc3YTM5ODk5MWJlNGI2OGUzNGE1NGNkNTEzZTM=', salt='2f556a247b317622796c6960253f6175' where id = 3;
update t_user set password='M2M0NmVmN2U4YWU4MTUwNDU1YmQ1YzM0YzhiNzljMWU=', salt='7923342e60554c3d7c3c7b79543f2b50' where id = 4;

insert into t_message_type(name, description, available) values('车出行', '车辆出现信息', 1);
insert into t_message_type(name, description, available) values('人出行', '人出行信息', 1);
insert into t_message_type(name, description, available) values('招聘', '发布招聘信息', 1);
insert into t_message_type(name, description, available) values('求职', '发布求职信息', 1);
insert into t_message_type(name, description, available) values('打听', '打听信息', 1);

insert into t_role(name, available, description) values('user', 1, '普通用户');
insert into t_role(name, available, description) values('admin', 1, '超级用户');

insert into t_permission(role_id, token, url, available, description) values(1, 'home', '/home', 1, '用户角色资源');
insert into t_permission(role_id, token, url, available, description) values(2, 'admin', '/admin', 1, '管理员资源');

insert into t_user_role(user_id, role_id, available) values(1, 1, 1);
insert into t_user_role(user_id, role_id, available) values(1, 2, 1);

insert into t_message(content, contacts, user_id, type_id) values ('(车找人）明天早上册亨到贵阳可坐4人，越早越好，有同路的朋友请联系15597995902', '12333333333', 1, 1);
insert into t_message(content, contacts, user_id, type_id) values ('人找车 明天早上册亨去兴义  一人 13595900677', '16633339999', 2, 2);
insert into t_message(content, contacts, user_id, type_id) values ('【车找人】安龙到册亨   轿车   联系电话15186409347', '16633339992', 1, 1);
insert into t_message(content, contacts, user_id, type_id) values ('【人找车】册亨到兴义，晚上8点走，电话：18296087317', '16633339993', 1, 2);
insert into t_message(content, contacts, user_id, type_id) values ('【人找车】兴义到安龙或者册亨，一个人，随时可走，电话：153-2969-4518', '16633339994', 2, 2);
insert into t_message(content, contacts, user_id, type_id) values ('【车找人】越野车找人    兴义 回册亨20点左右走     可带3人    13379686263', '16633339995', 1, 1);
insert into t_message(content, contacts, user_id, type_id) values ('【车找人】23号早上7.30私家轿车到兴义机场，可坐2人有同路的请联系.电话15186354063', '16633339996', 1, 1);
insert into t_message(content, contacts, user_id, type_id) values ('【人找车】册亨到兴义,两个人,有顺路的师傅麻烦联系一下！15285466460（谢谢）', '16633339997', 2, 2);
insert into t_message(content, contacts, user_id, type_id) values ('【人找车】兴义至册亨，二人，可随时出发，暗号：18008592092。', '16633339997', 1, 2);
insert into t_message(content, contacts, user_id, type_id) values ('【人找车】八点以后册亨到安龙 1人，18286143540', '16633339997', 1, 2);
insert into t_message(content, contacts, user_id, type_id) values ('【车找人】晚上双江回册亨，有同路的电话联系，18296006142', '16633339997', 3, 1);
insert into t_message(content, contacts, user_id, type_id) values ('【人找车】册亨到兴义,两个人,有顺路的师傅麻烦联系一下！15285466460（谢谢）', '16633339997', 4, 2);

update t_message set published_date=now(3) where id = 1;
update t_message set published_date=now(3) where id = 3;
update t_message set published_date=now(3) where id = 5;
update t_message set published_date=now(3) where id = 7;
update t_message set published_date=now(3) where id = 8;
update t_message set published_date=now(3) where id = 6;
update t_message set published_date=now(3) where id = 9;
update t_message set published_date=now(3) where id = 10;
update t_message set published_date=now(3) where id = 2;
update t_message set published_date=now(3) where id = 4;


#查询信息
select * from t_message where id > 3 order by id desc limit 0,2;