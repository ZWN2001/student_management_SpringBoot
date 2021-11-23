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
  `password` varchar(255) NOT NULL DEFAULT '123456',
  `clazz` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '2',
  `mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `other` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '其他信息',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `student_info` VALUES ('1001','23','123456', '2', '2134356214@qq.com', '18293940302', 'address', '这里描述一些其他信息');
INSERT INTO `student_info` VALUES ('1002', '23','123456','2', '1286438129@qq.com', '12346459653', 'address', '这里描述一些其他信息');
INSERT INTO `student_info` VALUES ('1003', '23','123456','2', '3310811999@qq.com', '17384950382', 'address', '这里描述一些其他信息');
INSERT INTO `student_info` VALUES ('1004','23','123456', '1', '331081199@qq.com', '14563463452', 'address', '这里描述一些其他信息');
INSERT INTO `student_info` VALUES ('1005','23','123456', '2', '3329262000@qq.com', '14563463452', 'address', '大家好我是来自浙江省的练习生洪飞鸿');
INSERT INTO `student_info` VALUES ('1006','23','123456', '2', '33292620000@qq.com', '14563463452', 'address', '大家好我是来自浙江省的练习生YK');
INSERT INTO `student_info` VALUES ('1016','23','123456', '2', '33292619990@qq.com', '14563463452', 'address', '这里是其他信息');
INSERT INTO `student_info` VALUES ('1017','23','123456', '2', '332926200001@qq.com', '14563463452', 'address', '大家好我是来自浙江省的练习生');
INSERT INTO `student_info` VALUES ('1021','23','123456', '1', '33292620001@qq.com', '14563463452', 'address', '7777777777');
INSERT INTO `student_info` VALUES ('1023','23','123456', '2', '332963199@qq.com', '14563463452', 'address', 'other infomathons');
INSERT INTO `student_info` VALUES ('1024','23','123456', '1', '33292619991@qq.com', '14563463452', 'address', 'other Infomations');
INSERT INTO `student_info` VALUES ('1029','23','123456', '1', '33292619991@qq.com', '14563463452', 'address', '12314aweqwe');
INSERT INTO `student_info` VALUES ('1030','23','123456', '1', '33292619991@qq.com', '14563463452', 'address', '请问阿斯顿2312321');
INSERT INTO `student_info` VALUES ('1033','23','123456', '3', '1231231231@qq.com', '14563463452', 'address', '123123123123123123');
INSERT INTO `student_info` VALUES ('1035','23','123456', '2', '231412312412@qq.com', '14563463452', 'address', '123123124123141');


DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info` (
  `tid` int(18) NOT NULL,
  `name` varchar(25) NOT NULL,
  `password` varchar(255) NOT NULL DEFAULT '123456',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `teacher_info` VALUES ('1', '王老师','123456');
INSERT INTO `teacher_info` VALUES ('2', '张老师','123456');
INSERT INTO `teacher_info` VALUES ('3', '李老师','123456');
#
# -- ----------------------------
# -- View structure for class_grade
# -- ----------------------------
# DROP VIEW IF EXISTS `class_grade`;
# CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `class_grade` AS select `student`.`sid` AS `sid`,`student`.`name` AS `studentName`,`class`.`grade` AS `grade`,`class`.`makeup_grade` AS `makeupGrade`,`course`.`cname` AS `cname`,`teacher`.`name` AS `teacherName`,`course`.`credit` AS `credit`,`class`.`rebuild` AS `rebuild` from (((`class` left join `course` on((`course`.`cid` = `class`.`cid`))) left join `student` on((`class`.`sid` = `student`.`sid`))) left join `teacher` on((`teacher`.`tid` = `course`.`tid`))) ;
#
# -- ----------------------------
# -- View structure for info_with_nopath
# -- ----------------------------
# DROP VIEW IF EXISTS `info_with_nopath`;
# CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `info_with_nopath` AS select `stu`.`sid` AS `sid`,`stu`.`name` AS `name` from `student` `stu` ;
#
# -- ----------------------------
# -- View structure for major_credit_num
# -- ----------------------------
# DROP VIEW IF EXISTS `major_credit_num`;
# CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `major_credit_num` AS select `major`.`id` AS `id`,`major`.`name` AS `name`,`major`.`electives` AS `electives`,(select sum(`course`.`credit`) from `course` where (`course`.`type` = 1)) AS `required`,(select sum(`course`.`credit`) from `course` where (`course`.`type` = 2)) AS `elective_total` from `major` ;
#
# -- ----------------------------
# -- View structure for stu_base_info
# -- ----------------------------
# DROP VIEW IF EXISTS `stu_base_info`;
# CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stu_base_info` AS select `stu`.`sid` AS `sid`,`stu`.`name` AS `name`,`info`.`address` AS `address`,concat(`major`.`name`,'(',`info`.`class`,')') AS `class`,`info`.`other` AS `other` from ((`student` `stu` left join `student_info` `info` on((`stu`.`sid` = `info`.`sid`))) left join `major` on((`major`.`id` = `info`.`major`))) where (`info`.`sid` is not null) ;
#
# -- ----------------------------
# -- View structure for student_credit
# -- ----------------------------
# DROP VIEW IF EXISTS `student_credit`;
# CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `student_credit` AS select `cla`.`studentName` AS `studentName`,`cour`.`type` AS `type`,sum(`cour`.`credit`) AS `credit` from (`class_grade` `cla` left join `course` `cour` on((`cla`.`cname` = `cour`.`cname`))) where ((`cla`.`grade` >= 60) or (`cla`.`makeupGrade` > 60)) group by `cla`.`studentName`,`cour`.`type` ;
#
# -- ----------------------------
# -- View structure for student_credit_merge
# -- ----------------------------
# DROP VIEW IF EXISTS `student_credit_merge`;
# CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `student_credit_merge` AS select `c1`.`studentName` AS `studentName`,`c1`.`credit` AS `required`,`c2`.`credit` AS `elective` from (`student_credit` `c1` join `student_credit` `c2`) where ((`c1`.`studentName` = `c2`.`studentName`) and (`c1`.`type` = 1) and (`c2`.`type` = 2)) ;
#
# -- ----------------------------
# -- View structure for student_info_with_credit
# -- ----------------------------
# DROP VIEW IF EXISTS `student_info_with_credit`;
# CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `student_info_with_credit` AS select `base`.`sid` AS `sid`,`base`.`name` AS `name`,`base`.`class` AS `class`,`cre`.`required` AS `required`,`cre`.`elective` AS `elective`,`sta`.`status` AS `status` from ((`stu_base_info` `base` left join `student_credit_merge` `cre` on((`base`.`name` = `cre`.`studentName`))) left join `student_status` `sta` on((`base`.`sid` = `sta`.`sid`))) ;
#
# -- ----------------------------
# -- Procedure structure for get_stu_base_info
# -- ----------------------------
# DROP PROCEDURE IF EXISTS `get_stu_base_info`;
# DELIMITER ;;
# CREATE DEFINER=`root`@`%` PROCEDURE `get_stu_base_info`()
# BEGIN
# 	DECLARE sname VARCHAR(255);
# 	DECLARE sclass VARCHAR(255);
# 	DECLARE done BOOLEAN DEFAULT 0;
# 	DECLARE base_info CURSOR
# 	FOR
# 		SELECT name,class FROM stu_base_info;
#
#
# 	OPEN base_info;
# 	REPEAT
# 		FETCH base_info INTO sname,sclass;
# 		SELECT concat(sname,'是一个',sclass,'班的又一位头秃青年') AS res;
# 	UNTIL done END REPEAT;
# 	CLOSE base_info;
# END
# ;;
# DELIMITER ;
#
# -- ----------------------------
# -- Procedure structure for insert_grade
# -- ----------------------------
# DROP PROCEDURE IF EXISTS `insert_grade`;
# DELIMITER ;;
# CREATE DEFINER=`root`@`%` PROCEDURE `insert_grade`()
# BEGIN
# 		UPDATE class SET makeup_grade = -1 where grade>=60;
# 		UPDATE class SET grade = NULL,makeup_grade=NULL,`rebuild`=1 where grade<60 ;
# 	END
# ;;
# DELIMITER ;
#
# -- ----------------------------
# -- Function structure for myf3
# -- ----------------------------
# DROP FUNCTION IF EXISTS `myf3`;
# DELIMITER ;;
# CREATE DEFINER=`root`@`%` FUNCTION `myf3`(gra INT(20)) RETURNS int(11)
# BEGIN
# 	DECLARE sal INT ;
# 	SELECT count(*) into sal from class where class.grade >gra;
# 	RETURN sal;
# END
# ;;
# DELIMITER ;
#
# DROP TRIGGER IF EXISTS `update_grade`;
# DELIMITER ;;
# CREATE TRIGGER `update_grade` AFTER UPDATE ON `class` FOR EACH ROW BEGIN
# INSERT INTO log(log_date, log_type,course_id) VALUES(Now(),'update grade', old.classid);
# END
# ;;
# DELIMITER ;
#
# DROP TRIGGER IF EXISTS `course_update`;
# DELIMITER ;;
# CREATE TRIGGER `course_update` BEFORE UPDATE ON `course` FOR EACH ROW BEGIN
#    INSERT INTO log(log_date, log_type,course_id)
#    VALUES(Now(),'course U', OLD.cid);
# END
# ;;
# DELIMITER ;
# DROP TRIGGER IF EXISTS `course_insert`;
# DELIMITER ;;
# CREATE TRIGGER `course_insert` AFTER INSERT ON `course` FOR EACH ROW BEGIN
#    INSERT INTO log(log_date, log_type,course_id)
#    VALUES(Now(),'course I', new.cid);
# END
# ;;
# DELIMITER ;
# DROP TRIGGER IF EXISTS `course_delete`;
# DELIMITER ;;
# CREATE TRIGGER `course_delete` BEFORE DELETE ON `course` FOR EACH ROW BEGIN
#    INSERT INTO log(log_date, log_type,course_id)
#    VALUES(Now(),'course D', OLD.cid);
# END
# ;;
# DELIMITER ;
# DROP TRIGGER IF EXISTS `init_student_status`;
# DELIMITER ;;
# CREATE TRIGGER `init_student_status` AFTER INSERT ON `student` FOR EACH ROW BEGIN
# 		INSERT INTO student_status(sid,status) value(new.sid,1);
# 		INSERT INTO class(cid,sid) values(1,new.sid),(2,new.sid),(3,new.sid),(5,new.sid),(6,new.sid),(7,new.sid),(8,new.sid),(9,new.sid);
#
#                       INSERT INTO log(log_date, log_type,course_id)
#                       VALUES(Now(),'Add New Student', new.sid);
#
# END
# ;;
# DELIMITER ;
# DROP TRIGGER IF EXISTS `update_student`;
# DELIMITER ;;
# CREATE TRIGGER `update_student` AFTER UPDATE ON `student` FOR EACH ROW BEGIN
# 	INSERT INTO log(log_date, log_type,course_id) VALUES(Now(),'update student', old.sid);
# END
# ;;
# DELIMITER ;
# DROP TRIGGER IF EXISTS `update_student_info`;
# DELIMITER ;;
# CREATE TRIGGER `update_student_info` AFTER UPDATE ON `student_info` FOR EACH ROW BEGIN
# 	INSERT INTO log(log_date, log_type,course_id) VALUES(Now(),'update student info', old.sid);
# END
# ;;
# DELIMITER ;
# DROP TRIGGER IF EXISTS `update_student_status`;
# DELIMITER ;;
# CREATE TRIGGER `update_student_status` AFTER UPDATE ON `student_status` FOR EACH ROW BEGIN
# 	INSERT INTO log(log_date, log_type,course_id) VALUES(Now(),'update student status', old.sid);
# END
# ;;
# DELIMITER ;
