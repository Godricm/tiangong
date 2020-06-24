CREATE TABLE `ry-vue`.`account_wechat`
(
    `wechat_id`          BIGINT(20)   NOT NULL COMMENT '主键',
    `name`               VARCHAR(32)  NOT NULL COMMENT '公众号名称',
    `account`            VARCHAR(32)  NOT NULL COMMENT '公众号账号',
    `original`           VARCHAR(64)  NOT NULL COMMENT '原始ID',
    `app_key`            VARCHAR(64)  NOT NULL COMMENT 'appid',
    `app_secret`         VARCHAR(64)  NOT NULL COMMENT 'appsecret',
    `token`              VARCHAR(64)  NOT NULL COMMENT '接入的token值',
    `encodingAesKey`     VARCHAR(255) NOT NULL COMMENT '接入的EncodingAESKey值',
    `level`              INT(4)       NOT NULL COMMENT '1、普通订阅号2、认证订阅号3、普通服务号4、认证服务号/认证媒体/政府订阅号',
    `country`            VARCHAR(10)  NOT NULL COMMENT '国家',
    `province`           VARCHAR(64)  NOT NULL COMMENT '省份',
    `city`               VARCHAR(64)  NOT NULL COMMENT '城市',
    `auth_refresh_token` VARCHAR(255) NOT NULL COMMENT '开放平台返回的auth_refresh_token',
    `status`             CHAR(1)      NOT NULL COMMENT '状态（0正常，1停用）',
    `del_flag`           CHAR(1)      NOT NULL COMMENT '删除标志（0代表存在，1代表删除）',
    `create_by`          VARCHAR(64)  NOT NULL COMMENT '创建者',
    `create_time`        DATETIME     NOT NULL COMMENT '创建时间',
    `update_by`          VARCHAR(64)  NOT NULL COMMENT '更新者',
    `update_time`        DATETIME     NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`wechat_id`),
    UNIQUE (`app_key`)
) ENGINE = InnoDB COMMENT = '微信公众号表';



-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信公众号', '3', '1', 'account', 'wechat/account/index', 1, 'C', '0', '0', 'wechat:account:list', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '微信公众号菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信公众号查询', @parentId, '1',  '#', '', 1,  'F', '0',  '0', 'wechat:account:query',        '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信公众号新增', @parentId, '2',  '#', '', 1,  'F', '0',  '0', 'wechat:account:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信公众号修改', @parentId, '3',  '#', '', 1,  'F', '0',  '0', 'wechat:account:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信公众号删除', @parentId, '4',  '#', '', 1,  'F', '0',  '0', 'wechat:account:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信公众号导出', @parentId, '5',  '#', '', 1,  'F', '0',  '0', 'wechat:account:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');