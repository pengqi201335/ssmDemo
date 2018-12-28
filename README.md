ssmDemo(IDEA下使用maven创建的ssm整合项目)
=====================================
创建paper表
----------
###  
    create table `paper`( 
    `paper_id` int not null auto_increment comment'论文编号', 
    `paper_title` varchar(100) not null comment'论文标题', 
    `paper_ref` int not null comment'论文被引次数', 
    `paper_detail` varchar(200) not null comment'论文描述', 
    primary key(`paper_id`) 
    )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='paper表';
###



