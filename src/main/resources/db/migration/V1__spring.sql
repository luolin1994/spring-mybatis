/**
MySql： DataBase:mytest
 */

SET FOREIGN_KEY_CHECKS=0;

/*用户表 */
DROP TABLE IF EXISTS `login_user`;
create table `login_user`(
   `id` int(11) primary key auto_increment,
   `username` varchar(255),
   `password` varchar(255),
   `enabled` tinyint(1) default '1'
   ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
insert into login_user values(1, 'admin', '$2a$10$qxW.4rU1BoA29DCQnQ2Wkul3uniMQWolP/.q2BQRwu6brlK6M.uF6',1),
                              (2, 'user', '$2a$10$qxW.4rU1BoA29DCQnQ2Wkul3uniMQWolP/.q2BQRwu6brlK6M.uF6',1);


/* 角色表 */
DROP TABLE IF EXISTS `role`;
create table `role`(
       `id` int(11) not null auto_increment,
       `name` varchar(64),
       `nameZh` varchar(64),
       primary key(`id`)
       ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
insert into `role` values(1,'ROLE_admin', '管理员'), (2,'ROLE_user', '用户');

/* 用户-角色表 */
DROP TABLE IF EXISTS `login_user_role`;
create table `login_user_role`(
       `id` int(11) not null auto_increment,
       `uid` int(11),
       `rid` int(11),
       primary key(`id`),
       constraint `user_login_1` foreign key (`uid`) references `login_user`(`id`) on delete cascade,
       constraint `user_login_2` foreign key (`rid`) references `role`(`id`)
       )ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
insert into `login_user_role` values(1,1,1), (2,1,2), (3,2,2);


/* 权限表 */
DROP TABLE IF EXISTS `permission`;
create table `permission`(
         `id` int(11) not null auto_increment,
         `url` varchar(64) default null,
         `name` varchar(64) default null,
         `parent_id` int(11) default null,
         primary key(`id`)
         )ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
insert into `permission` values(1,'/', '所有', null), (2,'/hello','你好',null),(3,'/admin','管理',null);



/* 权限-角色 */
DROP TABLE IF EXISTS `permission_role`;
CREATE TABLE `permission_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mid` (`pid`),
  KEY `rid` (`rid`),
  CONSTRAINT `permission_role_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `permission` (`id`),
  CONSTRAINT `permission_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=283 DEFAULT CHARSET=utf8;
insert into permission_role values(1,2,1),(2,2,2),(3,3,1);

SET FOREIGN_KEY_CHECKS=1;
