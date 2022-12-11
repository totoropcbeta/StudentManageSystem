CREATE TABLE `user_info`
(
    `id`            int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
    `user_id`       varchar(11)      NOT NULL COMMENT '用户账号ID',
    `user_name`     varchar(12)      NOT NULL COMMENT '用户姓名',
    `password`      varchar(128)     NOT NULL COMMENT '用户密码',
    `phone`         varchar(11)      NOT NULL COMMENT '用户手机号',
    `id_card`       varchar(18)      NOT NULL COMMENT '用户身份证',
    `email`         varchar(128)     NOT NULL COMMENT '用户邮箱',
    `active_status` tinyint(1)       NOT NULL DEFAULT '1' COMMENT '是否有效（0-无效,1-有效）',
    `create_time`   timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `user_id` (`user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户信息表';
