 create table position (
 id bigint not null auto_increment,
 name varchar(256) default null,
 salary varchar(50) default null,
 city varchar(256) default null,
 primary key(id)
 )engine=InnoDB default charset=utf8mb4;


 create table position_detail (
  id bigint not null auto_increment,
  pid bigint not null default '0',
  description text default null,
  primary key(id)
  )engine=InnoDB default charset=utf8mb4;

create table b_order
 (
  id bigint(20) not null auto_increment,
  is_del bit(1) not null default 0 comment'是否被删除',
  company_id int(11) not null comment'公司id',
  position_id int(11) not null comment'职位id',
  user_id int(11) not null comment '用户id',
  publish_user_id int(11) not null comment '职位发布者id',
  resume_type int(2) not null default 0 comment '简历类型：0附件 1 在线',
  status varchar(256) not null comment '投递状态 投递状态 WAIT-待处理 AUTO_FILTER',
  create_time datetime not null comment '创建时间',
  operate_time datetime not null comment '操作时间',
  work_year varchar(100) default null comment '工作年限',
  name varchar(256) default null comment '投递简历人名字',
  position_name varchar(256) default null comment '职位名称',
  resumeId int(10) default null comment '投递的简历id（在线和附件都记）',
  primary key(id),
  key index_createTime (create_time),
  key index_companyId_status (company_id,status(255),is_del),
  key i_comId_pub_ctime (company_id,publish_user_id,create_time),
  key index_companyId_positionId (company_id,position_id) using btree
 ) engine=InnoDB default charset=utf8mb4;

