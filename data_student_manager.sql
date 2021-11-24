use stu;

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `tid` int(18) NOT NULL,
  `cname` varchar(255) NOT NULL,
  `teacherName` char(18) not null ,
  `credit` int NOT NULL DEFAULT '2',
  `courseDay` int(1) not null default '1',
  `courseSection` int(1) not null default '1',
  `start`       int       not null ,
  `end`         int       not null ,
  `courseInfo` char(255) ,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

INSERT INTO `course` VALUES ('1', '1', 'Python(A)','王老师' ,'2', '2','1',2,3,'描述');
INSERT INTO `course` VALUES ('2', '1', '数据库系统','王老师' , '2', '1','1',3,6,'描述');
INSERT INTO `course` VALUES ('3', '2', 'Java程序设计','张老师' , '2', '3','4',2,6,'描述');
INSERT INTO `course` VALUES ('5', '3', 'C#程序设计','李老师' , '2', '4','3',2,7,'描述');
INSERT INTO `course` VALUES ('6', '2', 'C语言程序设计(A)','张老师' , '5', '4','3',3,8,'描述');
INSERT INTO `course` VALUES ('7', '1', 'C++面向对象(A)','王老师' , '5', '5','5',3,8,'描述');
INSERT INTO `course` VALUES ('8', '2', '高等数学A1','张老师' , '5', '2','4',3,8,'描述');
INSERT INTO `course` VALUES ('9', '2', '高等数学A2','张老师' , '5','3','5',3,8,'描述');



DROP TABLE IF EXISTS `course_selected`;
create table course_selected
(
    sid         int       not null,
    cid         int       not null,
    tid         int       not null ,
    cname       char(255) not null,
    teacherName char(255) not null,
    studentName char(255) not null ,
    clazz       int       not null ,
    credit      int       not null,
    start       int       not null ,
    end         int       not null ,
    mark        int       default '-1',
    courseDay int(1) not null default '1',
    courseSection int(1) not null default '1'
)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `sid` int(18) NOT NULL COMMENT '学号',
  `name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `passwordData` varchar(255) NOT NULL DEFAULT '123456',
  `clazz` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '2',
  `mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `other` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '其他信息',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `student_info` VALUES ('1001','23','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu', '2', '2134356214@qq.com', '18293940302', 'address', '这里描述一些其他信息');
INSERT INTO `student_info` VALUES ('1002', '23','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu','2', '1286438129@qq.com', '12346459653', 'address', '这里描述一些其他信息');
INSERT INTO `student_info` VALUES ('1003', '23','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu','2', '3310811999@qq.com', '17384950382', 'address', '这里描述一些其他信息');
INSERT INTO `student_info` VALUES ('1004','23','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu', '1', '331081199@qq.com', '14563463452', 'address', '这里描述一些其他信息');
INSERT INTO `student_info` VALUES ('1005','23','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu', '2', '3329262000@qq.com', '14563463452', 'address', '大家好我是来自浙江省的练习生洪飞鸿');
INSERT INTO `student_info` VALUES ('1006','23','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu', '2', '33292620000@qq.com', '14563463452', 'address', '大家好我是来自浙江省的练习生YK');
INSERT INTO `student_info` VALUES ('1016','23','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu', '2', '33292619990@qq.com', '14563463452', 'address', '这里是其他信息');
INSERT INTO `student_info` VALUES ('1017','23','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu', '2', '332926200001@qq.com', '14563463452', 'address', '大家好我是来自浙江省的练习生');
INSERT INTO `student_info` VALUES ('1021','23','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu', '1', '33292620001@qq.com', '14563463452', 'address', '7777777777');
INSERT INTO `student_info` VALUES ('1023','23','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu', '2', '332963199@qq.com', '14563463452', 'address', 'other infomathons');
INSERT INTO `student_info` VALUES ('1024','23','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu', '1', '33292619991@qq.com', '14563463452', 'address', 'other Infomations');
INSERT INTO `student_info` VALUES ('1029','23','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu', '1', '33292619991@qq.com', '14563463452', 'address', '12314aweqwe');
INSERT INTO `student_info` VALUES ('1030','23','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu', '1', '33292619991@qq.com', '14563463452', 'address', '请问阿斯顿2312321');
INSERT INTO `student_info` VALUES ('1033','23','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu', '3', '1231231231@qq.com', '14563463452', 'address', '123123123123123123');
INSERT INTO `student_info` VALUES ('1035','23','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu', '2', '231412312412@qq.com', '14563463452', 'address', '123123124123141');


DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info` (
  `tid` int(18) NOT NULL,
  `name` varchar(25) NOT NULL,
  `passwordData` varchar(255) NOT NULL ,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `teacher_info` VALUES ('1', '王老师','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu');
INSERT INTO `teacher_info` VALUES ('2', '张老师','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu');
INSERT INTO `teacher_info` VALUES ('3', '李老师','$2a$10$JxggSMAQ.gGG9TXN9oFaducwlqHRzT4NgR5Wh70z1sXnPk.ytHAlu');

DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
`logID` int not null auto_increment,
`id` int(18) not null ,
`lastLoginTime` CHAR(32) not null,
PRIMARY KEY (`logID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;