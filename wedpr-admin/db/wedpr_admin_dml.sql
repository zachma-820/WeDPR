insert into wedpr_group (group_id, group_name, admin_name, status) values('1000000000000000', '初始用户组', 'admin', 0);
insert into wedpr_group_detail (group_id, username, status) values('1000000000000000', 'admin', 0);
insert into wedpr_user (username, password, status) values('admin', '{bcrypt}$2a$10$XuiuKLg23kxtC/ldvYN0/evt0Y3aoBC9iV29srhIBMMDORzCQiYA.', 0);
insert into wedpr_user_role(username, role_id) values ('admin', '10');
insert into wedpr_role_permission (role_id, role_name, permission_id) values ('10', 'admin_user', '1')